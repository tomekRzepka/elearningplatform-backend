package com.example.elearningplatform.course;

import com.example.elearningplatform.user.UserEntity;
import com.example.elearningplatform.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private ContentMapper contentMapper;
    private UserMapper userMapper;

    CourseDto map(CourseEntity entity) {
        return new CourseDto(entity.getTitle(), entity.getAuthor().getLogin(), entity.getPrice(), contentMapper.map(entity.getContent()));
    }

    CourseEntity map(CourseDto dto, UserEntity author) {
        return CourseEntity.builder().title(dto.title()).author(author).price(dto.price()).content(contentMapper.map(dto.content())).build();
    }
}
