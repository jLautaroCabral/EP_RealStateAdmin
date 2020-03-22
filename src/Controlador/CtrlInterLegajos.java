/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasInmueble;
import Modelo.ConsultasLegajo;
import Modelo.ConsultasLegajoViejo;
import Modelo.ConsultasLocador;
import Modelo.ConsultasLocatario;
import Modelo.Inmueble;
import Modelo.Legajo;
import Modelo.LegajoViejo;
import Modelo.Locador;
import Modelo.Locatario;
import Vista.InterLegajos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lauti
 */
public class CtrlInterLegajos implements ActionListener, KeyListener {

    // Ventana y controladores
    InterLegajos interLegajos;
    CtrlAgMoLegajo ctrlAgregarLegajo;
    CtrlAgMoLegajo ctrlModificarLegajo;
    CtrlDetallesLegajo ctrlDetallesLegajo;

    // Otro
    DefaultTableModel tableModel = new DefaultTableModel();

    public CtrlInterLegajos() {

        // Preparar ventana
        interLegajos = new InterLegajos();
        interLegajos.setTitle("Legajos");
        añadirOyentesDeEvento();
        interLegajos.show();

        // Preparar tabla
        interLegajos.jtLegajos.setModel(tableModel);
        tableModel.addColumn("idLegajo");
        tableModel.addColumn("Locador");
        tableModel.addColumn("Inmueble");
        tableModel.addColumn("Piso - Depto");
        tableModel.addColumn("Locatario");
        ajustarConfiguraciónTabla();
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Al presionar BOTON BUSCAR
        if (e.getSource() == interLegajos.btnBuscar) {
            actualizarTabla(interLegajos.buscador.getText(), interLegajos.cmbSeleccion.getSelectedIndex());
        }

        // Al preisonar BOTON ACTUALIZAR
        if (e.getSource() == interLegajos.btnActualizar) {
            actualizarTabla();
        }

        // Al presionar BOTON DETALLES LEGAJO (Seguridad de selección incluida)
        if (e.getSource() == interLegajos.btnVerResumenDelLegajo) {
            int filaSeleccionada = interLegajos.jtLegajos.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idLegajoSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlDetallesLegajo == null) {
                    ctrlDetallesLegajo = new CtrlDetallesLegajo();
                    ctrlDetallesLegajo.rellanarResumenSegunLegajo(idLegajoSeleccionado);
                    ctrlDetallesLegajo.mostrarVentana();
                } else {
                    ctrlDetallesLegajo.rellanarResumenSegunLegajo(idLegajoSeleccionado);
                    ctrlDetallesLegajo.mostrarVentana();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Al presionar BOTON MOVER A FINALIZADOS (Seguridad de selección incluida)
        if (e.getSource() == interLegajos.btnMoverAFinalizados) {

            int filaSeleccionada = interLegajos.jtLegajos.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int a = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere mover el legajo a finalizados?\n Al moverse a finalizados el cambio será permanente", "Seguridad", JOptionPane.WARNING_MESSAGE);
                if (a == 0) {
                    int idLegajoSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                    if(ConsultasLegajoViejo.insertarLegajoViejo(crearLegajoViejoAPartirDeId(idLegajoSeleccionado))) {
                        ConsultasLegajo.eliminarLegajo(idLegajoSeleccionado);
                    }
                    actualizarTabla();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Al presionar BOTON ELIMINAR LEGAJO (Seguridad de selección incluida)
        if (e.getSource() == interLegajos.btnEliminarLegajo) {

            int filaSeleccionada = interLegajos.jtLegajos.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int a = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el legajo?\n Al borrar el legajo se borrará permanentemente", "Seguridad", JOptionPane.WARNING_MESSAGE);
                if (a == 0) {
                    int idLegajoSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                    ConsultasLegajo.eliminarLegajo(idLegajoSeleccionado);
                    actualizarTabla();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Al presionar BOTON MODIFICAR LEGAJO (Seguridad de selección incluida)
        if (e.getSource() == interLegajos.btnModificarLegajo) {

            int filaSeleccionada = interLegajos.jtLegajos.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idLegajoSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlModificarLegajo == null) {
                    ctrlModificarLegajo = new CtrlAgMoLegajo(true);
                    ctrlModificarLegajo.rellenarCamposSegunLegajo(idLegajoSeleccionado);
                    ctrlModificarLegajo.mostrarVentana();
                } else {
                    ctrlModificarLegajo.rellenarCamposSegunLegajo(idLegajoSeleccionado);
                    ctrlModificarLegajo.mostrarVentana();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Al presionar BOTON NUEVO LEGAJO
        if (e.getSource() == interLegajos.btnNuevoLegajo) {
            if (ctrlAgregarLegajo == null) {
                ctrlAgregarLegajo = new CtrlAgMoLegajo();
                ctrlAgregarLegajo.mostrarVentana();
            } else {
                ctrlAgregarLegajo.limpiarCampos();
                ctrlAgregarLegajo.mostrarVentana();
            }
        }
    }
    
        @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        actualizarTabla(interLegajos.buscador.getText(), interLegajos.cmbSeleccion.getSelectedIndex());
    }

    public InterLegajos getInterLegajo() {
        return interLegajos;
    }

    public void mostrarInterLegajo() {
        interLegajos.show();
    }

    public void ocultarInterLegajo() {
        interLegajos.hide();
    }

    private void añadirOyentesDeEvento() {
        interLegajos.btnBuscar.addActionListener(this);
        interLegajos.btnVerResumenDelLegajo.addActionListener(this);
        interLegajos.btnEliminarLegajo.addActionListener(this);
        interLegajos.btnModificarLegajo.addActionListener(this);
        interLegajos.btnNuevoLegajo.addActionListener(this);
        interLegajos.btnActualizar.addActionListener(this);
        interLegajos.btnMoverAFinalizados.addActionListener(this);
        
        interLegajos.buscador.addKeyListener(this);
    }

    private LegajoViejo crearLegajoViejoAPartirDeId(int idLegajoSeleccionado) {
        LegajoViejo legajoViejo = new LegajoViejo();
        Legajo legajoSeleccionado = new Legajo();
        Inmueble inm = new Inmueble();
        Locador loc = new Locador();
        Locatario loct = new Locatario();
        
        legajoSeleccionado = ConsultasLegajo.getLegajo(idLegajoSeleccionado);
        inm = ConsultasInmueble.getInmueble(legajoSeleccionado.getIdInmueble());
        loc = ConsultasLocador.getLocador(legajoSeleccionado.getIdLocador());
        loct = ConsultasLocatario.getLocatario(legajoSeleccionado.getIdLocatario());
        
        // Rellenar datos de inmueble
        legajoViejo.setLegajo(legajoSeleccionado.getLegajo());
        legajoViejo.setInmCalle(inm.getCalle());
        legajoViejo.setInmPisoDepto(inm.getPisoDepto());
        legajoViejo.setInmBarrio(inm.getBarrio());
        legajoViejo.setInmCodigoPostal(inm.getCodigoPostal());
        legajoViejo.setInmProvinciaLocalidad(inm.getProvinciaLocalidad());
        legajoViejo.setInmTipo(inm.getTipo());
        legajoViejo.setInmOperacion(inm.getOperacion());
        legajoViejo.setInmDormitorios(inm.getDormitorios());
        legajoViejo.setInmBaños(inm.getBaños());
        legajoViejo.setInmPlantas(inm.getPlantas());
        legajoViejo.setInmAntiguedad(inm.getAntiguedad());
        legajoViejo.setEstadoActual(inm.getEstadoGeneral());
        legajoViejo.setInmValor(inm.getValor());
        legajoViejo.setInmSuperficieTerreno(inm.getSuperficieTerreno());
        legajoViejo.setInmSuperficieCubierta(inm.getSuperficieCubierta());
        legajoViejo.setInmMtsFrente(inm.getMtsFrente());
        legajoViejo.setInmMtsFondo(inm.getMtsFondo());
        legajoViejo.setInmCantidadLlaves(inm.getCantidadLlaves());
        legajoViejo.setInmEstilo(inm.getEstilo());
        legajoViejo.setInmOrientacion(inm.getOrientacion());
        legajoViejo.setInmGarage(inm.getGarage());
        legajoViejo.setInmLiving(inm.getLiving());
        legajoViejo.setInmCocina(inm.getCocina());
        legajoViejo.setInmComedor(inm.getComedor());
        legajoViejo.setInmDependencia(inm.getDependencia());
        legajoViejo.setInmPiscina(inm.getPiscina());
        legajoViejo.setInmPatioJardin(inm.getPatioJardin());
        legajoViejo.setInmAccesorios(inm.getAccesorios());
        legajoViejo.setInmComentarios(inm.getComentarios());
        legajoViejo.setInmOtrasObservaciones(inm.getOtrasObservaciones());
        legajoViejo.setInmImpuestoMunicipal(inm.getImpuestoMunicipal());
        legajoViejo.setInmDgr(inm.getDgr());
        legajoViejo.setInmAgua(inm.getAgua());
        legajoViejo.setInmLuz(inm.getLuz());
        legajoViejo.setInmGas(inm.getGas());
        legajoViejo.setInmExpensas(inm.getExpensas());
        
        // Rellenar datos de locador
        legajoViejo.setLocadorNombre(loc.getNombre());
        legajoViejo.setLocadorTelefono(loc.getTelefono());
        legajoViejo.setLocadorMail(loc.getMail());
        legajoViejo.setLocadorDomicilio(loc.getDomicilio());
        legajoViejo.setLocadorFechaNacimiento(loc.getFechaNacimiento());
        legajoViejo.setLocadorTipoNroDocumento(loc.getTipoNroDocumento());
        legajoViejo.setLocadorOtrosDatos(loc.getOtrosDatos());
        
        // Rellenar datos de locatario
        legajoViejo.setLocatarioNombre(loct.getNombre());
        legajoViejo.setLocatarioTelefono(loct.getTelefono());
        legajoViejo.setLocatarioMail(loct.getMail());
        legajoViejo.setLocatarioTipoNroDocumento(loct.getTipoNroDocumento());
        legajoViejo.setLocatarioNroDocumento(loct.getNroDocumento());
        legajoViejo.setLocatarioOtrosDatos(loct.getOtrosDatos());
        
        // Rellenar datos del legajo
        legajoViejo.setGarante1Nombre(legajoSeleccionado.getGarante1Nombre());
        legajoViejo.setGarante1Telefono(legajoSeleccionado.getGarante1Telefono());
        legajoViejo.setGarante1Domicilio(legajoSeleccionado.getGarante1Domicilio());
        legajoViejo.setGarante1Mail(legajoSeleccionado.getGarante1Mail());
        legajoViejo.setGarante2Nombre(legajoSeleccionado.getGarante1Nombre());
        legajoViejo.setGarante2Telefono(legajoSeleccionado.getGarante1Telefono());
        legajoViejo.setGarante2Domicilio(legajoSeleccionado.getGarante1Domicilio());
        legajoViejo.setGarante2Mail(legajoSeleccionado.getGarante1Mail());
        legajoViejo.setGarante3Nombre(legajoSeleccionado.getGarante1Nombre());
        legajoViejo.setGarante3Telefono(legajoSeleccionado.getGarante1Telefono());
        legajoViejo.setGarante3Domicilio(legajoSeleccionado.getGarante1Domicilio());
        legajoViejo.setGarante3Mail(legajoSeleccionado.getGarante1Mail());
        legajoViejo.setGarante4Nombre(legajoSeleccionado.getGarante1Nombre());
        legajoViejo.setGarante4Telefono(legajoSeleccionado.getGarante1Telefono());
        legajoViejo.setGarante4Domicilio(legajoSeleccionado.getGarante1Domicilio());
        legajoViejo.setGarante4Mail(legajoSeleccionado.getGarante1Mail());
        legajoViejo.setOtrosGarantes(legajoSeleccionado.getOtrosGarantes());
        legajoViejo.setMontoAlquiler(legajoSeleccionado.getMontoAlquiler());
        legajoViejo.setTitularImpuestoMunicipal(legajoSeleccionado.getTitularImpuestoMunicipal());
        legajoViejo.setTitularDgr(legajoSeleccionado.getTitularDgr());
        legajoViejo.setTitularAgua(legajoSeleccionado.getTitularAgua());
        legajoViejo.setTitularLuz(legajoSeleccionado.getTitularLuz());
        legajoViejo.setTitularGas(legajoSeleccionado.getTitularGas());
        legajoViejo.setTitularExpensas(legajoSeleccionado.getTitularExpensas());
        legajoViejo.setObservaciones(legajoSeleccionado.getObservaciones());
        legajoViejo.setFechaSubscripcion(legajoSeleccionado.getFechaSubscripcion());
        legajoViejo.setFechaInicio(legajoSeleccionado.getFechaInicio());
        legajoViejo.setFechaFinalizacion(legajoSeleccionado.getFechaFinalizacion());
        legajoViejo.setEstadoActual("Finalizado");
        
        return legajoViejo;
    }

    private void limpiarTabla() {
        int rowCount = interLegajos.jtLegajos.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    private void ajustarConfiguraciónTabla() {
        // No es necesario ajustar el tamaño de la columna idLocatarios porque no se ve
        // No quise sacarlo ahora por vago
        int[] anchos = {35, 70, 210, 40,70};
        interLegajos.jtLegajos.getColumnModel().getColumn(0).setMaxWidth(anchos[0]);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            interLegajos.jtLegajos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        interLegajos.jtLegajos.removeColumn(interLegajos.jtLegajos.getColumnModel().getColumn(0));
    }
    

    private void actualizarTabla() {
        limpiarTabla();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT idLegajo, Inmueble_idInmueble, Locatario_idLocatario FROM legajo ORDER BY Locador_idLocador");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Object[] campos = new Object[6];
                    Inmueble inmueble = ConsultasInmueble.getInmueble(rs.getInt("Inmueble_idInmueble"));

                    campos[0] = rs.getInt("idLegajo");
                    campos[1] = ConsultasLocador.getLocador(inmueble.getIdLocador()).getNombre();
                    campos[2] = inmueble.getCalle();
                    campos[3] = inmueble.getPisoDepto();
                    campos[4] = ConsultasLocatario.getLocatario(rs.getInt("Locatario_idLocatario")).getNombre();

                    tableModel.addRow(campos);
                }
                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Buscar en la base de datos según una palabra y una columna
    private void actualizarTabla(String palabraClave, int seleccionCmbBuscar) {
        String palabraClaveParaBuscar = "%" + palabraClave + "%";
        
        limpiarTabla();

        Connection con;
        PreparedStatement ps;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();

            try {

                switch (seleccionCmbBuscar) {
                    case 0:
                        ps = con.prepareStatement("SELECT idLegajo, Inmueble_idInmueble, Locatario_idLocatario, EstadoActual FROM legajo WHERE Locador_idLocador IN (SELECT idLocador FROM locador WHERE Nombre LIKE ?) ORDER BY Locador_idLocador");
                        ps.setString(1, palabraClaveParaBuscar);
                        rs = ps.executeQuery();
                        break;
                        
                    case 1:
                        ps = con.prepareStatement("SELECT idLegajo, Inmueble_idInmueble, Locatario_idLocatario, EstadoActual FROM legajo WHERE Locatario_idLocatario IN (SELECT idLocatario FROM locatario WHERE Nombre LIKE ?) ORDER BY Locador_idLocador");
                        ps.setString(1, palabraClaveParaBuscar);
                        rs = ps.executeQuery();
                        break;
                        
                    case 2:
                        ps = con.prepareStatement("SELECT idLegajo, Inmueble_idInmueble, Locatario_idLocatario, EstadoActual FROM legajo WHERE Inmueble_idInmueble IN (SELECT idInmueble FROM inmueble WHERE Calle LIKE ?) ORDER BY Locador_idLocador");
                        ps.setString(1, palabraClaveParaBuscar);
                        rs = ps.executeQuery();
                        break;
                        
                    default:     
                        ps = con.prepareStatement("SELECT idLegajo, Inmueble_idInmueble, Locatario_idLocatario, EstadoActual FROM legajo ORDER BY Locador_idLocador");
                        rs = ps.executeQuery();
                        break;
                }
                
                while (rs.next()) {
                    Object[] campos = new Object[6];
                    Inmueble inmueble = ConsultasInmueble.getInmueble(rs.getInt("Inmueble_idInmueble"));

                    campos[0] = rs.getInt("idLegajo");
                    campos[1] = ConsultasLocador.getLocador(inmueble.getIdLocador()).getNombre();
                    campos[2] = inmueble.getCalle();
                    campos[3] = inmueble.getPisoDepto();
                    campos[4] = ConsultasLocatario.getLocatario(rs.getInt("Locatario_idLocatario")).getNombre();
                    campos[5] = rs.getString("EstadoActual");

                    tableModel.addRow(campos);
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
