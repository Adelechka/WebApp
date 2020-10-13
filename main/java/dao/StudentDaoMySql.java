package dao;

import dto.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoMySql implements StudentDao {

    private final MySqlConnection connection = new MySqlConnection();

    @Override
    public Student getStudentById(int id) {
        try (Connection conn = connection.getNewConnection()) {
            String sql = "SELECT id, firstName, lastName, course, createDateTime FROM test_user.students where id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setFirstName(resultSet.getString("firstName"));
                    student.setLastName(resultSet.getString("lastName"));
                    student.setCourse(resultSet.getInt("course"));
                    student.setCreateDateTime(resultSet.getTimestamp("createDateTime"));
                    return student;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveStudent(Student student) {
        try (Connection conn = connection.getNewConnection()) {
            String sql = "INSERT INTO test_user.students (firstName, lastName, course, password) values (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, student.getFirstName());
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setInt(3, student.getCourse());
                preparedStatement.setString(4, student.getPassword());

                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
