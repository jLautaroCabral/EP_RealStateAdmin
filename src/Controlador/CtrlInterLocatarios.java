/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasLocatario;
import Vista.InterLocatarios;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CtrlInterLocatarios implements ActionListener, KeyListener{
    
    // Ventana y controladores
    InterLocatarios interLocatarios;
    CtrlAgMoLocatorio ctrlAgregarLocatorio;
    CtrlAgMoLocatorio ctrlModificarLocatorio;
    CtrlDetallesLocatario ctrlDetallesLocatario;
    
    // Otros
    DefaultTableModel tableModel = new DefaultTableModel();
    
    public CtrlInterLocatarios() {
        // Preparar ventana
        interLocatarios = new InterLocatarios();
        interLocatarios.setTitle("Locatarios");
        
        añadirOyentesDeEvento();
        
        // Preparar tabla
        interLocatarios.jtLocatoriarios.setModel(tableModel);
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
        if(e.getSource() == interLocatarios.btnActualizar) {
            actualizarTabla();
        }
        
        // Al presionar BOTON BUSCAR
        if(e.getSource() == interLocatarios.btnBuscar) {
            actualizarTabla(interLocatarios.buscador.getText(), interLocatarios.cmbSeleccion.getSelectedIndex());
        }
        
        // Al presionar BOTON AGREGAR
        if(e.getSource() == interLocatarios.btnAgregar) {
            if(ctrlAgregarLocatorio == null) {
                ctrlAgregarLocatorio = new CtrlAgMoLocatorio();
                ctrlAgregarLocatorio.mostrarVentana();
            } else {
                ctrlAgregarLocatorio.limpiarCampos();
                ctrlAgregarLocatorio.mostrarVentana();
            }
        }
        
        // Al presionar BOTON ELIMINAR
        if(e.getSource() == interLocatarios.btnEliminar) {
            int filaSeleccionada = interLocatarios.jtLocatoriarios.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int a = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el locatario?\n Al borrar el locatario todos los registros que contengan este locador serán modificados", "Seguridad", JOptionPane.WARNING_MESSAGE);
                if (a == 0) {
                    int idLocatarioSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                    ConsultasLocatario.eliminarLocatario(idLocatarioSeleccionado);
                    actualizarTabla();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Al presionar BOTON MODIFICAR
        if(e.getSource() == interLocatarios.btnModificar) {
            
            int filaSeleccionada = interLocatarios.jtLocatoriarios.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idLocadorSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlModificarLocatorio == null) {
                    ctrlModificarLocatorio = new CtrlAgMoLocatorio(true);
                    ctrlModificarLocatorio.rellenarCamposSegunLocatario(idLocadorSeleccionado);
                    ctrlModificarLocatorio.mostrarVentana();
                } else {
                    ctrlModificarLocatorio.rellenarCamposSegunLocatario(idLocadorSeleccionado);
                    ctrlModificarLocatorio.mostrarVentana();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        
        // Al presionar BOTON VER DETALLES
        if (e.getSource() == interLocatarios.btnDetalles) {
            int filaSeleccionada = interLocatarios.jtLocatoriarios.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idLocadorSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlDetallesLocatario == null) {
                    ctrlDetallesLocatario = new CtrlDetallesLocatario();
                    ctrlDetallesLocatario.rellenarCamposSegunLocatario(idLocadorSeleccionado);
                    ctrlDetallesLocatario.mostrarVentana();
                } else {
                    ctrlDetallesLocatario.rellenarCamposSegunLocatario(idLocadorSeleccionado);
                    ctrlDetallesLocatario.mostrarVentana();
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
        actualizarTabla(interLocatarios.buscador.getText(), interLocatarios.cmbSeleccion.getSelectedIndex());
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

                ps = con.prepareStatement("SELECT idLocatario, Nombre, Telefono, Mail FROM locatario ORDER BY Nombre");
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

                ps = con.prepareStatement("SELECT idLocatario, Nombre, Telefono, Mail FROM locatario WHERE " + buscarPor +" LIKE ? ORDER BY Nombre");
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
    
    private void ajustarConfiguraciónTabla() {
        // No es necesario ajustar el tamaño de la columna idLocatarios porque no se ve
        // No quise sacarlo ahora por vago
        int[] anchos = {35, 90, 80, 120, 250};
        interLocatarios.jtLocatoriarios.getColumnModel().getColumn(0).setMaxWidth(anchos[0]);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            interLocatarios.jtLocatoriarios.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        interLocatarios.jtLocatoriarios.removeColumn(interLocatarios.jtLocatoriarios.getColumnModel().getColumn(0));
    }
    
    private void añadirOyentesDeEvento() {
        interLocatarios.btnActualizar.addActionListener(this);
        interLocatarios.btnEliminar.addActionListener(this);
        interLocatarios.btnAgregar.addActionListener(this);
        interLocatarios.btnModificar.addActionListener(this);
        interLocatarios.btnDetalles.addActionListener(this);
        interLocatarios.btnBuscar.addActionListener(this);
        interLocatarios.buscador.addKeyListener(this);
    }
    
    private void limpiarTabla() {

        int rowCount = interLocatarios.jtLocatoriarios.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }
    
    public InterLocatarios getInterLocatario() {
        return interLocatarios;
    }
    
    public void mostrarInterLocatarios() {
        interLocatarios.show();
    }
    
    public void ocultarInterLocatarios() {
        interLocatarios.hide();
    }
}
