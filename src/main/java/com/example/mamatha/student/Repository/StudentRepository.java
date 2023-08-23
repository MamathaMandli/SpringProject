package com.example.mamatha.student.Repository;

import com.example.mamatha.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long>
{


    List<String> findAllFirstNames();
}
