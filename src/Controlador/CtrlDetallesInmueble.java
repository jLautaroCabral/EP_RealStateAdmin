/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasInmueble;
import Modelo.ConsultasLocador;
import Modelo.Inmueble;
import Modelo.LegajoViejo;
import Modelo.Locador;
import Vista.JfDetallesInmueble;

/**
 *
 * @author Lauti
 */
public class CtrlDetallesInmueble {
    JfDetallesInmueble jfDetallesInmueble;

    public CtrlDetallesInmueble() {
        jfDetallesInmueble = new JfDetallesInmueble();
        jfDetallesInmueble.setTitle("Detalles del inmueble");
        jfDetallesInmueble.setLocationRelativeTo(null);
    }

    public void mostrarVentana() {
        jfDetallesInmueble.setVisible(true);
    }

    public void rellenarCamposSegunInmueble(int idInmueble) {

        Inmueble inmueble = ConsultasInmueble.getInmueble(idInmueble);
        Locador locador = ConsultasLocador.getLocador(inmueble.getIdLocador());

        jfDetallesInmueble.calle.setText(inmueble.getCalle());
        jfDetallesInmueble.pisoDepto.setText(inmueble.getPisoDepto());
        jfDetallesInmueble.barrio.setText(inmueble.getBarrio());
        jfDetallesInmueble.codigoPostal.setText(inmueble.getCodigoPostal());
        jfDetallesInmueble.provinciaLocalidad.setText(inmueble.getProvinciaLocalidad());
        jfDetallesInmueble.tipo.setText(inmueble.getTipo());
        jfDetallesInmueble.operacion.setText(inmueble.getOperacion());
        jfDetallesInmueble.dormitorios.setText(inmueble.getDormitorios());
        jfDetallesInmueble.baños.setText(inmueble.getBaños());
        jfDetallesInmueble.plantas.setText(inmueble.getPlantas());
        jfDetallesInmueble.antiguedad.setText(inmueble.getAntiguedad());
        jfDetallesInmueble.estadoGeneral.setText(inmueble.getEstadoGeneral());
        jfDetallesInmueble.valor.setText(inmueble.getValor());
        jfDetallesInmueble.superficieTerreno.setText(inmueble.getSuperficieTerreno());
        jfDetallesInmueble.superficieCubierta.setText(inmueble.getSuperficieCubierta());
        jfDetallesInmueble.mtsFondo.setText(inmueble.getMtsFondo());
        jfDetallesInmueble.mtsFrente.setText(inmueble.getMtsFrente());
        jfDetallesInmueble.cantidadLlaves.setText(inmueble.getCantidadLlaves());
        jfDetallesInmueble.estilo.setText(inmueble.getEstilo());
        jfDetallesInmueble.orientacion.setText(inmueble.getOrientacion());
        jfDetallesInmueble.garage.setText(inmueble.getGarage());
        jfDetallesInmueble.living.setText(inmueble.getLiving());
        jfDetallesInmueble.cocina.setText(inmueble.getCocina());
        jfDetallesInmueble.comedor.setText(inmueble.getComedor());
        jfDetallesInmueble.dependencia.setText(inmueble.getDependencia());
        jfDetallesInmueble.piscina.setText(inmueble.getPiscina());
        jfDetallesInmueble.patioJardin.setText(inmueble.getPatioJardin());
        jfDetallesInmueble.txtAccesorios.setText(inmueble.getAccesorios());
        jfDetallesInmueble.txtComentarios.setText(inmueble.getComentarios());
        jfDetallesInmueble.txtOtrasObservaciones.setText(inmueble.getOtrasObservaciones());
        jfDetallesInmueble.impuestoMunicipal.setText(inmueble.getImpuestoMunicipal());
        jfDetallesInmueble.dgr.setText(inmueble.getDgr());
        jfDetallesInmueble.agua.setText(inmueble.getAgua());
        jfDetallesInmueble.luz.setText(inmueble.getLuz());
        jfDetallesInmueble.gas.setText(inmueble.getGas());
        jfDetallesInmueble.expensas.setText(inmueble.getExpensas());

        jfDetallesInmueble.locadorNombre.setText(locador.getNombre());
        jfDetallesInmueble.locadorTelefono.setText(locador.getTelefono());
        jfDetallesInmueble.locadorMail.setText(locador.getMail());
        jfDetallesInmueble.locadorTipoNro.setText(locador.getTipoNroDocumento());
        jfDetallesInmueble.locadorNro.setText(locador.getNroDocumento());
        jfDetallesInmueble.locadorOtrosDatos.setText(locador.getOtrosDatos());
    }

    public void rellenarCamposSegunLegajoViejo(LegajoViejo legajoViejo) {
        jfDetallesInmueble.calle.setText(legajoViejo.getInmCalle());
        jfDetallesInmueble.pisoDepto.setText(legajoViejo.getInmPisoDepto());
        jfDetallesInmueble.barrio.setText(legajoViejo.getInmBarrio());
        jfDetallesInmueble.codigoPostal.setText(legajoViejo.getInmCodigoPostal());
        jfDetallesInmueble.provinciaLocalidad.setText(legajoViejo.getInmProvinciaLocalidad());
        jfDetallesInmueble.tipo.setText(legajoViejo.getInmTipo());
        jfDetallesInmueble.operacion.setText(legajoViejo.getInmOperacion());
        jfDetallesInmueble.dormitorios.setText(legajoViejo.getInmDormitorios());
        jfDetallesInmueble.baños.setText(legajoViejo.getInmBaños());
        jfDetallesInmueble.plantas.setText(legajoViejo.getInmPlantas());
        jfDetallesInmueble.antiguedad.setText(legajoViejo.getInmAntiguedad());
        jfDetallesInmueble.estadoGeneral.setText(legajoViejo.getInmEstadoGeneral());
        jfDetallesInmueble.valor.setText(legajoViejo.getInmValor());
        jfDetallesInmueble.superficieTerreno.setText(legajoViejo.getInmSuperficieTerreno());
        jfDetallesInmueble.superficieCubierta.setText(legajoViejo.getInmSuperficieCubierta());
        jfDetallesInmueble.mtsFondo.setText(legajoViejo.getInmMtsFondo());
        jfDetallesInmueble.mtsFrente.setText(legajoViejo.getInmMtsFrente());
        jfDetallesInmueble.cantidadLlaves.setText(legajoViejo.getInmCantidadLlaves());
        jfDetallesInmueble.estilo.setText(legajoViejo.getInmEstilo());
        jfDetallesInmueble.orientacion.setText(legajoViejo.getInmOrientacion());
        jfDetallesInmueble.garage.setText(legajoViejo.getInmGarage());
        jfDetallesInmueble.living.setText(legajoViejo.getInmLiving());
        jfDetallesInmueble.cocina.setText(legajoViejo.getInmCocina());
        jfDetallesInmueble.comedor.setText(legajoViejo.getInmComedor());
        jfDetallesInmueble.dependencia.setText(legajoViejo.getInmDependencia());
        jfDetallesInmueble.piscina.setText(legajoViejo.getInmPiscina());
        jfDetallesInmueble.patioJardin.setText(legajoViejo.getInmPatioJardin());
        jfDetallesInmueble.txtAccesorios.setText(legajoViejo.getInmAccesorios());
        jfDetallesInmueble.txtComentarios.setText(legajoViejo.getInmComentarios());
        jfDetallesInmueble.txtOtrasObservaciones.setText(legajoViejo.getInmOtrasObservaciones());
        jfDetallesInmueble.impuestoMunicipal.setText(legajoViejo.getInmImpuestoMunicipal());
        jfDetallesInmueble.dgr.setText(legajoViejo.getInmDgr());
        jfDetallesInmueble.agua.setText(legajoViejo.getInmAgua());
        jfDetallesInmueble.luz.setText(legajoViejo.getInmLuz());
        jfDetallesInmueble.gas.setText(legajoViejo.getInmGas());
        jfDetallesInmueble.expensas.setText(legajoViejo.getInmExpensas());

        jfDetallesInmueble.locadorNombre.setText(legajoViejo.getLocadorNombre());
        jfDetallesInmueble.locadorTelefono.setText(legajoViejo.getLocadorTelefono());
        jfDetallesInmueble.locadorMail.setText(legajoViejo.getLocadorMail());
        jfDetallesInmueble.locadorTipoNro.setText(legajoViejo.getLocadorTipoNroDocumento());
        jfDetallesInmueble.locadorNro.setText(legajoViejo.getLocadorNroDocument());
        jfDetallesInmueble.locadorOtrosDatos.setText(legajoViejo.getLocadorOtrosDatos());
    }
}
