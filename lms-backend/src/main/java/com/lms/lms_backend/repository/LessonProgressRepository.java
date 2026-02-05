package com.lms.lms_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.lms_backend.entity.LessonProgress;

public interface LessonProgressRepository 
        extends JpaRepository<LessonProgress, Long> {

    List<LessonProgress> findByUserId(Long userId);
}
