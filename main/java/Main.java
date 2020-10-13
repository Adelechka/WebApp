import service.StudentService;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        /* first lesson */
        /*
        StudentDao studentDao = new StudentDaoMySql();

        Student student = new Student();
        student.setFirstName("Nastya");
        student.setLastName(null);
        student.setCourse(2);

        System.out.println(studentDao.saveStudent(student));
        Student student1 = studentDao.getStudentById(1);
        System.out.println(student1.toString());
        */

        StudentService studentService = new StudentService();
        /* дальше должно быть в срвелете */
        studentService.enrollStudent("Valeria", "Stasevich", "qaz123456");


    }
}
