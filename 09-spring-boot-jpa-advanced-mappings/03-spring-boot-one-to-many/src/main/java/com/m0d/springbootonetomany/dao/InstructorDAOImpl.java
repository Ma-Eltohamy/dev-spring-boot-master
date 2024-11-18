package com.m0d.springbootonetomany.dao;

import com.m0d.springbootonetomany.entity.Course;
import com.m0d.springbootonetomany.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

    EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    /*
    *
    * NOTE:
    *   At industry you won't write 2 methods getAllLAZY & getAllEAGER you will just write one --> (getAll)
    *   and spring will look for the fetching type (Eager || Lazy)
    *
     */
    @Transactional
    @Override
    public List<Instructor> getAllLAZY() {
        // lazy because we didn't get the courses info yet
        TypedQuery<Instructor> query = entityManager.createQuery("from Instructor", Instructor.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Instructor> getAllEager() {
        TypedQuery<Instructor> query = entityManager.createQuery("from Instructor", Instructor.class);
        return query.getResultList();
    }

//    @Override
//    public Instructor getByIdJoinFETCH(int id) {
//        TypedQuery<Instructor> query = entityManager.createQuery(
//                "SELECT i FROM Instructor i JOIN FETCH i.courseList c WHERE c.instructor.id = :instructorId", Instructor.class);
//
//        query.setParameter("instructorId", id);
//        Instructor tmpInstructor = query.getSingleResult();
//        return tmpInstructor;
//    }
    @Override
    public Instructor getByIdJoinFETCH(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                        "JOIN FETCH i.courseList " +
                        "WHERE i.id = :instructorId", Instructor.class);

        query.setParameter("instructorId", id);
        return query.getSingleResult();
    }


    @Transactional
    @Override
    public Instructor findById(int instructorId) {
        return entityManager.find(Instructor.class, instructorId);
    }

    @Transactional
    @Override
    public void deleteById(int instructorId) {
        Instructor tmpInstructor = entityManager.find(Instructor.class, instructorId);

        if(tmpInstructor == null) // it should throw an exception if not found
            return;

        List<Course> courseList = tmpInstructor.getCourseList();

        for(Course course : courseList)
            course.setInstructor(null);

        entityManager.remove(tmpInstructor);
    }

    @Transactional
    @Override
    public void deleteCourseById(int courseId) {
        Course tmpCourse = findCourseByIdLAZY(courseId);

        if(tmpCourse == null) // it should throw an exception
            return;

        entityManager.remove(tmpCourse);
    }

    @Transactional
    @Override
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseByIdEAGER(int courseId) {
        return entityManager.find(Course.class, courseId);
    }

    @Override
    public Course findCourseByIdLAZY(int courseId) {
        return entityManager.find(Course.class, courseId);
    }

    @Transactional
    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }


}
