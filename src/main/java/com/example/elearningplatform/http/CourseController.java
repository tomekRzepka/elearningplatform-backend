package com.example.elearningplatform.http;

import com.example.elearningplatform.course.BoughtCourseService;
import com.example.elearningplatform.course.BuyCourseDto;
import com.example.elearningplatform.course.CourseDto;
import com.example.elearningplatform.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
@CrossOrigin
public class CourseController {

    private final CourseService courseService;
    private final BoughtCourseService boughtCourseService;

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{title}")
    public CourseDto getCourse(@PathVariable String title) {
        return courseService.getCourse(title);
    }

    @PostMapping("/add")
    public void addCourse(@RequestBody CourseDto course) {
        courseService.addCourse(course);
    }

    @DeleteMapping("/{title}/remove")
    public void removeCourse(@PathVariable String title) {
        courseService.removeCourse(title);
    }

    @GetMapping("/{login}")
    public List<CourseDto> getAllCoursesForCustomer(@PathVariable String login) {
        return boughtCourseService.getAllCoursesForUser(login);
    }
    @PostMapping("/buy")
    public void buyCourse(@RequestBody BuyCourseDto buyCourse) {
        boughtCourseService.buyCourse(buyCourse);
    }


}
