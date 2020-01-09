package pe.isil.dao;

import pe.isil.model.Curso;
import pe.isil.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void crear(Curso curso){
        try (Connection conn = DataBaseUtil.getConnection()) {
            final String SQL = "INSERT INTO tbl_cursos(curso_id, nombre, creditos, nombre_profesor) VALUES (?,?,?,?)";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, curso.getId());
                statement.setString(2, curso.getNombre());
                statement.setInt(3, curso.getCreditos());
                statement.setString(4, curso.getNombreProfesor());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificar(Curso curso){
        try (Connection conn = DataBaseUtil.getConnection()) {
            final String SQL = "UPDATE tbl_cursos SET nombre = ?, creditos = ?, nombre_profesor = ? WHERE curso_id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setString(1, curso.getNombre());
                statement.setInt(2, curso.getCreditos());
                statement.setString(3, curso.getNombreProfesor());
                statement.setInt(4, curso.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Curso curso){
        try (Connection conn = DataBaseUtil.getConnection()) {
            final String SQL = "DELETE FROM tbl_cursos  WHERE curso_id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, curso.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Curso> listar(){
        List<Curso> cursos = new ArrayList<>();
        try (Connection conn = DataBaseUtil.getConnection()) {
            final String SQL = "SELECT * FROM tbl_cursos";
            try (Statement statement = conn.createStatement()){
                ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()){
                    int curso_id = resultSet.getInt("curso_id");
                    String nombre = resultSet.getString("nombre");
                    int creditos = resultSet.getInt("creditos");
                    String nombre_profesor = resultSet.getString("nombre_profesor");
                    Curso curso = new Curso(curso_id, nombre, creditos, nombre_profesor);
                    cursos.add(curso);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public Curso listarPorId(Integer id){
        Curso curso = null;
        try (Connection conn = DataBaseUtil.getConnection()) {
            final String SQL = "SELECT * FROM tbl_cursos WHERE curso_id = ?";
            try ( PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int curso_id = resultSet.getInt("curso_id");
                    String nombre = resultSet.getString("nombre");
                    int creditos = resultSet.getInt("creditos");
                    String nombre_profesor = resultSet.getString("nombre_profesor");
                    curso = new Curso(curso_id, nombre, creditos, nombre_profesor);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return curso;
    }


}
