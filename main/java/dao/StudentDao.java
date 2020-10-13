package dao;

import dto.Student;

public interface StudentDao {
    Student getStudentById(int id);
    boolean saveStudent(Student student);
}
