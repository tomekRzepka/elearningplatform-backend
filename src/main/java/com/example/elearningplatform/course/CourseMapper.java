package com.example.elearningplatform.course;

import com.example.elearningplatform.user.UserEntity;
import com.example.elearningplatform.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private final UserMapper userMapper;

    CourseDto map(CourseEntity entity) {
        return new CourseDto(entity.getTitle(), entity.getAuthor().getLogin(), entity.getPrice(), entity.getDescription(), entity.getLink());
    }

    CourseEntity map(CourseDto dto, UserEntity author) {
        return CourseEntity.builder().title(dto.title()).author(author).price(dto.price()).description(dto.description()).link(dto.link()).build();
    }
}
