package com.angel.bd.entidades.venta.gui;

import javax.swing.*;

/**
 * Creado por @autor: angel
 * El  13 de may. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public class Venta extends JFrame{
    private JPanel panel;
    private JTextField idVentaTF;
    private JTextField fechaVentaTF;
    private JTextField idClienteTF;
    private JTextField idVehiculoTF;
    private JPanel panel2;

    public Venta() {
        JFrame frame = new JFrame("Venta");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
