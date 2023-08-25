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
    public List<String> findAll() {
        return studentRepository.getFirstNames();
    }
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student data = studentRepository.findById(id).orElse(null);
        if (data != null) {
            data.setFirstName(updatedStudent.getFirstName());
            data.setLastName(updatedStudent.getLastName());
            data.setEmail(updatedStudent.getEmail());
            return studentRepository.save(data);
        } else {
            return null;
        }
    }
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    @Override
    public List<Student> getStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public List<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

//



    @Override
    public void delete(Long id) {

    }

    public Optional<Student> deleteStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            studentRepository.delete(student); // Delete the student
        }

        return studentOptional;
    }






}


