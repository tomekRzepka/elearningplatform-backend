package com.example.elearningplatform.course;

import org.springframework.stereotype.Component;

@Component
public class ContentMapper {

    ContentDto map(ContentEntity entity) {

        return new ContentDto(entity.getDescription(), entity.getLink());
    }

    ContentEntity map(ContentDto dto) {

        return ContentEntity.builder().description(dto.description()).link(dto.link()).build();
    }
}
