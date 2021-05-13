package com.angel.bd.acceso;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creado por @autor: angel
 * El  12 de may. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public  class Conexion {
    static String url = "angelDB.sqlite";
    static Connection conexion;

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Conexion.url = url;
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        Conexion.conexion = conexion;
    }

    public static void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (conexion != null) {
                System.out.println("Conexion establecida");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion" + " " + e.getErrorCode());

        }
    }

    public static void cerrarConexion() {
        try {
            conexion.close();

        }catch (SQLException e){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public static int ejecutarSentenciaSQL(String sentenciaSQL){


        try {
            PreparedStatement st= conexion.prepareStatement(sentenciaSQL);
            st.execute();
            return 1;


        }catch (SQLException e){
            System.out.println("Error en la ejecucion " + e);
            return 0;
        }

    }
    public static ResultSet consultarDatos(String sentenciaSQL){

        try {
            PreparedStatement st= conexion.prepareStatement(sentenciaSQL);
            ResultSet resultado=st.executeQuery();
            return resultado;

        }catch (SQLException e){
            System.out.println("Error en la consulta" + e);
            return null;
        }
    }
}
