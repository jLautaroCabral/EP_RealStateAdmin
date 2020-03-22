/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasLocador;
import Modelo.Locador;
import Vista.JfAgregarModificarLocadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lauti
 */
public class CtrlAgMoLocador implements ActionListener {

    JfAgregarModificarLocadores vAgregarModificar;
    int idField;
    boolean modific = false;

    public CtrlAgMoLocador() {
        // Preparar ventana
        vAgregarModificar = new JfAgregarModificarLocadores();
        vAgregarModificar.setTitle("Agregar locador");
        vAgregarModificar.labelTitulo.setText("AGREGAR LOCADOR");
        vAgregarModificar.btnAgMo.setText("Agregar");
        vAgregarModificar.setLocationRelativeTo(null);
        
        // Añadir oyentes
        vAgregarModificar.btnAgMo.addActionListener(this);
    }

    public CtrlAgMoLocador(boolean modificar) {
        modific = modificar;
        // Preparar ventana
        vAgregarModificar = new JfAgregarModificarLocadores();
        vAgregarModificar.setTitle("Modificar locador");
        vAgregarModificar.labelTitulo.setText("MODIFICAR LOCADOR");
        vAgregarModificar.btnAgMo.setText("Modificar");
        vAgregarModificar.setLocationRelativeTo(null);
        
        // Añadir oyentes
        vAgregarModificar.btnAgMo.addActionListener(this);
    }
    
    public void mostrarVentana() {
        vAgregarModificar.setVisible(true);
    }
    
    public void ocultarVentana() {
        vAgregarModificar.setVisible(false);
    }
    
    public void limpiarCampos() {
        vAgregarModificar.mail.setText(null);
        vAgregarModificar.nombre.setText(null);
        vAgregarModificar.nroDocum.setText(null);
        vAgregarModificar.telefono.setText(null);
        vAgregarModificar.cmbTipoNroDocum.setSelectedIndex(0);
        vAgregarModificar.otrosDatos.setText(null);
    }
    
    public void rellenarCamposSegunLocador(int idLocador) {
        Locador locador = ConsultasLocador.getLocador(idLocador);
        
        idField = idLocador;
        vAgregarModificar.nombre.setText(locador.getNombre());
        vAgregarModificar.telefono.setText(locador.getTelefono());
        vAgregarModificar.mail.setText(locador.getMail());
        vAgregarModificar.domicilio.setText(locador.getDomicilio());
        vAgregarModificar.dateFechaNacimiento.setDate(locador.getFechaNacimiento());
        vAgregarModificar.nroDocum.setText(locador.getNroDocumento());
        vAgregarModificar.otrosDatos.setText(locador.getOtrosDatos());
        
        switch(locador.getTipoNroDocumento()) {
            case "DNI - CUIT":
                vAgregarModificar.cmbTipoNroDocum.setSelectedItem("DNI - CUIT");
                break;
            default:
                System.out.println("malio sal");
                vAgregarModificar.cmbTipoNroDocum.setSelectedItem(null);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vAgregarModificar.btnAgMo) {
            if(!modific) {
                // Agregar locador
                Locador locador = new Locador();
                locador.setNombre(vAgregarModificar.nombre.getText());
                locador.setTelefono(vAgregarModificar.telefono.getText());
                locador.setMail(vAgregarModificar.mail.getText());
                locador.setDomicilio(vAgregarModificar.domicilio.getText());
                
                // Conversion de fecha
                java.util.Date d = vAgregarModificar.dateFechaNacimiento.getDate();
                long date = d.getTime();
                java.sql.Date fecha = new java.sql.Date(date);
                
                locador.setFechaNacimiento(fecha);
                
                locador.setTipoNroDocumento((String) vAgregarModificar.cmbTipoNroDocum.getModel().getSelectedItem());
                locador.setNroDocumento(vAgregarModificar.nroDocum.getText());
                locador.setOtrosDatos(vAgregarModificar.otrosDatos.getText());
                if(ConsultasLocador.insertarLocador(locador)) ocultarVentana();
            } else {
                // Modificar locador
                Locador locador = new Locador();
                locador.setNombre(vAgregarModificar.nombre.getText());
                locador.setTelefono(vAgregarModificar.telefono.getText());
                locador.setMail(vAgregarModificar.mail.getText());
                locador.setDomicilio(vAgregarModificar.domicilio.getText());
                
                // Conversion de fecha
                java.util.Date d = vAgregarModificar.dateFechaNacimiento.getDate();
                long date = d.getTime();
                java.sql.Date fecha = new java.sql.Date(date);
                
                locador.setFechaNacimiento(fecha);
                
                locador.setTipoNroDocumento((String) vAgregarModificar.cmbTipoNroDocum.getModel().getSelectedItem());
                locador.setNroDocumento(vAgregarModificar.nroDocum.getText());
                locador.setOtrosDatos(vAgregarModificar.otrosDatos.getText());
                if(ConsultasLocador.modificarLocador(locador, idField)) ocultarVentana();
            }
        }
    }
}
