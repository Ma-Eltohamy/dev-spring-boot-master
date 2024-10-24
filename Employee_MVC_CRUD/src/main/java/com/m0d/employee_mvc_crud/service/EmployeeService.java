package com.m0d.employee_mvc_crud.service;

import com.m0d.employee_mvc_crud.repository.EmployeeRepository;
import com.m0d.employee_mvc_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    EmployeeRepository employeeDAO;

    @Autowired
    public EmployeeService(EmployeeRepository employeeDAO, EmployeeRepository employeeRepository){
        this.employeeDAO = employeeDAO;
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(Integer employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> findAllSortedByFirstName(){
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }



}
