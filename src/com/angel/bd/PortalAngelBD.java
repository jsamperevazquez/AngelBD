package com.angel.bd;

import com.angel.bd.acceso.Conexion;
import com.angel.bd.entidades.Clientes.gui.Clientes;
import com.angel.bd.entidades.vehiculos.gui.Vehiculo;
import com.angel.bd.entidades.venta.gui.Venta;

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
    public JTextField infoBDArea;
    private JButton CERRARCONEXIONBDButton;



    public PortalAngelBD() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Conexion.conectar();
                if (Conexion.conectar()==true){
                    infoBDArea.setText("\t Conectado a BD");
                }
                Clientes cliente = new Clientes();
                cliente.setVisible(true);
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Conexion.conectar();
                if (Conexion.conectar()==true){
                    infoBDArea.setText("\t Conectado a BD");
                }
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Conexion.conectar();
                if (Conexion.conectar()==true){
                    infoBDArea.setText("\t Conectado a BD");
                }
                Venta venta=new Venta();
                venta.setVisible(true);
            }
        });
        CERRARCONEXIONBDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Conexion.cerrarConexion();
                infoBDArea.setText("\t Conexion cerrada");
            }
        });
    }

    public JTextField getInfoBDArea() {
        return infoBDArea;
    }

    public void setInfoBDArea(JTextField infoBDArea) {
        this.infoBDArea = infoBDArea;
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

