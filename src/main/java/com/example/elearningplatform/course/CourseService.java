package com.example.elearningplatform.course;

import com.example.elearningplatform.exception.CourseNotFoundException;
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
    private final ContentRepository contentRepository;
    private final ContentMapper contentMapper;
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
        courseRepository.save(courseMapper.map(course));
    }

    @Transactional
    public CourseDto addContent(String title, ContentDto content) {
        CourseEntity courseEntity = getCourseEntity(title);
        ContentEntity contentEntity = contentMapper.map(content);
        courseEntity.setContent(contentEntity);
        return courseMapper.map(courseRepository.save(courseEntity));
    }

    public void removeCourse(String title) {
        courseRepository.deleteById(getCourseEntity(title).getId());
    }

    public void clearContentForCourse(String title) {
        contentRepository.deleteById(getCourseEntity(title).getContent().getId());
    }

    private CourseEntity getCourseEntity(String title) {
        return courseRepository.findByTitle(title)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with title: " + title));

    }


}