package com.example.mamatha.student.Service.Impl;

import com.example.mamatha.student.Entity.Employee;
import com.example.mamatha.student.Repository.EmployeeRepository;
import com.example.mamatha.student.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<String> findByFirstLetter(char letter) {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream()
                .filter(employee -> employee.getEmployeeName().toLowerCase().charAt(0) == Character.toLowerCase(letter))
                .map(Employee::getEmployeeName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id)
    {
        employeeRepository.deleteById(id);

    }

    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee employeeToUpdate = existingEmployee.get();
            employeeToUpdate.setEmployeeName(updatedEmployee.getEmployeeName());
            employeeToUpdate.setSalary(updatedEmployee.getSalary());

            return Optional.of(employeeRepository.save(employeeToUpdate));
        } else {
            return Optional.empty(); // Employee not found
        }
    }

    public Employee updateEmployeeSalary(Long id, double newSalary) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setSalary(newSalary);

            return employeeRepository.save(existingEmployee);
        } else {
              throw new NoSuchElementException("id is not present in the database");

        }
    }

    @Override
    public boolean checkById(Long abcd) {
        return employeeRepository.existsById(abcd);
    }


}

