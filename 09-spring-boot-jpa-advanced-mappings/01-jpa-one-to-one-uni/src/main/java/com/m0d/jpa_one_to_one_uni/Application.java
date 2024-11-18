package com.m0d.jpa_one_to_one_uni;

import com.m0d.jpa_one_to_one_uni.dao.InstructorDAO;
import com.m0d.jpa_one_to_one_uni.dao.InstructorDAOImpl;
import com.m0d.jpa_one_to_one_uni.dao.InstructorDetailDAO;
import com.m0d.jpa_one_to_one_uni.entity.Instructor;
import com.m0d.jpa_one_to_one_uni.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO, InstructorDetailDAO instructorDetailDAO){
        return runner -> {

//            createInstructor(instructorDAO);
//            printInstructorById(instructorDAO, 2);
            deleteInstructorById(instructorDAO, 1);

//            printInstructorByDetailId(instructorDetailDAO, 2);
//            deleteInstructorByDetailId(instructorDetailDAO, 3);

        };
    }

    private void deleteInstructorByDetailId(InstructorDetailDAO instructorDetailDAO, int i) {
        InstructorDetail tmpInstructorDetail = instructorDetailDAO.findById(i);
        System.out.println(tmpInstructorDetail.getInstructor().toString());
        instructorDetailDAO.delete(i);
        System.out.println("Instructor has been delete successfully using it's instructor detail ID.");
    }

    private void printInstructorByDetailId(InstructorDetailDAO instructorDetailDAO, int i) {
        InstructorDetail tmpInstructorDetail = instructorDetailDAO.findById(i);
        System.out.println(tmpInstructorDetail.getInstructor().toString());

    }

    private void deleteInstructorById(InstructorDAO instructorDAO, int instructorId) {
        Instructor tmpInstructor = instructorDAO.findById(instructorId);
        System.out.println(tmpInstructor.toString());
        instructorDAO.delete(instructorId);
        System.out.println("Instructor has been delete successfully.");
    }

    private void printInstructorById(InstructorDAO instructorDAO, int instructorId) {
        Instructor tmpInstructor = instructorDAO.findById(instructorId);
        System.out.println(tmpInstructor.toString());
    }


    private void createInstructor(InstructorDAO instructorDAO) {

        // first Instructor
        Instructor tmpInstructor = new Instructor("Mahmoud", "Tohamy", "mahmoud.tohamy@gmail.com");
        InstructorDetail tmpInstructorDetail = new InstructorDetail("M0D@youtube.com", "soccer");

        tmpInstructor.setInstructorDetail(tmpInstructorDetail);

        System.out.println("Saving instructor: " + tmpInstructor.toString());
        instructorDAO.save(tmpInstructor);

        // second Instructor
        tmpInstructor = new Instructor("Ramy", "Ahmed", "ramy.ahmed@gmail.com");
        tmpInstructorDetail = new InstructorDetail("ramyAmhed.M0D@youtube.com", "swimming");

        tmpInstructor.setInstructorDetail(tmpInstructorDetail);

        System.out.println("Saving instructor: " + tmpInstructor.toString());
        instructorDAO.save(tmpInstructor);
        System.out.println("Done!");
    }

}
