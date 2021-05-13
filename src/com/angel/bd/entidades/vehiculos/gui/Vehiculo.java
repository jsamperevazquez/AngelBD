package com.angel.bd.entidades.vehiculos.gui;

import com.angel.bd.acceso.Conexion;
import com.angel.bd.negocio.ClienteBL;
import com.angel.bd.negocio.VehiculoBL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField fieldModelo;
    private JTextField fieldFecha;
    private JButton registrarVehiculoButton;

    public Vehiculo() {
        JFrame frame = new JFrame("Vehiculo");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 600);
        frame.setVisible(true);
        registrarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Conexion.conectar();
                VehiculoBL vehiculoBL = recuperarDatosForm();

                String strSentenciaInsert = String.format("insert into Vehiculo(marca,modelo,fecha_entrada) " +
                        "VALUES ('%s','%s','%s')", vehiculoBL.getMarca(), vehiculoBL.getModelo(), vehiculoBL.getFechaEntrada());
                Conexion.ejecutarSentenciaSQL(strSentenciaInsert);
            }
        });
    }

    public VehiculoBL recuperarDatosForm() {
        Conexion.conectar();
        VehiculoBL objetoVehiculo = new VehiculoBL();
        Integer id = (fieldId.getText().isEmpty()) ? 0 : Integer.parseInt(fieldId.getText());
        objetoVehiculo.setIdVehiculo(id);
        objetoVehiculo.setMarca(fieldMarca.getText());
        objetoVehiculo.setModelo(fieldModelo.getText());
        objetoVehiculo.setFechaEntrada(fieldFecha.getText());
        return objetoVehiculo;
    }
}
