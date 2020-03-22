/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasRecibos;
import Modelo.ReciboLegajo;
import Vista.JfGenerarRecibo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Lauti
 */
public class CtrlGenerarRecibo implements ActionListener {

    JfGenerarRecibo vGenerarRecibo;
    ReciboLegajo reciboTemporal;
    int idField;

    public CtrlGenerarRecibo() {
        vGenerarRecibo = new JfGenerarRecibo();
        vGenerarRecibo.setTitle("Nuevo recibo");
        vGenerarRecibo.setLocationRelativeTo(null);

        vGenerarRecibo.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vGenerarRecibo.btnAgregar) {
            crearReciboLegajoSegunCampos();
            if (generarRecibo()) {
                ConsultasRecibos.insertarRecibo(reciboTemporal, idField);
            }
        }
    }

    public void mostrarVentana() {
        vGenerarRecibo.setVisible(true);
    }

    public void rellenarSegunLegajo(ReciboLegajo recibo, int idLegajo) {
        idField = idLegajo;
        reciboTemporal = recibo;

        vGenerarRecibo.nombreLocatario.setText(reciboTemporal.getNombreLocatario());
        vGenerarRecibo.nombreLocatario2.setText(reciboTemporal.getNombreLocatario());

        vGenerarRecibo.nombreLocador.setText(reciboTemporal.getNombreLocador());
        vGenerarRecibo.nombreLocador2.setText(reciboTemporal.getNombreLocador());
        vGenerarRecibo.dniLocador.setText(reciboTemporal.getDniLocador());

        vGenerarRecibo.tipoInmueble.setText(reciboTemporal.getTipoInmueble());
        vGenerarRecibo.tipoInmueble2.setText(reciboTemporal.getTipoInmueble());
        vGenerarRecibo.direccionInmueble.setText(reciboTemporal.getDireccionInmueble());
        vGenerarRecibo.direccionInmueble2.setText(reciboTemporal.getDireccionInmueble());
        vGenerarRecibo.pisoDepto.setText(reciboTemporal.getPisoDepto());
        vGenerarRecibo.barrioInmueble.setText(reciboTemporal.getBarrioInmueble());

        // Preparar fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");

        vGenerarRecibo.fecha.setText(dateFormat.format(reciboTemporal.getFechaDelRecibo()));
        vGenerarRecibo.fecha2.setText(dateFormat.format(reciboTemporal.getFechaDelRecibo()));
        vGenerarRecibo.hora.setText(timeFormat.format(reciboTemporal.getFechaDelRecibo()));
        vGenerarRecibo.hora2.setText(timeFormat.format(reciboTemporal.getFechaDelRecibo()));
        System.out.println(timeFormat.format(recibo.getFechaDelRecibo()));
    }

    private void crearReciboLegajoSegunCampos() {

        reciboTemporal.setMontoEnLetras(vGenerarRecibo.montoEnLetras.getText());
        reciboTemporal.setMesEnLetras(vGenerarRecibo.mesEnLetras.getText());
        reciboTemporal.setImporte(vGenerarRecibo.importe.getText());
        reciboTemporal.setImporteAbonado(vGenerarRecibo.importeAbonado.getText());
        reciboTemporal.setObservaciones(vGenerarRecibo.observaciones.getText());
        reciboTemporal.setIncluyeImpuestos(vGenerarRecibo.incluyeImpuestos.getText());
        reciboTemporal.setObservaciones(vGenerarRecibo.observaciones.getText());
        
        reciboTemporal.setFechaVencimiento(vGenerarRecibo.jcalendarVencimiento.getDate());
    }

    private boolean generarRecibo() {
        try {

            JasperReport reporte;
            String ruta = "..\\src\\Modelo\\reporteRecibo.jasper";
            File file = new File(ruta);

            Map parametros = new HashMap();
            parametros.put("locatarioNombre", reciboTemporal.getNombreLocatario());
            parametros.put("montoEnLetras", reciboTemporal.getMontoEnLetras());
            parametros.put("tipoInmueble", reciboTemporal.getTipoInmueble());
            parametros.put("mesEnLetras", reciboTemporal.getMesEnLetras());
            parametros.put("direccionInmueble", reciboTemporal.getDireccionInmueble());
            parametros.put("pisoDepto", reciboTemporal.getPisoDepto());
            parametros.put("locadorNombre", reciboTemporal.getNombreLocador());
            parametros.put("locadorDni", reciboTemporal.getDniLocador());
            parametros.put("importe", reciboTemporal.getImporte());
            parametros.put("importeAbonado", reciboTemporal.getImporteAbonado());
            parametros.put("incluyeImpuestos", reciboTemporal.getIncluyeImpuestos());
            parametros.put("barrioInmueble", reciboTemporal.getBarrioInmueble());
            parametros.put("observaciones", reciboTemporal.getObservaciones());

            // Convertir e insertar fechas
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm");
            
            String fechaSubscripcion = "";
            String fechaInicio = "";
            String fechaFinalizacion = "";
            
            
            /* Métodos anteriores?
            try {
                fechaSubscripcion = formatoUtilDate.format(formatoSqlDate.parse(legajo.getFechaSubscripcion().toString()));
                fechaInicio = formatoUtilDate.format(formatoSqlDate.parse(legajo.getFechaInicio().toString()));
                fechaFinalizacion = formatoUtilDate.format(formatoSqlDate.parse(legajo.getFechaFinalizacion().toString()));
                
            } catch (ParseException ex) {
                Logger.getLogger(CtrlDetallesLegajo.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
            
            parametros.put("fecha", formatoFecha.format(reciboTemporal.getFechaDelRecibo()));
            parametros.put("hora", formatoHora.format(reciboTemporal.getFechaDelRecibo()));
            parametros.put("fechaFinalizacion", formatoFecha.format(reciboTemporal.getFechaVencimiento()));
            
            reporte = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());
            
            String destino = "..\\temp\\recibo.pdf";
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destino);
            exporter.exportReport();
            
            try {
                ProcessBuilder p = new ProcessBuilder();
                p.command("cmd.exe", "/c", destino);
                p.start();
            } catch (IOException ex1) {
                JOptionPane.showMessageDialog(null, "Tipo de error" + ex1, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
            // Método anterior
            /*
            JasperViewer jasperView = new JasperViewer(jprint, false);
            jasperView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jasperView.setVisible(true);
            */

        } catch (JRException ex2) {
            JOptionPane.showMessageDialog(null, "Tipo de error" + ex2, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
