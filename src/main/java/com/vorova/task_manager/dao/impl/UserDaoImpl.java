package com.vorova.task_manager.dao.impl;

import com.vorova.task_manager.dao.UserDao;
import com.vorova.task_manager.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    public Optional<User> getUserByUsername(String username) {
        try {
            return Optional.of(
                    em.createQuery("FROM User WHERE username = :username", User.class)
                            .setParameter("username", username)
                            .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
