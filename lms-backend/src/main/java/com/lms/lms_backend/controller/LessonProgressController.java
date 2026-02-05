package com.lms.lms_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.lms_backend.entity.LessonProgress;
import com.lms.lms_backend.repository.LessonRepository;
import com.lms.lms_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin
public class LessonProgressController {

    @Autowired
    private LessonProgressRepository progressRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private LessonRepository lessonRepo;

    @PostMapping("/{userId}/{lessonId}")
    public LessonProgress markCompleted(
            @PathVariable Long userId,
            @PathVariable Long lessonId) {

        LessonProgress progress = new LessonProgress();
        progress.setUser(userRepo.findById(userId).orElseThrow());
        progress.setLesson(lessonRepo.findById(lessonId).orElseThrow());
        progress.setCompleted(true);

        return progressRepo.save(progress);
    }

    @GetMapping("/user/{userId}")
    public List<LessonProgress> getProgress(@PathVariable Long userId) {
        return progressRepo.findByUserId(userId);
    }
}
