package com.angel.bd.negocio;

/**
 * Creado por @autor: angel
 * El  13 de may. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public class VentaBL {
    Integer id_venta;
    String fechaVenta;
    Integer id_cliente;
    Integer id_vehiculo;

    public VentaBL() {
    }

    public VentaBL(Integer id_venta, String fechaVenta, Integer id_cliente, Integer id_vehiculo) {
        this.id_venta = id_venta;
        this.fechaVenta = fechaVenta;
        this.id_cliente = id_cliente;
        this.id_vehiculo = id_vehiculo;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Integer id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }
}
