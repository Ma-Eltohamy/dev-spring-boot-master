package com.m0d.springbootonetomanyuni.dao;

import com.m0d.springbootonetomanyuni.entity.Course;
import com.m0d.springbootonetomanyuni.entity.Instructor;
import com.m0d.springbootonetomanyuni.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDAOImpl  implements InstructorDAO{

    EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void saveInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int instructorId) {
        return entityManager.find(Instructor.class, instructorId);
    }

    @Transactional
    @Override
    // It wouldn't Fetch JOIN so it's lazy fetching
    public List<Instructor> findAllInstructors() {
        TypedQuery<Instructor> query = entityManager.createQuery("from Instructor", Instructor.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Transactional
    @Override
    public void deleteInstructorById(int instructorId) {
        Instructor tmpInstructor = entityManager.find(Instructor.class, instructorId);

        if(tmpInstructor == null)
            return;

        entityManager.remove(tmpInstructor);
    }

    @Override
    public Course findCourseById(int courseId) {
        return entityManager.find(Course.class, courseId);
    }

    @Override
    public Course fetchCourseWithReviews(int courseId) {
        String jpql = "SELECT c FROM Course c LEFT JOIN FETCH c.reviewList WHERE c.id = :courseId";
        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
        query.setParameter("courseId", courseId);

        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Transactional
    @Override
    public void deleteCourseById(int courseId) {
        Course tmpCourse = entityManager.find(Course.class, courseId);

        if(tmpCourse == null)
            return;

        entityManager.remove(tmpCourse);
    }

    @Override
    public void addReview(int courseId) {

    }

    @Override
    public Review findReviewById(int reviewId) {
        return entityManager.find(Review.class, reviewId);
    }

    @Transactional
    @Override
    public void updateReview(Review review) {
        entityManager.merge(review);
    }

    @Transactional
    @Override
    public void deleteReviewById(int reviewId) {
        Review tmpReview = entityManager.find(Review.class, reviewId);

        if(tmpReview == null)
            return;

        entityManager.remove(tmpReview);
    }
}
