package pe.isil.base.dao;

import pe.isil.base.model.Enrollment;
import pe.isil.uti.DataBaseHelper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDao {

    public void create(Enrollment enrollment){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "INSERT INTO tbl_dae1_enrollment(id, course_id, student_id, created_date, credit) VALUES (?,?,?,?,?)";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, enrollment.getId());
                statement.setInt(2, enrollment.getCourseId());
                statement.setInt(3, enrollment.getStudentId());
                statement.setDate(4, Date.valueOf(enrollment.getCreatedDate()));
                statement.setInt(5, enrollment.getCredit());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Enrollment enrollment){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "UPDATE tbl_dae1_enrollment SET course_id = ?, student_id = ?, created_date = ?, credit = ? WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, enrollment.getCourseId());
                statement.setInt(2, enrollment.getStudentId());
                statement.setDate(3, Date.valueOf(enrollment.getCreatedDate()));
                statement.setInt(4, enrollment.getCredit());
                statement.setInt(5, enrollment.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Enrollment enrollment){
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "DELETE FROM tbl_dae1_enrollment  WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, enrollment.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Enrollment> getAll(){
        List<Enrollment> enrollments = new ArrayList<>();
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_dae1_enrollment";
            try (Statement statement = conn.createStatement()){
                ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int studentId = resultSet.getInt("student_id");
                    int courseId = resultSet.getInt("course_id");
                    LocalDate createdDate = resultSet.getDate("created_date").toLocalDate();
                    int credit = resultSet.getInt("credit");
                    Enrollment enrollment = new Enrollment(id, studentId, courseId, createdDate, credit);
                    enrollments.add(enrollment);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return enrollments;
    }

    public Enrollment getById(Integer id){
        Enrollment enrollment = null;
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_dae1_enrollment WHERE id = ?";
            try ( PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int rsId = resultSet.getInt("id");
                    int studentId = resultSet.getInt("student_id");
                    int courseId = resultSet.getInt("course_id");
                    LocalDate createdDate = resultSet.getDate("created_date").toLocalDate();
                    int credit = resultSet.getInt("credit");
                    enrollment = new Enrollment(rsId, studentId, courseId, createdDate, credit);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return enrollment;
    }



}
