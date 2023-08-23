package com.example.mamatha.student.Service;

import com.example.mamatha.student.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Student save(Student student);

    Optional<Student> getStudentById(Long id);

    List<String> getAllFirstNames();
}
