/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasInmueble;
import Modelo.ConsultasLocador;
import Modelo.Inmueble;
import Modelo.Locador;
import Vista.JfAgregarModificarInmueble;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Lauti
 */
public class CtrlAgMoInmueble implements ActionListener {

    JfAgregarModificarInmueble jfAgregarModificarInmueble;
    boolean modific;
    int idField;

    public CtrlAgMoInmueble() {
        // Preparar ventana
        jfAgregarModificarInmueble = new JfAgregarModificarInmueble();
        jfAgregarModificarInmueble.setTitle("Agregar inmueble");
        jfAgregarModificarInmueble.btnAgregar.setText("Agregar inmueble");
        jfAgregarModificarInmueble.setLocationRelativeTo(null);
        configurarCmbLocadores();

        // Añadir oyentes
        jfAgregarModificarInmueble.btnAgregar.addActionListener(this);
    }

    public CtrlAgMoInmueble(boolean modificar) {
        modific = modificar;

        // Preparar ventana
        jfAgregarModificarInmueble = new JfAgregarModificarInmueble();
        jfAgregarModificarInmueble.setTitle("Modificar inmueble");
        jfAgregarModificarInmueble.btnAgregar.setText("Modificar inmueble");
        jfAgregarModificarInmueble.setLocationRelativeTo(null);
        configurarCmbLocadores();

        // Añadir oyentes
        jfAgregarModificarInmueble.btnAgregar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jfAgregarModificarInmueble.btnAgregar) {
            if (!modific) {
                Inmueble inmueble = crearInmuebleSegunCampos();
                if(ConsultasInmueble.insertarInmueble(inmueble)) ocultarVentana();
            } else {
                Inmueble inmueble = crearInmuebleSegunCampos();
                if(ConsultasInmueble.modificarInmueble(inmueble, idField)) ocultarVentana();
            }
        }
    }

    public void mostrarVentana() {
        jfAgregarModificarInmueble.setVisible(true);
    }
    
    public void ocultarVentana() {
        jfAgregarModificarInmueble.setVisible(false);
    }

    public void limpiarCampos() {
        jfAgregarModificarInmueble.calle.setText(null);
        jfAgregarModificarInmueble.pisoDepto.setText(null);
        jfAgregarModificarInmueble.barrio.setText(null);
        jfAgregarModificarInmueble.codigoPostal.setText(null);
        jfAgregarModificarInmueble.provinciaLocalidad.setText(null);
        jfAgregarModificarInmueble.tipo.setText(null);
        jfAgregarModificarInmueble.operacion.setText(null);
        jfAgregarModificarInmueble.dormitorios.setText(null);
        jfAgregarModificarInmueble.baños.setText(null);
        jfAgregarModificarInmueble.plantas.setText(null);
        jfAgregarModificarInmueble.antiguedad.setText(null);
        jfAgregarModificarInmueble.estadoGeneral.setText(null);
        jfAgregarModificarInmueble.valor.setText(null);
        jfAgregarModificarInmueble.superficieTerreno.setText(null);
        jfAgregarModificarInmueble.superficieCubierta.setText(null);
        jfAgregarModificarInmueble.mtsFrente.setText(null);
        jfAgregarModificarInmueble.mtsFondo.setText(null);
        jfAgregarModificarInmueble.cantidadLlaves.setText(null);
        jfAgregarModificarInmueble.estilo.setText(null);
        jfAgregarModificarInmueble.orientacion.setText(null);
        jfAgregarModificarInmueble.garage.setText(null);
        jfAgregarModificarInmueble.living.setText(null);
        jfAgregarModificarInmueble.cocina.setText(null);
        jfAgregarModificarInmueble.comedor.setText(null);
        jfAgregarModificarInmueble.dependencia.setText(null);
        jfAgregarModificarInmueble.piscina.setText(null);
        jfAgregarModificarInmueble.patioJardin.setText(null);
        jfAgregarModificarInmueble.txtAccesorios.setText(null);
        jfAgregarModificarInmueble.txtComentarios.setText(null);
        jfAgregarModificarInmueble.txtOtrasObservaciones.setText(null);
        jfAgregarModificarInmueble.impuestoMunicipal.setText(null);
        jfAgregarModificarInmueble.dgr.setText(null);
        jfAgregarModificarInmueble.agua.setText(null);
        jfAgregarModificarInmueble.luz.setText(null);
        jfAgregarModificarInmueble.gas.setText(null);
        jfAgregarModificarInmueble.expensas.setText(null);
        
        jfAgregarModificarInmueble.cmbLocador.setSelectedIndex(0);   
    }

    private void configurarCmbLocadores() {
        ConsultasLocador consultasLocador = new ConsultasLocador();
        ArrayList<String> nombresAAgregar = consultasLocador.getNombresLocadores();
        for (int i = 0; i < nombresAAgregar.size(); i++) {
            jfAgregarModificarInmueble.cmbLocador.addItem(nombresAAgregar.get(i));
        }
    }

    private Inmueble crearInmuebleSegunCampos() {
        Inmueble inmueble = new Inmueble();

        inmueble.setCalle(jfAgregarModificarInmueble.calle.getText());
        inmueble.setPisoDepto(jfAgregarModificarInmueble.pisoDepto.getText());
        inmueble.setBarrio(jfAgregarModificarInmueble.barrio.getText());
        inmueble.setCodigoPostal(jfAgregarModificarInmueble.codigoPostal.getText());
        inmueble.setProvinciaLocalidad(jfAgregarModificarInmueble.provinciaLocalidad.getText());
        inmueble.setTipo(jfAgregarModificarInmueble.tipo.getText());
        inmueble.setOperacion(jfAgregarModificarInmueble.operacion.getText());
        inmueble.setDormitorios(jfAgregarModificarInmueble.dormitorios.getText());
        inmueble.setBaños(jfAgregarModificarInmueble.baños.getText());
        inmueble.setPlantas(jfAgregarModificarInmueble.plantas.getText());
        inmueble.setAntiguedad(jfAgregarModificarInmueble.antiguedad.getText());
        inmueble.setEstadoGeneral(jfAgregarModificarInmueble.estadoGeneral.getText());
        inmueble.setValor(jfAgregarModificarInmueble.valor.getText());
        inmueble.setSuperficieTerreno(jfAgregarModificarInmueble.superficieTerreno.getText());
        inmueble.setSuperficieCubierta(jfAgregarModificarInmueble.superficieTerreno.getText());
        inmueble.setMtsFrente(jfAgregarModificarInmueble.mtsFrente.getText());
        inmueble.setMtsFondo(jfAgregarModificarInmueble.mtsFondo.getText());
        inmueble.setCantidadLlaves(jfAgregarModificarInmueble.cantidadLlaves.getText());
        inmueble.setEstilo(jfAgregarModificarInmueble.estilo.getText());
        inmueble.setOrientacion(jfAgregarModificarInmueble.orientacion.getText());
        inmueble.setGarage(jfAgregarModificarInmueble.garage.getText());
        inmueble.setLiving(jfAgregarModificarInmueble.living.getText());
        inmueble.setCocina(jfAgregarModificarInmueble.cocina.getText());
        inmueble.setComedor(jfAgregarModificarInmueble.comedor.getText());
        inmueble.setDependencia(jfAgregarModificarInmueble.dependencia.getText());
        inmueble.setPiscina(jfAgregarModificarInmueble.piscina.getText());
        inmueble.setPatioJardin(jfAgregarModificarInmueble.patioJardin.getText());
        inmueble.setAccesorios(jfAgregarModificarInmueble.txtAccesorios.getText());
        inmueble.setComentarios(jfAgregarModificarInmueble.txtComentarios.getText());
        inmueble.setOtrasObservaciones(jfAgregarModificarInmueble.txtOtrasObservaciones.getText());
        inmueble.setImpuestoMunicipal(jfAgregarModificarInmueble.impuestoMunicipal.getText());
        inmueble.setDgr(jfAgregarModificarInmueble.dgr.getText());
        inmueble.setAgua(jfAgregarModificarInmueble.agua.getText());
        inmueble.setLuz(jfAgregarModificarInmueble.luz.getText());
        inmueble.setGas(jfAgregarModificarInmueble.gas.getText());
        inmueble.setExpensas(jfAgregarModificarInmueble.expensas.getText());
        inmueble.setIdLocador(ConsultasLocador.getIdLocadorSegunNombre((String) jfAgregarModificarInmueble.cmbLocador.getSelectedItem()));
        inmueble.setEstadoActual("DESOCUPADO");

        return inmueble;
    }

    public void rellenarCamposSegunInmueble(int idInmueble) {

        idField = idInmueble;

        Inmueble inmueble = ConsultasInmueble.getInmueble(idInmueble);
        Locador locador = ConsultasLocador.getLocador(inmueble.getIdLocador());

        jfAgregarModificarInmueble.calle.setText(inmueble.getCalle());
        jfAgregarModificarInmueble.pisoDepto.setText(inmueble.getPisoDepto());
        jfAgregarModificarInmueble.barrio.setText(inmueble.getBarrio());
        jfAgregarModificarInmueble.codigoPostal.setText(inmueble.getCodigoPostal());
        jfAgregarModificarInmueble.provinciaLocalidad.setText(inmueble.getProvinciaLocalidad());
        jfAgregarModificarInmueble.tipo.setText(inmueble.getTipo());
        jfAgregarModificarInmueble.operacion.setText(inmueble.getOperacion());
        jfAgregarModificarInmueble.dormitorios.setText(inmueble.getDormitorios());
        jfAgregarModificarInmueble.baños.setText(inmueble.getBaños());
        jfAgregarModificarInmueble.plantas.setText(inmueble.getPlantas());
        jfAgregarModificarInmueble.antiguedad.setText(inmueble.getAntiguedad());
        jfAgregarModificarInmueble.estadoGeneral.setText(inmueble.getEstadoGeneral());
        jfAgregarModificarInmueble.valor.setText(inmueble.getValor());
        jfAgregarModificarInmueble.superficieTerreno.setText(inmueble.getSuperficieTerreno());
        jfAgregarModificarInmueble.superficieCubierta.setText(inmueble.getSuperficieCubierta());
        jfAgregarModificarInmueble.mtsFondo.setText(inmueble.getMtsFondo());
        jfAgregarModificarInmueble.mtsFrente.setText(inmueble.getMtsFrente());
        jfAgregarModificarInmueble.cantidadLlaves.setText(inmueble.getCantidadLlaves());
        jfAgregarModificarInmueble.estilo.setText(inmueble.getEstilo());
        jfAgregarModificarInmueble.orientacion.setText(inmueble.getOrientacion());
        jfAgregarModificarInmueble.garage.setText(inmueble.getGarage());
        jfAgregarModificarInmueble.living.setText(inmueble.getLiving());
        jfAgregarModificarInmueble.cocina.setText(inmueble.getCocina());
        jfAgregarModificarInmueble.comedor.setText(inmueble.getComedor());
        jfAgregarModificarInmueble.dependencia.setText(inmueble.getDependencia());
        jfAgregarModificarInmueble.piscina.setText(inmueble.getPiscina());
        jfAgregarModificarInmueble.patioJardin.setText(inmueble.getPatioJardin());
        jfAgregarModificarInmueble.txtAccesorios.setText(inmueble.getAccesorios());
        jfAgregarModificarInmueble.txtComentarios.setText(inmueble.getComentarios());
        jfAgregarModificarInmueble.txtOtrasObservaciones.setText(inmueble.getOtrasObservaciones());
        jfAgregarModificarInmueble.impuestoMunicipal.setText(inmueble.getImpuestoMunicipal());
        jfAgregarModificarInmueble.dgr.setText(inmueble.getDgr());
        jfAgregarModificarInmueble.agua.setText(inmueble.getAgua());
        jfAgregarModificarInmueble.luz.setText(inmueble.getLuz());
        jfAgregarModificarInmueble.gas.setText(inmueble.getGas());
        jfAgregarModificarInmueble.expensas.setText(inmueble.getExpensas());

        jfAgregarModificarInmueble.cmbLocador.setSelectedItem(locador.getNombre());
    }
}
