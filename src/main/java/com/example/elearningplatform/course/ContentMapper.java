package com.example.elearningplatform.course;

import org.springframework.stereotype.Component;

@Component
public class ContentMapper {

    Content map(ContentEntity entity) {

        return new Content(entity.getDescription(), entity.getLink());
    }

}
