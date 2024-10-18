package com.m0d.employeesystem.dao;

import com.m0d.employeesystem.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee getById(int id);

    Employee save(Employee employee);
    Employee update(Employee employee);

    void delete(int employeeId);
}
