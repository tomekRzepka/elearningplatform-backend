package com.example.elearningplatform.course;

import com.example.elearningplatform.user.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;


public record BuyCourseDto(String customer,
                           String courseTitle) {
}
