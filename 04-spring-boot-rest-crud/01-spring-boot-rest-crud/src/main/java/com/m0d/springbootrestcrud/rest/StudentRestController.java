package com.m0d.springbootrestcrud.rest;

import com.m0d.springbootrestcrud.entity.Student;
import com.m0d.springbootrestcrud.error.StudentErrorResponse;
import com.m0d.springbootrestcrud.exception.StudentInvalidDataException;
import com.m0d.springbootrestcrud.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> studentList;
    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();

        // Adding some dummy data
        studentList.add(new Student(1, "mahmoud", "Sultan", true));
        studentList.add(new Student(2, "ramy", "Saad", false));
        studentList.add(new Student(3, "ahmed", "karim", true));
        studentList.add(new Student(4, "Ali", "Samy", false));
        studentList.add(new Student(2938, "Samir", "Ahmed", false));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable String studentId){
        int id;
        try{
            id = Integer.parseInt(studentId);
        }
        catch(NumberFormatException e) {
            throw new StudentInvalidDataException("This is an Invalid student id: " + studentId);
        }

        if(id <= 0 || id >= studentList.size())
            throw new StudentNotFoundException("Student id not found - " + studentId);
        return studentList.get(id - 1);
    }


}
