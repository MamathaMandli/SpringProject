package com.example.mamatha.student.Service.Impl;

import com.example.mamatha.student.Entity.Student;
import com.example.mamatha.student.Repository.StudentRepository;
import com.example.mamatha.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();

    }



    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

//    @Override
//    public Student getStudentById(Long id) {
//        return null;
//    }

    //    @Override
//    public Student getStudentById(Long id) {
//        return studentRepository.findById(id);
//    }
    public List<String> getAllFirstNames() {
        return studentRepository.findAllFirstNames();
    }
}
