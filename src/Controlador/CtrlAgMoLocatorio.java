/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasLocatario;
import Modelo.Locatario;
import Vista.JfAgregarModificarLocatario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Lauti
 */
public class CtrlAgMoLocatorio implements ActionListener {

    JfAgregarModificarLocatario vAgregarModificar;
    int idField;
    boolean modific = false;

    public CtrlAgMoLocatorio() {
        // Preparar ventana
        vAgregarModificar = new JfAgregarModificarLocatario();
        vAgregarModificar.setTitle("Agregar locatario");
        vAgregarModificar.labelTitulo.setText("AGREGAR LOCATORIO");
        vAgregarModificar.btnAgMo.setText("Agregar");
        vAgregarModificar.setLocationRelativeTo(null);
        
        // Añadir oyentes
        vAgregarModificar.btnAgMo.addActionListener(this);
    }

    public CtrlAgMoLocatorio(boolean modificar) {
        modific = modificar;
        // Preparar ventana
        vAgregarModificar = new JfAgregarModificarLocatario();
        vAgregarModificar.setTitle("Modificar locatario");
        vAgregarModificar.labelTitulo.setText("MODIFICAR LOCATORIO");
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
    
    public void rellenarCamposSegunLocatario(int idLocatario) {
        Locatario locatario = ConsultasLocatario.getLocatario(idLocatario);
        
        idField = idLocatario;
        vAgregarModificar.nombre.setText(locatario.getNombre());
        vAgregarModificar.telefono.setText(locatario.getTelefono());
        vAgregarModificar.mail.setText(locatario.getMail());
        vAgregarModificar.nroDocum.setText(locatario.getNroDocumento());
        vAgregarModificar.otrosDatos.setText(locatario.getOtrosDatos());
        
        // Set ComboBox Tipo Nro Documento
        switch(locatario.getTipoNroDocumento()) {
            case "DNI - CUIT":
                vAgregarModificar.cmbTipoNroDocum.setSelectedItem("DNI - CUIT");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error al llenar el ComboBox", "Error", JOptionPane.ERROR_MESSAGE);
                vAgregarModificar.cmbTipoNroDocum.setSelectedItem(null);
                vAgregarModificar.setVisible(false);
                break;
        }
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vAgregarModificar.btnAgMo) {
            if(!modific) {
                // Agregar Locatario
                Locatario locatario = new Locatario();
                locatario.setNombre(vAgregarModificar.nombre.getText());
                locatario.setTelefono(vAgregarModificar.telefono.getText());
                locatario.setMail(vAgregarModificar.mail.getText());   
                locatario.setTipoNroDocumento((String) vAgregarModificar.cmbTipoNroDocum.getModel().getSelectedItem());
                locatario.setNroDocumento(vAgregarModificar.nroDocum.getText());
                locatario.setOtrosDatos(vAgregarModificar.otrosDatos.getText());
                if(ConsultasLocatario.insertarLocatario(locatario)) ocultarVentana();
            } else {
                // Modificar Locatario
                Locatario locatario = new Locatario();
                locatario.setNombre(vAgregarModificar.nombre.getText());
                locatario.setTelefono(vAgregarModificar.telefono.getText());
                locatario.setMail(vAgregarModificar.mail.getText());              
                locatario.setTipoNroDocumento((String) vAgregarModificar.cmbTipoNroDocum.getModel().getSelectedItem());
                locatario.setNroDocumento(vAgregarModificar.nroDocum.getText());
                locatario.setOtrosDatos(vAgregarModificar.otrosDatos.getText());
                if(ConsultasLocatario.modificarLocatario(locatario, idField)) ocultarVentana();
            }
        }
    }
}
