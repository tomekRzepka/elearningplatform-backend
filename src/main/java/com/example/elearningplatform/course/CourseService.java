package com.example.elearningplatform.course;

import com.example.elearningplatform.ElearningPlatformException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {
    private CourseRepository courseRepository;
    private ContentRepository contentRepository;
    private ContentMapper contentMapper;
    private CourseMapper courseMapper;

    public List<Course> getAllCourses() {
        try {
            List<CourseEntity> all = courseRepository.findAll();
            return all.stream().map(courseMapper::map).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ElearningPlatformException("No course entity", e);
        }
    }
}
