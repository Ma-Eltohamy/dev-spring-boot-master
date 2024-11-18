package com.m0d.jpa_one_to_one_uni.dao;


import com.m0d.jpa_one_to_one_uni.entity.InstructorDetail;

public interface InstructorDetailDAO {

    void save(InstructorDetail instructorDetail);

    InstructorDetail findById(int instructorDetailId);

    void delete(int instructorDetailId);
}
