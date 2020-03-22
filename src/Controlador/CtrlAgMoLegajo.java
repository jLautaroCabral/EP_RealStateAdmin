/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasInmueble;
import Modelo.ConsultasLegajo;
import Modelo.ConsultasLocatario;
import Modelo.Inmueble;
import Modelo.Legajo;
import Vista.JfAgregarModificarLegajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lauti
 */
public class CtrlAgMoLegajo implements ActionListener {
    JfAgregarModificarLegajo jfAgregarModificarLegajo;
    boolean modific;
    int idField;
    ArrayList<String> direccionesInmuebles = new ArrayList<>();
    ArrayList<Inmueble> inmuebles = new ArrayList<>();

    public CtrlAgMoLegajo() {     
        // Preparar ventana
        jfAgregarModificarLegajo = new JfAgregarModificarLegajo();
        jfAgregarModificarLegajo.setTitle("Agregar legajo");
        jfAgregarModificarLegajo.btnAgregar.setText("Agregar legajo");
        jfAgregarModificarLegajo.setLocationRelativeTo(null);
        configurarCmbLocatarios();
        configurarCmbInmuebles();

        // Añadir oyentes
        jfAgregarModificarLegajo.btnAgregar.addActionListener(this);
    }

    public CtrlAgMoLegajo(boolean modificar) {
        modific = modificar;

        // Preparar ventana
        jfAgregarModificarLegajo = new JfAgregarModificarLegajo();
        jfAgregarModificarLegajo.setTitle("Modificar inmueble");
        jfAgregarModificarLegajo.btnAgregar.setText("Modificar inmueble");
        jfAgregarModificarLegajo.setLocationRelativeTo(null);
        configurarCmbLocatarios();
        configurarCmbInmuebles();

        // Añadir oyentes
        jfAgregarModificarLegajo.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jfAgregarModificarLegajo.btnAgregar && comprobarCamposDeFechasNoNulos()) {
            if (!modific) {
                Legajo legajo = crearLegajoSegunCampos();
                if(ConsultasLegajo.insertarLegajo(legajo)) ocultarVentana();
            } else {
                Legajo legajo = crearLegajoSegunCampos();
                if(ConsultasLegajo.modificarLegajo(legajo, idField)) ocultarVentana();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Compruebe que llenó correctamente los campos con fechas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarVentana() {
        jfAgregarModificarLegajo.setVisible(true);
    }
    
    public void ocultarVentana() {
        jfAgregarModificarLegajo.setVisible(false);
    }
    
    public void limpiarCampos() { 
        jfAgregarModificarLegajo.legajo.setText(null);
        
        jfAgregarModificarLegajo.cmbInmueble.setSelectedIndex(0);
        jfAgregarModificarLegajo.cmbLocatario.setSelectedIndex(0);
        
        jfAgregarModificarLegajo.garante1Nombre.setText(null);
        jfAgregarModificarLegajo.garante1Telefono.setText(null);
        jfAgregarModificarLegajo.garante1Domicilio.setText(null);
        jfAgregarModificarLegajo.garante1Mail.setText(null);
        
        jfAgregarModificarLegajo.garante2Nombre.setText(null);
        jfAgregarModificarLegajo.garante2Telefono.setText(null);
        jfAgregarModificarLegajo.garante2Domicilio.setText(null);
        jfAgregarModificarLegajo.garante2Mail.setText(null);
        
        jfAgregarModificarLegajo.garante3Nombre.setText(null);
        jfAgregarModificarLegajo.garante3Telefono.setText(null);
        jfAgregarModificarLegajo.garante3Domicilio.setText(null);
        jfAgregarModificarLegajo.garante3Mail.setText(null);
        
        jfAgregarModificarLegajo.garante4Nombre.setText(null);
        jfAgregarModificarLegajo.garante4Telefono.setText(null);
        jfAgregarModificarLegajo.garante4Domicilio.setText(null);
        jfAgregarModificarLegajo.garante4Mail.setText(null);
        
        jfAgregarModificarLegajo.txtOtrosGarantes.setText(null);
        
        jfAgregarModificarLegajo.dateFechaSubscripcion.setDate(null);
        jfAgregarModificarLegajo.dateFechaInicio.setDate(null);
        jfAgregarModificarLegajo.dateFechaFinalizacion.setDate(null);
        
        
        jfAgregarModificarLegajo.montoAlquiler.setText(null);
        jfAgregarModificarLegajo.titularImpuestoMunicipal.setText(null);
        jfAgregarModificarLegajo.titularDGR.setText(null);
        jfAgregarModificarLegajo.titularAgua.setText(null);
        jfAgregarModificarLegajo.titularLuz.setText(null);
        jfAgregarModificarLegajo.titularGas.setText(null);
        jfAgregarModificarLegajo.titularExpensas.setText(null);
        
        jfAgregarModificarLegajo.txtObservaciones.setText(null);
    }
    
    private void configurarCmbLocatarios() {
        ArrayList<String> nombresAAgregar = ConsultasLocatario.getNombresLocatarios();
        for (int i = 0; i < nombresAAgregar.size(); i++) {
            jfAgregarModificarLegajo.cmbLocatario.addItem(nombresAAgregar.get(i));
        }
    }
    
    private void configurarCmbInmuebles() {
        inmuebles = ConsultasInmueble.getDireccionesYPisoDepto();
        System.out.println(inmuebles.get(1).getCalle());
        for (int i = 0; i < inmuebles.size(); i++) {
            direccionesInmuebles.add(inmuebles.get(i).getCalle());
            jfAgregarModificarLegajo.cmbInmueble.addItem(inmuebles.get(i).getCalle() + " - Piso Depto: " + inmuebles.get(i).getPisoDepto());
        }
    }
    private boolean comprobarCamposDeFechasNoNulos() {
        return jfAgregarModificarLegajo.dateFechaInicio.getDate() != null ||
               jfAgregarModificarLegajo.dateFechaSubscripcion.getDate() != null ||
               jfAgregarModificarLegajo.dateFechaFinalizacion.getDate() != null;
    }
    
    private Legajo crearLegajoSegunCampos() { 
        Legajo legajo = new Legajo();
        Inmueble inmueble = ConsultasInmueble.getInmueble(ConsultasInmueble.getIdInmuebleSegunDireccion(direccionesInmuebles.get(jfAgregarModificarLegajo.cmbInmueble.getSelectedIndex())));
        legajo.setIdInmueble(ConsultasInmueble.getIdInmuebleSegunDireccion(direccionesInmuebles.get(jfAgregarModificarLegajo.cmbInmueble.getSelectedIndex())));
        legajo.setIdLocador(inmueble.getIdLocador());
        legajo.setIdLocatario(ConsultasLocatario.getIdLocatarioSegunNombre((String) jfAgregarModificarLegajo.cmbLocatario.getSelectedItem()));
        
        legajo.setLegajo(jfAgregarModificarLegajo.legajo.getText());
        
        legajo.setGarante1Nombre(jfAgregarModificarLegajo.garante1Nombre.getText());
        legajo.setGarante1Telefono(jfAgregarModificarLegajo.garante1Telefono.getText());
        legajo.setGarante1Domicilio(jfAgregarModificarLegajo.garante1Domicilio.getText());
        legajo.setGarante1Mail(jfAgregarModificarLegajo.garante1Mail.getText());
        
        legajo.setGarante2Nombre(jfAgregarModificarLegajo.garante2Nombre.getText());
        legajo.setGarante2Telefono(jfAgregarModificarLegajo.garante2Telefono.getText());
        legajo.setGarante2Domicilio(jfAgregarModificarLegajo.garante2Domicilio.getText());
        legajo.setGarante2Mail(jfAgregarModificarLegajo.garante2Mail.getText());
        
        legajo.setGarante3Nombre(jfAgregarModificarLegajo.garante3Nombre.getText());
        legajo.setGarante3Telefono(jfAgregarModificarLegajo.garante3Telefono.getText());
        legajo.setGarante3Domicilio(jfAgregarModificarLegajo.garante3Domicilio.getText());
        legajo.setGarante3Mail(jfAgregarModificarLegajo.garante3Mail.getText());
        
        legajo.setGarante4Nombre(jfAgregarModificarLegajo.garante4Nombre.getText());
        legajo.setGarante4Telefono(jfAgregarModificarLegajo.garante4Telefono.getText());
        legajo.setGarante4Domicilio(jfAgregarModificarLegajo.garante4Domicilio.getText());
        legajo.setGarante4Mail(jfAgregarModificarLegajo.garante4Mail.getText());
        
        legajo.setOtrosGarantes(jfAgregarModificarLegajo.txtOtrosGarantes.getText());
        legajo.setMontoAlquiler(jfAgregarModificarLegajo.montoAlquiler.getText());
        legajo.setTitularImpuestoMunicipal(jfAgregarModificarLegajo.titularImpuestoMunicipal.getText());
        legajo.setTitularDgr(jfAgregarModificarLegajo.titularDGR.getText());
        legajo.setTitularAgua(jfAgregarModificarLegajo.titularAgua.getText());
        legajo.setTitularLuz(jfAgregarModificarLegajo.titularLuz.getText());
        legajo.setTitularGas(jfAgregarModificarLegajo.titularGas.getText());
        legajo.setTitularExpensas(jfAgregarModificarLegajo.titularExpensas.getText());
        legajo.setObservaciones(jfAgregarModificarLegajo.txtObservaciones.getText());
        
        // Conversiones de fecha
        java.util.Date d;
        long date;
        java.sql.Date fechaSubscripcion;
        java.sql.Date fechaInicio;
        java.sql.Date fechaFinalizacion;
        
        d = jfAgregarModificarLegajo.dateFechaSubscripcion.getDate();
        date = d.getTime();
        fechaSubscripcion = new java.sql.Date(date);
        legajo.setFechaSubscripcion(fechaSubscripcion);
        
        d = jfAgregarModificarLegajo.dateFechaInicio.getDate();
        date = d.getTime();
        fechaInicio = new java.sql.Date(date);
        legajo.setFechaInicio(fechaInicio);
        
        d = jfAgregarModificarLegajo.dateFechaFinalizacion.getDate();
        date = d.getTime();
        fechaFinalizacion = new java.sql.Date(date);
        legajo.setFechaFinalizacion(fechaFinalizacion);
        
        legajo.setEstadoActual("EN CURSO");

        return legajo;
    }

    public void rellenarCamposSegunLegajo(int idLegajo) {
        idField = idLegajo;
        
        Legajo legajo = ConsultasLegajo.getLegajo(idLegajo);
        
        jfAgregarModificarLegajo.legajo.setText(legajo.getLegajo());
        
        jfAgregarModificarLegajo.cmbInmueble.setSelectedItem(ConsultasInmueble.getInmueble(legajo.getIdInmueble()).getCalle());
        jfAgregarModificarLegajo.cmbLocatario.setSelectedItem(ConsultasLocatario.getLocatario(legajo.getIdLocatario()).getNombre());
        
        jfAgregarModificarLegajo.garante1Nombre.setText(legajo.getGarante1Nombre());
        jfAgregarModificarLegajo.garante1Telefono.setText(legajo.getGarante1Telefono());
        jfAgregarModificarLegajo.garante1Domicilio.setText(legajo.getGarante1Domicilio());
        jfAgregarModificarLegajo.garante1Mail.setText(legajo.getGarante1Mail());
        
        jfAgregarModificarLegajo.garante2Nombre.setText(legajo.getGarante2Nombre());
        jfAgregarModificarLegajo.garante2Telefono.setText(legajo.getGarante2Telefono());
        jfAgregarModificarLegajo.garante2Domicilio.setText(legajo.getGarante2Domicilio());
        jfAgregarModificarLegajo.garante2Mail.setText(legajo.getGarante2Mail());
        
        jfAgregarModificarLegajo.garante3Nombre.setText(legajo.getGarante3Nombre());
        jfAgregarModificarLegajo.garante3Telefono.setText(legajo.getGarante3Telefono());
        jfAgregarModificarLegajo.garante3Domicilio.setText(legajo.getGarante3Domicilio());
        jfAgregarModificarLegajo.garante3Mail.setText(legajo.getGarante3Mail());
        
        jfAgregarModificarLegajo.garante4Nombre.setText(legajo.getGarante4Nombre());
        jfAgregarModificarLegajo.garante4Telefono.setText(legajo.getGarante4Telefono());
        jfAgregarModificarLegajo.garante4Domicilio.setText(legajo.getGarante4Domicilio());
        jfAgregarModificarLegajo.garante4Mail.setText(legajo.getGarante4Mail());
        
        jfAgregarModificarLegajo.txtOtrosGarantes.setText(legajo.getOtrosGarantes());
        
        jfAgregarModificarLegajo.dateFechaSubscripcion.setDate(legajo.getFechaSubscripcion());
        jfAgregarModificarLegajo.dateFechaInicio.setDate(legajo.getFechaInicio());
        jfAgregarModificarLegajo.dateFechaFinalizacion.setDate(legajo.getFechaFinalizacion());
        
        
        jfAgregarModificarLegajo.montoAlquiler.setText(legajo.getMontoAlquiler());
        jfAgregarModificarLegajo.titularImpuestoMunicipal.setText(legajo.getTitularImpuestoMunicipal());
        jfAgregarModificarLegajo.titularDGR.setText(legajo.getTitularDgr());
        jfAgregarModificarLegajo.titularAgua.setText(legajo.getTitularAgua());
        jfAgregarModificarLegajo.titularLuz.setText(legajo.getTitularLuz());
        jfAgregarModificarLegajo.titularGas.setText(legajo.getTitularGas());
        jfAgregarModificarLegajo.titularExpensas.setText(legajo.getTitularExpensas());
        
        jfAgregarModificarLegajo.txtObservaciones.setText(legajo.getObservaciones());
    }
    
}
