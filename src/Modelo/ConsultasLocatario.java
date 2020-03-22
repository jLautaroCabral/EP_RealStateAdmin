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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lauti
 */
public class ConsultasLocatario {
    // Devuelve un Locatario según el idLocatario
    public static Locatario getLocatario(int idLocatario) {
        Locatario locatario = new Locatario();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT Nombre, Telefono, Mail, TipoNroDocumento, NroDocumento, OtrosDatos FROM locatario WHERE idLocatario = ?");
                ps.setInt(1, idLocatario);
                rs = ps.executeQuery();

                if (rs.next()) {
                    locatario.setNombre((String) rs.getObject(1));
                    locatario.setTelefono((String) rs.getObject(2));
                    locatario.setMail((String) rs.getObject(3));
                    locatario.setTipoNroDocumento((String) rs.getObject(4));
                    locatario.setNroDocumento((String) rs.getObject(5));
                    locatario.setOtrosDatos((String) rs.getObject(6));
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return locatario;
    }
    
    public static boolean insertarLocatario(Locatario locatario) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("INSERT INTO locatario (Nombre, Telefono, Mail, TipoNroDocumento, NroDocumento, OtrosDatos) VALUES (?,?,?,?,?,?)");
                ps.setString(1, locatario.getNombre());
                ps.setString(2, locatario.getTelefono());
                ps.setString(3, locatario.getMail());
                ps.setString(4, locatario.getTipoNroDocumento());
                ps.setString(5, locatario.getNroDocumento());
                ps.setString(6, locatario.getOtrosDatos());


                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha agregado el locatario", null, JOptionPane.PLAIN_MESSAGE);
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
    
    public static boolean modificarLocatario(Locatario locatario, int idLocatario) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("UPDATE locatario SET Nombre = ?, Telefono = ?, Mail = ?, TipoNroDocumento = ?, NroDocumento = ?, OtrosDatos = ? WHERE idLocatario = ?");
                ps.setString(1, locatario.getNombre());
                ps.setString(2, locatario.getTelefono());
                ps.setString(3, locatario.getMail());
                ps.setString(4, locatario.getTipoNroDocumento());
                ps.setString(5, locatario.getNroDocumento());
                ps.setString(6, locatario.getOtrosDatos());
                ps.setInt(9, idLocatario);


                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha modificado el locatario", null, JOptionPane.PLAIN_MESSAGE);
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
    
    public static void eliminarLocatario(int idLocatario) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("DELETE FROM locatario WHERE idLocatario = ?");
                ps.setInt(1, idLocatario);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el locatario", null, JOptionPane.PLAIN_MESSAGE);
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<String> getNombresLocatarios() {
        ArrayList<String> nombresLocatarios = new ArrayList<String>();
        
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT Nombre FROM locatario");
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    nombresLocatarios.add(rs.getString("Nombre"));
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return nombresLocatarios;
    }
    
    public static int getIdLocatarioSegunNombre(String nombre) {
        int id = -1;

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT idLocatario FROM locatario WHERE Nombre = ?");
                ps.setString(1, nombre);
                rs = ps.executeQuery();

                if (rs.next()) {
                    id = rs.getInt("idLocatario");
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return id;
    }
}
