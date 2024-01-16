package com.example.elearningplatform.course;

import com.example.elearningplatform.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "course")
@Data
class CourseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String title;
    @OneToOne
    UserEntity author;
    BigDecimal price;
    @OneToOne
    ContentEntity content;
}
