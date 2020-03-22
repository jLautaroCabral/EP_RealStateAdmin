/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasInmueble;
import Modelo.ConsultasLocador;
import Vista.InterInmuebles;
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
public class CtrlInterInmuebles implements ActionListener, KeyListener {

    // Ventana y controladores
    InterInmuebles interInmuebles;
    CtrlDetallesInmueble ctrlDetallesInmuebles;
    CtrlAgMoInmueble ctrlAgregarInmueble;
    CtrlAgMoInmueble ctrlModificarInmueble;

    // Otro
    DefaultTableModel tableModel = new DefaultTableModel();

    public CtrlInterInmuebles() {
        // Preparar ventana
        interInmuebles = new InterInmuebles();
        interInmuebles.setTitle("Inmuebles");
        añadirOyentesDeEvento();

        // Preparar tabla
        interInmuebles.jtInmuebles.setModel(tableModel);
        tableModel.addColumn("idInmueble");
        tableModel.addColumn("Locador");
        tableModel.addColumn("Dirección");
        tableModel.addColumn("Piso - Depto");
        tableModel.addColumn("Barrio");
        ajustarConfiguraciónTabla();
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Al presionar BOTON ACTUALIZAR
        if (e.getSource() == interInmuebles.btnActualizar) {
            actualizarTabla();
        }
        
        // Al presionar BOTON BUSCAR
        if (e.getSource() == interInmuebles.btnBuscar) {
            actualizarTabla(interInmuebles.buscador.getText(), interInmuebles.cmbSeleccion.getSelectedIndex());
        }

        // Al presionar BOTON AGREGAR
        if (e.getSource() == interInmuebles.btnAgregar) {
            if (ctrlAgregarInmueble == null) {
                ctrlAgregarInmueble = new CtrlAgMoInmueble();
                ctrlAgregarInmueble.mostrarVentana();
            } else {
                ctrlAgregarInmueble.limpiarCampos();
                ctrlAgregarInmueble.mostrarVentana();
            }
        }

        // Al presionar BOTON DETALLES
        if (e.getSource() == interInmuebles.btnDetalles) {
            int filaSeleccionada = interInmuebles.jtInmuebles.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idInmuebleSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlDetallesInmuebles == null) {
                    ctrlDetallesInmuebles = new CtrlDetallesInmueble();
                    ctrlDetallesInmuebles.rellenarCamposSegunInmueble(idInmuebleSeleccionado);
                    ctrlDetallesInmuebles.mostrarVentana();
                } else {
                    ctrlDetallesInmuebles.rellenarCamposSegunInmueble(idInmuebleSeleccionado);
                    ctrlDetallesInmuebles.mostrarVentana();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Al presionar BOTON ELIMINAR (Seguridad de selección incluida)
        if (e.getSource() == interInmuebles.btnEliminar) {

            int filaSeleccionada = interInmuebles.jtInmuebles.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int a = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el inmueble?\n Al borrar el inmueble todos los registros que contengan este inmueble serán modificados", "Seguridad", JOptionPane.WARNING_MESSAGE);
                if (a == 0) {
                    int idInmuebleSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                    ConsultasInmueble.eliminarInmueble(idInmuebleSeleccionado);
                    actualizarTabla();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Al presionar BOTON MODIFICAR
        if (e.getSource() == interInmuebles.btnModificar) {

            int filaSeleccionada = interInmuebles.jtInmuebles.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idInmuebleSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlModificarInmueble == null) {
                    ctrlModificarInmueble = new CtrlAgMoInmueble(true);
                    ctrlModificarInmueble.rellenarCamposSegunInmueble(idInmuebleSeleccionado);
                    ctrlModificarInmueble.mostrarVentana();
                } else {
                    ctrlModificarInmueble.rellenarCamposSegunInmueble(idInmuebleSeleccionado);
                    ctrlModificarInmueble.mostrarVentana();
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
        actualizarTabla(interInmuebles.buscador.getText(), interInmuebles.cmbSeleccion.getSelectedIndex());
    }

    public InterInmuebles getInterInmuebles() {
        return interInmuebles;
    }

    public void mostrarInterInmuebles() {
        interInmuebles.show();
    }

    public void ocultarInterInmuebles() {
        interInmuebles.hide();
    }

    private void ajustarConfiguraciónTabla() {
        // No es necesario ajustar el tamaño de la columna idInmuebles porque no se ve
        // No quise sacarlo ahora por vago
        int[] anchos = {35, 80, 250, 90, 60, 60};
        interInmuebles.jtInmuebles.getColumnModel().getColumn(0).setMaxWidth(anchos[0]);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            interInmuebles.jtInmuebles.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        interInmuebles.jtInmuebles.removeColumn(interInmuebles.jtInmuebles.getColumnModel().getColumn(0));
    }

    private void añadirOyentesDeEvento() {
        interInmuebles.btnDetalles.addActionListener(this);
        interInmuebles.btnAgregar.addActionListener(this);
        interInmuebles.btnModificar.addActionListener(this);
        interInmuebles.btnEliminar.addActionListener(this);
        interInmuebles.btnActualizar.addActionListener(this);
        interInmuebles.buscador.addKeyListener(this);
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

                ps = con.prepareStatement("SELECT idInmueble, idLocador, Calle, PisoDepto, Barrio FROM inmueble ORDER BY Calle");
                rs = ps.executeQuery();
                rsMd = rs.getMetaData();

                cantidadColumnasEnResultSet = rsMd.getColumnCount();
                while (rs.next()) {
                    Object[] campos = new Object[cantidadColumnasEnResultSet];
                    for (int i = 0; i < cantidadColumnasEnResultSet; i++) {

                        if (i == 1) {
                            campos[i] = ConsultasLocador.getLocador(rs.getInt("idLocador")).getNombre();
                        } else {
                            campos[i] = rs.getObject(i + 1);
                        }

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

    private void actualizarTabla(String palabraClave, int seleccionCmbBuscar) {
        String buscarPor = seleccionCmbBuscar == 0 ? "Calle" : "Barrio";
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

                ps = con.prepareStatement("SELECT idInmueble, idLocador, Calle, PisoDepto, Barrio FROM inmueble WHERE " + buscarPor + " LIKE ?");
                ps.setString(1, palabraClaveParaBuscar);
                rs = ps.executeQuery();
                rsMd = rs.getMetaData();

                cantidadColumnasEnResultSet = rsMd.getColumnCount();
                while (rs.next()) {
                    Object[] campos = new Object[cantidadColumnasEnResultSet];
                    for (int i = 0; i < cantidadColumnasEnResultSet; i++) {

                        if (i == 1) {
                            campos[i] = ConsultasLocador.getLocador(rs.getInt("idLocador")).getNombre();
                        } else {
                            campos[i] = rs.getObject(i + 1);
                        }

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

        int rowCount = interInmuebles.jtInmuebles.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }
}
