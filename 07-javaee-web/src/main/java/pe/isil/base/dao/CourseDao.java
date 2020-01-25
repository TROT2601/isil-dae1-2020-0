package pe.isil.base.dao;

import pe.isil.base.model.Course;

import pe.isil.uti.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    public void create(Course course){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "INSERT INTO tbl_dae1_course(id, name, teacher_id) VALUES (?,?,?)";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, course.getId());
                statement.setString(2, course.getName());
                statement.setInt(3, course.getTeacherId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Course course){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "UPDATE tbl_dae1_course SET name = ?, teacher_id = ? WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setString(1, course.getName());
                statement.setInt(2, course.getTeacherId());
                statement.setInt(3, course.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Course course){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "DELETE FROM tbl_dae1_course  WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, course.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAll(){
        List<Course> cursos = new ArrayList<>();
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_dae1_course";
            try (Statement statement = conn.createStatement()){
                ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int teacherId = resultSet.getInt("teacher_id");
                    Course course = new Course(id, name, teacherId);
                    cursos.add(course);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public Course getById(Integer id){
        Course course = null;
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_dae1_course WHERE id = ?";
            try ( PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int rsId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int teacherId = resultSet.getInt("teacher_id");
                    course = new Course(id, name, teacherId);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }


}
