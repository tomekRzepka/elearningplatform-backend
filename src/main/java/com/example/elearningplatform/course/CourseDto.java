package com.example.elearningplatform.course;

import com.example.elearningplatform.user.UserDto;

import java.math.BigDecimal;

public record CourseDto(String title,
                        UserDto author,
                        BigDecimal price,
                        ContentDto content) {
}
