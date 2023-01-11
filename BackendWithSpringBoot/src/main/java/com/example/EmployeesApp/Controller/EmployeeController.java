package com.example.EmployeesApp.Controller;

import com.example.EmployeesApp.Model.Employee;
import com.example.EmployeesApp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employee/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("employee/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        Employee emp = employeeService.findEmployeeById(id);

        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping("employee/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping("employee/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("employee/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        Employee emp =employeeService.deleteEmployee(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
