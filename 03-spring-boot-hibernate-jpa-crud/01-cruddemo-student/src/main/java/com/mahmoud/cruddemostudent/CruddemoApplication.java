package com.mahmoud.cruddemostudent;

import com.mahmoud.cruddemostudent.DAO.StudentDAO;
import com.mahmoud.cruddemostudent.Entity.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO){
        System.out.println("--> " + studentDAO.deleteAll() + " Rows has been deleted successfully.");
    }
    private void deleteById(StudentDAO studentDAO) {
        Integer studentId = 3000;
        Student student = studentDAO.findById(studentId);

        if (student == null){
            System.out.println("Sorry, couldn't find a student with " + studentId + " id.");
            return;
        }

        studentDAO.deleteById(student);
        System.out.println("Student \n" + student + "\nhas been delete successfully");
    }

    private void updateAllStudentsLastName(StudentDAO studentDAO){
        String newLastName = "Test";
        studentDAO.updateAllLastName(newLastName);
    }

    private void updateStudentById(StudentDAO studentDAO){
        Integer studentId = 3000;

        // first: check if there's a user with the id
        Student student = studentDAO.findById(studentId);

        if(student == null) {
            System.out.println("Sorry, couldn't find a student with " + studentId + " id.");
            return;
        }

        student.setFirstName("ali");
        student.setLastName("ramy");

        studentDAO.updateById(student);
        System.out.println(student);
    }

    private void readStudentFirstName(StudentDAO studentDAO, String firstName){
        List<Student> studentList = studentDAO.findByFirstName(firstName);

        for(Student student : studentList)
            System.out.println(student);
    }

    private void readStudentLastName(StudentDAO studentDAO, String lastName){
        List<Student> studentList = studentDAO.findByLastName(lastName);

        for(Student student : studentList)
            System.out.println(student);
    }

    private void readStudent(StudentDAO studentDAO){
        Integer studentId = 3000;
        Student student = studentDAO.findById(studentId);
        if (student != null)
            System.out.println(student);
        else
            System.out.println("Sorry, couldn't find a student with "+ studentId + " id.");
    }

    private void createStudent(StudentDAO studentDAO) {

        // create student object
        System.out.println("Creating a new student object....");

        Student tmpStudent = new Student("ramy", "ahmed", "niceEmail@gmail.com");

        // save the student object
        System.out.println("Saving the new student....");
        studentDAO.save(tmpStudent);

        // display id of the saved student
        System.out.println("The new student has been saved successfully. Generated id: " + tmpStudent.getId());
    }

}
