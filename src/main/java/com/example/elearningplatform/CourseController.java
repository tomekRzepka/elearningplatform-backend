package com.example.elearningplatform;

import com.example.elearningplatform.course.ContentDto;
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

    @PutMapping("/{title}/addContent")
    public CourseDto addCourse(@PathVariable String title, @RequestBody ContentDto course) {
        return courseService.addContent(title, course);
    }

    @DeleteMapping("/{title}/remove")
    public void removeCourse(@PathVariable String title) {
        courseService.removeCourse(title);
    }

    @DeleteMapping("/{title}/clearContent")
    public void clearContent(@PathVariable String title) {
        courseService.clearContentForCourse(title);
    }

}
