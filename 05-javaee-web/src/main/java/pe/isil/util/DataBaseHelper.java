package pe.isil.util;

import java.sql.*;

public class DataBaseHelper {

    private static final String URL = "jdbc:mysql://mysql02.c4utrkzk5zgf.us-west-1.rds.amazonaws.com:3306/isil_db";
    private static final String USER = "isil";
    private static final String PASSWORD = "isil";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

 /*   public int modificarRegistro(String consultaSQL){
        Connection conexion = null;
        Statement sentencia = null;
        int filasAfectadas = 0;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(consultaSQL);

        } catch (ClassNotFoundException e) {
            System.out.println("Error en la carga del driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error accediendo a la base de datos " + e.getMessage());
        }finally {
            if(sentencia != null){
                try{
                    sentencia.close();
                }catch (SQLException e){
                    System.out.println("e = " + e);
                }
            }
            if(conexion != null){
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("e = " + e);
                }
            }
        }

        return filasAfectadas;
    }

    public ResultSet seleccionarRegistros(String consultaSQL){

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet filas = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            sentencia = conexion.createStatement();
            filas = sentencia.executeQuery(consultaSQL);

        } catch (ClassNotFoundException e) {
            System.out.println("Error en la carga del driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error accediendo a la base de datos " + e.getMessage());
        }

        return filas;
    }*/

}
