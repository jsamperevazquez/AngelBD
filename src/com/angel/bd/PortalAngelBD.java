package com.angel.bd;

import com.angel.bd.entidades.Clientes.gui.Clientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creado por @autor: angel
 * El  13 de may. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public class PortalAngelBD {
    private JPanel panel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel2;
    private JLabel imagen;

    public PortalAngelBD() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Clientes cliente = new Clientes();
                cliente.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PortalAngelBD");
        frame.setContentPane(new PortalAngelBD().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(1200,600);
        frame.setVisible(true);

    }

    private void createUIComponents() {
        panel2 = new JPanel();

    }
}

