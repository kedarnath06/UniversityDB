package com.JPA.JPA.repository;

import com.JPA.JPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Derived Query to find students by first name
    List<Student> findByFirstName(String firstName);

    // Derived Query to find students whose first name contains a given string
    List<Student> findByFirstNameContaining(String name);

    // Derived Query to find students whose last name is not null
    List<Student> findByLastNameNotNull();

    // Derived Query to find students by guardian's name
    List<Student> findByGuardianName(String guardianName);

    // JPQL Query to find a student by email
    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmail(String email);

    // Native SQL Query to find a student by email
    @Query(value = "SELECT * FROM tbl_student WHERE email_address = ?1", nativeQuery = true)
    Student getStudentByEmailNative(String email);

    // Native SQL Query with named parameter to find a student by email
    @Query(value = "SELECT * FROM tbl_student WHERE email_address = :email", nativeQuery = true)
    Student getStudentByEmailNativeParam(@Param("email") String email);

    @Modifying //Modifying queries can only use void or int/Integer as return type;
    @Transactional
    @Query(value = "update tbl_student set first_name=?1 where email_address=?2", nativeQuery = true)
    int updateStudentNameByEmail(String firstname, String email);
}
