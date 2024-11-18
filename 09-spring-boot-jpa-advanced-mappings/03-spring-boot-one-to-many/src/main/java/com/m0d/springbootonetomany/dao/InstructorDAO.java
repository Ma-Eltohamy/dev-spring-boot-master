package com.m0d.springbootonetomany.dao;

import com.m0d.springbootonetomany.entity.Course;
import com.m0d.springbootonetomany.entity.Instructor;

import java.util.List;

public interface InstructorDAO {
    void save(Instructor instructor);

    List<Instructor> getAllLAZY();

    List<Instructor> getAllEager();

    Instructor getByIdJoinFETCH(int id);

    Instructor findById(int instructorId);

    void deleteById(int instructorId);

    void deleteCourseById(int courseId);

    void update(Instructor instructor);

    Course findCourseByIdEAGER(int courseId);

    Course findCourseByIdLAZY(int courseId);

    void updateCourse(Course course);
}
