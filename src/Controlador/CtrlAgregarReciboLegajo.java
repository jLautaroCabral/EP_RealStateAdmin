/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasRecibos;
import Modelo.ReciboLegajo;
import Vista.JfAgregarReciboLegajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lauti
 */
public class CtrlAgregarReciboLegajo implements ActionListener{
    JfAgregarReciboLegajo vAgregarReciboLegajo;
    ReciboLegajo reciboTemporal;
    int idField;
    
    public CtrlAgregarReciboLegajo() {
        vAgregarReciboLegajo = new JfAgregarReciboLegajo();
        vAgregarReciboLegajo.setTitle("Nuevo recibo");
        vAgregarReciboLegajo.setLocationRelativeTo(null);  
        
        vAgregarReciboLegajo.btnAgregar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vAgregarReciboLegajo.btnAgregar) {
            crearReciboLegajoSegunCampos();
            ConsultasRecibos.insertarRecibo(reciboTemporal, idField);
        }
    }
    
    public void mostrarVentana() {
        vAgregarReciboLegajo.setVisible(true);
    }
    
    public void rellenarCamposSegunLegajo(ReciboLegajo recibo, int idLegajo) {
        reciboTemporal = recibo;
        idField = idLegajo;
        
        vAgregarReciboLegajo.nombreLocatario.setText(reciboTemporal.getNombreLocatario());
        vAgregarReciboLegajo.nombreLocatario2.setText(reciboTemporal.getNombreLocatario());
        
        vAgregarReciboLegajo.nombreLocador.setText(reciboTemporal.getNombreLocador());
        vAgregarReciboLegajo.nombreLocador2.setText(reciboTemporal.getNombreLocador());
        vAgregarReciboLegajo.dniLocador.setText(reciboTemporal.getDniLocador());
        
        vAgregarReciboLegajo.tipoInmueble.setText(reciboTemporal.getTipoInmueble());
        vAgregarReciboLegajo.tipoInmueble2.setText(reciboTemporal.getTipoInmueble());
        vAgregarReciboLegajo.direccionInmueble.setText(reciboTemporal.getDireccionInmueble());
        vAgregarReciboLegajo.direccionInmueble2.setText(reciboTemporal.getDireccionInmueble());
        vAgregarReciboLegajo.barrioInmueble.setText(reciboTemporal.getBarrioInmueble());
        
        // Preparar fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        
        vAgregarReciboLegajo.fecha.setText(dateFormat.format(reciboTemporal.getFechaDelRecibo()));
        vAgregarReciboLegajo.fecha2.setText(dateFormat.format(reciboTemporal.getFechaDelRecibo()));
        vAgregarReciboLegajo.hora.setText(timeFormat.format(reciboTemporal.getFechaDelRecibo()));
        vAgregarReciboLegajo.hora2.setText(timeFormat.format(reciboTemporal.getFechaDelRecibo()));
        System.out.println(timeFormat.format(recibo.getFechaDelRecibo()));
    }
    
    private void crearReciboLegajoSegunCampos(){
        
        reciboTemporal.setMontoEnLetras(vAgregarReciboLegajo.montoEnLetras.getText());
        reciboTemporal.setMesEnLetras(vAgregarReciboLegajo.mesEnLetras.getText());
        reciboTemporal.setImporte(vAgregarReciboLegajo.importe.getText());
        reciboTemporal.setImporteAbonado(vAgregarReciboLegajo.importeAbonado.getText());
        reciboTemporal.setObservaciones(vAgregarReciboLegajo.observaciones.getText());
        reciboTemporal.setIncluyeImpuestos(vAgregarReciboLegajo.incluyeImpuestos.getText());
        
        reciboTemporal.setFechaVencimiento(vAgregarReciboLegajo.jcalendarVencimiento.getDate());  
    }
}
