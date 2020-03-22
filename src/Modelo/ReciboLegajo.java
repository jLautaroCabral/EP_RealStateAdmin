/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Lauti
 */
public class ReciboLegajo {
    
    int Legajo_idLegajo;
    Date fechaDelRecibo;
    
    String direccionInmueble;
    String pisoDepto;
    String tipoInmueble;
    String barrioInmueble;
    
    String nombreLocatario;
    String nombreLocador;

    String dniLocador;
    
    String montoEnLetras;
    String mesEnLetras;
    String importe;
    String importeAbonado;
    String incluyeImpuestos;
    
    Date fechaVencimiento;
    
    String observaciones;

    
    
    public String getBarrioInmueble() {
        return barrioInmueble;
    }

    public void setBarrioInmueble(String barrioInmueble) {
        this.barrioInmueble = barrioInmueble;
    }
    
    public String getNombreLocador() {
        return nombreLocador;
    }

    public void setNombreLocador(String nombreLocador) {
        this.nombreLocador = nombreLocador;
    }

    public int getLegajo_idLegajo() {
        return Legajo_idLegajo;
    }

    public void setLegajo_idLegajo(int Legajo_idLegajo) {
        this.Legajo_idLegajo = Legajo_idLegajo;
    }


    public String getDireccionInmueble() {
        return direccionInmueble;
    }

    public void setDireccionInmueble(String direccionInmueble) {
        this.direccionInmueble = direccionInmueble;
    }
    
    public String getPisoDepto() {
        return pisoDepto;
    }

    public void setPisoDepto(String pisoDepto) {
        this.pisoDepto = pisoDepto;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getNombreLocatario() {
        return nombreLocatario;
    }

    public void setNombreLocatario(String nombreLocatario) {
        this.nombreLocatario = nombreLocatario;
    }

    public String getDniLocador() {
        return dniLocador;
    }

    public void setDniLocador(String dniLocador) {
        this.dniLocador = dniLocador;
    }

    public String getMontoEnLetras() {
        return montoEnLetras;
    }

    public void setMontoEnLetras(String montoEnLetras) {
        this.montoEnLetras = montoEnLetras;
    }

    public String getMesEnLetras() {
        return mesEnLetras;
    }

    public void setMesEnLetras(String mesEnLetras) {
        this.mesEnLetras = mesEnLetras;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getImporteAbonado() {
        return importeAbonado;
    }

    public void setImporteAbonado(String importeAbonado) {
        this.importeAbonado = importeAbonado;
    }

    public String getIncluyeImpuestos() {
        return incluyeImpuestos;
    }

    public void setIncluyeImpuestos(String incluyeImpuestos) {
        this.incluyeImpuestos = incluyeImpuestos;
    }


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaDelRecibo() {
        return fechaDelRecibo;
    }

    public void setFechaDelRecibo(Date fechaDelRecibo) {
        this.fechaDelRecibo = fechaDelRecibo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
