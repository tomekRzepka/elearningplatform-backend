package com.example.elearningplatform.course;

import com.example.elearningplatform.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private ContentMapper contentMapper;
    private UserMapper userMapper;

    CourseDto map(CourseEntity entity) {
        return new CourseDto(entity.getTitle(), userMapper.map(entity.getAuthor()), entity.getPrice(), contentMapper.map(entity.getContent()));
    }

    CourseEntity map(CourseDto dto) {
        return CourseEntity.builder().title(dto.title()).author(userMapper.map(dto.author())).price(dto.price()).content(contentMapper.map(dto.content())).build();
    }
}
