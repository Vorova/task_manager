package com.vorova.task_manager.dao;

import com.vorova.task_manager.model.entity.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUserByUsername(String username);

}
