package com.example.mamatha.student.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    private  String employeeName;
    private double salary;


    public String getEmployeeName(Employee getEmployeeName)
    {
        return getEmployeeName();
    }
}

