package pe.isil.dao;

import pe.isil.model.Alumno;
import pe.isil.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlumnoDAO {

    public void crear(Alumno alumno){

        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
            final String sql = "INSERT INTO tbl_alumno (dni, ape_paterno, ape_materno, nombres, edad) " +
                    " values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getApePaterno());
            ps.setString(3, alumno.getApeMaterno());
            ps.setString(4, alumno.getNombres());
            ps.setInt(5, alumno.getEdad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void actualizar(Alumno alumno){
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
            final String sql = "UPDATE tbl_alumno SET nombres = ?, ape_paterno = ?, ape_materno= ?, edad = ? WHERE dni = ?  ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, alumno.getNombres());
            ps.setString(2, alumno.getApePaterno());
            ps.setString(3, alumno.getApeMaterno());
            ps.setInt(4, alumno.getEdad());
            ps.setString(5, alumno.getDni());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void eliminar(Alumno alumno){
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
            final String sql = "DELETE FROM tbl_alumno WHERE dni = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, alumno.getDni());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
