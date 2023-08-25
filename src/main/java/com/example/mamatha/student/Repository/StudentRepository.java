package com.example.mamatha.student.Repository;

import com.example.mamatha.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
{
    void deleteById(Long id);
    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    List<Student> findByEmail(String email);


    @Query(value = "select id,first_name from student",nativeQuery = true)
    List<String> getFirstNames();
}


