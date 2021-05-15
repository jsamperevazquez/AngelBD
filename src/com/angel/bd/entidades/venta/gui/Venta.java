package com.angel.bd.entidades.venta.gui;

import com.angel.bd.acceso.Conexion;
import com.angel.bd.negocio.VentaBL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creado por @autor: angel
 * El  13 de may. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public class Venta extends JFrame {
    private JPanel panel;
    private JTextField idVentaTF;
    private JTextField fechaVentaTF;
    private JTextField idClienteTF;
    private JTextField idVehiculoTF;
    private JPanel panel2;
    private JButton registrarVentaButton;

    public Venta() {
        JFrame frame = new JFrame("Venta");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        registrarVentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                VentaBL ventaBL = recuperarDatosForm();
                String strSentenciaInsert = String.format("insert into venta(fecha_venta,id_cliente,id_vehiculo) " +
                        "VALUES ('%s','%s','%s')", ventaBL.getFechaVenta(), ventaBL.getId_cliente(), ventaBL.getId_vehiculo());
                Conexion.ejecutarSentenciaSQL(strSentenciaInsert);
            }
        });
    }

    public VentaBL recuperarDatosForm() {
        VentaBL venta = new VentaBL();
        Integer id = (idVentaTF.getText().isEmpty()) ? 0 : Integer.parseInt(idVentaTF.getText());
        venta.setId_venta(id);
        venta.setFechaVenta(fechaVentaTF.getText());
        venta.setId_cliente(Integer.parseInt(idClienteTF.getText()));
        venta.setId_vehiculo(Integer.parseInt(idVehiculoTF.getText()));
        return venta;
    }
}
