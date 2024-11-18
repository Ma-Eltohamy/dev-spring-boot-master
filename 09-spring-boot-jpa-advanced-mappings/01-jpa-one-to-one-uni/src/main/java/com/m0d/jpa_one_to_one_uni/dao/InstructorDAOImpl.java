package com.m0d.jpa_one_to_one_uni.dao;

import com.m0d.jpa_one_to_one_uni.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDAOImpl implements InstructorDAO{

    EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl (EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int instructorId) {
        return entityManager.find(Instructor.class, instructorId);
    }


    @Transactional
    @Override
    public void delete(int instructorId) {
        Instructor tmpInstructor = entityManager.find(Instructor.class, instructorId);
        if(tmpInstructor == null)
            return;
        tmpInstructor.setInstructorDetail(null);
        entityManager.remove(tmpInstructor);
    }


}
