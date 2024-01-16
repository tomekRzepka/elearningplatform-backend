package com.example.elearningplatform.course;

import java.math.BigDecimal;

public record Course(String title,
                     String author,
                     BigDecimal price,
                     Content content) {
}
