package com.JPA.JPA.repository;

import com.JPA.JPA.entity.Course;
import com.JPA.JPA.entity.Guardian;
import com.JPA.JPA.entity.Student;
import com.JPA.JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses:"+courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Sumon")
                .lastName("Reza")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(3)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Course course = Course.builder()
                .title("AI")
                .credit(3)
                .teacher(Teacher.builder()
                        .firstName("Sultana")
                        .lastName("JAhan")
                        .build())
                .build();

        Student student1 = Student.builder()
                .firstName("Avishek")
                .lastName("Roy")
                .email("roy24@gmail.com")
                .guardian(Guardian.builder()
                        .name("Rahul Roy")
                        .email("Rahul@gmail.com")
                        .mobile("14244819").build())
                .build();

        Student student2 = Student.builder()
                .firstName("Avi")
                .lastName("Roy")
                .email("roy@gmail.com")
                .guardian(Guardian.builder()
                        .name("Raj Roy")
                        .email("Raj@gmail.com")
                        .mobile("634244819").build())
                .build();

        course.addStudents(student1);
        course.addStudents(student2);

        courseRepository.save(course);

    }



//    @Test
//    public void findAllPagination() {
//        Pageable firstPageWithThreeRecords = (Pageable) PageRequest.of(0, 3);
//        Pageable secondPageWithTwoRecords = (Pageable) PageRequest.of(1, 2);
//
//        Page<Course> coursesPage1 = courseRepository.findAll(firstPageWithThreeRecords);
//        Page<Course> coursesPage2 = courseRepository.findAll(secondPageWithTwoRecords);
//
//        List<Course> coursesPage1Content = coursesPage1.getContent();
//        List<Course> coursesPage2Content = coursesPage2.getContent();
//
//        System.out.println("First Page Courses: " + coursesPage1Content);
//        System.out.println("Second Page Courses: " + coursesPage2Content);
//
//        // Optional: Print additional page information
//        System.out.println("Total Elements in Page 1: " + coursesPage1.getTotalElements());
//        System.out.println("Total Pages: " + coursesPage1.getTotalPages());
//        System.out.println("Number of Elements in Page 1: " + coursesPage1.getNumberOfElements());
//
//        System.out.println("Total Elements in Page 2: " + coursesPage2.getTotalElements());
//        System.out.println("Total Pages: " + coursesPage2.getTotalPages());
//        System.out.println("Number of Elements in Page 2: " + coursesPage2.getNumberOfElements());
//    }

}