package pe.isil.base.dao;

import pe.isil.base.model.Course;
import pe.isil.base.model.Student;
import pe.isil.uti.DataBaseHelper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    
    public void create(Student student){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "INSERT INTO tbl_dae1_student(id, name, last_name, birth_date) VALUES (?,?,?,?)";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, student.getId());
                statement.setString(2, student.getName());
                statement.setString(3, student.getLastName());
                statement.setDate(4, Date.valueOf(student.getBirthDate()));
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Student student){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "UPDATE tbl_dae1_student SET name = ?, last_name = ?, birth_date = ? WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setString(1, student.getName());
                statement.setString(2, student.getLastName());
                statement.setDate(3, Date.valueOf(student.getBirthDate()));
                statement.setInt(4, student.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Student student){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "DELETE FROM tbl_dae1_student  WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, student.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_dae1_student";
            try (Statement statement = conn.createStatement()){
                ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String lastName = resultSet.getString("last_name");
                    LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
                    Student student = new Student(id, name, lastName, birthDate);
                    students.add(student);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getById(Integer id){
        Student student = null;
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_dae1_student WHERE id = ?";
            try ( PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int rsId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String lastName = resultSet.getString("last_name");
                    LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
                    student = new Student(rsId, name, lastName, birthDate);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

}
