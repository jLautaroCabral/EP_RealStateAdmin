/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Lauti
 */
public class Inmueble {
    
    private String calle;
    private String pisoDepto;
    private String barrio;
    private String codigoPostal;
    private String provinciaLocalidad;
    private String tipo;
    private String operacion;
    private String dormitorios;
    private String baños;
    private String plantas;
    private String antiguedad;
    private String estadoGeneral;
    private String valor;
    private String superficieTerreno;
    private String superficieCubierta;
    private String mtsFrente;
    private String mtsFondo;
    private String cantidadLlaves;
    private String estilo;
    private String orientacion;
    private String garage;
    private String living;
    private String cocina;
    private String comedor;
    private String dependencia;
    private String piscina;
    private String patioJardin;
    private String accesorios;
    private String comentarios;
    private String otrasObservaciones;
    private String impuestoMunicipal;
    private String dgr;
    private String agua;
    private String luz;
    private String gas;
    private String expensas;
    
    private int idLocador;
    private String estadoActual;
    
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPisoDepto() {
        return pisoDepto;
    }

    public void setPisoDepto(String pisoDepto) {
        this.pisoDepto = pisoDepto;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvinciaLocalidad() {
        return provinciaLocalidad;
    }

    public void setProvinciaLocalidad(String provinciaLocalidad) {
        this.provinciaLocalidad = provinciaLocalidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(String dormitorios) {
        this.dormitorios = dormitorios;
    }

    public String getBaños() {
        return baños;
    }

    public void setBaños(String baños) {
        this.baños = baños;
    }

    public String getPlantas() {
        return plantas;
    }

    public void setPlantas(String plantas) {
        this.plantas = plantas;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getEstadoGeneral() {
        return estadoGeneral;
    }

    public void setEstadoGeneral(String estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getSuperficieTerreno() {
        return superficieTerreno;
    }

    public void setSuperficieTerreno(String superficieTerreno) {
        this.superficieTerreno = superficieTerreno;
    }

    public String getSuperficieCubierta() {
        return superficieCubierta;
    }

    public void setSuperficieCubierta(String superficieCubierta) {
        this.superficieCubierta = superficieCubierta;
    }

    public String getMtsFrente() {
        return mtsFrente;
    }

    public void setMtsFrente(String mtsFrente) {
        this.mtsFrente = mtsFrente;
    }

    public String getMtsFondo() {
        return mtsFondo;
    }

    public void setMtsFondo(String mtsFondo) {
        this.mtsFondo = mtsFondo;
    }

    public String getCantidadLlaves() {
        return cantidadLlaves;
    }

    public void setCantidadLlaves(String cantidadLlaves) {
        this.cantidadLlaves = cantidadLlaves;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }

    public String getCocina() {
        return cocina;
    }

    public void setCocina(String cocina) {
        this.cocina = cocina;
    }

    public String getComedor() {
        return comedor;
    }

    public void setComedor(String comedor) {
        this.comedor = comedor;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getPiscina() {
        return piscina;
    }

    public void setPiscina(String piscina) {
        this.piscina = piscina;
    }

    public String getPatioJardin() {
        return patioJardin;
    }

    public void setPatioJardin(String patioJardin) {
        this.patioJardin = patioJardin;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getOtrasObservaciones() {
        return otrasObservaciones;
    }

    public void setOtrasObservaciones(String otrasObservaciones) {
        this.otrasObservaciones = otrasObservaciones;
    }

    public String getImpuestoMunicipal() {
        return impuestoMunicipal;
    }

    public void setImpuestoMunicipal(String impuestoMunicipal) {
        this.impuestoMunicipal = impuestoMunicipal;
    }

    public String getDgr() {
        return dgr;
    }

    public void setDgr(String dgr) {
        this.dgr = dgr;
    }

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getExpensas() {
        return expensas;
    }

    public void setExpensas(String expensas) {
        this.expensas = expensas;
    }

    public int getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(int idLocador) {
        this.idLocador = idLocador;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
    
}
