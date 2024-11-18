package com.m0d.springbootonetomany;

import com.m0d.springbootonetomany.dao.InstructorDAO;
import com.m0d.springbootonetomany.entity.Course;
import com.m0d.springbootonetomany.entity.Instructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOneToManyApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
        return runner->{

            // C ->Create
//            createSomeInstructors(instructorDAO);
            createSomeCoursesByInstructor(instructorDAO);

            // R -> Read for instructors
//            findInstructorById(1, instructorDAO);
//            getAllLAZY(instructorDAO);
//            getAllEager(instructorDAO);
//            findInstructorByIdJoinFETCH(instructorDAO);
//            findInstructorByIdLazy(instructorDAO);

            // R -> Read for courses
//            findCourseByIdEAGER(instructorDAO);
//            findCourseByIdLAZY(instructorDAO);

//            findInstructorByCourseId(instructorDAO);

            // U -> Updating
//            updateInstructorById(instructorDAO);
//            updateCourseById(instructorDAO);

            // D -> Deleting
//            DeleteInstructorById(instructorDAO);
//            DeleteCourseById(instructorDAO);
        };
    }

    private void DeleteCourseById(InstructorDAO instructorDAO) {
        int courseId = 28;
        System.out.println("----> Deleting course by ID");
        Course tmpCourse  = findCourseByIdLAZY(instructorDAO, courseId); // just for logging purposes

        if(tmpCourse == null)
            return;

        instructorDAO.deleteCourseById(tmpCourse.getId());
        System.out.println("Done!");
    }

    private void DeleteInstructorById(InstructorDAO instructorDAO) {
        System.out.println("----> Deleting instructor by ID");
        Instructor tmpInstructor = instructorDAO.getByIdJoinFETCH(1); // just for logging purposes

        if(tmpInstructor == null)
            return;

        instructorDAO.deleteById(tmpInstructor.getId());
        System.out.println("Done!");
    }

    private void updateCourseById(InstructorDAO instructorDAO) {
        System.out.println("----> Updating the course by id");
        int courseId = 18;
        Course tmpCourse = findCourseByIdLAZY(instructorDAO, courseId);

        if(tmpCourse == null)
            return;

        tmpCourse.setTitle("The New Course");

        instructorDAO.updateCourse(tmpCourse);

        System.out.println("Done!");
    }

    private Instructor findInstructorByCourseId(InstructorDAO instructorDAO) {
        int courseId = 12;
        System.out.println("----> Finding the Instructor By CourseId("  + courseId + ")......");

        // First-> We fetch the course with lazy fetching
        Course tmpCourse = findCourseByIdLAZY(instructorDAO, courseId);

        if(tmpCourse == null)
            return null;

        // second -> We fetch the instructor with lazy fetching
        Instructor tmpInstructor = instructorDAO.findById(tmpCourse.getInstructor_id());

        // Now -> We fetched both (instructor & course) using lazy fetching
        if(tmpInstructor == null) {
            System.out.println("Invalid instructor Id");
            return null;
        }

        System.out.println("Instructor with ID: " + tmpInstructor.getId() + " has been found successfully.");
        System.out.println(tmpInstructor.toString()); // printing the instructor without the courses list

        return tmpInstructor;
    }

    private Course findCourseByIdLAZY(InstructorDAO instructorDAO, int courseId) {
        System.out.println("----> Finding the Course by id(" + courseId +") LAZY...");

        Course tmpCourse = instructorDAO.findCourseByIdLAZY(courseId);


        if(tmpCourse == null) {
            System.out.println("Invalid course Id");
            return null;
        }

        System.out.println("Course with ID: " + courseId + " has been found successfully.");
        System.out.println(tmpCourse.toString());

        return tmpCourse;
    }

    private Course findCourseByIdEAGER(InstructorDAO instructorDAO) {
        int courseId = 17;
        System.out.println("----> Finding the Course by id(" + courseId +") EAGER...");

        Course tmpCourse = instructorDAO.findCourseByIdEAGER(courseId);


        if(tmpCourse == null) {
            System.out.println("Invalid course Id");
            return null;
        }

        System.out.println("Course with ID: " + courseId + " has been found successfully.");
        System.out.println(tmpCourse.toString());
        System.out.println(tmpCourse.getInstructor().toString());

        return tmpCourse;
    }

    private void findInstructorByIdLazy(InstructorDAO instructorDAO) {
        findInstructorById(2, instructorDAO);
    }


    private void findInstructorByIdJoinFETCH(InstructorDAO instructorDAO) {
        System.out.println("----> Getting all instructors with JoinFETCH Fetching...");
        Instructor tmpInstructor = instructorDAO.getByIdJoinFETCH(1);

        System.out.println(tmpInstructor.toString());
        System.out.println(tmpInstructor.getCourseList().toString());

        System.out.println("Done!");
    }

    private void getAllEager(InstructorDAO instructorDAO) {
        // Simply we will just change the fetching type in the Instructor class to EAGER

        System.out.println("----> Getting all instructors with EAGER Fetching...");
        List<Instructor> instructorsList = instructorDAO.getAllEager();
        int instructorsListSize = instructorsList.size();

        for(int i = 0;i < instructorsListSize; ++i) {
            System.out.println(instructorsList.get(i).toString());
            System.out.println(instructorsList.get(i).getCourseList().toString());
        }

        System.out.println("Done!");
    }

    private void getAllLAZY(InstructorDAO instructorDAO) {
        System.out.println("---> Getting all instructors with LAZY Fetching...");
        List<Instructor> instructorsList = instructorDAO.getAllLAZY();
        int instructorsListSize = instructorsList.size();

        for(int i = 0;i < instructorsListSize; ++i)
            System.out.println(instructorsList.get(i).toString());

        System.out.println("Done!");
    }

    private void createSomeCoursesByInstructor(InstructorDAO instructorDAO) {
        System.out.println("----> Creating some courses....");

        List<String> coursesTitles = new ArrayList<>(
                Arrays.asList("Java", "C++", "C", "Python", "JavaScript", "Bash", "Go", "Ruby", "PHP", "Basic"));
        int coursesTitlesSize = coursesTitles.size();

        // Finding an instructor to add these courses to.
        int instructorId = 3;
        // here you must fetch with EAGER because if you didn't fetch the course list
        // HOW DO I KNOW IF IT IS NULL OR HAS SOME COURSES IN
        Instructor tmpInstructor = findInstructorById(instructorId, instructorDAO);

        for(int i = 0;i < coursesTitlesSize; ++i) {
            String courseTitle = coursesTitles.get(i);

            Course tmpCourse = new Course(courseTitle);
            // We must do all the Operations through an existing instructor
            tmpInstructor.addCourse(tmpCourse);
        }
        instructorDAO.update(tmpInstructor);
        System.out.println("Done!");
    }

    private void updateInstructorById(InstructorDAO instructorDAO) {
        System.out.println("----> updating an instructor....");
        Instructor tmpInstructor = findInstructorById(3, instructorDAO);
        tmpInstructor.setFirstName("Ali");
        instructorDAO.update(tmpInstructor);
        System.out.println("Done!");
    }

    private Instructor findInstructorById(int instructorId, InstructorDAO instructorDAO) {
        System.out.println("----> Finding the Instructor By Id("  + instructorId + ")......");

        Instructor tmpInstructor = instructorDAO.findById(instructorId);

        if(tmpInstructor == null) {
            System.out.println("Invalid instructor Id");
            return null;
        }

        System.out.println("Instructor with ID: " + instructorId + " has been found successfully.");
        System.out.println(tmpInstructor.toString()); // printing the instructor without the courses list

        return tmpInstructor;
    }

    private void createSomeInstructors(InstructorDAO instructorDAO){
        System.out.println("----> Creating some instructors....");
        Instructor tmpInstructor1 = new Instructor("Mahmoud", "Tohamy", "mahmoud.tohamy@gmail.com");
        Instructor tmpInstructor2 = new Instructor("Ramy", "Ahmed", "ramy.ahmed@gmail.com");
        Instructor tmpInstructor3 = new Instructor("Ali", "Samir", "ali.samir@gmail.com");

        instructorDAO.save(tmpInstructor1);
        instructorDAO.save(tmpInstructor2);
        instructorDAO.save(tmpInstructor3);

        System.out.println("Done!");
    }

}
