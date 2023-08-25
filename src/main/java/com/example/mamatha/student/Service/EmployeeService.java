package com.example.mamatha.student.Service;

import com.example.mamatha.student.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    void  save(Employee employee);

  // List<Employee> findAll();




    List<String> findByFirstLetter(char letter);

    List<Employee> findAll();

    void deleteEmployeeById(Long id);

    Optional<Employee> updateEmployee(Long id, Employee updatedStudent);


    Employee updateEmployeeSalary(Long id, double salary);

    boolean checkById(Long abcd);
}
