/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasLocatario;
import Modelo.LegajoViejo;
import Modelo.Locatario;
import Vista.JfDetallesLocatario;

/**
 *
 * @author Lauti
 */
public class CtrlDetallesLocatario {
    
    JfDetallesLocatario jfDetallesLocadorio;
    Locatario locatario;
    
    public CtrlDetallesLocatario() {
        jfDetallesLocadorio = new JfDetallesLocatario();
        jfDetallesLocadorio.setTitle("Detalles locador");
        jfDetallesLocadorio.setLocationRelativeTo(null);
    }
    
    public void mostrarVentana() {
        jfDetallesLocadorio.setVisible(true);
    }
    
    public void limpiarCampos() {
        jfDetallesLocadorio.nombre.setText("Nombre?");
        jfDetallesLocadorio.telefono.setText("Teléfono?");
        jfDetallesLocadorio.mail.setText("Mail?");
        jfDetallesLocadorio.tipoDocumento.setText("Tipo Documento?");
        jfDetallesLocadorio.nroDocumento.setText("Nro Documento?");
        jfDetallesLocadorio.otrosDatos.setText("Otros datos?");
    }
    
    public void rellenarCamposSegunLocatario(int idLocatario) {
        locatario = ConsultasLocatario.getLocatario(idLocatario);
        jfDetallesLocadorio.nombre.setText(locatario.getNombre());
        jfDetallesLocadorio.telefono.setText(locatario.getTelefono());
        jfDetallesLocadorio.mail.setText(locatario.getMail());
        jfDetallesLocadorio.tipoDocumento.setText(locatario.getTipoNroDocumento());
        jfDetallesLocadorio.nroDocumento.setText(locatario.getNroDocumento());
        jfDetallesLocadorio.otrosDatos.setText(locatario.getOtrosDatos());
    }
    
    public void rellenarCamposSegunLegajoViejo(LegajoViejo legajoViejo) {
        jfDetallesLocadorio.nombre.setText(legajoViejo.getLocatarioNombre());
        jfDetallesLocadorio.telefono.setText(legajoViejo.getLocatarioTelefono());
        jfDetallesLocadorio.mail.setText(legajoViejo.getLocatarioMail());
        jfDetallesLocadorio.tipoDocumento.setText(legajoViejo.getLocatarioTipoNroDocumento());
        jfDetallesLocadorio.nroDocumento.setText(legajoViejo.getLocatarioNroDocumento());
        jfDetallesLocadorio.otrosDatos.setText(legajoViejo.getLocatarioOtrosDatos());
    }
}
