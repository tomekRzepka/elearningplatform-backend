package com.example.elearningplatform.course;

import com.example.elearningplatform.exception.CourseNotFoundException;
import com.example.elearningplatform.user.UserEntity;
import com.example.elearningplatform.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoughtCourseService {
    private final CourseRepository courseRepository;
    private final BoughtCourseRepository boughtCourseRepository;
    private final UserService userService;
    private final CourseMapper courseMapper;

    public List<CourseDto> getAllCoursesForUser(String login) {
        UserEntity customer = userService.getUserEntity(login);
        List<BoughtCourseEntity> coursesByUserId = boughtCourseRepository.findAllByUserId(customer.getId());
        List<CourseEntity> courses = coursesByUserId.stream()
                .map(boughtCourseEntity -> courseRepository.findById(boughtCourseEntity.getCourse().getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        return courses.stream().map(courseMapper::map).toList();
    }

    public void buyCourse(BuyCourseDto buyCourseDto) {
        UserEntity customer = userService.getUserEntity(buyCourseDto.customer());
        CourseEntity course = courseRepository.findByTitle(buyCourseDto.courseTitle())
                .orElseThrow(() -> new CourseNotFoundException("Course not found with title: " + buyCourseDto.courseTitle()));

        BoughtCourseEntity boughtCourse = BoughtCourseEntity.builder()
                .user(customer)
                .course(course)
                .build();
        boughtCourseRepository.save(boughtCourse);
    }

}