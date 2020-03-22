/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasInmueble;
import Modelo.ConsultasLegajo;
import Modelo.ConsultasLocador;
import Modelo.ConsultasLocatario;
import Modelo.ConsultasRecibos;
import Modelo.Inmueble;
import Modelo.Legajo;
import Modelo.Locador;
import Modelo.Locatario;
import Modelo.ReciboLegajo;
import Vista.JfRecibosLegajo;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lauti
 */
public class CtrlRecibosLegajo implements ActionListener {

    // Ventana y controladores
    JfRecibosLegajo vRecibosLegajo;
    CtrlAgregarReciboLegajo ctrlAgregarReciboLegajo;
    CtrlDetallesReciboLegajo ctrlDetallesReciboLegajo;
    int idField;

    // Otro
    DefaultTableModel tableModel = new DefaultTableModel();

    public CtrlRecibosLegajo() {

        // Preparar ventana
        vRecibosLegajo = new JfRecibosLegajo();
        vRecibosLegajo.setTitle("Recibos");
        vRecibosLegajo.legajo.setText("AGREGAR LOCADOR");
        vRecibosLegajo.setLocationRelativeTo(null);
        añadirOyentesDeEvento();

        // Preparar tabla
        vRecibosLegajo.jtRecibos.setModel(tableModel);
        tableModel.addColumn("id");
        tableModel.addColumn("Fecha y hora");
        tableModel.addColumn("Monto");
        ajustarConfiguraciónTabla();
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Al presionar BOTON ACTUALIZAR
        if (e.getSource() == vRecibosLegajo.btnActualizar) {
            actualizarTabla();
        }

        // Al presionar BOTON VER RECIBO (Seguridad de selección incluida)
        if (e.getSource() == vRecibosLegajo.btnVerRecibo) {

            int filaSeleccionada = vRecibosLegajo.jtRecibos.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idReciboSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                if (ctrlDetallesReciboLegajo == null) {
                    ctrlDetallesReciboLegajo = new CtrlDetallesReciboLegajo();
                    ctrlDetallesReciboLegajo.rellenarCamposSegunRecibo(ConsultasRecibos.getRecibo(idReciboSeleccionado));
                    ctrlDetallesReciboLegajo.mostrarVentana();
                } else {
                    ctrlDetallesReciboLegajo.rellenarCamposSegunRecibo(ConsultasRecibos.getRecibo(idReciboSeleccionado));
                    ctrlDetallesReciboLegajo.mostrarVentana();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Al presionar BOTON NUEVO RECIBO
        if (e.getSource() == vRecibosLegajo.btnNuevoRecibo) {
            if (ctrlAgregarReciboLegajo == null) {
                ctrlAgregarReciboLegajo = new CtrlAgregarReciboLegajo();
                ctrlAgregarReciboLegajo.rellenarCamposSegunLegajo(crearNuevoReciboSegunLegajo(idField), idField);
                ctrlAgregarReciboLegajo.mostrarVentana();
            } else {
                ctrlAgregarReciboLegajo.rellenarCamposSegunLegajo(crearNuevoReciboSegunLegajo(idField), idField);
                ctrlAgregarReciboLegajo.mostrarVentana();
            }
        }
    }

    public void mostrarVentana() {
        vRecibosLegajo.setVisible(true);
    }

    private void limpiarTabla() {
        int rowCount = vRecibosLegajo.jtRecibos.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    public void rellenarSegunLegajo(int idLegajo) {
        idField = idLegajo;
        System.out.println(idLegajo);
        System.out.println(ConsultasLegajo.getLegajo(idLegajo).getLegajo());
        vRecibosLegajo.legajo.setText(ConsultasLegajo.getLegajo(idLegajo).getLegajo());
    }

    private void añadirOyentesDeEvento() {
        vRecibosLegajo.btnActualizar.addActionListener(this);
        vRecibosLegajo.btnNuevoRecibo.addActionListener(this);
        vRecibosLegajo.btnVerRecibo.addActionListener(this);
    }

    private ReciboLegajo crearNuevoReciboSegunLegajo(int idLegajo) {
        ReciboLegajo recibo = new ReciboLegajo();
        Legajo legajo = ConsultasLegajo.getLegajo(idLegajo);

        Inmueble inmueble = ConsultasInmueble.getInmueble(legajo.getIdInmueble());
        Locador locador = ConsultasLocador.getLocador(inmueble.getIdLocador());
        Locatario locatario = ConsultasLocatario.getLocatario(legajo.getIdLocatario());

        recibo.setNombreLocatario(locatario.getNombre());
        recibo.setTipoInmueble(inmueble.getTipo());
        recibo.setNombreLocador(locador.getNombre());
        recibo.setDniLocador(locador.getNroDocumento());
        recibo.setDireccionInmueble(inmueble.getCalle());
        recibo.setBarrioInmueble(inmueble.getBarrio());

        recibo.setFechaDelRecibo(new java.util.Date());

        return recibo;
    }

    private void ajustarConfiguraciónTabla() {
        // No es necesario ajustar el tamaño de la columna idLocatarios porque no se ve
        // No quise sacarlo ahora por vago
        int[] anchos = {35, 90, 90};
        vRecibosLegajo.jtRecibos.getColumnModel().getColumn(0).setMaxWidth(anchos[0]);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            vRecibosLegajo.jtRecibos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        vRecibosLegajo.jtRecibos.removeColumn(vRecibosLegajo.jtRecibos.getColumnModel().getColumn(0));
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

                ps = con.prepareStatement("SELECT idReciboLegajo, FechaRecibo, ImporteAbonado FROM recibolegajo");
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
}
