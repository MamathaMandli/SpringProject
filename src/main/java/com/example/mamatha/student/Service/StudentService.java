package com.example.mamatha.student.Service;

import com.example.mamatha.student.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<String> findAll();

    Student save(Student student);


    Optional<Student> getStudentById(Long id);

    Student updateStudent(Long id, Student updatedStudent);

    void delete(Long id);

    Optional<Student> deleteStudentById(Long id);


    List<Student> getStudentsByFirstName(String firstName);
    List<Student> getStudentsByLastName(String lastName);

    List<Student> getStudentByEmail(String email);





}
