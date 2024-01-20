package com.example.elearningplatform.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface BoughtCourseRepository extends JpaRepository<BoughtCourseEntity, Long> {
    List<BoughtCourseEntity> findAllByUserId(Long id);
}
