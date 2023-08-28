package com.example.mamatha.student.Controller;

import com.example.mamatha.student.Entity.Employee;

import com.example.mamatha.student.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/employee")
@RestController
public class EmployeeController
{

   @Autowired
    public EmployeeService employeeService;
    @PostMapping("/add") //api/add
    public void addEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
     employeeService.save(employee);
    }
    @GetMapping("/getAll")
    public List<Employee> getAllEmployee() {
        System.out.println("request is coming");
        return employeeService.findAll();
    }

    @GetMapping("/get")
    public List<String> getAllEmployees(@RequestParam(value = "search") char letter)
    {
        List<String> employees = employeeService.findByFirstLetter(letter);
        return employees;
        //return employeeService.findAll();


    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployeeById(id);
    }
    @GetMapping()
    public Employee getEmployeeById( Long id ) {
        return employeeService.getEmployeeById(id);
    }


    @GetMapping("/getOnlyNames")
    public List<String> getOnlyNames()
    {
        List<Employee> employees = employeeService.findAll();
        List<String> employeeNames = new ArrayList<>();
        for(Employee employee:employees){
            employeeNames.add(employee.getEmployeeName());
        }
        return employeeNames;
    }
    @GetMapping("/getSalary")
    public List<String> getSalary(){
        List<Employee> employees=employeeService.findAll();
        List<String> employeeSalary=new ArrayList<>();
        for(Employee employee:employees){
            employeeSalary.add(String.valueOf(employee.getSalary()));
        }
        return employeeSalary;
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> updated = employeeService.updateEmployee(id, updatedEmployee);
        if (updated!= null) {
            return ResponseEntity.ok("data updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Employee>> fetchId(@PathVariable Long id){
//        Optional<Employee> fetchId=employeeService.fetchId(id);
//        if(fetchId!=null){
//            return ResponseEntity.ok(fetchId);
//        }
//        return ResponseEntity.notFound().build();
//    }



    @PatchMapping("/{id}/update-salary")
    public ResponseEntity<Object> updateEmployeeSalary(
            @PathVariable(name = "id") Long abcd,
            @RequestParam(name = "new-salary") double newSalary) {
        if (employeeService.checkById(abcd)) {
            Employee updatedSalary = employeeService.updateEmployeeSalary(abcd, newSalary);
            return ResponseEntity.ok(updatedSalary);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(abcd+" " +"id is not present in the database");
        }
    }
}
