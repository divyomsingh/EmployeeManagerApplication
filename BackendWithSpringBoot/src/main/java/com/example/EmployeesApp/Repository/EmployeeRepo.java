package com.example.EmployeesApp.Repository;

import com.example.EmployeesApp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {


}
