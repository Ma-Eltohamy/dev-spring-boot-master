package com.mahmoud.cruddemostudent.Repository;

import com.mahmoud.cruddemostudent.DAO.StudentDAO;
import com.mahmoud.cruddemostudent.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id){
        // with find, you will have to use an identifier
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where firstName=:theData", Student.class);
        theQuery.setParameter("theData", firstName);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> listAll() {
        TypedQuery<Student> studentsList = entityManager.createQuery("from Student", Student.class);
        return studentsList.getResultList();
    }

    @Transactional
    @Override
    public void updateById(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void updateAllLastName(String newLastName){
        Query theQuery = entityManager.createQuery("update Student set lastName=:theData");
        theQuery.setParameter("theData", newLastName);
        theQuery.executeUpdate();
    }

    @Transactional
    @Override
    public void deleteById(Student student){
        Student managedStudent = entityManager.find(Student.class, student.getId());
        if (managedStudent != null)
            entityManager.remove(managedStudent);
    }

    @Transactional
    @Override
    public Integer deleteAll(){
        return entityManager.createQuery("delete Student").executeUpdate();
    }
}
