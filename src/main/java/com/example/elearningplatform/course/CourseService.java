package com.example.elearningplatform.course;

import com.example.elearningplatform.exception.CourseNotFoundException;
import com.example.elearningplatform.user.UserDto;
import com.example.elearningplatform.user.UserEntity;
import com.example.elearningplatform.user.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserService userService;
    private final CourseMapper courseMapper;

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::map).toList();
    }

    public CourseDto getCourse(String title) {
        CourseEntity course = courseRepository.findByTitle(title)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with title: " + title));
        return courseMapper.map(course);

    }

    public void addCourse(CourseDto course) {
        UserEntity author = userService.getUserEntity(course.author());
        courseRepository.save(courseMapper.map(course,author));
    }

    public void removeCourse(String title) {
        courseRepository.deleteById(getCourseEntity(title).getId());
    }

    private CourseEntity getCourseEntity(String title) {
        return courseRepository.findByTitle(title)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with title: " + title));

    }


}