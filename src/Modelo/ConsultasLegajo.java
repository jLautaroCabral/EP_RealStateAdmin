/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lauti
 */
public class ConsultasLegajo {
    
    public static Legajo getLegajo(int idLegajo) {
        Legajo legajo = new Legajo();
        
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT * FROM legajo WHERE idLegajo = ?");
                ps.setInt(1, idLegajo);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    legajo.setIdInmueble((int) rs.getObject(2));
                    legajo.setIdLocador((int) rs.getObject(3));
                    legajo.setIdLocatario((int) rs.getObject(4));
                    legajo.setLegajo((String) rs.getObject(5));
                    
                    legajo.setGarante1Nombre((String) rs.getObject(6));
                    legajo.setGarante1Telefono((String) rs.getObject(7));
                    legajo.setGarante1Domicilio((String) rs.getObject(8));
                    legajo.setGarante1Mail((String) rs.getObject(9));
                    
                    legajo.setGarante2Nombre((String) rs.getObject(10));
                    legajo.setGarante2Telefono((String) rs.getObject(11));
                    legajo.setGarante2Domicilio((String) rs.getObject(12));
                    legajo.setGarante2Mail((String) rs.getObject(13));
                    
                    legajo.setGarante3Nombre((String) rs.getObject(14));
                    legajo.setGarante3Telefono((String) rs.getObject(15));
                    legajo.setGarante3Domicilio((String) rs.getObject(16));
                    legajo.setGarante3Mail((String) rs.getObject(17));
                    
                    legajo.setGarante4Nombre((String) rs.getObject(18));
                    legajo.setGarante4Telefono((String) rs.getObject(19));
                    legajo.setGarante4Domicilio((String) rs.getObject(20));
                    legajo.setGarante4Mail((String) rs.getObject(21));
                    
                    legajo.setOtrosGarantes((String) rs.getObject(22));                   
                    legajo.setMontoAlquiler((String) rs.getObject(23));
                    legajo.setTitularImpuestoMunicipal((String) rs.getObject(24));
                    legajo.setTitularDgr((String) rs.getObject(25));
                    legajo.setTitularAgua((String) rs.getObject(26));
                    legajo.setTitularLuz((String) rs.getObject(27));
                    legajo.setTitularGas((String) rs.getObject(28));
                    legajo.setTitularExpensas((String) rs.getObject(29));
                    legajo.setObservaciones((String) rs.getObject(30));
                    
                    legajo.setFechaSubscripcion((Date) rs.getObject(31));
                    legajo.setFechaInicio((Date) rs.getObject(32));
                    legajo.setFechaFinalizacion((Date) rs.getObject(33));
                    
                    legajo.setEstadoActual((String) rs.getObject(34));
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return legajo;
    }
    
    public static boolean insertarLegajo(Legajo legajo) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement
                ("INSERT INTO legajo ("
                        + "Inmueble_idInmueble,"
                        + "Locador_idLocador,"
                        + "Locatario_idLocatario,"
                        + "Legajo,"
                        
                        + "Garante1Nombre,"
                        + "Garante1Telefono,"
                        + "Garante1Domicilio,"
                        + "Garante1Mail,"
                        
                        + "Garante2Nombre,"
                        + "Garante2Telefono,"
                        + "Garante2Domicilio,"
                        + "Garante2Mail,"
                        
                        + "Garante3Nombre,"
                        + "Garante3Telefono,"
                        + "Garante3Domicilio,"
                        + "Garante3Mail,"
                        
                        + "Garante4Nombre,"
                        + "Garante4Telefono,"
                        + "Garante4Domicilio,"
                        + "Garante4Mail,"
                        
                        + "OtrosGarantes,"
                        + "MontoAlquiler,"
                        + "TitularImpuestoMunicipal,"
                        + "TitularDGR,"
                        + "TitularAgua,"
                        + "TitularLuz,"
                        + "TitularGas,"
                        + "TitularExpensas,"
                        + "Observaciones,"
                        + "FechaSubscripcion,"
                        + "FechaInicio,"
                        + "FechaFinalizacion,"
                        + "EstadoActual)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                ps.setInt(1, legajo.getIdInmueble());
                ps.setInt(2, legajo.getIdLocador());
                ps.setInt(3, legajo.getIdLocatario());
                ps.setString(4, legajo.getLegajo());
                
                ps.setString(5, legajo.getGarante1Nombre());
                ps.setString(6, legajo.getGarante1Telefono());
                ps.setString(7, legajo.getGarante1Domicilio());
                ps.setString(8, legajo.getGarante1Mail());
                
                ps.setString(9, legajo.getGarante2Nombre());
                ps.setString(10, legajo.getGarante2Telefono());
                ps.setString(11, legajo.getGarante2Domicilio());
                ps.setString(12, legajo.getGarante2Mail());
                
                ps.setString(13, legajo.getGarante3Nombre());
                ps.setString(14, legajo.getGarante3Telefono());
                ps.setString(15, legajo.getGarante3Domicilio());
                ps.setString(16, legajo.getGarante3Mail());
                
                ps.setString(17, legajo.getGarante4Nombre());
                ps.setString(18, legajo.getGarante4Telefono());
                ps.setString(19, legajo.getGarante4Domicilio());
                ps.setString(20, legajo.getGarante4Mail());
                
                ps.setString(21, legajo.getOtrosGarantes());
                ps.setString(22, legajo.getMontoAlquiler());
                ps.setString(23, legajo.getTitularImpuestoMunicipal());
                ps.setString(24, legajo.getTitularDgr());
                ps.setString(25, legajo.getTitularAgua());
                ps.setString(26, legajo.getTitularLuz());
                ps.setString(27, legajo.getTitularGas());
                ps.setString(28, legajo.getTitularExpensas());
                ps.setString(29, legajo.getObservaciones());
                ps.setDate(30, legajo.getFechaSubscripcion());
                ps.setDate(31, legajo.getFechaInicio());
                ps.setDate(32, legajo.getFechaFinalizacion());
                ps.setString(33, legajo.getEstadoActual());
                
                
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha agregado el legajo", null, JOptionPane.PLAIN_MESSAGE);
                }

                con.close();
                return true;
            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean modificarLegajo(Legajo legajo, int idLegajo) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement
                ("UPDATE legajo SET "
                        + "Inmueble_idInmueble = ?,"
                        + "Locador_idLocador = ?,"
                        + "Locatario_idLocatario = ?,"
                        + "Legajo = ?,"
                        
                        + "Garante1Nombre = ?,"
                        + "Garante1Telefono = ?,"
                        + "Garante1Domicilio = ?,"
                        + "Garante1Mail = ?,"
                        
                        + "Garante2Nombre = ?,"
                        + "Garante2Telefono = ?,"
                        + "Garante2Domicilio = ?,"
                        + "Garante2Mail = ?,"
                        
                        + "Garante3Nombre = ?,"
                        + "Garante3Telefono = ?,"
                        + "Garante3Domicilio = ?,"
                        + "Garante3Mail = ?,"
                        
                        + "Garante4Nombre = ?,"
                        + "Garante4Telefono = ?,"
                        + "Garante4Domicilio = ?,"
                        + "Garante4Mail = ?,"
                        
                        + "OtrosGarantes = ?,"
                        + "MontoAlquiler = ?,"
                        + "TitularImpuestoMunicipal = ?,"
                        + "TitularDGR = ?,"
                        + "TitularAgua = ?,"
                        + "TitularLuz = ?,"
                        + "TitularGas = ?,"
                        + "TitularExpensas = ?,"
                        + "Observaciones = ?,"
                        + "FechaSubscripcion = ?,"
                        + "FechaInicio = ?,"
                        + "FechaFinalizacion = ?,"
                        + "EstadoActual = ?"
                        + " WHERE idLegajo = ?");
                
                ps.setInt(1, legajo.getIdInmueble());
                ps.setInt(2, legajo.getIdLocador());
                ps.setInt(3, legajo.getIdLocatario());
                ps.setString(4, legajo.getLegajo());
                
                ps.setString(5, legajo.getGarante1Nombre());
                ps.setString(6, legajo.getGarante1Telefono());
                ps.setString(7, legajo.getGarante1Domicilio());
                ps.setString(8, legajo.getGarante1Mail());
                
                ps.setString(9, legajo.getGarante2Nombre());
                ps.setString(10, legajo.getGarante2Telefono());
                ps.setString(11, legajo.getGarante2Domicilio());
                ps.setString(12, legajo.getGarante2Mail());
                
                ps.setString(13, legajo.getGarante3Nombre());
                ps.setString(14, legajo.getGarante3Telefono());
                ps.setString(15, legajo.getGarante3Domicilio());
                ps.setString(16, legajo.getGarante3Mail());
                
                ps.setString(17, legajo.getGarante4Nombre());
                ps.setString(18, legajo.getGarante4Telefono());
                ps.setString(19, legajo.getGarante4Domicilio());
                ps.setString(20, legajo.getGarante4Mail());
                
                ps.setString(21, legajo.getOtrosGarantes());
                ps.setString(22, legajo.getMontoAlquiler());
                ps.setString(23, legajo.getTitularImpuestoMunicipal());
                ps.setString(24, legajo.getTitularDgr());
                ps.setString(25, legajo.getTitularAgua());
                ps.setString(26, legajo.getTitularLuz());
                ps.setString(27, legajo.getTitularGas());
                ps.setString(28, legajo.getTitularExpensas());
                ps.setString(29, legajo.getObservaciones());
                ps.setDate(30, legajo.getFechaSubscripcion());
                ps.setDate(31, legajo.getFechaInicio());
                ps.setDate(32, legajo.getFechaFinalizacion());
                ps.setString(33, legajo.getEstadoActual());
                
                ps.setInt(34, idLegajo);
                
                
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha modificado el legajo", null, JOptionPane.PLAIN_MESSAGE);
                }

                con.close();
                return true;
            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static void eliminarLegajo(int idLegajo) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("DELETE FROM legajo WHERE idLegajo = ?");
                ps.setInt(1, idLegajo);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el legajo", null, JOptionPane.PLAIN_MESSAGE);
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
