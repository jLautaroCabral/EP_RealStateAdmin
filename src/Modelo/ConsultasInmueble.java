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
public class ConsultasInmueble {
    
    public static Inmueble getInmueble(int idInmueble) {
        Inmueble inmueble = new Inmueble();
        
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement
                ("SELECT "
                        + "Calle,"
                        + "PisoDepto,"
                        + "Barrio,"
                        + "CodigoPostal,"
                        + "ProvinciaLocalidad,"
                        + "Tipo,"
                        + "Operacion,"
                        + "Dormitorios,"
                        + "Baños,"
                        + "Plantas,"
                        + "Antiguedad,"
                        + "EstadoGeneral,"
                        + "Valor,"
                        + "SuperficieTerreno,"
                        + "SuperficieCubierta,"
                        + "MtsFrente,"
                        + "MtsFondo,"
                        + "CantidadLlaves,"
                        + "Estilo,"
                        + "Orientacion,"
                        + "Garage,"
                        + "Living,"
                        + "Cocina,"
                        + "Comedor,"
                        + "Dependencia,"
                        + "Piscina,"
                        + "PatioJardin,"
                        + "Accesorios,"
                        + "Comentarios,"
                        + "OtrasObservaciones,"
                        + "ImpuestoMunicipal,"
                        + "DGR,"
                        + "Agua,"
                        + "Luz,"
                        + "Gas,"
                        + "Expensas,"
                        + "idLocador,"
                        + "EstadoActual"
                        + " FROM inmueble WHERE idInmueble = ?");
                
                ps.setInt(1, idInmueble);
                rs = ps.executeQuery();

                if (rs.next()) {
                    inmueble.setCalle(rs.getString("Calle"));
                    inmueble.setPisoDepto(rs.getString("PisoDepto"));
                    inmueble.setBarrio(rs.getString("Barrio"));
                    inmueble.setCodigoPostal(rs.getString("CodigoPostal"));
                    inmueble.setProvinciaLocalidad(rs.getString("ProvinciaLocalidad"));
                    inmueble.setTipo(rs.getString("Tipo"));
                    inmueble.setOperacion(rs.getString("Operacion"));
                    inmueble.setDormitorios(rs.getString("Dormitorios"));
                    inmueble.setBaños(rs.getString("Baños"));
                    inmueble.setPlantas(rs.getString("Plantas"));
                    inmueble.setAntiguedad(rs.getString("Antiguedad"));
                    inmueble.setEstadoGeneral(rs.getString("EstadoGeneral"));
                    inmueble.setValor(rs.getString("Valor"));
                    inmueble.setSuperficieTerreno(rs.getString("SuperficieTerreno"));
                    inmueble.setSuperficieCubierta(rs.getString("SuperficieCubierta"));
                    inmueble.setMtsFondo(rs.getString("MtsFondo"));
                    inmueble.setMtsFrente(rs.getString("MtsFrente"));
                    inmueble.setCantidadLlaves(rs.getString("CantidadLlaves"));
                    inmueble.setEstilo(rs.getString("Estilo"));
                    inmueble.setOrientacion(rs.getString("Orientacion"));
                    inmueble.setGarage(rs.getString("Garage"));
                    inmueble.setLiving(rs.getString("Living"));
                    inmueble.setCocina(rs.getString("Cocina"));
                    inmueble.setComedor(rs.getString("Comedor"));
                    inmueble.setDependencia(rs.getString("Dependencia"));
                    inmueble.setPiscina(rs.getString("Piscina"));
                    inmueble.setPatioJardin(rs.getString("PatioJardin"));
                    inmueble.setAccesorios(rs.getString("Accesorios"));
                    inmueble.setComentarios(rs.getString("Comentarios"));
                    inmueble.setOtrasObservaciones(rs.getString("OtrasObservaciones"));
                    inmueble.setImpuestoMunicipal(rs.getString("ImpuestoMunicipal"));
                    inmueble.setDgr(rs.getString("DGR"));
                    inmueble.setAgua(rs.getString("Agua"));
                    inmueble.setLuz(rs.getString("Luz"));
                    inmueble.setGas(rs.getString("Gas"));
                    inmueble.setExpensas(rs.getString("Expensas"));
                    inmueble.setIdLocador(rs.getInt("idLocador"));
                    inmueble.setEstadoActual(rs.getString("EstadoActual"));
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return inmueble;
    }
    
    public static boolean insertarInmueble(Inmueble inmueble) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement
                ("INSERT INTO inmueble ("
                        + "Calle,"
                        + "PisoDepto,"
                        + "Barrio,"
                        + "CodigoPostal,"
                        + "ProvinciaLocalidad,"
                        + "Tipo,"
                        + "Operacion,"
                        + "Dormitorios,"
                        + "Baños,"
                        + "Plantas,"
                        + "Antiguedad,"
                        + "EstadoGeneral,"
                        + "Valor,"
                        + "SuperficieTerreno,"
                        + "SuperficieCubierta,"
                        + "MtsFrente,"
                        + "MtsFondo,"
                        + "CantidadLlaves,"
                        + "Estilo,"
                        + "Orientacion,"
                        + "Garage,"
                        + "Living,"
                        + "Cocina,"
                        + "Comedor,"
                        + "Dependencia,"
                        + "Piscina,"
                        + "PatioJardin,"
                        + "Accesorios,"
                        + "Comentarios,"
                        + "OtrasObservaciones,"
                        + "ImpuestoMunicipal,"
                        + "DGR,"
                        + "Agua,"
                        + "Luz,"
                        + "Gas,"
                        + "Expensas,"
                        + "idLocador,"
                        + "EstadoActual)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                ps.setString(1, inmueble.getCalle());
                ps.setString(2, inmueble.getPisoDepto());
                ps.setString(3, inmueble.getBarrio());
                ps.setString(4, inmueble.getCodigoPostal());
                ps.setString(5, inmueble.getProvinciaLocalidad());
                ps.setString(6, inmueble.getTipo());
                ps.setString(7, inmueble.getOperacion());
                ps.setString(8, inmueble.getDormitorios());
                ps.setString(9, inmueble.getBaños());
                ps.setString(10, inmueble.getPlantas());
                ps.setString(11, inmueble.getAntiguedad());
                ps.setString(12, inmueble.getEstadoGeneral());
                ps.setString(13, inmueble.getValor());
                ps.setString(14, inmueble.getSuperficieTerreno());
                ps.setString(15, inmueble.getSuperficieCubierta());
                ps.setString(16, inmueble.getMtsFrente());
                ps.setString(17, inmueble.getMtsFondo());
                ps.setString(18, inmueble.getCantidadLlaves());
                ps.setString(19, inmueble.getEstilo());
                ps.setString(20, inmueble.getOrientacion());
                ps.setString(21, inmueble.getGarage());
                ps.setString(22, inmueble.getLiving());
                ps.setString(23, inmueble.getCocina());
                ps.setString(24, inmueble.getComedor());
                ps.setString(25, inmueble.getDependencia());
                ps.setString(26, inmueble.getPiscina());
                ps.setString(27, inmueble.getPatioJardin());
                ps.setString(28, inmueble.getAccesorios());
                ps.setString(29, inmueble.getComentarios());
                ps.setString(30, inmueble.getOtrasObservaciones());
                ps.setString(31, inmueble.getImpuestoMunicipal());
                ps.setString(32, inmueble.getDgr());
                ps.setString(33, inmueble.getAgua());
                ps.setString(34, inmueble.getLuz());
                ps.setString(35, inmueble.getGas());
                ps.setString(36, inmueble.getExpensas());
                ps.setInt(37, inmueble.getIdLocador());
                ps.setString(38, inmueble.getEstadoActual());
                
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha agregado el inmueble", null, JOptionPane.PLAIN_MESSAGE);
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
    
    public static boolean modificarInmueble(Inmueble inmueble, int idInmueble) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement
                ("UPDATE inmueble SET "
                        + "Calle = ?,"
                        + "PisoDepto = ?,"
                        + "Barrio = ?,"
                        + "CodigoPostal = ?,"
                        + "ProvinciaLocalidad = ?,"
                        + "Tipo = ?,"
                        + "Operacion = ?,"
                        + "Dormitorios = ?,"
                        + "Baños = ?,"
                        + "Plantas = ?,"
                        + "Antiguedad = ?,"
                        + "EstadoGeneral = ?,"
                        + "Valor = ?,"
                        + "SuperficieTerreno = ?,"
                        + "SuperficieCubierta = ?,"
                        + "MtsFrente = ?,"
                        + "MtsFondo = ?,"
                        + "CantidadLlaves = ?,"
                        + "Estilo = ?,"
                        + "Orientacion = ?,"
                        + "Garage = ?,"
                        + "Living = ?,"
                        + "Cocina = ?,"
                        + "Comedor = ?,"
                        + "Dependencia = ?,"
                        + "Piscina = ?,"
                        + "PatioJardin = ?,"
                        + "Accesorios = ?,"
                        + "Comentarios = ?,"
                        + "OtrasObservaciones = ?,"
                        + "ImpuestoMunicipal = ?,"
                        + "DGR = ?,"
                        + "Agua = ?,"
                        + "Luz = ?,"
                        + "Gas = ?,"
                        + "Expensas = ?,"
                        + "idLocador = ?,"
                        + "EstadoActual  = ?"
                        + " WHERE idInmueble = ?");
                
                ps.setString(1, inmueble.getCalle());
                ps.setString(2, inmueble.getPisoDepto());
                ps.setString(3, inmueble.getBarrio());
                ps.setString(4, inmueble.getCodigoPostal());
                ps.setString(5, inmueble.getProvinciaLocalidad());
                ps.setString(6, inmueble.getTipo());
                ps.setString(7, inmueble.getOperacion());
                ps.setString(8, inmueble.getDormitorios());
                ps.setString(9, inmueble.getBaños());
                ps.setString(10, inmueble.getPlantas());
                ps.setString(11, inmueble.getAntiguedad());
                ps.setString(12, inmueble.getEstadoGeneral());
                ps.setString(13, inmueble.getValor());
                ps.setString(14, inmueble.getSuperficieTerreno());
                ps.setString(15, inmueble.getSuperficieCubierta());
                ps.setString(16, inmueble.getMtsFrente());
                ps.setString(17, inmueble.getMtsFondo());
                ps.setString(18, inmueble.getCantidadLlaves());
                ps.setString(19, inmueble.getEstilo());
                ps.setString(20, inmueble.getOrientacion());
                ps.setString(21, inmueble.getGarage());
                ps.setString(22, inmueble.getLiving());
                ps.setString(23, inmueble.getCocina());
                ps.setString(24, inmueble.getComedor());
                ps.setString(25, inmueble.getDependencia());
                ps.setString(26, inmueble.getPiscina());
                ps.setString(27, inmueble.getPatioJardin());
                ps.setString(28, inmueble.getAccesorios());
                ps.setString(29, inmueble.getComentarios());
                ps.setString(30, inmueble.getOtrasObservaciones());
                ps.setString(31, inmueble.getImpuestoMunicipal());
                ps.setString(32, inmueble.getDgr());
                ps.setString(33, inmueble.getAgua());
                ps.setString(34, inmueble.getLuz());
                ps.setString(35, inmueble.getGas());
                ps.setString(36, inmueble.getExpensas());
                ps.setInt(37, inmueble.getIdLocador());
                ps.setString(38, inmueble.getEstadoActual());
                
                ps.setInt(39, idInmueble);
                
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha modificado el inmueble", null, JOptionPane.PLAIN_MESSAGE);
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
    
    public static void eliminarInmueble(int idInmueble) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("DELETE FROM inmueble WHERE idInmueble = ?");
                ps.setInt(1, idInmueble);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el inmueble", null, JOptionPane.PLAIN_MESSAGE);
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<Inmueble> getDireccionesYPisoDepto() {
        ArrayList<Inmueble> inmuebles = new ArrayList<>();
        
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT Calle, PisoDepto FROM inmueble");
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    Inmueble inmueble = new Inmueble();
                    inmueble.setCalle(rs.getString("Calle"));
                    inmueble.setPisoDepto(rs.getString("PisoDepto"));
                    inmuebles.add(inmueble);
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return inmuebles;
    }
    
    public static int getIdInmuebleSegunDireccion(String direccion) {
        int id = -1;

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT idInmueble FROM inmueble WHERE Calle = ?");
                ps.setString(1, direccion);
                rs = ps.executeQuery();

                if (rs.next()) {
                    id = rs.getInt("idInmueble");
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
