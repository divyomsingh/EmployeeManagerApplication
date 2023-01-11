package com.example.EmployeesApp.Service;

import com.example.EmployeesApp.Exception.UserNotFoundException;
import com.example.EmployeesApp.Model.Employee;
import com.example.EmployeesApp.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        Employee emp = null;
        try {
            emp =  employeeRepo.findById(id).orElseThrow(()->new UserNotFoundException("Employee with id : + " + id + " is not found!"));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public Employee deleteEmployee(Long id){
        Employee emp = null;
        try {
            emp =  employeeRepo.findById(id).orElseThrow(()->new UserNotFoundException("Employee with id : + " + id + " is not found!"));
            employeeRepo.delete(emp);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return emp;
    }


}
