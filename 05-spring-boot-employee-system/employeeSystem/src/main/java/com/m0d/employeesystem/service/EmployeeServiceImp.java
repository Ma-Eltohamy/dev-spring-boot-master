package com.m0d.employeesystem.service;

import com.m0d.employeesystem.dao.EmployeeDAO;
import com.m0d.employeesystem.entity.Employee;
import com.m0d.employeesystem.exception.EmployeeInvalidDataException;
import com.m0d.employeesystem.exception.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    EmployeeDAO employeeDAO;

    @Autowired
    public void EmployeeService(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        if(employee.getFirstName() == null || employee.getLastName() == null || employee.getEmail() == null)
            throw new EmployeeInvalidDataException("Sorry, Invalid employee data.");
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Transactional
    @Override
    public String delete(int employeeId) {
        Employee tmpEmployee = getById(employeeId);

        if(tmpEmployee == null)
            throw new EmployeeNotFoundException("Employee id is not found - " + employeeId);
        employeeDAO.delete(employeeId);
        return "Deleted Employee id - " + employeeId;
    }
}
