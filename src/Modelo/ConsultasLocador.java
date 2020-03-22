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
public class ConsultasLocador {

    // Devuelve un Locador según el idLocador
    public static Locador getLocador(int idLocador) {
        Locador locador = new Locador();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT Nombre, Telefono, Mail, Domicilio, FechaNacimiento, TipoNroDocumento, NroDocumento, OtrosDatos FROM locador WHERE idLocador = ?");
                ps.setInt(1, idLocador);
                rs = ps.executeQuery();

                if (rs.next()) {
                    locador.setNombre((String) rs.getObject(1));
                    locador.setTelefono((String) rs.getObject(2));
                    locador.setMail((String) rs.getObject(3));
                    locador.setDomicilio((String) rs.getObject(4));
                    locador.setFechaNacimiento((java.sql.Date) rs.getObject(5));
                    locador.setTipoNroDocumento((String) rs.getObject(6));
                    locador.setNroDocumento((String) rs.getObject(7));
                    locador.setOtrosDatos((String) rs.getObject(8));
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return locador;
    }

    public static ArrayList<String> getNombresLocadores() {
        ArrayList<String> nombresLocadores = new ArrayList<String>();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT Nombre FROM locador");
                rs = ps.executeQuery();

                while (rs.next()) {
                    nombresLocadores.add(rs.getString("Nombre"));
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return nombresLocadores;
    }

    public static boolean insertarLocador(Locador locador) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("INSERT INTO locador (Nombre, Telefono, Mail, Domicilio, FechaNacimiento, TipoNroDocumento, NroDocumento, OtrosDatos) VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, locador.getNombre());
                ps.setString(2, locador.getTelefono());
                ps.setString(3, locador.getMail());
                ps.setString(4, locador.getDomicilio());
                ps.setDate(5, locador.getFechaNacimiento());
                ps.setString(6, locador.getTipoNroDocumento());
                ps.setString(7, locador.getNroDocumento());
                ps.setString(8, locador.getOtrosDatos());

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha agregado el locador", null, JOptionPane.PLAIN_MESSAGE);
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

    public static boolean modificarLocador(Locador locador, int idLocador) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("UPDATE locador SET Nombre = ?, Telefono = ?, Mail = ?,Domicilio = ?, FechaNacimiento = ?, TipoNroDocumento = ?, NroDocumento = ?, OtrosDatos = ? WHERE idLocador = ?");
                ps.setString(1, locador.getNombre());
                ps.setString(2, locador.getTelefono());
                ps.setString(3, locador.getMail());
                ps.setString(4, locador.getDomicilio());
                ps.setDate(5, locador.getFechaNacimiento());
                ps.setString(6, locador.getTipoNroDocumento());
                ps.setString(7, locador.getNroDocumento());
                ps.setString(8, locador.getOtrosDatos());
                ps.setInt(9, idLocador);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha modificado el locador", null, JOptionPane.PLAIN_MESSAGE);
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

    public static void eliminarLocador(int idLocador) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("DELETE FROM locador WHERE idLocador = ?");
                ps.setInt(1, idLocador);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el locador", null, JOptionPane.PLAIN_MESSAGE);
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int getIdLocadorSegunNombre(String nombre) {
        int id = -1;

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT idLocador FROM locador WHERE Nombre = ?");
                ps.setString(1, nombre);
                rs = ps.executeQuery();

                if (rs.next()) {
                    id = rs.getInt("idLocador");
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
