/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lauti
 */
public class ConsultasRecibos {

    public static ReciboLegajo getRecibo(int idReciboLegajo) {
        ReciboLegajo recibo = new ReciboLegajo();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT "
                        + " Legajo_idLegajo,"
                        + " FechaRecibo,"
                        + " DireccionInmueble,"
                        + " TipoInmueble,"
                        + " BarrioInmueble,"
                        + " NombreLocatario,"
                        + " NombreLocador,"
                        + " DniLocador,"
                        + " MontoEnLetras,"
                        + " MesEnLetras,"
                        + " Importe,"
                        + " ImporteAbonado,"
                        + " IncluyeImpuestos,"
                        + " FechaVencimiento,"
                        + " Observaciones"                        
                        + " FROM recibolegajo WHERE idReciboLegajo = ?");
                ps.setInt(1, idReciboLegajo);
                rs = ps.executeQuery();

                if (rs.next()) {
                    
                    recibo.setLegajo_idLegajo(rs.getInt("Legajo_idLegajo"));
                    recibo.setDireccionInmueble(rs.getString("DireccionInmueble"));
                    recibo.setTipoInmueble(rs.getString("TipoInmueble"));
                    recibo.setBarrioInmueble(rs.getString("BarrioInmueble"));
                    recibo.setNombreLocatario(rs.getString("NombreLocatario"));
                    recibo.setNombreLocador(rs.getString("NombreLocador"));
                    recibo.setDniLocador(rs.getString("DniLocador"));
                    
                    
                    recibo.setMontoEnLetras(rs.getString("MontoEnLetras"));
                    recibo.setMesEnLetras(rs.getString("MesEnLetras"));
                    recibo.setImporte(rs.getString("Importe"));
                    recibo.setImporteAbonado(rs.getString("ImporteAbonado"));
                    recibo.setIncluyeImpuestos(rs.getString("IncluyeImpuestos"));
                    recibo.setFechaVencimiento(rs.getDate("FechaVencimiento"));
                    recibo.setObservaciones(rs.getString("Observaciones"));
                    
                    
                    recibo.setFechaDelRecibo(rs.getDate("FechaRecibo"));
                    java.sql.Date fecha = new java.sql.Date(rs.getDate("FechaRecibo").getTime());
                    
                    System.out.println(fecha.toString());
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return recibo;
    }

    public static boolean insertarRecibo(ReciboLegajo legajo, int idLegajo) {
        Connection con;
        PreparedStatement ps;
        // Conversion de fechas
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("INSERT INTO recibolegajo (Legajo_idLegajo,"
                        + " FechaRecibo,"
                        + " DireccionInmueble,"
                        + " BarrioInmueble,"
                        + " NombreLocatario,"
                        + " NombreLocador,"
                        + " DniLocador,"
                        + " MontoEnLetras,"
                        + " MesEnLetras,"
                        + " Importe,"
                        + " ImporteAbonado,"
                        + " IncluyeImpuestos,"
                        + " FechaVencimiento,"
                        + " Observaciones)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, idLegajo);
                ps.setString(2, dateFormat.format(legajo.getFechaDelRecibo()));
                ps.setString(3, legajo.getDireccionInmueble());
                ps.setString(4, legajo.getBarrioInmueble());
                ps.setString(5, legajo.getNombreLocatario());
                ps.setString(6, legajo.getNombreLocador());
                ps.setString(7, legajo.getDniLocador());
                ps.setString(8, legajo.getMontoEnLetras());
                ps.setString(9, legajo.getMesEnLetras());
                ps.setString(10, legajo.getImporte());
                ps.setString(11, legajo.getImporteAbonado());
                ps.setString(12, legajo.getIncluyeImpuestos());
                ps.setString(13, dateFormat.format(legajo.getFechaVencimiento()));
                ps.setString(14, legajo.getObservaciones());

                ps.executeUpdate();
                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

}
