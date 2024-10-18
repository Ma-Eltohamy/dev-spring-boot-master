package com.m0d.employeesystem.service;

import com.m0d.employeesystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee getById(int id);

    Employee save(Employee employee);
    Employee update(Employee employee);

    String delete(int employeeId);
}
