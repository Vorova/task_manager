package com.vorova.task_manager.service;

import com.vorova.task_manager.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User getUserByUsername(String username);

}
