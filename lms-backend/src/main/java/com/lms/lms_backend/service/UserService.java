package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.UserDTO;
import com.lms.lms_backend.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<UserDTO> getAllUsers();
}
