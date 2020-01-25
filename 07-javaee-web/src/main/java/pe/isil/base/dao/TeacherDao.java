package pe.isil.base.dao;

import pe.isil.base.model.Teacher;
import pe.isil.uti.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    public void create(Teacher teacher){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "INSERT INTO tbl_dae1_teacher(id, name, last_name) VALUES (?,?,?)";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, teacher.getId());
                statement.setString(2, teacher.getName());
                statement.setString(3, teacher.getLastName());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Teacher teacher){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "UPDATE tbl_dae1_teacher SET name = ?, last_name = ? WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setString(1, teacher.getName());
                statement.setString(2, teacher.getLastName());
                statement.setInt(3, teacher.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Teacher teacher){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "DELETE FROM tbl_dae1_teacher  WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, teacher.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> getAll(){
        List<Teacher> cursos = new ArrayList<>();
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_dae1_teacher";
            try (Statement statement = conn.createStatement()){
                ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String lastName = resultSet.getString("last_name");
                    Teacher teacher = new Teacher(id, name, lastName);
                    cursos.add(teacher);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public Teacher getById(Integer id){
        Teacher teacher = null;
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_dae1_teacher WHERE id = ?";
            try ( PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int rsId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String lastName = resultSet.getString("last_name");
                    teacher = new Teacher(rsId, name, lastName);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return teacher;
    }


}
