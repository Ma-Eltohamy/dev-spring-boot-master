package com.m0d.employee_system_spring_data_rest.dao;

import com.m0d.employee_system_spring_data_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
