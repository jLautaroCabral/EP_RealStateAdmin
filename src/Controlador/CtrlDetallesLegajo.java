/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasInmueble;
import Modelo.ConsultasLegajo;
import Modelo.ConsultasLocador;
import Modelo.ConsultasLocatario;
import Modelo.Inmueble;
import Modelo.Legajo;
import Modelo.LegajoViejo;
import Modelo.Locador;
import Modelo.Locatario;
import Modelo.ReciboLegajo;
import Vista.JfDetallesLegajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lauti
 */
public class CtrlDetallesLegajo implements ActionListener {

    private JfDetallesLegajo jfResumenLegajo;
    private CtrlDetallesInmueble ctrlDetallesInmuebles;
    private CtrlDetallesLocador ctrlDetallesLocador;
    private CtrlDetallesLocatario ctrlDetallesLocatario;
    private CtrlGenerarRecibo ctrlGenerarRecibo;
    
    private Legajo legajo;
    private LegajoViejo legajoViejoSeleccionado;
    
    int idField;
    boolean esLegajoViejo = false;

    public CtrlDetallesLegajo() {
        jfResumenLegajo = new JfDetallesLegajo();
        jfResumenLegajo.setTitle("Detalles legajo");
        jfResumenLegajo.setLocationRelativeTo(null);

        añadirOyentesDeEvento();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Al presionar BOTON VER DETALLES INMUEBLE
        if (e.getSource() == jfResumenLegajo.btnDetallesInmueble) {
            if (esLegajoViejo) {
                if (ctrlDetallesInmuebles == null) {
                    ctrlDetallesInmuebles = new CtrlDetallesInmueble();
                    ctrlDetallesInmuebles.rellenarCamposSegunLegajoViejo(legajoViejoSeleccionado);
                    ctrlDetallesInmuebles.mostrarVentana();
                } else {
                    ctrlDetallesInmuebles.rellenarCamposSegunLegajoViejo(legajoViejoSeleccionado);
                    ctrlDetallesInmuebles.mostrarVentana();
                }
            } else {
                if (ctrlDetallesInmuebles == null) {
                    ctrlDetallesInmuebles = new CtrlDetallesInmueble();
                    ctrlDetallesInmuebles.rellenarCamposSegunInmueble(ConsultasLegajo.getLegajo(idField).getIdInmueble());
                    ctrlDetallesInmuebles.mostrarVentana();
                } else {
                    ctrlDetallesInmuebles.rellenarCamposSegunInmueble(ConsultasLegajo.getLegajo(idField).getIdInmueble());
                    ctrlDetallesInmuebles.mostrarVentana();
                }
            }
        }

        // Al presionar BOTON VER DETALLES LOCATARIO
        if (e.getSource() == jfResumenLegajo.btnDetallesLocatario) {
            if (esLegajoViejo) {
                if (ctrlDetallesLocatario == null) {
                    ctrlDetallesLocatario = new CtrlDetallesLocatario();
                    ctrlDetallesLocatario.rellenarCamposSegunLegajoViejo(legajoViejoSeleccionado);
                    ctrlDetallesLocatario.mostrarVentana();
                } else {
                    ctrlDetallesLocatario.rellenarCamposSegunLegajoViejo(legajoViejoSeleccionado);
                    ctrlDetallesLocatario.mostrarVentana();
                }
            } else {
                if (ctrlDetallesLocatario == null) {
                    ctrlDetallesLocatario = new CtrlDetallesLocatario();
                    ctrlDetallesLocatario.rellenarCamposSegunLocatario(ConsultasLegajo.getLegajo(idField).getIdLocatario());
                    ctrlDetallesLocatario.mostrarVentana();
                } else {
                    ctrlDetallesLocatario.rellenarCamposSegunLocatario(ConsultasLegajo.getLegajo(idField).getIdLocatario());
                    ctrlDetallesLocatario.mostrarVentana();
                }
            }
        }

        // Al presionar BOTON VER DETALLES LOCADOR
        if (e.getSource() == jfResumenLegajo.btnDetallesLocador) {

            if (esLegajoViejo) {
                if (ctrlGenerarRecibo == null) {
                    ctrlDetallesLocador = new CtrlDetallesLocador();
                    ctrlDetallesLocador.rellenarCamposSegunLocador(legajoViejoSeleccionado);
                    ctrlDetallesLocador.mostrarVentana();
                } else {
                    ctrlDetallesLocador.rellenarCamposSegunLocador(legajoViejoSeleccionado);
                    ctrlDetallesLocador.mostrarVentana();
                }
            } else {
                if (ctrlGenerarRecibo == null) {
                    ctrlDetallesLocador = new CtrlDetallesLocador();
                    ctrlDetallesLocador.rellenarCamposSegunLocador(ConsultasLegajo.getLegajo(idField).getIdLocador());
                    ctrlDetallesLocador.mostrarVentana();
                } else {
                    ctrlDetallesLocador.rellenarCamposSegunLocador(ConsultasLegajo.getLegajo(idField).getIdLocador());
                    ctrlDetallesLocador.mostrarVentana();
                }
            }
        }

        // Al presionar BOTON IMPRIMIR
        if (e.getSource() == jfResumenLegajo.btnImprimir) {
            crearReporte(ConsultasLegajo.getLegajo(idField));
        }

        // Al presionar BOTON VER RECIBOS
        if (e.getSource() == jfResumenLegajo.btnGenerarRecibo) {
            if (ctrlGenerarRecibo == null) {
                ctrlGenerarRecibo = new CtrlGenerarRecibo();
                ctrlGenerarRecibo.rellenarSegunLegajo(crearNuevoReciboSegunLegajo(), idField);
                ctrlGenerarRecibo.mostrarVentana();
            } else {
                ctrlGenerarRecibo.rellenarSegunLegajo(crearNuevoReciboSegunLegajo(), idField);
                ctrlGenerarRecibo.mostrarVentana();
            }
        }

    }

    public void mostrarVentana() {
        jfResumenLegajo.setVisible(true);
    }

    public void rellenarResumenSegunLegajoViejo(LegajoViejo legajoViejo) {
        try {
            legajoViejoSeleccionado = legajoViejo;
            esLegajoViejo = true;

            // Rellenar encabezado
            jfResumenLegajo.legajo.setText(legajoViejo.getLegajo());
            jfResumenLegajo.estado.setText(legajoViejo.getEstadoActual());

            jfResumenLegajo.tipoInmueble.setText(legajoViejo.getInmTipo());
            jfResumenLegajo.direccion.setText(legajoViejo.getInmCalle());
            jfResumenLegajo.barrio.setText(legajoViejo.getInmBarrio());
            jfResumenLegajo.pisoDepto.setText(legajoViejo.getInmPisoDepto());

            // Rellanar cuerpo
            jfResumenLegajo.locadorNombre.setText(legajoViejo.getLocadorNombre());
            jfResumenLegajo.locadorTelefono.setText(legajoViejo.getLocadorTelefono());
            jfResumenLegajo.locadorMail.setText(legajoViejo.getLocadorMail());
            if (legajoViejo.getLocadorDomicilio() == null) {
                jfResumenLegajo.locadorDomicilio.setText(null);
            } else {
                jfResumenLegajo.locadorDomicilio.setText(legajoViejo.getLocadorDomicilio());
            }

            jfResumenLegajo.locatarioNombre.setText(legajoViejo.getLocatarioNombre());
            jfResumenLegajo.locatarioTelefono.setText(legajoViejo.getLocatarioTelefono());
            jfResumenLegajo.locatarioMail.setText(legajoViejo.getLocatarioMail());

            jfResumenLegajo.garante1Nombre.setText(legajoViejo.getGarante1Nombre());
            jfResumenLegajo.garante1Telefono.setText(legajoViejo.getGarante1Telefono());
            jfResumenLegajo.garante1Domicilio.setText(legajoViejo.getGarante1Domicilio());
            jfResumenLegajo.garante1Mail.setText(legajoViejo.getGarante1Mail());

            jfResumenLegajo.garante2Nombre.setText(legajoViejo.getGarante2Nombre());
            jfResumenLegajo.garante2Telefono.setText(legajoViejo.getGarante2Telefono());
            jfResumenLegajo.garante2Domicilio.setText(legajoViejo.getGarante2Domicilio());
            jfResumenLegajo.garante2Mail.setText(legajoViejo.getGarante2Mail());

            jfResumenLegajo.garante3Nombre.setText(legajoViejo.getGarante3Nombre());
            jfResumenLegajo.garante3Telefono.setText(legajoViejo.getGarante3Telefono());
            jfResumenLegajo.garante3Domicilio.setText(legajoViejo.getGarante3Domicilio());
            jfResumenLegajo.garante3Mail.setText(legajoViejo.getGarante3Mail());

            jfResumenLegajo.garante4Nombre.setText(legajoViejo.getGarante4Nombre());
            jfResumenLegajo.garante4Telefono.setText(legajoViejo.getGarante4Telefono());
            jfResumenLegajo.garante4Domicilio.setText(legajoViejo.getGarante4Domicilio());
            jfResumenLegajo.garante4Mail.setText(legajoViejo.getGarante4Mail());

            jfResumenLegajo.txtOtrosGarantes.setText(legajoViejo.getOtrosGarantes());

            // Rellernar pie 
            jfResumenLegajo.impuestoMunicipal.setText(legajoViejo.getInmImpuestoMunicipal());
            jfResumenLegajo.dgr.setText(legajoViejo.getInmDgr());
            jfResumenLegajo.agua.setText(legajoViejo.getInmAgua());
            jfResumenLegajo.luz.setText(legajoViejo.getInmLuz());
            jfResumenLegajo.gas.setText(legajoViejo.getInmGas());
            jfResumenLegajo.expensas.setText(legajoViejo.getInmExpensas());

            jfResumenLegajo.titularImpuestoMunicipal.setText(legajoViejo.getTitularImpuestoMunicipal());
            jfResumenLegajo.titularDgr.setText(legajoViejo.getTitularDgr());
            jfResumenLegajo.titularAgua.setText(legajoViejo.getTitularAgua());
            jfResumenLegajo.titularLuz.setText(legajoViejo.getTitularLuz());
            jfResumenLegajo.titularGas.setText(legajoViejo.getTitularGas());
            jfResumenLegajo.titularExpensas.setText(legajoViejo.getTitularExpensas());

            jfResumenLegajo.fechaSubscripcion.setText(legajoViejo.getFechaSubscripcion().toString());
            jfResumenLegajo.fechaInicio.setText(legajoViejo.getFechaInicio().toString());
            jfResumenLegajo.fechaFinalizacion.setText(legajoViejo.getFechaFinalizacion().toString());

            jfResumenLegajo.observaciones.setText(legajoViejo.getObservaciones());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void rellanarResumenSegunLegajo(int idLegajo) {
        try {
            esLegajoViejo = false;
            idField = idLegajo;

            legajo = ConsultasLegajo.getLegajo(idLegajo);
            Inmueble inmueble = ConsultasInmueble.getInmueble(legajo.getIdInmueble());
            Locador locador = ConsultasLocador.getLocador(inmueble.getIdLocador());
            Locatario locatario = ConsultasLocatario.getLocatario(legajo.getIdLocatario());

            // Rellenar encabezado
            jfResumenLegajo.legajo.setText(legajo.getLegajo());
            jfResumenLegajo.estado.setText(legajo.getEstadoActual());

            jfResumenLegajo.tipoInmueble.setText(inmueble.getTipo());
            jfResumenLegajo.direccion.setText(inmueble.getCalle());
            jfResumenLegajo.barrio.setText(inmueble.getBarrio());
            jfResumenLegajo.pisoDepto.setText(inmueble.getPisoDepto());

            // Rellanar cuerpo
            jfResumenLegajo.locadorNombre.setText(locador.getNombre());
            jfResumenLegajo.locadorTelefono.setText(locador.getTelefono());
            jfResumenLegajo.locadorMail.setText(locador.getMail());
            if (locador.getDomicilio() == null) {
                jfResumenLegajo.locadorDomicilio.setText(null);
            } else {
                jfResumenLegajo.locadorDomicilio.setText(locador.getDomicilio());
            }

            jfResumenLegajo.locatarioNombre.setText(locatario.getNombre());
            jfResumenLegajo.locatarioTelefono.setText(locatario.getTelefono());
            jfResumenLegajo.locatarioMail.setText(locatario.getMail());

            jfResumenLegajo.garante1Nombre.setText(legajo.getGarante1Nombre());
            jfResumenLegajo.garante1Telefono.setText(legajo.getGarante1Telefono());
            jfResumenLegajo.garante1Domicilio.setText(legajo.getGarante1Domicilio());
            jfResumenLegajo.garante1Mail.setText(legajo.getGarante1Mail());

            jfResumenLegajo.garante2Nombre.setText(legajo.getGarante2Nombre());
            jfResumenLegajo.garante2Telefono.setText(legajo.getGarante2Telefono());
            jfResumenLegajo.garante2Domicilio.setText(legajo.getGarante2Domicilio());
            jfResumenLegajo.garante2Mail.setText(legajo.getGarante2Mail());

            jfResumenLegajo.garante3Nombre.setText(legajo.getGarante3Nombre());
            jfResumenLegajo.garante3Telefono.setText(legajo.getGarante3Telefono());
            jfResumenLegajo.garante3Domicilio.setText(legajo.getGarante3Domicilio());
            jfResumenLegajo.garante3Mail.setText(legajo.getGarante3Mail());

            jfResumenLegajo.garante4Nombre.setText(legajo.getGarante4Nombre());
            jfResumenLegajo.garante4Telefono.setText(legajo.getGarante4Telefono());
            jfResumenLegajo.garante4Domicilio.setText(legajo.getGarante4Domicilio());
            jfResumenLegajo.garante4Mail.setText(legajo.getGarante4Mail());

            jfResumenLegajo.txtOtrosGarantes.setText(legajo.getOtrosGarantes());

            // Rellernar pie 
            jfResumenLegajo.impuestoMunicipal.setText(inmueble.getImpuestoMunicipal());
            jfResumenLegajo.dgr.setText(inmueble.getDgr());
            jfResumenLegajo.agua.setText(inmueble.getAgua());
            jfResumenLegajo.luz.setText(inmueble.getLuz());
            jfResumenLegajo.gas.setText(inmueble.getGas());
            jfResumenLegajo.expensas.setText(inmueble.getExpensas());

            jfResumenLegajo.titularImpuestoMunicipal.setText(legajo.getTitularImpuestoMunicipal());
            jfResumenLegajo.titularDgr.setText(legajo.getTitularDgr());
            jfResumenLegajo.titularAgua.setText(legajo.getTitularAgua());
            jfResumenLegajo.titularLuz.setText(legajo.getTitularLuz());
            jfResumenLegajo.titularGas.setText(legajo.getTitularGas());
            jfResumenLegajo.titularExpensas.setText(legajo.getTitularExpensas());

            jfResumenLegajo.fechaSubscripcion.setText(legajo.getFechaSubscripcion().toString());
            jfResumenLegajo.fechaInicio.setText(legajo.getFechaInicio().toString());
            jfResumenLegajo.fechaFinalizacion.setText(legajo.getFechaFinalizacion().toString());

            jfResumenLegajo.observaciones.setText(legajo.getObservaciones());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void añadirOyentesDeEvento() {
        jfResumenLegajo.btnDetallesInmueble.addActionListener(this);
        jfResumenLegajo.btnDetallesLocador.addActionListener(this);
        jfResumenLegajo.btnDetallesLocatario.addActionListener(this);
        jfResumenLegajo.btnImprimir.addActionListener(this);
        jfResumenLegajo.btnGenerarRecibo.addActionListener(this);
    }

    private void crearReporte(Legajo legajo) {
        try {

            Inmueble inmueble = ConsultasInmueble.getInmueble(legajo.getIdInmueble());
            Locador locador = ConsultasLocador.getLocador(inmueble.getIdLocador());
            Locatario locatario = ConsultasLocatario.getLocatario(legajo.getIdLocatario());

            JasperReport reporte;
            String ruta = "..\\src\\Modelo\\reporteLegajo.jasper";
            File file = new File(ruta);

            Map parametros = new HashMap();
            parametros.put("legajo", legajo.getLegajo());
            parametros.put("tipoInmueble", inmueble.getTipo());
            parametros.put("direccion", inmueble.getCalle());
            parametros.put("barrio", inmueble.getBarrio());
            parametros.put("pisoDepto", inmueble.getPisoDepto());

            parametros.put("locatarioNombre", locatario.getNombre());
            parametros.put("locatarioTelefono", locatario.getTelefono());
            parametros.put("locatarioMail", locatario.getMail());

            parametros.put("locadorNombre", locador.getNombre());
            parametros.put("locadorTelefono", locador.getTelefono());
            parametros.put("locadorMail", locador.getMail());
            parametros.put("locadorDomicilio", locador.getDomicilio());

            parametros.put("garante1Nombre", legajo.getGarante1Nombre());
            parametros.put("garante1Domicilio", legajo.getGarante1Domicilio());
            parametros.put("garante1Telefono", legajo.getGarante1Telefono());
            parametros.put("garante1Mail", legajo.getGarante1Mail());

            parametros.put("garante2Nombre", legajo.getGarante2Nombre());
            parametros.put("garante2Domicilio", legajo.getGarante2Domicilio());
            parametros.put("garante2Telefono", legajo.getGarante2Telefono());
            parametros.put("garante2Mail", legajo.getGarante2Mail());

            parametros.put("garante3Nombre", legajo.getGarante3Nombre());
            parametros.put("garante3Domicilio", legajo.getGarante3Domicilio());
            parametros.put("garante3Telefono", legajo.getGarante3Telefono());
            parametros.put("garante3Mail", legajo.getGarante3Mail());

            parametros.put("garante4Nombre", legajo.getGarante4Nombre());
            parametros.put("garante4Domicilio", legajo.getGarante4Domicilio());
            parametros.put("garante4Telefono", legajo.getGarante4Telefono());
            parametros.put("garante4Mail", legajo.getGarante4Mail());

            parametros.put("otrosGarantes", legajo.getOtrosGarantes());

            parametros.put("montoAlquiler", legajo.getMontoAlquiler());
            parametros.put("impuestoMunicipal", inmueble.getImpuestoMunicipal());
            parametros.put("dgr", inmueble.getDgr());
            parametros.put("agua", inmueble.getAgua());
            parametros.put("luz", inmueble.getLuz());
            parametros.put("gas", inmueble.getGas());
            parametros.put("expensas", inmueble.getExpensas());

            parametros.put("titularImpuestoMunicipal", legajo.getTitularImpuestoMunicipal());
            parametros.put("titularDgr", legajo.getTitularDgr());
            parametros.put("titularAgua", legajo.getTitularAgua());
            parametros.put("titularLuz", legajo.getTitularLuz());
            parametros.put("titularGas", legajo.getTitularGas());
            parametros.put("titularExpensas", legajo.getTitularExpensas());

            // Convertir e insertar fechas
            SimpleDateFormat formatoSqlDate = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoUtilDate = new SimpleDateFormat("dd/MM/yyyy");

            String fechaSubscripcion = "";
            String fechaInicio = "";
            String fechaFinalizacion = "";
            try {
                fechaSubscripcion = formatoUtilDate.format(formatoSqlDate.parse(legajo.getFechaSubscripcion().toString()));
                fechaInicio = formatoUtilDate.format(formatoSqlDate.parse(legajo.getFechaInicio().toString()));
                fechaFinalizacion = formatoUtilDate.format(formatoSqlDate.parse(legajo.getFechaFinalizacion().toString()));

            } catch (ParseException ex) {
                Logger.getLogger(CtrlDetallesLegajo.class.getName()).log(Level.SEVERE, null, ex);
            }

            parametros.put("fechaSubscripcion", fechaSubscripcion);
            parametros.put("fechaInicio", fechaInicio);
            parametros.put("fechaFinalizacion", fechaFinalizacion);

            // Generar reporte
            reporte = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());
            JasperViewer jasperView = new JasperViewer(jprint, false);
            jasperView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jasperView.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Tipo de error" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ReciboLegajo crearNuevoReciboSegunLegajo() {
        ReciboLegajo recibo = new ReciboLegajo();
        Legajo legajo = ConsultasLegajo.getLegajo(idField);

        Inmueble inmueble = ConsultasInmueble.getInmueble(legajo.getIdInmueble());
        Locador locador = ConsultasLocador.getLocador(legajo.getIdLocador());
        Locatario locatario = ConsultasLocatario.getLocatario(legajo.getIdLocatario());

        recibo.setNombreLocatario(locatario.getNombre());
        recibo.setTipoInmueble(inmueble.getTipo());
        recibo.setNombreLocador(locador.getNombre());
        recibo.setDniLocador(locador.getNroDocumento());
        recibo.setDireccionInmueble(inmueble.getCalle());
        recibo.setPisoDepto(inmueble.getPisoDepto());
        recibo.setBarrioInmueble(inmueble.getBarrio());

        recibo.setFechaDelRecibo(new java.util.Date());

        return recibo;
    }
}
