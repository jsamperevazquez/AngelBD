package com.angel.bd.entidades.Clientes.gui;

import com.angel.bd.negocio.ClienteBL;
import com.angel.bd.acceso.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

/**
 * Creado por @autor: angel
 * El  12 de may. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public class Clientes extends JFrame {
    private JPanel panel;
    private JTextField nombreCliente;
    private JTextField apellidoCliente;
    private JTextField emailCliente;
    private JTextField telefonoCliente;
    private JButton insertarCliButton;
    private JButton modificarCliButton;
    private JButton eliminarCliButton;
    private JTable tableClientes;
    private JButton consultarCliente;
    private JTextField idCliente;
    private JPanel panel2;
    private DefaultTableModel modelo;
    private static String[] titulosColumnas = {"Id", "Nombre", "Apellido", "Email", "Telefono"};

    public Clientes() {
        JFrame frame = new JFrame("Clientes");
         frame.setContentPane(panel);
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setSize(900,900);
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
        mostrarDatos();
        consultarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer idPeticion = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el ID del cliente"));
                try {
                    ResultSet resultado = Conexion.consultarDatos("SELECT * FROM clientes where id_clientes=" + idPeticion);
                    while (resultado.next()) {
                        if (idPeticion.toString().equals(resultado.getString("id_clientes"))) {
                            JOptionPane.showMessageDialog(null, resultado.getString("nombre_cliente"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error en la consulta" + e);

                }
            }
        });
        insertarCliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ClienteBL clienteBL = recuperarDatosForm();
                String strSentenciaInsert = String.format("insert into Clientes(nombre_cliente,apellido_cliente,email_cliente,telefono_cliente) " +
                        "VALUES ('%s','%s','%s','%s')", clienteBL.getNombre(), clienteBL.getApellido(), clienteBL.getEmail(), clienteBL.getTelefono());
                Conexion.ejecutarSentenciaSQL(strSentenciaInsert);
                mostrarDatos();
                idCliente.setText("");
                nombreCliente.setText("");
                apellidoCliente.setText("");
                emailCliente.setText("");
                telefonoCliente.setText("");

            }
        });
        tableClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    if (mouseEvent.getClickCount() == 1) {
                        JTable receptor = (JTable) mouseEvent.getSource();
                        idCliente.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
                        nombreCliente.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
                        apellidoCliente.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
                        emailCliente.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
                        telefonoCliente.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }

            }
        });
        eliminarCliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ClienteBL clienteBL = recuperarDatosForm();
                String strSentenciaInsert = String.format("DELETE FROM Clientes WHERE id_clientes = %d ", clienteBL.getId_cliente());
                Conexion.ejecutarSentenciaSQL(strSentenciaInsert);
                mostrarDatos();
            }
        });
        modificarCliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ClienteBL clienteBL = recuperarDatosForm();
                String strSentenciaInsert = String.format("UPDATE  Clientes SET nombre_cliente='%s', " +
                        "apellido_cliente='%s'," + "email_cliente='%s'," + "telefono_cliente='%s' WHERE id_clientes=%d", clienteBL.getNombre(), clienteBL.getApellido(), clienteBL.getEmail(), clienteBL.getTelefono(), clienteBL.getId_cliente());
                Conexion.ejecutarSentenciaSQL(strSentenciaInsert);
                idCliente.setText("");
                nombreCliente.setText("");
                apellidoCliente.setText("");
                emailCliente.setText("");
                telefonoCliente.setText("");
                mostrarDatos();
            }
        });
    }

    public void mostrarDatos() {
        while (modelo.getRowCount() > 1) {
            modelo.removeRow(1);
        }

        try {
            ResultSet resultado = Conexion.consultarDatos("SELECT * FROM clientes");
            while (resultado.next()) {

                Object[] oCliente = {resultado.getString("id_clientes"), resultado.getString("nombre_cliente"), resultado.getString("apellido_cliente"), resultado.getString("email_cliente"), resultado.getString("telefono_cliente")};
                modelo.addRow(oCliente);
            }

        } catch (Exception e) {
            System.out.println("Error en la consulta" + e);

        }
    }


    public ClienteBL recuperarDatosForm() {
        ClienteBL objetoCliente = new ClienteBL();
        Integer id = (idCliente.getText().isEmpty()) ? 0 : Integer.parseInt(idCliente.getText());
        objetoCliente.setId_cliente(id);
        objetoCliente.setNombre(nombreCliente.getText());
        objetoCliente.setApellido(apellidoCliente.getText());
        objetoCliente.setEmail(emailCliente.getText());
        objetoCliente.setTelefono(telefonoCliente.getText());


        return objetoCliente;
    }

    private void createUIComponents() {
        JScrollPane scrollPane = new JScrollPane();
        tableClientes = new JTable();
        modelo = new DefaultTableModel();

        modelo.addColumn("columnaId");
        modelo.addColumn("columnaNombre");
        modelo.addColumn("columnaApellido");
        modelo.addColumn("columnaEmail");
        modelo.addColumn("columnaTelefono");
        modelo.addRow(new Object[]{"Id", "Nombre", "Apellido", "Email", "Telefono"});


        tableClientes.setModel(modelo);
        scrollPane.setViewportView(tableClientes);
        scrollPane.setBounds(20,20,200,100);
        getContentPane().add(scrollPane);
        tableClientes.setDefaultRenderer(Object.class, new MiRenderer());

    }

    class MiRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int row,
                                                       int column) {
            String nombreCelda = (String) table.getValueAt(row, 0); // Casteo a String y obtengo valores de la tabla para poder comparar
            if (nombreCelda.equalsIgnoreCase("id")) {
                setBackground(Color.LIGHT_GRAY);
                setForeground(Color.BLACK);
                setHorizontalAlignment(SwingConstants.CENTER); // A las siguientes filas las pongo en blanco
            } else {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
                setHorizontalAlignment(SwingConstants.CENTER);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}

