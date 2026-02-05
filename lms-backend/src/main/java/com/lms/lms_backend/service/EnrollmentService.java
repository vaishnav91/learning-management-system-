package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.Enrollment;

public interface EnrollmentService {

    Enrollment enrollUser(Long userId, Long courseId);
}
