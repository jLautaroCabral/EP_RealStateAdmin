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
public class ConsultasLegajoViejo {
    
    public static LegajoViejo getLegajoViejo(int idLegajoViejo) {
        LegajoViejo legajoViejo = new LegajoViejo();
        
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT * FROM legajosviejos WHERE idLegajosViejos = ?");
                ps.setInt(1, idLegajoViejo);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    legajoViejo.setInmCalle((String) rs.getObject(2));
                    legajoViejo.setInmPisoDepto((String) rs.getObject(3));
                    legajoViejo.setInmBarrio((String) rs.getObject(4));
                    legajoViejo.setInmCodigoPostal((String) rs.getObject(5));
                    legajoViejo.setInmProvinciaLocalidad((String) rs.getObject(6));
                    legajoViejo.setInmTipo((String) rs.getObject(7));
                    legajoViejo.setInmOperacion((String) rs.getObject(8));
                    legajoViejo.setInmDormitorios((String) rs.getObject(9));
                    legajoViejo.setInmBaños((String) rs.getObject(10));
                    legajoViejo.setInmPlantas((String) rs.getObject(11));
                    legajoViejo.setInmAntiguedad((String) rs.getObject(12));
                    legajoViejo.setInmEstadoGeneral((String) rs.getObject(13));
                    legajoViejo.setInmValor((String) rs.getObject(14));
                    legajoViejo.setInmSuperficieTerreno((String) rs.getObject(15));
                    legajoViejo.setInmSuperficieCubierta((String) rs.getObject(16));
                    legajoViejo.setInmMtsFondo((String) rs.getObject(17));
                    legajoViejo.setInmMtsFrente((String) rs.getObject(18));
                    legajoViejo.setInmCantidadLlaves((String) rs.getObject(19));
                    legajoViejo.setInmEstilo((String) rs.getObject(20));
                    legajoViejo.setInmOrientacion((String) rs.getObject(21));
                    legajoViejo.setInmGarage((String) rs.getObject(22));
                    legajoViejo.setInmLiving((String) rs.getObject(23));
                    legajoViejo.setInmCocina((String) rs.getObject(24));
                    legajoViejo.setInmComedor((String) rs.getObject(25));
                    legajoViejo.setInmDependencia((String) rs.getObject(26));
                    legajoViejo.setInmPiscina((String) rs.getObject(27));
                    legajoViejo.setInmPatioJardin((String) rs.getObject(28));
                    legajoViejo.setInmAccesorios((String) rs.getObject(29));
                    legajoViejo.setInmComentarios((String) rs.getObject(30));
                    legajoViejo.setInmOtrasObservaciones((String) rs.getObject(31));
                    legajoViejo.setInmImpuestoMunicipal((String) rs.getObject(32));
                    legajoViejo.setInmDgr((String) rs.getObject(33));
                    legajoViejo.setInmAgua((String) rs.getObject(34));
                    legajoViejo.setInmLuz((String) rs.getObject(35));
                    legajoViejo.setInmGas((String) rs.getObject(36));
                    legajoViejo.setInmExpensas((String) rs.getObject(37));
                    legajoViejo.setLocadorNombre((String) rs.getObject(38));
                    legajoViejo.setLocadorTelefono((String) rs.getObject(39));
                    legajoViejo.setLocadorMail((String) rs.getObject(40));
                    legajoViejo.setLocadorDomicilio((String) rs.getObject(41));
                    legajoViejo.setLocadorFechaNacimiento((Date) rs.getObject(42));
                    legajoViejo.setLocadorTipoNroDocumento((String) rs.getObject(43));
                    legajoViejo.setLocadorNroDocument((String) rs.getObject(44));
                    legajoViejo.setLocadorOtrosDatos((String) rs.getObject(45));
                    legajoViejo.setLocatarioNombre((String) rs.getObject(46));
                    legajoViejo.setLocatarioTelefono((String) rs.getObject(47));
                    legajoViejo.setLocatarioMail((String) rs.getObject(48));
                    legajoViejo.setLocatarioTipoNroDocumento((String) rs.getObject(49));
                    legajoViejo.setLocatarioNroDocumento((String) rs.getObject(50));
                    legajoViejo.setLocatarioOtrosDatos((String) rs.getObject(51));
                    legajoViejo.setGarante1Nombre((String) rs.getObject(52));
                    legajoViejo.setGarante1Telefono((String) rs.getObject(53));
                    legajoViejo.setGarante1Domicilio((String) rs.getObject(54));
                    legajoViejo.setGarante1Mail((String) rs.getObject(55));
                    legajoViejo.setGarante2Nombre((String) rs.getObject(56));
                    legajoViejo.setGarante2Telefono((String) rs.getObject(57));
                    legajoViejo.setGarante2Domicilio((String) rs.getObject(58));
                    legajoViejo.setGarante2Mail((String) rs.getObject(59));
                    legajoViejo.setGarante3Nombre((String) rs.getObject(60));
                    legajoViejo.setGarante3Telefono((String) rs.getObject(61));
                    legajoViejo.setGarante3Domicilio((String) rs.getObject(62));
                    legajoViejo.setGarante3Mail((String) rs.getObject(63));
                    legajoViejo.setGarante4Nombre((String) rs.getObject(64));
                    legajoViejo.setGarante4Telefono((String) rs.getObject(65));
                    legajoViejo.setGarante4Domicilio((String) rs.getObject(66));
                    legajoViejo.setGarante4Mail((String) rs.getObject(67));
                    legajoViejo.setOtrosGarantes((String) rs.getObject(68));
                    legajoViejo.setMontoAlquiler((String) rs.getObject(69));
                    legajoViejo.setTitularImpuestoMunicipal((String) rs.getObject(70));
                    legajoViejo.setTitularDgr((String) rs.getObject(71));
                    legajoViejo.setTitularAgua((String) rs.getObject(72));
                    legajoViejo.setTitularLuz((String) rs.getObject(73));
                    legajoViejo.setTitularGas((String) rs.getObject(74));
                    legajoViejo.setTitularExpensas((String) rs.getObject(75));
                    legajoViejo.setObservaciones((String) rs.getObject(76));
                    
                    legajoViejo.setFechaSubscripcion((Date) rs.getObject(77));
                    legajoViejo.setFechaInicio((Date) rs.getObject(78));
                    legajoViejo.setFechaFinalizacion((Date) rs.getObject(79));
                    
                    legajoViejo.setEstadoActual((String) rs.getObject(80));
                    legajoViejo.setLegajo((String) rs.getObject(81));
                    
                }

                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return legajoViejo;
    }

    public static boolean insertarLegajoViejo(LegajoViejo legv) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement
                ("INSERT INTO legajosviejos ("
                        + "Legajo,"
                        + "InmCalle,"
                        + "InmPisoDepto,"
                        + "InmBarrio,"
                        + "InmCodigoPostal,"
                        + "InmProvinciaLocalidad,"
                        + "InmTipo,"
                        + "InmOperacion,"
                        + "InmDormitorios,"
                        + "InmBaños,"
                        + "InmPlantas,"
                        + "InmAntiguedad,"
                        + "InmEstadoGeneral,"
                        + "InmValor,"
                        + "InmSuperficieTerreno,"
                        + "InmSuperficieCubierta,"
                        + "InmMtsFrente,"
                        + "InmMtsFondo,"
                        + "InmCantidadLlaves,"
                        + "InmEstilo,"
                        + "InmOrientacion,"
                        + "InmGarage,"
                        + "InmLiving,"
                        + "InmCocina,"
                        + "InmComedor,"
                        + "InmDependencia,"
                        + "InmPiscina,"
                        + "InmPatioJardin,"
                        + "InmAccesorios,"
                        + "InmComentarios,"
                        + "InmOtrasObservaciones,"
                        + "InmImpuestoMunicipal,"
                        + "InmDgr,"
                        + "InmAgua,"
                        + "InmLuz,"
                        + "InmGas,"
                        + "InmExpensas,"
                        + "LocadorNombre,"
                        + "LocadorTelefono,"
                        + "LocadorMail,"
                        + "LocadorDomicilio,"
                        + "LocadorFechaNacimiento,"
                        + "LocadorTipoNroDocumento,"
                        + "LocadorNroDocumento,"
                        + "LocadorOtrosDatos,"
                        + "LocatarioNombre,"
                        + "LocatarioTelefono,"
                        + "LocatarioMail,"
                        + "LocatarioTipoNroDocumento,"
                        + "LocatarioNroDocumento,"
                        + "LocatarioOtrosDatos,"
                        + "Garante1Nombre,"
                        + "Garante1Telefono,"
                        + "Garante1Mail,"
                        + "Garante1Domicilio,"
                        + "Garante2Nombre,"
                        + "Garante2Telefono,"
                        + "Garante2Mail,"
                        + "Garante2Domicilio,"
                        + "Garante3Nombre,"
                        + "Garante3Telefono,"
                        + "Garante3Mail,"
                        + "Garante3Domicilio,"
                        + "Garante4Nombre,"
                        + "Garante4Telefono,"
                        + "Garante4Mail,"
                        + "Garante4Domicilio,"
                        + "OtrosGarantes,"
                        + "MontoAlquiler,"
                        + "TitularImpuestoMunicipal,"
                        + "TitularDgr,"
                        + "TitularAgua,"
                        + "TitularLuz,"
                        + "TitularGas,"
                        + "TitularExpensas,"
                        + "Observaciones,"
                        + "FechaSubscripcion,"
                        + "FechaInicio,"
                        + "FechaFinalizacion,"
                        + "EstadoActual)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                ps.setString(1, legv.getLegajo());
                
                ps.setString(2, legv.getInmCalle());
                ps.setString(3, legv.getInmPisoDepto());
                ps.setString(4, legv.getInmBarrio());
                ps.setString(5, legv.getInmCodigoPostal());
                ps.setString(6, legv.getInmProvinciaLocalidad());
                ps.setString(7, legv.getInmTipo());
                ps.setString(8, legv.getInmOperacion());
                ps.setString(9, legv.getInmDormitorios());
                ps.setString(10, legv.getInmBaños());
                ps.setString(11, legv.getInmPlantas());
                ps.setString(12, legv.getInmAntiguedad());
                ps.setString(13, legv.getInmEstadoGeneral());
                ps.setString(14, legv.getInmValor());
                ps.setString(15, legv.getInmSuperficieTerreno());
                ps.setString(16, legv.getInmSuperficieCubierta());
                ps.setString(17, legv.getInmMtsFrente());
                ps.setString(18, legv.getInmMtsFondo());
                ps.setString(19, legv.getInmCantidadLlaves());
                ps.setString(20, legv.getInmEstilo());
                ps.setString(21, legv.getInmOrientacion());
                ps.setString(22, legv.getInmGarage());
                ps.setString(23, legv.getInmLiving());
                ps.setString(24, legv.getInmCocina());
                ps.setString(25, legv.getInmComedor());
                ps.setString(26, legv.getInmDependencia());
                ps.setString(27, legv.getInmPiscina());
                ps.setString(28, legv.getInmPatioJardin());
                ps.setString(29, legv.getInmAccesorios());
                ps.setString(30, legv.getInmComentarios());
                ps.setString(31, legv.getInmOtrasObservaciones());
                ps.setString(32, legv.getInmImpuestoMunicipal());
                ps.setString(33, legv.getInmDgr());
                ps.setString(34, legv.getInmAgua());
                ps.setString(35, legv.getInmLuz());
                ps.setString(36, legv.getInmGas());
                ps.setString(37, legv.getInmExpensas());
                
                ps.setString(38, legv.getLocadorNombre());
                ps.setString(39, legv.getLocadorTelefono());
                ps.setString(40, legv.getLocadorMail());
                ps.setString(41, legv.getLocadorDomicilio());
                ps.setDate(42, legv.getLocadorFechaNacimiento());
                ps.setString(43, legv.getLocadorTipoNroDocumento());
                ps.setString(44, legv.getLocadorNroDocument());
                ps.setString(45, legv.getLocadorOtrosDatos());
                
                ps.setString(46, legv.getLocatarioNombre());
                ps.setString(47, legv.getLocatarioTelefono());
                ps.setString(48, legv.getLocatarioMail());
                ps.setString(49, legv.getLocatarioTipoNroDocumento());
                ps.setString(50, legv.getLocatarioNroDocumento());
                ps.setString(51, legv.getLocatarioOtrosDatos());
                
                ps.setString(52, legv.getGarante1Nombre());
                ps.setString(53, legv.getGarante1Telefono());
                ps.setString(54, legv.getGarante1Domicilio());
                ps.setString(55, legv.getGarante1Mail());
                
                ps.setString(56, legv.getGarante2Nombre());
                ps.setString(57, legv.getGarante2Telefono());
                ps.setString(58, legv.getGarante2Domicilio());
                ps.setString(59, legv.getGarante2Mail());
                
                ps.setString(60, legv.getGarante3Nombre());
                ps.setString(61, legv.getGarante3Telefono());
                ps.setString(62, legv.getGarante3Domicilio());
                ps.setString(63, legv.getGarante3Mail());
                
                ps.setString(64, legv.getGarante4Nombre());
                ps.setString(65, legv.getGarante4Telefono());
                ps.setString(66, legv.getGarante4Domicilio());
                ps.setString(67, legv.getGarante4Mail());
                
                ps.setString(68, legv.getOtrosGarantes());
                ps.setString(69, legv.getMontoAlquiler());
                ps.setString(70, legv.getTitularImpuestoMunicipal());
                ps.setString(71, legv.getTitularDgr());
                ps.setString(72, legv.getTitularAgua());
                ps.setString(73, legv.getTitularLuz());
                ps.setString(74, legv.getTitularGas());
                ps.setString(75, legv.getTitularExpensas());
                ps.setString(76, legv.getObservaciones());
                ps.setDate(77, legv.getFechaSubscripcion());
                ps.setDate(78, legv.getFechaInicio());
                ps.setDate(79, legv.getFechaFinalizacion());
                ps.setString(80, legv.getEstadoActual());

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha agregado a legajos viejos", null, JOptionPane.PLAIN_MESSAGE);
                }

                con.close();
                return true;
            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("aaa");
                return false;
            }
            
        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void eliminarLegajoViejo(int idLegajoViejo) {
        Connection con;
        PreparedStatement ps;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("DELETE FROM legajosviejos WHERE idLegajosViejos = ?");
                ps.setInt(1, idLegajoViejo);

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
