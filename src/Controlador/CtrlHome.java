/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Lauti
 */
public class CtrlHome implements ActionListener {

    Home vHome;
    CtrlInterLocadores ctrlInterLocadores;
    CtrlInterLocatarios ctrlInterLocatarios;
    CtrlInterInmuebles ctrlInterInmuebles;
    CtrlInterLegajos ctrlInterLegajos;
    CtrlInterLegajosViejos ctrlInterLegajosViejos;

    public CtrlHome() {
        vHome = new Home();
        vHome.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vHome.setLocationRelativeTo(null);
        vHome.setVisible(true);

        // Inicializar controladores y añadirlos al desktop pane
        ctrlInterLocadores = new CtrlInterLocadores();
        vHome.dpHome.add(ctrlInterLocadores.getInterLocadores());
        ctrlInterLocatarios = new CtrlInterLocatarios();
        vHome.dpHome.add(ctrlInterLocatarios.getInterLocatario());
        ctrlInterInmuebles = new CtrlInterInmuebles();
        vHome.dpHome.add(ctrlInterInmuebles.getInterInmuebles());
        ctrlInterLegajos = new CtrlInterLegajos();
        vHome.dpHome.add(ctrlInterLegajos.getInterLegajo());
        ctrlInterLegajosViejos = new CtrlInterLegajosViejos();
        vHome.dpHome.add(ctrlInterLegajosViejos.getInterLegajosViejos());

        añadirOyentesDeEventos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Al presionar LOCADORES
        if (e.getSource() == vHome.itmenuLocadores) {
            ctrlInterLegajosViejos.ocultarInterLegajo();
            ctrlInterInmuebles.ocultarInterInmuebles();
            ctrlInterLegajos.ocultarInterLegajo();
            ctrlInterLocatarios.ocultarInterLocatarios();
            ctrlInterLocadores.mostrarInterLocadores();
        }
        
        // Al presionar LOCATARIOS
        if (e.getSource() == vHome.itmenuLocatarios) {
            ctrlInterLegajosViejos.ocultarInterLegajo();
            ctrlInterInmuebles.ocultarInterInmuebles();
            ctrlInterLegajos.ocultarInterLegajo();
            ctrlInterLocadores.ocultarInterLocadores();
            ctrlInterLocatarios.mostrarInterLocatarios();
        }
        
        // Al presionar INMUEBLES
        if(e.getSource() == vHome.itmenuInmuebles) {
            ctrlInterLegajosViejos.ocultarInterLegajo();
            ctrlInterLegajos.ocultarInterLegajo();
            ctrlInterLocadores.ocultarInterLocadores();
            ctrlInterLocatarios.ocultarInterLocatarios();
            ctrlInterInmuebles.mostrarInterInmuebles();
        }
        
        // Al presionar LEGAJOS
        if(e.getSource() == vHome.itmenuLegajos) {
            ctrlInterLegajosViejos.ocultarInterLegajo();
            ctrlInterLocadores.ocultarInterLocadores();
            ctrlInterLocatarios.ocultarInterLocatarios();
            ctrlInterInmuebles.ocultarInterInmuebles();
            ctrlInterLegajos.mostrarInterLegajo();
        }
        
        // Al presionar LEGAJOS VIEJOS
        if(e.getSource() == vHome.itmenuLegajosViejos) {
            ctrlInterLocadores.ocultarInterLocadores();
            ctrlInterLocatarios.ocultarInterLocatarios();
            ctrlInterInmuebles.ocultarInterInmuebles();
            ctrlInterLegajos.ocultarInterLegajo();
            ctrlInterLegajosViejos.mostrarInterLegajo();
        }
    }

    private void añadirOyentesDeEventos() {
        vHome.itmenuLocadores.addActionListener(this);
        vHome.itmenuLocatarios.addActionListener(this);
        vHome.itmenuInmuebles.addActionListener(this);
        vHome.itmenuLegajos.addActionListener(this);
        vHome.itmenuLegajosViejos.addActionListener(this);
    }
}

