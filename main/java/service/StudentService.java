package service;

import dao.StudentDao;
import dao.StudentDaoMySql;
import dto.Student;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final String SALT = "qaz123456";
    private StudentDao studentDao = new StudentDaoMySql();

    public List<String> enrollStudent(String firstName, String lastName, String password) {
        List<String> errors = new ArrayList<>();

        if (firstName == null) {
            errors.add("firstName is empty");
        }
        if (lastName == null) {
            errors.add("lastName is empty");
        }
        if (password == null) {
            errors.add("password is empty");
        }
        if (!errors.isEmpty()) {
            return errors;
        }

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        String pass = generateSecurePassword(password);
        student.setPassword(pass);


        studentDao.saveStudent(student);
        return null;
    }

    private String generateSecurePassword(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(SALT.getBytes());
            byte[] newValue = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
            return java.util.Base64.getEncoder().encodeToString(newValue);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }
}
