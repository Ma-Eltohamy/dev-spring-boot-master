package com.m0d.springbootmanytomany;

import com.m0d.springbootmanytomany.dao.AppDAO;
import com.m0d.springbootmanytomany.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner -> {
            // CRUD ----> for Instructor & InstructorDetails
//            createSomeInstructors(appDAO);
//            findInstructorById(appDAO, 2);
//            System.out.println(getAllInstructorsLazy(appDAO));
//            createTheInstructorsDetails(appDAO);

//            updateInstructor(appDAO);
//            updateInstructorDetail(appDAO);
//            deleteInstructorById(appDAO);

            // CRUD ----> Course
//            createSomeCoursesByInstructor(appDAO);
//            findCourseById(appDAO, 11);
//            updateCourse(appDAO, 17);
//            deleteCourseById(appDAO, 16);


            // CRUD ----> Review
//            createSomeReviews(appDAO, 11);
//            findReviewById(appDAO, 5);
//            updateReviewById(appDAO,  5);
//            deleteReviewById(appDAO, 5);
//
//            findCourseAndReviews(appDAO, 11);
//            deleteCourseAndReviews(appDAO, 11);

            // CRUD ----> Students
//            createSomeStudents(appDAO);
//            findStudent(appDAO, 2);
//            EnrollStudentInCourse(appDAO);
//            findStudentWithCourses(appDAO, 1);
//            findCourseWithStudents(appDAO, 12);
//            updateStudent(appDAO);
//            deleteStudent(appDAO, 1);
        };
    }

    private void deleteStudent(AppDAO appDAO, int studentId) {
        System.out.println("----> Deleting a Student By Id(" + studentId + ").....");

        Student tmpStudent = findStudentById(appDAO, studentId);

        if(tmpStudent == null)
            return;

        appDAO.deleteStudent(studentId);
        System.out.println("Done!");
    }

    private void findCourseWithStudents(AppDAO appDAO, int courseId) {
        System.out.println("----> Finding the Course By Id("  + courseId + ")......");

        Course tmpCourse = appDAO.fetchCourseWithStudents(courseId);

        if(tmpCourse == null) {
            System.out.println("Invalid Course Id");
            return;
        }

        System.out.println("Course with ID: " + courseId + " has been found successfully.");
        System.out.println(tmpCourse.toString()); // printing the instructor without the courses list
        System.out.println(tmpCourse.getStudentsList().toString());

        System.out.println("Done!");
    }

    private void findStudentWithCourses(AppDAO appDAO, int studentId) {
        System.out.println("----> Finding the Student By Id("  + studentId + ")......");

        Student tmpStudent = appDAO.fetchStudentWithCourses(studentId);

        if(tmpStudent == null) {
            System.out.println("Invalid Student Id");
            return;
        }

        System.out.println("Student with ID: " + studentId + " has been found successfully.");
        System.out.println(tmpStudent.toString()); // printing the instructor without the courses list
        System.out.println(tmpStudent.getCourseList().toString());

        System.out.println("Done!");
    }

    private void EnrollStudentInCourse(AppDAO appDAO) {
        int studentId = 1;

        List<Course> courseList = Arrays.asList(
          findCourseById(appDAO, 12), findCourseById(appDAO, 14), findCourseById(appDAO, 17)
        );

        Student tmpStudent = findStudentById(appDAO, studentId);

        if(tmpStudent == null)
            return;

        for(Course course : courseList)
            tmpStudent.addCourse(course);

        appDAO.updateStudent(tmpStudent);

        System.out.println("Done!");

    }

    private Student findStudentById(AppDAO appDAO, int studentId) {
        System.out.println("----> Finding the Student By Id("  + studentId + ")......");

        Student tmpStudent = appDAO.fetchStudentWithCourses(studentId);

        if(tmpStudent == null) {
            System.out.println("Invalid Student Id");
            return null;
        }

        System.out.println("Student with ID: " + studentId + " has been found successfully.");
        System.out.println(tmpStudent.toString()); // printing the instructor without the courses list

        return tmpStudent;

    }

    private void createSomeStudents(AppDAO appDAO) {
        System.out.println("----> Creating some students....");
        Student tmpStudent1 = new Student("Mohamed", "ali", "mahmed.ali@gmail.com");
        Student tmpStudent2 = new Student("Atef", "ahmed", "atef.ahmed@gmail.com");
        Student tmpStudent3 = new Student("ahmed", "ahmed", "ahmed.ahmed@gmail.com");

        appDAO.saveStudent(tmpStudent1);
        appDAO.saveStudent(tmpStudent2);
        appDAO.saveStudent(tmpStudent3);

        System.out.println("Done!");

    }

    private void deleteCourseAndReviews(AppDAO appDAO, int courseId) {
        System.out.println("Deleting Course with Reviews....");

        Course tmpCourse = appDAO.fetchCourseWithReviews(courseId);

        if(tmpCourse == null) {
            System.out.println("Invalid Course ID.");
            return;
        }

        appDAO.deleteCourseById(courseId);
        System.out.println("Done!");
    }

    private void findCourseAndReviews(AppDAO appDAO, int courseId) {
        System.out.println("Finding Course with Reviews....");

        Course tmpCourse = appDAO.fetchCourseWithReviews(courseId);

        if(tmpCourse == null) {
            System.out.println("Invalid Course ID.");
            return;
        }

        System.out.println(tmpCourse.toString());
        System.out.println(tmpCourse.getReviewList().toString());
        System.out.println("Done!");
    }

    private void deleteReviewById(AppDAO appDAO, int reviewId) {
        System.out.println("----> Deleting review by ID("+reviewId+")....");

        Review tmpReview = findReviewById(appDAO, reviewId);

        if(tmpReview == null)
            return;

        appDAO.deleteReviewById(reviewId);
        System.out.println("Done!");
    }

    private void updateReviewById(AppDAO appDAO, int reviewId) {
        System.out.println("----> Updating review by ID("+reviewId+")....");

        Review tmpReview = findReviewById(appDAO, reviewId);

        if(tmpReview == null)
            return;

        tmpReview.setComment("This is the most Beautiful course i have ever seen in my entire life");
        appDAO.updateReview(tmpReview);
        System.out.println("Done!");
    }

    private Review findReviewById(AppDAO appDAO, int reviewId) {
        System.out.println("----> Finding review by ID("+reviewId+")....");

        Review tmpReview = appDAO.findReviewById(reviewId);

        if(tmpReview == null) {
            System.out.println("Invalid review ID.");
            return tmpReview;
        }

        System.out.println(tmpReview.toString());
        return tmpReview;
    }

    private void createSomeReviews(AppDAO appDAO, int courseId) {
        System.out.println("----> Adding some reviews for Course with ID(" + courseId + ").....");

//        Course tmpCourse = findCourseById(appDAO, courseId);
        Course tmpCourse = appDAO.fetchCourseWithReviews(courseId);

        if(tmpCourse == null)
            return;

        List<String> cppCourseReviews = Arrays.asList(
                "Great course! Learned a lot about C++.",
                "The instructor explained concepts clearly.",
                "Hands-on exercises helped solidify my understanding.",
                "I appreciate the real-world examples provided.",
                "The course could use more advanced topics.",
                "Assignments were challenging but rewarding.",
                "Fantastic resources were shared during the course.",
                "The pace was a bit fast, but manageable.",
                "I would recommend this course to beginners.",
                "Overall, an excellent introduction to C++ programming."
        );
        int reviewsListSize = cppCourseReviews.size();

        for(int i = 0; i < reviewsListSize; ++i){
            Review tmpReview = new Review(cppCourseReviews.get(i));
            tmpCourse.addReview(tmpReview);
        }

        appDAO.updateCourse(tmpCourse);

        System.out.println("Done!");
    }

    private void deleteCourseById(AppDAO appDAO, int courseId) {
        System.out.println("----> Deleting Course By ID(" + courseId + ").....");

        Course tmpCourse = findCourseById(appDAO, courseId);

        if(tmpCourse == null)
            return;

        appDAO.deleteCourseById(courseId);
        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO, int courseId) {
        System.out.println("----> Updating Course By ID(" + courseId + ").....");

        Course tmpCourse = findCourseById(appDAO, courseId);

        if(tmpCourse == null)
            return;

        int instructorId=2;
        tmpCourse.setTitle("The Ultimate Course ForEver");
        tmpCourse.setInstructor(findInstructorById(appDAO,instructorId));

        appDAO.updateCourse(tmpCourse);
        System.out.println("Done!");
    }

    private Course findCourseById(AppDAO appDAO, int courseId) {

        System.out.println("----> Finding course by ID("+courseId+")....");

        Course tmpCourse = appDAO.findCourseById(courseId);

        if(tmpCourse == null) {
            System.out.println("Invalid course ID.");
            return tmpCourse;
        }

        System.out.println("Course with ID: " + courseId + " has been found successfully.");
        System.out.println(tmpCourse.toString()); // printing the instructor without the courses list
        return tmpCourse;
    }

    private void createSomeCoursesByInstructor(AppDAO appDAO) {
        System.out.println("----> Creating some courses....");

        List<String> coursesTitles = new ArrayList<>(
                Arrays.asList("Java", "C++", "C", "Python", "JavaScript", "Bash", "Go", "Ruby", "PHP", "Basic"));
        int coursesTitlesSize = coursesTitles.size();

        // Finding an instructor to add these courses to.
        int instructorId = 1;
        // here you must fetch with EAGER because if you didn't fetch the course list
        // HOW DO I KNOW IF IT IS NULL OR HAS SOME COURSES IN
        Instructor tmpInstructor = findInstructorById(appDAO, instructorId);

        for(int i = 0;i < coursesTitlesSize; ++i) {
            String courseTitle = coursesTitles.get(i);

            Course tmpCourse = new Course(courseTitle);
            // We must do all the Operations through an existing instructor
            tmpInstructor.addCourse(tmpCourse);
        }
        appDAO.updateInstructor(tmpInstructor);
        System.out.println("Done!");
    }

    private void deleteInstructorById(AppDAO appDAO) {
        System.out.println("----> Deleting an instructor.....");

        int instructorId = 3;
        Instructor tmpInstructor = findInstructorById(appDAO, instructorId);

        if(tmpInstructor == null)
            return;

        appDAO.deleteInstructorById(instructorId);
        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
        System.out.println("----> Updating an instructor.....");

        int instructorId = 3;
        Instructor tmpInstructor = findInstructorById(appDAO, instructorId);

        if(tmpInstructor == null)
            return;

        tmpInstructor.setFirstName("Samy");
        appDAO.updateInstructor(tmpInstructor);
        System.out.println("Done!");
    }

    private void updateInstructorDetail(AppDAO appDAO) {
        System.out.println("----> Updating an instructor details.....");

        int instructorId = 2;
        Instructor tmpInstructor = findInstructorById(appDAO, instructorId);

        if(tmpInstructor == null)
            return;

        tmpInstructor.getInstructorDetail().setHobby("Coding");
        appDAO.updateInstructor(tmpInstructor);
        System.out.println("Done!");
    }


    private void createTheInstructorsDetails(AppDAO appDAO) {
        System.out.println("----> Creating some instructors Details....");

        List<String> hobbies = Arrays.asList("Reading", "Cooking", "Traveling");
        List<Instructor> instructorList = getAllInstructorsLazy(appDAO);

        int instructorsNum = instructorList.size();
        for(int i = 0;i < instructorsNum; ++i) {
            Instructor tmpInstructor = instructorList.get(i);
            String youtubeChannel = "https://www.youtube.com/@" + tmpInstructor.getFirstName() + '.' + tmpInstructor.getLastName();

            InstructorDetail tmpInstructorDetail = new InstructorDetail(youtubeChannel, hobbies.get(i));

            tmpInstructor.setInstructorDetail(tmpInstructorDetail);
            appDAO.updateInstructor(tmpInstructor);
        }
        System.out.println("Done!");
    }

    private List<Instructor> getAllInstructorsLazy(AppDAO appDAO) {
        System.out.println("----> Finding all instructors....");

        List<Instructor> instructorList = appDAO.findAllInstructors();

        if(instructorList == null) {
            System.out.println("There's no instructors at the current moment");
            return null;
        }

        return instructorList;
    }

    private Instructor findInstructorById(AppDAO appDAO, int instructorId) {
        System.out.println("----> Finding the Instructor By Id("  + instructorId + ")......");

        Instructor tmpInstructor = appDAO.fetchInstructorWithCourses(instructorId);

        if(tmpInstructor == null) {
            System.out.println("Invalid instructor Id");
            return null;
        }

        System.out.println("Instructor with ID: " + instructorId + " has been found successfully.");
        System.out.println(tmpInstructor.toString()); // printing the instructor without the courses list

        return tmpInstructor;
    }

    private void createSomeInstructors(AppDAO appDAO) {
        System.out.println("----> Creating some instructors....");
        Instructor tmpInstructor1 = new Instructor("Mahmoud", "Tohamy", "mahmoud.tohamy@gmail.com");
        Instructor tmpInstructor2 = new Instructor("Ramy", "Ahmed", "ramy.ahmed@gmail.com");
        Instructor tmpInstructor3 = new Instructor("Ali", "Samir", "ali.samir@gmail.com");

        appDAO.saveInstructor(tmpInstructor1);
        appDAO.saveInstructor(tmpInstructor2);
        appDAO.saveInstructor(tmpInstructor3);

        System.out.println("Done!");
    }

}

