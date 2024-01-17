package com.example.elearningplatform.course;

import java.math.BigDecimal;

public record CourseDto(String title,
                        String author,
                        BigDecimal price,
                        ContentDto content) {
}
