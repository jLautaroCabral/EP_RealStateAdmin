/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.InterLocadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Conexion;
import Modelo.ConsultasLocador;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lauti
 */
public class CtrlInterLocadores implements ActionListener, KeyListener {

    // Ventana y controladores
    InterLocadores interLocadores;
    CtrlAgMoLocador ctrlAgregarLocador;
    CtrlAgMoLocador ctrlModificarLocador;
    CtrlDetallesLocador ctrlDetallesLocador;

    // Otro
    DefaultTableModel tableModel = new DefaultTableModel();

    public CtrlInterLocadores() {
        // Preparar ventana
        interLocadores = new InterLocadores();
        interLocadores.setTitle("Locadores");
        añadirOyentesDeEvento();


        // Preparar tabla
        interLocadores.jtLocadores.setModel(tableModel);
        tableModel.addColumn("id");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Telefono");
        tableModel.addColumn("Mail");
        ajustarConfiguraciónTabla();
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Al presionar BOTON ACTUALIZAR
        if (e.getSource() == interLocadores.btnActualizar) {
            actualizarTabla();
        }

        // Al presionar BOTON BUSCAR
        if (e.getSource() == interLocadores.btnBuscar) {
            actualizarTabla(interLocadores.buscador.getText(), interLocadores.cmbSeleccion.getSelectedIndex());
        }

        // Al presionar BOTON AGREGAR
        if (e.getSource() == interLocadores.btnAgregar) {
            if (ctrlAgregarLocador == null) {
                ctrlAgregarLocador = new CtrlAgMoLocador();
                ctrlAgregarLocador.mostrarVentana();
            } else {
                ctrlAgregarLocador.limpiarCampos();
                ctrlAgregarLocador.mostrarVentana();
            }
        }

        // Al presionar BOTON ELIMINAR (Seguridad de selección incluida)
        if (e.getSource() == interLocadores.btnEliminar) {

            int filaSeleccionada = interLocadores.jtLocadores.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int a = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el locador?\n Al borrar el locador todos los registros que contengan este locador serán modificados", "Seguridad", JOptionPane.WARNING_MESSAGE);
                if (a == 0) {
                    int idLocadorSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                    ConsultasLocador.eliminarLocador(idLocadorSeleccionado);
                    actualizarTabla();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Al presionar BOTON MODIFICAR (Seguridad de selección incluida)
        if (e.getSource() == interLocadores.btnModificar) {

            int filaSeleccionada = interLocadores.jtLocadores.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idLocadorSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlModificarLocador == null) {
                    ctrlModificarLocador = new CtrlAgMoLocador(true);
                    ctrlModificarLocador.rellenarCamposSegunLocador(idLocadorSeleccionado);
                    ctrlModificarLocador.mostrarVentana();
                } else {
                    ctrlModificarLocador.rellenarCamposSegunLocador(idLocadorSeleccionado);
                    ctrlModificarLocador.mostrarVentana();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Al presionar BOTON VER DETALLES (Seguridad de selección incluida)
        if (e.getSource() == interLocadores.btnDetalles) {

            int filaSeleccionada = interLocadores.jtLocadores.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idLocadorSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlDetallesLocador == null) {
                    ctrlDetallesLocador = new CtrlDetallesLocador();
                    ctrlDetallesLocador.rellenarCamposSegunLocador(idLocadorSeleccionado);
                    ctrlDetallesLocador.mostrarVentana();
                } else {
                    ctrlDetallesLocador.rellenarCamposSegunLocador(idLocadorSeleccionado);
                    ctrlDetallesLocador.mostrarVentana();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getSource() == interLocadores.buscador) {
            actualizarTabla(interLocadores.buscador.getText(), interLocadores.cmbSeleccion.getSelectedIndex());
        }
    }

    private void añadirOyentesDeEvento() {
        interLocadores.btnBuscar.addActionListener(this);
        interLocadores.btnEliminar.addActionListener(this);
        interLocadores.btnAgregar.addActionListener(this);
        interLocadores.btnModificar.addActionListener(this);
        interLocadores.btnDetalles.addActionListener(this);
        interLocadores.btnActualizar.addActionListener(this);
        interLocadores.buscador.addKeyListener(this);
    }

    private void actualizarTabla() {
        limpiarTabla();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsMd;

        int cantidadColumnasEnResultSet;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT idLocador, Nombre, Telefono, Mail FROM locador ORDER BY Nombre");
                rs = ps.executeQuery();
                rsMd = rs.getMetaData();

                cantidadColumnasEnResultSet = rsMd.getColumnCount();

                while (rs.next()) {
                    Object[] campos = new Object[cantidadColumnasEnResultSet];
                    for (int i = 0; i < cantidadColumnasEnResultSet; i++) {
                        campos[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(campos);
                }
                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Buscar en la base de datos según una palabra y una columna
    private void actualizarTabla(String palabraClave, int seleccionCmbBuscar) {
        String buscarPor = seleccionCmbBuscar == 0 ? "Nombre" : "NroDocumento";
        String palabraClaveParaBuscar = "%" + palabraClave + "%";
        System.out.println(palabraClaveParaBuscar);
        
        limpiarTabla();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsMd;

        int cantidadColumnasEnResultSet;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT idLocador, Nombre, Telefono, Mail FROM locador WHERE " + buscarPor +" LIKE ? ORDER BY Nombre");
                ps.setString(1, palabraClaveParaBuscar);
                System.out.println(ps);
                rs = ps.executeQuery();
                rsMd = rs.getMetaData();

                cantidadColumnasEnResultSet = rsMd.getColumnCount();

                while (rs.next()) {
                    Object[] campos = new Object[cantidadColumnasEnResultSet];
                    for (int i = 0; i < cantidadColumnasEnResultSet; i++) {
                        campos[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(campos);
                }
                con.close();

            } catch (SQLException exSql1) {
                JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos:\n" + exSql1, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException exSql2) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + exSql2, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private void limpiarTabla() {

        int rowCount = interLocadores.jtLocadores.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    private void ajustarConfiguraciónTabla() {
        // No es necesario ajustar el tamaño de la columna idLocatarios porque no se ve
        // No quise sacarlo ahora por vago
        int[] anchos = {35, 90, 80, 150};
        interLocadores.jtLocadores.getColumnModel().getColumn(0).setMaxWidth(anchos[0]);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            interLocadores.jtLocadores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        interLocadores.jtLocadores.removeColumn(interLocadores.jtLocadores.getColumnModel().getColumn(0));
    }

    public InterLocadores getInterLocadores() {
        return interLocadores;
    }

    public void mostrarInterLocadores() {
        interLocadores.show();
    }

    public void ocultarInterLocadores() {
        interLocadores.hide();
    }

}
