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
public class Locador {
    
    private String nombre;
    private String telefono;
    private String mail;
    private String domicilio;
    private java.sql.Date fechaNacimiento;
    private String tipoNroDocumento;
    private String nroDocumento;
    private String otrosDatos;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTipoNroDocumento(String tipoNroDocumento) {
        this.tipoNroDocumento = tipoNroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public void setOtrosDatos(String otrosDatos) {
        this.otrosDatos = otrosDatos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoNroDocumento() {
        return tipoNroDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public String getOtrosDatos() {
        return otrosDatos;
    }
     
}
