/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ReciboLegajo;
import Vista.JfDetallesReciboLegajo;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lauti
 */
public class CtrlDetallesReciboLegajo {
    
    JfDetallesReciboLegajo vDetallesReciboLegajo;
    
    public CtrlDetallesReciboLegajo() {
        // Preparar ventana
        vDetallesReciboLegajo = new JfDetallesReciboLegajo();
        vDetallesReciboLegajo.setTitle("Detalles del recibo");
        vDetallesReciboLegajo.setLocationRelativeTo(null);    
    }
    
    public void mostrarVentana() {
        vDetallesReciboLegajo.setVisible(true);
    }
    
    public void rellenarCamposSegunRecibo(ReciboLegajo recibo) {
        
        vDetallesReciboLegajo.nombreLocatario.setText(recibo.getNombreLocatario());
        vDetallesReciboLegajo.nombreLocatario2.setText(recibo.getNombreLocatario());
        
        vDetallesReciboLegajo.nombreLocador.setText(recibo.getNombreLocador());
        vDetallesReciboLegajo.nombreLocador2.setText(recibo.getNombreLocador());
        vDetallesReciboLegajo.dniLocador.setText(recibo.getDniLocador());
        
        vDetallesReciboLegajo.tipoInmueble.setText(recibo.getTipoInmueble());
        vDetallesReciboLegajo.tipoInmueble2.setText(recibo.getTipoInmueble());
        vDetallesReciboLegajo.direccionInmueble.setText(recibo.getDireccionInmueble());
        vDetallesReciboLegajo.direccionInmueble2.setText(recibo.getDireccionInmueble());
        vDetallesReciboLegajo.barrioInmueble.setText(recibo.getBarrioInmueble());
        
        vDetallesReciboLegajo.montoEnLetras.setText(recibo.getMontoEnLetras());
        vDetallesReciboLegajo.montoEnLetras2.setText(recibo.getMontoEnLetras());
        vDetallesReciboLegajo.mesEnLetras.setText(recibo.getMesEnLetras());
        vDetallesReciboLegajo.mesEnLetras2.setText(recibo.getMesEnLetras());
        vDetallesReciboLegajo.importe.setText(recibo.getImporte());
        vDetallesReciboLegajo.importeAbonado.setText(recibo.getImporteAbonado());
        vDetallesReciboLegajo.incluyeImpuestos.setText(recibo.getIncluyeImpuestos());
        
        vDetallesReciboLegajo.txtObservaciones.setText(recibo.getObservaciones());
        vDetallesReciboLegajo.txtObsevaciones2.setText(recibo.getObservaciones());
        
        // Preparar fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        
        vDetallesReciboLegajo.fecha.setText(dateFormat.format(recibo.getFechaDelRecibo()));
        vDetallesReciboLegajo.fecha2.setText(dateFormat.format(recibo.getFechaDelRecibo()));
        vDetallesReciboLegajo.hora.setText(timeFormat.format(recibo.getFechaDelRecibo()));
        vDetallesReciboLegajo.hora2.setText(timeFormat.format(recibo.getFechaDelRecibo()));
        System.out.println(timeFormat.format(recibo.getFechaDelRecibo()));
    }
}
