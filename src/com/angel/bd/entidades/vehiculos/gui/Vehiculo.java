package com.angel.bd.entidades.vehiculos.gui;

import javax.swing.*;

/**
 * Creado por @autor: angel
 * El  12 de may. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public class Vehiculo extends JFrame {
    private JPanel panel;
    private JTextField fieldId;
    private JLabel id_vehiculo;
    private JTextField fieldMarca;
    private JTextField textField2;
    private JTextField textField3;
    private JButton registrarVehiculoButton;

    public Vehiculo() {
        JFrame frame = new JFrame("Vehiculo");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
