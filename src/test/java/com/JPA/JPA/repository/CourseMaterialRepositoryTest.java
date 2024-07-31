package com.JPA.JPA.repository;

import com.JPA.JPA.entity.Course;
import com.JPA.JPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("OS")
                .credit(3)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.gfg.com")
                //.course(course) this will not work as the optional = false
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial() {

        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Course Materials :" +courseMaterials);
    }

}