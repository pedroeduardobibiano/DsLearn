package com.improvement.dslearn.repositories;

import com.improvement.dslearn.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}