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
    public List<String> getAllStudents() {
        System.out.println("request is coming");
        return studentService.findAll();
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {

        return studentService.save(student);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findFirstName/{f}")
    public ResponseEntity<List<Student>> getStudentByFirstName(@PathVariable(value = "f") String firstName) {
        List<Student> studentFirstName = studentService.getStudentsByFirstName(firstName);
        if (studentFirstName != null) {
            return ResponseEntity.ok(studentFirstName);
        }
        return null;
    }

    @GetMapping("/findLastName/{lastName}")
    public ResponseEntity<List<Student>> getStudentByLastName(@PathVariable String lastName) {
        List<Student> studentLastName = studentService.getStudentsByLastName(lastName);
        if (studentLastName != null) {
            return ResponseEntity.ok(studentLastName);
        }
        return null;

    }
}
