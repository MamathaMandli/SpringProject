package com.example.mamatha.student.Repository;

import com.example.mamatha.student.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long >
{
   @Query(value = "SELECT * FROM employee WHERE id=14",nativeQuery = true)
 // @Query (value = "select e from Employee e where e.id=15")

 // @Query(value = "select e from Employee e order by e.id desc limit 1")
  // @Query(value ="select * from employee order by id desc limit 1",nativeQuery = true)
    Employee findEmployeeById(Long id);

}
