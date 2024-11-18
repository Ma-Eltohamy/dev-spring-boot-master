package com.m0d.jpa_one_to_one_uni.dao;

import com.m0d.jpa_one_to_one_uni.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findById(int instructorId);

    void delete(int instructorId);
}
