package com.m0d.employee_mvc_crud.repository;

import com.m0d.employee_mvc_crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderByFirstNameAsc();
}
