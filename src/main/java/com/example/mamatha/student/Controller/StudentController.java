package com.example.mamatha.student.Controller;

import com.example.mamatha.student.Entity.Student;
import com.example.mamatha.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        System.out.println("request is coming");
        return studentService.findAll();
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
     return  studentService.save(student);
    }
    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<Optional<Student>>> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(Optional.of(student));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/first-names")
    public List<String> getAllFirstNames() {
        return studentService.getAllFirstNames();
    }


}

