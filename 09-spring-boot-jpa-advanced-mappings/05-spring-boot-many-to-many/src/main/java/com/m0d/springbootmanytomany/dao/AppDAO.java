package com.m0d.springbootmanytomany.dao;

import com.m0d.springbootmanytomany.entity.Course;
import com.m0d.springbootmanytomany.entity.Instructor;
import com.m0d.springbootmanytomany.entity.Review;
import com.m0d.springbootmanytomany.entity.Student;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AppDAO {
    /*
     CRUD ----> for Instructor
     CRUD ----> for InstructorDetail the relation is uni
         So, any operation happen on the instructor it will happen accordingly to the instructor detail
     */
    void saveInstructor(Instructor instructor);

    Instructor findInstructorById(int instructorId);

    Instructor fetchInstructorWithCourses(int instructorId);

    List<Instructor> findAllInstructors();

    void updateInstructor(Instructor instructor);

    void deleteInstructorById(int instructorId);

    /*
     CRUD ----> for Course
         Save course will happen by finding the instructor then updating his courseList
     */

    Course findCourseById(int courseId);

    Course fetchCourseWithReviews(int courseId);

    Course fetchCourseWithStudents(int courseId);

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

    /*
     CRUD ----> for Students
     */

    void saveStudent(Student student);

    Student findStudentById(int studentId);

    Student fetchStudentWithCourses(int studentId);

    void updateStudent(Student student);

    void deleteStudent(int studentId);
}
