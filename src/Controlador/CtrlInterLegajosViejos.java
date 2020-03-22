/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasLegajoViejo;
import Modelo.LegajoViejo;
import Vista.InterLegajosViejos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lauti
 */
public class CtrlInterLegajosViejos implements ActionListener, KeyListener {

    // Ventana y controladores
    InterLegajosViejos interLegajosViejos;
    CtrlDetallesLocatario ctrlDetallesLocatario = new CtrlDetallesLocatario();
    CtrlDetallesLocador ctrlDetallesLocador = new CtrlDetallesLocador();
    CtrlDetallesInmueble ctrlDetallesInmueble = new CtrlDetallesInmueble();
    CtrlDetallesLegajo ctrlDetallesLegajo = new CtrlDetallesLegajo();

    // Otro
    DefaultTableModel tableModel = new DefaultTableModel();

    public CtrlInterLegajosViejos() {

        // Preparar ventana
        interLegajosViejos = new InterLegajosViejos();
        interLegajosViejos.setTitle("Legajos viejos");
        añadirOyentesDeEvento();

        // Preparar tabla
        interLegajosViejos.jtLegajos.setModel(tableModel);
        tableModel.addColumn("idLegajoViejo");
        tableModel.addColumn("Locador");
        tableModel.addColumn("Inmueble");
        tableModel.addColumn("Piso - Depto");
        tableModel.addColumn("Locatario");
        ajustarConfiguraciónTabla();
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Al presionar BOTON BUSCAR
        if (e.getSource() == interLegajosViejos.btnBuscar) {
            actualizarTabla(interLegajosViejos.buscador.getText(), interLegajosViejos.cmbSeleccion.getSelectedIndex());
        }

        // Al preisonar BOTON ACTUALIZAR
        if (e.getSource() == interLegajosViejos.btnActualizar) {
            actualizarTabla();
        }

        // Al presionar BOTON DETALLES LEGAJO (Seguridad de selección incluida)
        if (e.getSource() == interLegajosViejos.btnVerInfoDelLegajo) {
            int filaSeleccionada = interLegajosViejos.jtLegajos.getSelectedRow();

            if (filaSeleccionada >= 0) {
                int idLegajoSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                LegajoViejo legajoViejo = ConsultasLegajoViejo.getLegajoViejo(idLegajoSeleccionado);
                ctrlDetallesLegajo.rellenarResumenSegunLegajoViejo(legajoViejo);
                ctrlDetallesLegajo.mostrarVentana();  
            } else {
                JOptionPane.showMessageDialog(null, "Asegurese de haber seleccionado una fila de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Al presionar BOTON ELIMINAR LEGAJO (Seguridad de selección incluida)
        if (e.getSource() == interLegajosViejos.btnEliminarLegajo) {

            int filaSeleccionada = interLegajosViejos.jtLegajos.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int a = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el legajo viejo?\n Al borrar el legajo viejo se borrará permanentemente", "Seguridad", JOptionPane.WARNING_MESSAGE);
                if (a == 0) {
                    int idLegajoSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);
                    ConsultasLegajoViejo.eliminarLegajoViejo(idLegajoSeleccionado);
                    actualizarTabla();
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
        actualizarTabla(interLegajosViejos.buscador.getText(), interLegajosViejos.cmbSeleccion.getSelectedIndex());
    }

    public InterLegajosViejos getInterLegajosViejos() {
        return interLegajosViejos;
    }

    public void mostrarInterLegajo() {
        interLegajosViejos.show();
    }

    public void ocultarInterLegajo() {
        interLegajosViejos.hide();
    }

    private void añadirOyentesDeEvento() {
        interLegajosViejos.btnBuscar.addActionListener(this);
        interLegajosViejos.btnEliminarLegajo.addActionListener(this);
        interLegajosViejos.btnActualizar.addActionListener(this);
        interLegajosViejos.btnVerInfoDelLegajo.addActionListener(this);
        
        interLegajosViejos.buscador.addKeyListener(this);
    }

    private void limpiarTabla() {
        int rowCount = interLegajosViejos.jtLegajos.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    private void ajustarConfiguraciónTabla() {
        // No es necesario ajustar el tamaño de la columna idLocatarios porque no se ve
        // No quise sacarlo ahora por vago
        int[] anchos = {35, 70, 210, 40,70};
        interLegajosViejos.jtLegajos.getColumnModel().getColumn(0).setMaxWidth(anchos[0]);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            interLegajosViejos.jtLegajos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        interLegajosViejos.jtLegajos.removeColumn(interLegajosViejos.jtLegajos.getColumnModel().getColumn(0));
    }
    

    private void actualizarTabla() {
        limpiarTabla();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = Conexion.getConnection();

            try {

                ps = con.prepareStatement("SELECT idLegajosViejos, LocadorNombre, InmCalle, InmPisoDepto, LocatarioNombre FROM legajosviejos ORDER BY LocadorNombre");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Object[] campos = new Object[6];

                    campos[0] = rs.getInt("idLegajosViejos");
                    campos[1] = rs.getString("LocadorNombre");
                    campos[2] = rs.getString("InmCalle");
                    campos[3] = rs.getString("InmPisoDepto");
                    campos[4] = rs.getString("LocatarioNombre");

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
        String palabraClaveParaBuscar = "%" + palabraClave + "%";
        
        limpiarTabla();

        Connection con;
        PreparedStatement ps;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();

            try {

                switch (seleccionCmbBuscar) {
                    case 0:
                        ps = con.prepareStatement("SELECT idLegajosViejos, LocadorNombre, InmCalle, InmPisoDepto, LocatarioNombre FROM legajosviejos WHERE LocadorNombre LIKE ? ORDER BY LocadorNombre");
                        ps.setString(1, palabraClaveParaBuscar);
                        rs = ps.executeQuery();
                        break;
                        
                    case 1:
                        ps = con.prepareStatement("SELECT idLegajosViejos, LocadorNombre, InmCalle, InmPisoDepto, LocatarioNombre FROM legajosviejos WHERE LocatarioNombre LIKE ? ORDER BY LocadorNombre");
                        ps.setString(1, palabraClaveParaBuscar);
                        rs = ps.executeQuery();
                        break;
                        
                    case 2:
                        ps = con.prepareStatement("SELECT idLegajosViejos, LocadorNombre, InmCalle, InmPisoDepto, LocatarioNombre FROM legajosviejos WHERE InmCalle LIKE ? ORDER BY LocadorNombre");
                        ps.setString(1, palabraClaveParaBuscar);
                        rs = ps.executeQuery();
                        break;
                        
                    default:     
                        ps = con.prepareStatement("SELECT idLegajo, Inmueble_idInmueble, Locatario_idLocatario, EstadoActual FROM legajo");
                        rs = ps.executeQuery();
                        break;
                }
                
                while (rs.next()) {
                    Object[] campos = new Object[6];

                    campos[0] = rs.getInt("idLegajosViejos");
                    campos[1] = rs.getString("LocadorNombre");
                    campos[2] = rs.getString("InmCalle");
                    campos[3] = rs.getString("InmPisoDepto");
                    campos[4] = rs.getString("LocatarioNombre");

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
