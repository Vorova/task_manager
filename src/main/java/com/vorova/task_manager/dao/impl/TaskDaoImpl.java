package com.vorova.task_manager.dao.impl;

import com.vorova.task_manager.dao.TaskDao;
import com.vorova.task_manager.model.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    private final EntityManager em;

    public TaskDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Task> getAll(Long userId) {
        return em.createQuery("""
                FROM Task t WHERE t.userId = :userId
                """, Task.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public void create(Task task) {
        em.persist(task);
    }

    @Override
    public void update(Task task) {
        em.merge(task);
    }

    @Override
    public void delete(Long taskId) {
        var task = new Task();
        task.setId(taskId);
        em.remove(task);
    }
}
