package com.mahmoud.cruddemostudent.DAO;

import com.mahmoud.cruddemostudent.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> listAll();

    void updateById(Student student);
    void updateAllLastName(String newLastName);

    void deleteById(Student student);
    Integer deleteAll();

}