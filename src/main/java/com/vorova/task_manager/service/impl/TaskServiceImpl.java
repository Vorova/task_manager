package com.vorova.task_manager.service.impl;

import com.vorova.task_manager.dao.TaskDao;
import com.vorova.task_manager.model.entity.Task;
import com.vorova.task_manager.service.TaskService;
import com.vorova.task_manager.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;
    private final UserService userService;

    public TaskServiceImpl(TaskDao taskDao, UserService userService) {
        this.taskDao = taskDao;
        this.userService = userService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAll(Long userId) {
        return taskDao.getAll(userId);
    }

    @Override
    @Transactional
    public void create(Task task) {
        verification(task.getId());
    }

    @Override
    @Transactional
    public void update(Task task) {
        verification(task.getId());
    }

    @Override
    @Transactional
    public void delete(Long taskId) {
        verification(taskId);
    }

    /**
     * Необходимо исправить на корректную проверку
     */
    protected void verification(Long taskId) {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userService.getUserByUsername(username);
        if (!Objects.equals(taskId, user.getId())) {
            throw new RuntimeException();
        }
    }
}
