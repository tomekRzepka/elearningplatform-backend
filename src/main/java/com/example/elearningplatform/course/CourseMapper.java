package com.example.elearningplatform.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private ContentMapper contentMapper;

    CourseDto map(CourseEntity entity) {
        return new CourseDto(entity.getTitle(), entity.author.getLogin(), entity.getPrice(), contentMapper.map(entity.getContent()));
    }
}
