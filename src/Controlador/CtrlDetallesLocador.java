/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasLocador;
import Modelo.LegajoViejo;
import Modelo.Locador;
import Vista.JfDetallesLocador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lauti
 */
public class CtrlDetallesLocador {

    private JfDetallesLocador jfDetallesLocador;
    private Locador locador;

    public CtrlDetallesLocador() {
        jfDetallesLocador = new JfDetallesLocador();
        jfDetallesLocador.setTitle("Detalles locador");
        jfDetallesLocador.setLocationRelativeTo(null);
    }

    public void mostrarVentana() {
        jfDetallesLocador.setVisible(true);
    }

    public void rellenarCamposSegunLocador(int idLocador) {
        locador = ConsultasLocador.getLocador(idLocador);
        jfDetallesLocador.nombre.setText(locador.getNombre());
        jfDetallesLocador.telefono.setText(locador.getTelefono());
        jfDetallesLocador.mail.setText(locador.getMail());

        if (locador.getDomicilio() == null) {
            jfDetallesLocador.domicilio.setText(null);
        } else {
            jfDetallesLocador.domicilio.setText(locador.getDomicilio());
        }

        if (locador.getFechaNacimiento() == null) {
            jfDetallesLocador.fechaNacimiento.setText(null);
        } else {
            SimpleDateFormat inputDateFormayçt = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaNacimiento = "";

            try {
                fechaNacimiento = outputDateFormat.format(inputDateFormayçt.parse(locador.getFechaNacimiento().toString()));
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar la fecha" + e, "Error", JOptionPane.ERROR_MESSAGE);
            }

            jfDetallesLocador.fechaNacimiento.setText(fechaNacimiento);
        }

        jfDetallesLocador.tipoDocumento.setText(locador.getTipoNroDocumento());
        jfDetallesLocador.nroDocumento.setText(locador.getNroDocumento());
        jfDetallesLocador.otrosDatos.setText(locador.getOtrosDatos());
    }
    
    public void rellenarCamposSegunLocador(LegajoViejo legajoViejo) {
        jfDetallesLocador.nombre.setText(legajoViejo.getLocadorNombre());
        jfDetallesLocador.telefono.setText(legajoViejo.getLocadorTelefono());
        jfDetallesLocador.mail.setText(legajoViejo.getLocadorMail());

        if (legajoViejo.getLocadorDomicilio() == null) {
            jfDetallesLocador.domicilio.setText(null);
        } else {
            jfDetallesLocador.domicilio.setText(legajoViejo.getLocadorDomicilio());
        }

        if (legajoViejo.getLocadorFechaNacimiento() == null) {
            jfDetallesLocador.fechaNacimiento.setText(null);
        } else {
            SimpleDateFormat inputDateFormayçt = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaNacimiento = "";

            try {
                fechaNacimiento = outputDateFormat.format(inputDateFormayçt.parse(legajoViejo.getLocadorFechaNacimiento().toString()));
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar la fecha" + e, "Error", JOptionPane.ERROR_MESSAGE);
            }

            jfDetallesLocador.fechaNacimiento.setText(fechaNacimiento);
        }

        jfDetallesLocador.tipoDocumento.setText(legajoViejo.getLocadorTipoNroDocumento());
        jfDetallesLocador.nroDocumento.setText(legajoViejo.getLocadorNroDocument());
        jfDetallesLocador.otrosDatos.setText(legajoViejo.getLocadorOtrosDatos());
    }
}
