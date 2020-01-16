package pe.isil.dao;

import pe.isil.model.Libro;
import pe.isil.util.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void crear(Libro libro){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "INSERT INTO libros(isbn, titulo, categoria) VALUES (?,?,?)";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setString(1, libro.getIsbn());
                statement.setString(2, libro.getTitle());
                statement.setString(3, libro.getCategoria());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Libro> listar(){
        List<Libro> cursos = new ArrayList<>();
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM libros";
            try (Statement statement = conn.createStatement()){
                ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()){
                    String isbn = resultSet.getString("isbn");
                    String titulo = resultSet.getString("titulo");
                    String categoria = resultSet.getString("categoria");
                    Libro curso = new Libro(isbn, titulo, categoria);
                    cursos.add(curso);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursos;
    }

}
