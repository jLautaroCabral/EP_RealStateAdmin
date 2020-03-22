/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Lauti
 */
public class Legajo {
    
    private int idInmueble;
    private int idLocador;
    private int idLocatario;
    
    private String legajo;
    
    private String garante1Nombre;
    private String garante1Telefono;
    private String garante1Domicilio;
    private String garante1Mail;
    
    private String garante2Nombre;
    private String garante2Telefono;
    private String garante2Domicilio;
    private String garante2Mail;
    
    private String garante3Nombre;
    private String garante3Telefono;
    private String garante3Domicilio;
    private String garante3Mail;
    
    private String garante4Nombre;
    private String garante4Telefono;
    private String garante4Domicilio;
    private String garante4Mail;
    
    private String otrosGarantes;
    private String montoAlquiler;
    private String titularImpuestoMunicipal;
    private String titularDgr;
    private String titularAgua;
    private String titularLuz;
    private String titularGas;
    private String titularExpensas;
    private String observaciones;
    
    private java.sql.Date fechaSubscripcion;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFinalizacion;
    
    private String estadoActual;

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public int getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(int idLocador) {
        this.idLocador = idLocador;
    }

    public int getIdLocatario() {
        return idLocatario;
    }

    public void setIdLocatario(int idLocatario) {
        this.idLocatario = idLocatario;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getGarante1Nombre() {
        return garante1Nombre;
    }

    public void setGarante1Nombre(String garante1Nombre) {
        this.garante1Nombre = garante1Nombre;
    }

    public String getGarante1Telefono() {
        return garante1Telefono;
    }

    public void setGarante1Telefono(String garante1Telefono) {
        this.garante1Telefono = garante1Telefono;
    }

    public String getGarante1Domicilio() {
        return garante1Domicilio;
    }

    public void setGarante1Domicilio(String garante1Domicilio) {
        this.garante1Domicilio = garante1Domicilio;
    }

    public String getGarante1Mail() {
        return garante1Mail;
    }

    public void setGarante1Mail(String garante1Mail) {
        this.garante1Mail = garante1Mail;
    }

    public String getGarante2Nombre() {
        return garante2Nombre;
    }

    public void setGarante2Nombre(String garante2Nombre) {
        this.garante2Nombre = garante2Nombre;
    }

    public String getGarante2Telefono() {
        return garante2Telefono;
    }

    public void setGarante2Telefono(String garante2Telefono) {
        this.garante2Telefono = garante2Telefono;
    }

    public String getGarante2Domicilio() {
        return garante2Domicilio;
    }

    public void setGarante2Domicilio(String garante2Domicilio) {
        this.garante2Domicilio = garante2Domicilio;
    }

    public String getGarante2Mail() {
        return garante2Mail;
    }

    public void setGarante2Mail(String garante2Mail) {
        this.garante2Mail = garante2Mail;
    }

    public String getGarante3Nombre() {
        return garante3Nombre;
    }

    public void setGarante3Nombre(String garante3Nombre) {
        this.garante3Nombre = garante3Nombre;
    }

    public String getGarante3Telefono() {
        return garante3Telefono;
    }

    public void setGarante3Telefono(String garante3Telefono) {
        this.garante3Telefono = garante3Telefono;
    }

    public String getGarante3Domicilio() {
        return garante3Domicilio;
    }

    public void setGarante3Domicilio(String garante3Domicilio) {
        this.garante3Domicilio = garante3Domicilio;
    }

    public String getGarante3Mail() {
        return garante3Mail;
    }

    public void setGarante3Mail(String garante3Mail) {
        this.garante3Mail = garante3Mail;
    }

    public String getGarante4Nombre() {
        return garante4Nombre;
    }

    public void setGarante4Nombre(String garante4Nombre) {
        this.garante4Nombre = garante4Nombre;
    }

    public String getGarante4Telefono() {
        return garante4Telefono;
    }

    public void setGarante4Telefono(String garante4Telefono) {
        this.garante4Telefono = garante4Telefono;
    }

    public String getGarante4Domicilio() {
        return garante4Domicilio;
    }

    public void setGarante4Domicilio(String garante4Domicilio) {
        this.garante4Domicilio = garante4Domicilio;
    }

    public String getGarante4Mail() {
        return garante4Mail;
    }

    public void setGarante4Mail(String garante4Mail) {
        this.garante4Mail = garante4Mail;
    }

    public String getOtrosGarantes() {
        return otrosGarantes;
    }

    public void setOtrosGarantes(String otrosGarantes) {
        this.otrosGarantes = otrosGarantes;
    }

    public String getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(String montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }

    public String getTitularImpuestoMunicipal() {
        return titularImpuestoMunicipal;
    }

    public void setTitularImpuestoMunicipal(String titularImpuestoMunicipal) {
        this.titularImpuestoMunicipal = titularImpuestoMunicipal;
    }

    public String getTitularDgr() {
        return titularDgr;
    }

    public void setTitularDgr(String titularDgr) {
        this.titularDgr = titularDgr;
    }

    public String getTitularAgua() {
        return titularAgua;
    }

    public void setTitularAgua(String titularAgua) {
        this.titularAgua = titularAgua;
    }

    public String getTitularLuz() {
        return titularLuz;
    }

    public void setTitularLuz(String titularLuz) {
        this.titularLuz = titularLuz;
    }

    public String getTitularGas() {
        return titularGas;
    }

    public void setTitularGas(String titularGas) {
        this.titularGas = titularGas;
    }

    public String getTitularExpensas() {
        return titularExpensas;
    }

    public void setTitularExpensas(String titularExpensas) {
        this.titularExpensas = titularExpensas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaSubscripcion() {
        return fechaSubscripcion;
    }

    public void setFechaSubscripcion(Date fechaSubscripcion) {
        this.fechaSubscripcion = fechaSubscripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
    
}
