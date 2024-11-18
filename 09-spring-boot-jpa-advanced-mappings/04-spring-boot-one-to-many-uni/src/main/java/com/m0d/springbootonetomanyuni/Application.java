package com.m0d.springbootonetomanyuni;

import com.m0d.springbootonetomanyuni.dao.InstructorDAO;
import com.m0d.springbootonetomanyuni.entity.Course;
import com.m0d.springbootonetomanyuni.entity.InstructorDetail;
import com.m0d.springbootonetomanyuni.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.m0d.springbootonetomanyuni.entity.Instructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
        return runner -> {

            // CRUD ----> for Instructor & InstructorDetails
            createSomeInstructors(instructorDAO);
//            findInstructorById(instructorDAO, 2);
//            getAllInstructorsLazy(instructorDAO);
//            createTheInstructorsDetails(instructorDAO);

//            updateInstructor(instructorDAO);
//            updateInstructorDetail(instructorDAO);
//            deleteInstructorById(instructorDAO);

            // CRUD ----> Course
//            createSomeCoursesByInstructor(instructorDAO);
//            findCourseById(instructorDAO, 21);
//            updateCourse(instructorDAO, 27);
//            deleteCourseById(instructorDAO, 26);


            // CRUD ----> Review
//            createSomeReviews(instructorDAO, 21);
//            findReviewById(instructorDAO, 5);
//            updateReviewById(instructorDAO,  5);
//            deleteReviewById(instructorDAO, 5);

//            findCourseAndReviews(instructorDAO, 21);
//            deleteCourseAndReviews(instructorDAO, 21);

        };
    }

    private void deleteCourseAndReviews(InstructorDAO instructorDAO, int courseId) {
        System.out.println("Deleting Course with Reviews....");

        Course tmpCourse = instructorDAO.fetchCourseWithReviews(courseId);

        if(tmpCourse == null) {
            System.out.println("Invalid Course ID.");
            return;
        }

        instructorDAO.deleteCourseById(courseId);
        System.out.println("Done!");
    }

    private void findCourseAndReviews(InstructorDAO instructorDAO, int courseId) {
        System.out.println("Finding Course with Reviews....");

        Course tmpCourse = instructorDAO.fetchCourseWithReviews(courseId);

        if(tmpCourse == null) {
            System.out.println("Invalid Course ID.");
            return;
        }

        System.out.println(tmpCourse.toString());
        System.out.println(tmpCourse.getReviewList().toString());
        System.out.println("Done!");
    }

    private void deleteReviewById(InstructorDAO instructorDAO, int reviewId) {
        System.out.println("----> Deleting review by ID("+reviewId+")....");

        Review tmpReview = findReviewById(instructorDAO, reviewId);

        if(tmpReview == null)
            return;

        instructorDAO.deleteReviewById(reviewId);
        System.out.println("Done!");
    }

    private void updateReviewById(InstructorDAO instructorDAO, int reviewId) {
        System.out.println("----> Updating review by ID("+reviewId+")....");

        Review tmpReview = findReviewById(instructorDAO, reviewId);

        if(tmpReview == null)
            return;

        tmpReview.setComment("This is the most Beautiful course i have ever seen in my entire life");
        instructorDAO.updateReview(tmpReview);
        System.out.println("Done!");
    }

    private Review findReviewById(InstructorDAO instructorDAO, int reviewId) {
        System.out.println("----> Finding review by ID("+reviewId+")....");

        Review tmpReview = instructorDAO.findReviewById(reviewId);

        if(tmpReview == null) {
            System.out.println("Invalid review ID.");
            return tmpReview;
        }

        System.out.println(tmpReview.toString());
        return tmpReview;
    }

    private void createSomeReviews(InstructorDAO instructorDAO, int courseId) {
        System.out.println("----> Adding some reviews for Course with ID(" + courseId + ").....");

//        Course tmpCourse = findCourseById(instructorDAO, courseId);
        Course tmpCourse = instructorDAO.fetchCourseWithReviews(courseId);

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

        instructorDAO.updateCourse(tmpCourse);

        System.out.println("Done!");
    }

    private void deleteCourseById(InstructorDAO instructorDAO, int courseId) {
        System.out.println("----> Deleting Course By ID(" + courseId + ").....");

        Course tmpCourse = findCourseById(instructorDAO, courseId);

        if(tmpCourse == null)
            return;

        instructorDAO.deleteCourseById(courseId);
        System.out.println("Done!");
    }

    private void updateCourse(InstructorDAO instructorDAO, int courseId) {
        System.out.println("----> Updating Course By ID(" + courseId + ").....");

        Course tmpCourse = findCourseById(instructorDAO, courseId);

        if(tmpCourse == null)
            return;

        tmpCourse.setTitle("The Ultimate Course ForEver");
        tmpCourse.setInstructor(findInstructorById(instructorDAO,4));

        instructorDAO.updateCourse(tmpCourse);
        System.out.println("Done!");
    }

    private Course findCourseById(InstructorDAO instructorDAO, int courseId) {

        System.out.println("----> Finding course by ID("+courseId+")....");

        Course tmpCourse = instructorDAO.findCourseById(courseId);

        if(tmpCourse == null) {
            System.out.println("Invalid course ID.");
            return tmpCourse;
        }

        System.out.println("Course with ID: " + courseId + " has been found successfully.");
        System.out.println(tmpCourse.toString()); // printing the instructor without the courses list
        return tmpCourse;
    }

    private void createSomeCoursesByInstructor(InstructorDAO instructorDAO) {
        System.out.println("----> Creating some courses....");

        List<String> coursesTitles = new ArrayList<>(
                Arrays.asList("Java", "C++", "C", "Python", "JavaScript", "Bash", "Go", "Ruby", "PHP", "Basic"));
        int coursesTitlesSize = coursesTitles.size();

        // Finding an instructor to add these courses to.
        int instructorId = 5;
        // here you must fetch with EAGER because if you didn't fetch the course list
        // HOW DO I KNOW IF IT IS NULL OR HAS SOME COURSES IN
        Instructor tmpInstructor = findInstructorById(instructorDAO, instructorId);

        for(int i = 0;i < coursesTitlesSize; ++i) {
            String courseTitle = coursesTitles.get(i);

            Course tmpCourse = new Course(courseTitle);
            // We must do all the Operations through an existing instructor
            tmpInstructor.addCourse(tmpCourse);
        }
        instructorDAO.updateInstructor(tmpInstructor);
        System.out.println("Done!");
    }

    private void deleteInstructorById(InstructorDAO instructorDAO) {
        System.out.println("----> Deleting an instructor.....");

        int instructorId = 6;
        Instructor tmpInstructor = findInstructorById(instructorDAO, instructorId);

        if(tmpInstructor == null)
            return;

        instructorDAO.deleteInstructorById(instructorId);
        System.out.println("Done!");
    }

    private void updateInstructor(InstructorDAO instructorDAO) {
        System.out.println("----> Updating an instructor.....");

        int instructorId = 6;
        Instructor tmpInstructor = findInstructorById(instructorDAO, instructorId);

        if(tmpInstructor == null)
            return;

        tmpInstructor.setFirstName("Samy");
        instructorDAO.updateInstructor(tmpInstructor);
        System.out.println("Done!");
    }

    private void updateInstructorDetail(InstructorDAO instructorDAO) {
        System.out.println("----> Updating an instructor details.....");

        int instructorId = 5;
        Instructor tmpInstructor = findInstructorById(instructorDAO, instructorId);

        if(tmpInstructor == null)
            return;

        tmpInstructor.getInstructorDetail().setHobby("Coding");
        instructorDAO.updateInstructor(tmpInstructor);
        System.out.println("Done!");
    }


    private void createTheInstructorsDetails(InstructorDAO instructorDAO) {
        System.out.println("----> Creating some instructors Details....");

        List<String> hobbies = Arrays.asList("Reading", "Cooking", "Traveling");
        List<Instructor> instructorList = getAllInstructorsLazy(instructorDAO);

        int instructorsNum = instructorList.size();
        for(int i = 0;i < instructorsNum; ++i) {
            Instructor tmpInstructor = instructorList.get(i);
            String youtubeChannel = "https://www.youtube.com/@" + tmpInstructor.getFirstName() + '.' + tmpInstructor.getLastName();

            InstructorDetail tmpInstructorDetail = new InstructorDetail(youtubeChannel, hobbies.get(i));

            tmpInstructor.setInstructorDetail(tmpInstructorDetail);
            instructorDAO.updateInstructor(tmpInstructor);
        }
        System.out.println("Done!");
    }

    private List<Instructor> getAllInstructorsLazy(InstructorDAO instructorDAO) {
        System.out.println("----> Finding all instructors....");

        List<Instructor> instructorList = instructorDAO.findAllInstructors();

        if(instructorList == null) {
            System.out.println("There's no instructors at the current moment");
            return null;
        }

        return instructorList;
    }

    private Instructor findInstructorById(InstructorDAO instructorDAO, int instructorId) {
        System.out.println("----> Finding the Instructor By Id("  + instructorId + ")......");

        Instructor tmpInstructor = instructorDAO.findInstructorById(instructorId);

        if(tmpInstructor == null) {
            System.out.println("Invalid instructor Id");
            return null;
        }

        System.out.println("Instructor with ID: " + instructorId + " has been found successfully.");
        System.out.println(tmpInstructor.toString()); // printing the instructor without the courses list

        return tmpInstructor;
    }

    private void createSomeInstructors(InstructorDAO instructorDAO) {
        System.out.println("----> Creating some instructors....");
        Instructor tmpInstructor1 = new Instructor("Mahmoud", "Tohamy", "mahmoud.tohamy@gmail.com");
        Instructor tmpInstructor2 = new Instructor("Ramy", "Ahmed", "ramy.ahmed@gmail.com");
        Instructor tmpInstructor3 = new Instructor("Ali", "Samir", "ali.samir@gmail.com");

        instructorDAO.saveInstructor(tmpInstructor1);
        instructorDAO.saveInstructor(tmpInstructor2);
        instructorDAO.saveInstructor(tmpInstructor3);

        System.out.println("Done!");
    }

}
