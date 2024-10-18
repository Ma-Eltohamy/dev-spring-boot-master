package com.m0d.employeesystem.rest;

import com.m0d.employeesystem.EmployeeSystemApplication;
import com.m0d.employeesystem.dao.EmployeeDAO;
import com.m0d.employeesystem.entity.Employee;
import com.m0d.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeService employeeService;

    // quick and dirty employeeDAO injection using contractor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return employeeService.getById(employeeId);
    }

    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){
        return employeeService.delete(employeeId);
    }
}
