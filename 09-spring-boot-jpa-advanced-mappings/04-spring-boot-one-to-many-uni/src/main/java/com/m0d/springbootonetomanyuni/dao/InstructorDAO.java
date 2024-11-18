package com.m0d.springbootonetomanyuni.dao;

import com.m0d.springbootonetomanyuni.entity.Course;
import com.m0d.springbootonetomanyuni.entity.Instructor;
import com.m0d.springbootonetomanyuni.entity.Review;
import java.util.List;

public interface InstructorDAO {
    /*
     CRUD ----> for Instructor
     CRUD ----> for InstructorDetail the relation is uni
         So, any operation happen on the instructor it will happen accordingly to the instructor detail
     */
    void saveInstructor(Instructor instructor);

    Instructor findInstructorById(int instructorId);

    List<Instructor> findAllInstructors();

    void updateInstructor(Instructor instructor);

    void deleteInstructorById(int instructorId);

    /*
     CRUD ----> for Course
         Save course will happen by finding the instructor then updating his courseList
     */

    Course findCourseById(int courseId);

    Course fetchCourseWithReviews(int courseId);

    void updateCourse(Course course);

    void deleteCourseById(int courseId);

    /*
     CRUD ----> for Review
        Saving review will happen by finding the course then updating his review list
     */

    void addReview(int courseId);

    Review findReviewById(int reviewId);

    void updateReview(Review review);

    void deleteReviewById(int reviewId);



}
