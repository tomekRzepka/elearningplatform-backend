package com.example.elearningplatform.course;

import com.example.elearningplatform.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "bought_course")
@Builder
@Data
@AllArgsConstructor
public class BoughtCourseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    public BoughtCourseEntity() {
        this.course = new CourseEntity();
        this.user = new UserEntity();
    }
}
