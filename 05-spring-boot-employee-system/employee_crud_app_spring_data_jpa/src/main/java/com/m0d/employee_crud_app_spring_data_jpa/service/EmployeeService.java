package com.m0d.employee_crud_app_spring_data_jpa.service;

import com.m0d.employee_crud_app_spring_data_jpa.entity.Employee;
import com.m0d.employee_crud_app_spring_data_jpa.exception.EmployeeNotFoundException;
import com.m0d.employee_crud_app_spring_data_jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee getById(Integer employeeId){
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee tmpEmployee = null;

        if(!result.isPresent())
            throw new EmployeeNotFoundException("Invalid employee id - " + employeeId);

        tmpEmployee = result.get();
        tmpEmployee.validate();
        return tmpEmployee;
    }

    public Employee save(Employee employee){
        employee.validate();
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee){
        employee.validate();
        return employeeRepository.save(employee);
    }

    public void delete(int employeeId){
        Employee tmpEmployee = getById(employeeId);
        employeeRepository.deleteById(tmpEmployee.getId());
    }
}
