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
public class LegajoViejo {
    String legajo;

    // Inmueble
    private String InmCalle;
    private String InmPisoDepto;
    private String InmBarrio;
    private String InmCodigoPostal;
    private String InmProvinciaLocalidad;
    private String InmTipo;
    private String InmOperacion;
    private String InmDormitorios;
    private String InmBaños;
    private String InmPlantas;
    private String InmAntiguedad;
    private String InmEstadoGeneral;
    private String InmValor;
    private String InmSuperficieTerreno;
    private String InmSuperficieCubierta;
    private String InmMtsFrente;
    private String InmMtsFondo;
    private String InmCantidadLlaves;
    private String InmEstilo;
    private String InmOrientacion;
    private String InmGarage;
    private String InmLiving;
    private String InmCocina;
    private String InmComedor;
    private String InmDependencia;
    private String InmPiscina;
    private String InmPatioJardin;
    private String InmAccesorios;
    private String InmComentarios;
    private String InmOtrasObservaciones;
    private String InmImpestoMunicipal;
    private String InmDgr;
    private String InmAgua;
    private String InmLuz;
    private String InmGas;
    private String InmExpensas;

    // Locador
    private String LocadorNombre;
    private String LocadorTelefono;
    private String LocadorMail;
    private String LocadorDomicilio;
    private java.sql.Date LocadorFechaNacimiento;
    private String LocadorTipoNroDocumento;
    private String LocadorNroDocument;
    private String LocadorOtrosDatos;
    
    // Locatario
    private String LocatarioNombre;
    private String LocatarioTelefono;
    private String LocatarioMail;
    private String LocatarioTipoNroDocumento;
    private String LocatarioNroDocumento;
    private String LocatarioOtrosDatos;
    
    // Legajo
    private String Garante1Nombre;
    private String Garante1Telefono;
    private String Garante1Domicilio;
    private String Garante1Mail;
    private String Garante2Nombre;
    private String Garante2Telefono;
    private String Garante2Domicilio;
    private String Garante2Mail;
    private String Garante3Nombre;
    private String Garante3Telefono;
    private String Garante3Domicilio;
    private String Garante3Mail;
    private String Garante4Nombre;
    private String Garante4Telefono;
    private String Garante4Domicilio;
    private String Garante4Mail;
    private String OtrosGarantes;
    private String MontoAlquiler;
    private String TitularImpuestoMunicipal;
    private String TitularDgr;
    private String TitularAgua;
    private String TitularLuz;
    private String TitularGas;
    private String TitularExpensas;
    private String Observaciones;
    private java.sql.Date FechaSubscripcion;
    private java.sql.Date FechaInicio;
    private java.sql.Date FechaFinalizacion;
    private String EstadoActual;

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getInmCalle() {
        return InmCalle;
    }

    public void setInmCalle(String InmCalle) {
        this.InmCalle = InmCalle;
    }

    public String getInmPisoDepto() {
        return InmPisoDepto;
    }

    public void setInmPisoDepto(String InmPisoDepto) {
        this.InmPisoDepto = InmPisoDepto;
    }

    public String getInmBarrio() {
        return InmBarrio;
    }

    public void setInmBarrio(String InmBarrio) {
        this.InmBarrio = InmBarrio;
    }

    public String getInmCodigoPostal() {
        return InmCodigoPostal;
    }

    public void setInmCodigoPostal(String InmCodigoPostal) {
        this.InmCodigoPostal = InmCodigoPostal;
    }

    public String getInmProvinciaLocalidad() {
        return InmProvinciaLocalidad;
    }

    public void setInmProvinciaLocalidad(String InmProvinciaLocalidad) {
        this.InmProvinciaLocalidad = InmProvinciaLocalidad;
    }

    public String getInmTipo() {
        return InmTipo;
    }

    public void setInmTipo(String InmTipo) {
        this.InmTipo = InmTipo;
    }

    public String getInmOperacion() {
        return InmOperacion;
    }

    public void setInmOperacion(String InmOperacion) {
        this.InmOperacion = InmOperacion;
    }

    public String getInmDormitorios() {
        return InmDormitorios;
    }

    public void setInmDormitorios(String InmDormitorios) {
        this.InmDormitorios = InmDormitorios;
    }

    public String getInmBaños() {
        return InmBaños;
    }

    public void setInmBaños(String InmBaños) {
        this.InmBaños = InmBaños;
    }

    public String getInmPlantas() {
        return InmPlantas;
    }

    public void setInmPlantas(String InmPlantas) {
        this.InmPlantas = InmPlantas;
    }

    public String getInmAntiguedad() {
        return InmAntiguedad;
    }

    public void setInmAntiguedad(String InmAntiguedad) {
        this.InmAntiguedad = InmAntiguedad;
    }

    public String getInmEstadoGeneral() {
        return InmEstadoGeneral;
    }

    public void setInmEstadoGeneral(String InmEstadoGeneral) {
        this.InmEstadoGeneral = InmEstadoGeneral;
    }

    public String getInmValor() {
        return InmValor;
    }

    public void setInmValor(String InmValor) {
        this.InmValor = InmValor;
    }

    public String getImpSuperficieTerreno() {
        return InmSuperficieTerreno;
    }

    public void setInmSuperficieTerreno(String InmSuperficieTerreno) {
        this.InmSuperficieTerreno = InmSuperficieTerreno;
    }

    public String getInmSuperficieCubierta() {
        return InmSuperficieCubierta;
    }

    public void setInmSuperficieCubierta(String InmSuperficieCubierta) {
        this.InmSuperficieCubierta = InmSuperficieCubierta;
    }

    public String getInmMtsFrente() {
        return InmMtsFrente;
    }

    public void setInmMtsFrente(String InmMtsFrente) {
        this.InmMtsFrente = InmMtsFrente;
    }

    public String getInmMtsFondo() {
        return InmMtsFondo;
    }

    public void setInmMtsFondo(String InmMtsFondo) {
        this.InmMtsFondo = InmMtsFondo;
    }

    public String getInmCantidadLlaves() {
        return InmCantidadLlaves;
    }

    public void setInmCantidadLlaves(String InmCantidadLlaves) {
        this.InmCantidadLlaves = InmCantidadLlaves;
    }

    public String getInmEstilo() {
        return InmEstilo;
    }

    public void setInmEstilo(String InmEstilo) {
        this.InmEstilo = InmEstilo;
    }

    public String getInmOrientacion() {
        return InmOrientacion;
    }

    public void setInmOrientacion(String InmOrientacion) {
        this.InmOrientacion = InmOrientacion;
    }

    public String getInmGarage() {
        return InmGarage;
    }

    public void setInmGarage(String InmGarage) {
        this.InmGarage = InmGarage;
    }

    public String getInmLiving() {
        return InmLiving;
    }

    public void setInmLiving(String InmLiving) {
        this.InmLiving = InmLiving;
    }

    public String getInmCocina() {
        return InmCocina;
    }

    public void setInmCocina(String InmCocina) {
        this.InmCocina = InmCocina;
    }

    public String getInmComedor() {
        return InmComedor;
    }

    public void setInmComedor(String InmComedor) {
        this.InmComedor = InmComedor;
    }

    public String getInmDependencia() {
        return InmDependencia;
    }

    public void setInmDependencia(String InmDependencia) {
        this.InmDependencia = InmDependencia;
    }

    public String getInmPiscina() {
        return InmPiscina;
    }

    public void setInmPiscina(String InmPiscina) {
        this.InmPiscina = InmPiscina;
    }

    public String getInmPatioJardin() {
        return InmPatioJardin;
    }

    public void setInmPatioJardin(String InmPatioJardin) {
        this.InmPatioJardin = InmPatioJardin;
    }

    public String getInmAccesorios() {
        return InmAccesorios;
    }

    public void setInmAccesorios(String InmAccesorios) {
        this.InmAccesorios = InmAccesorios;
    }

    public String getInmComentarios() {
        return InmComentarios;
    }

    public void setInmComentarios(String InmComentarios) {
        this.InmComentarios = InmComentarios;
    }

    public String getInmOtrasObservaciones() {
        return InmOtrasObservaciones;
    }

    public void setInmOtrasObservaciones(String InmOtrasObservaciones) {
        this.InmOtrasObservaciones = InmOtrasObservaciones;
    }

    public String getInmImpuestoMunicipal() {
        return InmImpestoMunicipal;
    }

    public void setInmImpuestoMunicipal(String InmImpestoMunicipal) {
        this.InmImpestoMunicipal = InmImpestoMunicipal;
    }

    public String getInmDgr() {
        return InmDgr;
    }

    public void setInmDgr(String InmDgr) {
        this.InmDgr = InmDgr;
    }

    public String getInmAgua() {
        return InmAgua;
    }

    public void setInmAgua(String InmAgua) {
        this.InmAgua = InmAgua;
    }

    public String getInmLuz() {
        return InmLuz;
    }

    public void setInmLuz(String InmLuz) {
        this.InmLuz = InmLuz;
    }

    public String getInmGas() {
        return InmGas;
    }

    public void setInmGas(String InmGas) {
        this.InmGas = InmGas;
    }

    public String getInmExpensas() {
        return InmExpensas;
    }

    public void setInmExpensas(String InmExpensas) {
        this.InmExpensas = InmExpensas;
    }

    public String getLocadorNombre() {
        return LocadorNombre;
    }

    public void setLocadorNombre(String LocadorNombre) {
        this.LocadorNombre = LocadorNombre;
    }

    public String getLocadorTelefono() {
        return LocadorTelefono;
    }

    public void setLocadorTelefono(String LocadorTelefono) {
        this.LocadorTelefono = LocadorTelefono;
    }

    public String getLocadorDomicilio() {
        return LocadorDomicilio;
    }

    public void setLocadorDomicilio(String LocadorDomicilio) {
        this.LocadorDomicilio = LocadorDomicilio;
    }

    public Date getLocadorFechaNacimiento() {
        return LocadorFechaNacimiento;
    }

    public void setLocadorFechaNacimiento(Date LocadorFechaNacimiento) {
        this.LocadorFechaNacimiento = LocadorFechaNacimiento;
    }

    public String getLocadorTipoNroDocumento() {
        return LocadorTipoNroDocumento;
    }

    public void setLocadorTipoNroDocumento(String LocadorTipoNroDocumento) {
        this.LocadorTipoNroDocumento = LocadorTipoNroDocumento;
    }

    public String getLocadorNroDocument() {
        return LocadorNroDocument;
    }

    public void setLocadorNroDocument(String LocadorNroDocument) {
        this.LocadorNroDocument = LocadorNroDocument;
    }

    public String getLocadorOtrosDatos() {
        return LocadorOtrosDatos;
    }

    public void setLocadorOtrosDatos(String LocadorOtrosDatos) {
        this.LocadorOtrosDatos = LocadorOtrosDatos;
    }

    public String getLocatarioNombre() {
        return LocatarioNombre;
    }

    public void setLocatarioNombre(String LocatarioNombre) {
        this.LocatarioNombre = LocatarioNombre;
    }

    public String getLocatarioTelefono() {
        return LocatarioTelefono;
    }

    public void setLocatarioTelefono(String LocatarioTelefono) {
        this.LocatarioTelefono = LocatarioTelefono;
    }

    public String getLocatarioMail() {
        return LocatarioMail;
    }

    public void setLocatarioMail(String LocatarioMail) {
        this.LocatarioMail = LocatarioMail;
    }

    public String getLocatarioTipoNroDocumento() {
        return LocatarioTipoNroDocumento;
    }

    public void setLocatarioTipoNroDocumento(String LocatarioTipoNroDocumento) {
        this.LocatarioTipoNroDocumento = LocatarioTipoNroDocumento;
    }

    public String getLocatarioNroDocumento() {
        return LocatarioNroDocumento;
    }

    public void setLocatarioNroDocumento(String LocatarioNroDocumento) {
        this.LocatarioNroDocumento = LocatarioNroDocumento;
    }

    public String getLocatarioOtrosDatos() {
        return LocatarioOtrosDatos;
    }

    public void setLocatarioOtrosDatos(String LocatarioOtrosDatos) {
        this.LocatarioOtrosDatos = LocatarioOtrosDatos;
    }

    public String getGarante1Nombre() {
        return Garante1Nombre;
    }

    public void setGarante1Nombre(String Garante1Nombre) {
        this.Garante1Nombre = Garante1Nombre;
    }

    public String getGarante1Telefono() {
        return Garante1Telefono;
    }

    public void setGarante1Telefono(String Garante1Telefono) {
        this.Garante1Telefono = Garante1Telefono;
    }

    public String getGarante1Domicilio() {
        return Garante1Domicilio;
    }

    public void setGarante1Domicilio(String Garante1Domicilio) {
        this.Garante1Domicilio = Garante1Domicilio;
    }

    public String getGarante1Mail() {
        return Garante1Mail;
    }

    public void setGarante1Mail(String Garante1Mail) {
        this.Garante1Mail = Garante1Mail;
    }

    public String getGarante2Nombre() {
        return Garante2Nombre;
    }

    public void setGarante2Nombre(String Garante2Nombre) {
        this.Garante2Nombre = Garante2Nombre;
    }

    public String getGarante2Telefono() {
        return Garante2Telefono;
    }

    public void setGarante2Telefono(String Garante2Telefono) {
        this.Garante2Telefono = Garante2Telefono;
    }

    public String getGarante2Domicilio() {
        return Garante2Domicilio;
    }

    public void setGarante2Domicilio(String Garante2Domicilio) {
        this.Garante2Domicilio = Garante2Domicilio;
    }

    public String getGarante2Mail() {
        return Garante2Mail;
    }

    public void setGarante2Mail(String Garante2Mail) {
        this.Garante2Mail = Garante2Mail;
    }

    public String getGarante3Nombre() {
        return Garante3Nombre;
    }

    public void setGarante3Nombre(String Garante3Nombre) {
        this.Garante3Nombre = Garante3Nombre;
    }

    public String getGarante3Telefono() {
        return Garante3Telefono;
    }

    public void setGarante3Telefono(String Garante3Telefono) {
        this.Garante3Telefono = Garante3Telefono;
    }

    public String getGarante3Domicilio() {
        return Garante3Domicilio;
    }

    public void setGarante3Domicilio(String Garante3Domicilio) {
        this.Garante3Domicilio = Garante3Domicilio;
    }

    public String getGarante3Mail() {
        return Garante3Mail;
    }

    public void setGarante3Mail(String Garante3Mail) {
        this.Garante3Mail = Garante3Mail;
    }

    public String getGarante4Nombre() {
        return Garante4Nombre;
    }

    public void setGarante4Nombre(String Garante4Nombre) {
        this.Garante4Nombre = Garante4Nombre;
    }

    public String getGarante4Telefono() {
        return Garante4Telefono;
    }

    public void setGarante4Telefono(String Garante4Telefono) {
        this.Garante4Telefono = Garante4Telefono;
    }

    public String getGarante4Domicilio() {
        return Garante4Domicilio;
    }

    public void setGarante4Domicilio(String Garante4Domicilio) {
        this.Garante4Domicilio = Garante4Domicilio;
    }

    public String getGarante4Mail() {
        return Garante4Mail;
    }

    public void setGarante4Mail(String Garante4Mail) {
        this.Garante4Mail = Garante4Mail;
    }

    public String getOtrosGarantes() {
        return OtrosGarantes;
    }

    public void setOtrosGarantes(String OtrosGarantes) {
        this.OtrosGarantes = OtrosGarantes;
    }

    public String getMontoAlquiler() {
        return MontoAlquiler;
    }

    public void setMontoAlquiler(String MontoAlquiler) {
        this.MontoAlquiler = MontoAlquiler;
    }

    public String getTitularImpuestoMunicipal() {
        return TitularImpuestoMunicipal;
    }

    public void setTitularImpuestoMunicipal(String TitularImpuestoMunicipal) {
        this.TitularImpuestoMunicipal = TitularImpuestoMunicipal;
    }

    public String getTitularDgr() {
        return TitularDgr;
    }

    public void setTitularDgr(String TitularDgr) {
        this.TitularDgr = TitularDgr;
    }

    public String getTitularAgua() {
        return TitularAgua;
    }

    public void setTitularAgua(String TitularAgua) {
        this.TitularAgua = TitularAgua;
    }

    public String getTitularLuz() {
        return TitularLuz;
    }

    public void setTitularLuz(String TitularLuz) {
        this.TitularLuz = TitularLuz;
    }

    public String getTitularGas() {
        return TitularGas;
    }

    public void setTitularGas(String TitularGas) {
        this.TitularGas = TitularGas;
    }

    public String getTitularExpensas() {
        return TitularExpensas;
    }

    public void setTitularExpensas(String TitularExpensas) {
        this.TitularExpensas = TitularExpensas;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public Date getFechaSubscripcion() {
        return FechaSubscripcion;
    }

    public void setFechaSubscripcion(Date FechaSubscripcion) {
        this.FechaSubscripcion = FechaSubscripcion;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFinalizacion() {
        return FechaFinalizacion;
    }

    public void setFechaFinalizacion(Date FechaFinalizacion) {
        this.FechaFinalizacion = FechaFinalizacion;
    }

    public String getEstadoActual() {
        return EstadoActual;
    }

    public void setEstadoActual(String EstadoActual) {
        this.EstadoActual = EstadoActual;
    }
    
    public String getInmSuperficieTerreno() {
        return InmSuperficieTerreno;
    }

    public String getInmImpestoMunicipal() {
        return InmImpestoMunicipal;
    }

    public void setInmImpestoMunicipal(String InmImpestoMunicipal) {
        this.InmImpestoMunicipal = InmImpestoMunicipal;
    }

    public String getLocadorMail() {
        return LocadorMail;
    }

    public void setLocadorMail(String LocadorMail) {
        this.LocadorMail = LocadorMail;
    }

    
}
