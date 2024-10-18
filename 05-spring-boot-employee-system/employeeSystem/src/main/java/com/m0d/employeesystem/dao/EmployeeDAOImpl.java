package com.m0d.employeesystem.dao;

import com.m0d.employeesystem.entity.Employee;
import com.m0d.employeesystem.exception.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return entityManager.find(Employee.class, employee.getId());
    }

    @Override
    public Employee update(Employee employee) {
        entityManager.merge(employee);
        return entityManager.find(Employee.class, employee.getId());
    }

    @Override
    public void delete(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
