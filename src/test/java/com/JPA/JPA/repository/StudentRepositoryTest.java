package com.JPA.JPA.repository;

import com.JPA.JPA.entity.Guardian;
import com.JPA.JPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Raghu")
                .email("raghu@gmail.com")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Kedar")
                .lastName("Nath")
                .email("kedar06@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Kedar");
        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Ke");
        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Raghu");
        System.out.println("Students : " + students);
    }

    @Test
    public void printGetStudentByEmail() {
        Student student = studentRepository.getStudentByEmail("Kedar06@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void printGetStudentByEmailNative() {
        Student student = studentRepository.getStudentByEmailNative("kedar06@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void printGetStudentByEmailNativeParam() {
        Student student = studentRepository.getStudentByEmailNativeParam("kedar06@gmail.com");
        System.out.println("Student : " + student);
    }

//    @Test
//    public void getupdateStudentNameByEmail(String firstname, String email) {
//        studentRepository.updateStudentNameByEmail("Anuj", "shabbir@gmail.com");
//    }
//Gives ParameterResolutionnException . 2 probabale solution

    @ParameterizedTest
    @CsvSource({
            "Anuj, shabbir@gmail.com",
            "Ravi, kedar06@gmail.com"
    })
    public void getupdateStudentNameByEmail(String firstname, String email) {
        studentRepository.updateStudentNameByEmail(firstname, email);
        Student updatedStudent = studentRepository.getStudentByEmail(email);
        assert updatedStudent.getFirstName().equals(firstname);
        System.out.println("Updated Student : " + updatedStudent);
    }

//    Another
//    @Test
//    public void getupdateStudentNameByEmail() {
//        String firstname = "Amit";
//        String email = "shabbir@gmail.com";
//
//        studentRepository.updateStudentNameByEmail(firstname, email);
//        Student updatedStudent = studentRepository.getStudentByEmail(email);
//        assert updatedStudent.getFirstName().equals(firstname);
//        System.out.println("Updated Student : " + updatedStudent);
//    }



}
