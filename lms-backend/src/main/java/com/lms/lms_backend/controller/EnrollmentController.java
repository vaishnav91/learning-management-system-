package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.Enrollment;
import com.lms.lms_backend.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public Enrollment enrollUser(
            @RequestParam Long userId,
            @RequestParam Long courseId) {

        return enrollmentService.enrollUser(userId, courseId);
    }
}
