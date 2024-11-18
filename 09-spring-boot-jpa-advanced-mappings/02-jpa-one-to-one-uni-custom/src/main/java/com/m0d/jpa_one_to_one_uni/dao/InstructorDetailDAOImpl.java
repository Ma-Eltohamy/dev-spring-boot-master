package com.m0d.jpa_one_to_one_uni.dao;

import com.m0d.jpa_one_to_one_uni.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDetailDAOImpl implements InstructorDetailDAO {

    EntityManager entityManager;

    @Autowired
    public InstructorDetailDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void save(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
    }

    @Override
    public InstructorDetail findById(int instructorDetailId) {
        return entityManager.find(InstructorDetail.class, instructorDetailId);
    }

    @Transactional
    @Override
    public void delete(int instructorDetailId) {
        InstructorDetail tmpInstructorDetail = entityManager.find(InstructorDetail.class, instructorDetailId);

        tmpInstructorDetail.getInstructor().setInstructorDetail(null);

        if(tmpInstructorDetail == null)
            return;
        entityManager.remove(tmpInstructorDetail);
    }
}
