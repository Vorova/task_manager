package com.vorova.task_manager.dao;

import com.vorova.task_manager.model.entity.Task;

import java.util.List;

public interface TaskDao {

    List<Task> getAll(Long userId);

    void create(Task task);

    void update(Task task);

    void delete(Long taskId);

}
