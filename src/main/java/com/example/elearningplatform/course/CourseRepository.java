package com.example.elearningplatform.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    Optional<CourseEntity> findByTitle(String title);
}
