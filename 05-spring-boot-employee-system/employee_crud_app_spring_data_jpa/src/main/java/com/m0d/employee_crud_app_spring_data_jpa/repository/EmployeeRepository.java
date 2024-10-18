package com.m0d.employee_crud_app_spring_data_jpa.repository;

import com.m0d.employee_crud_app_spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
