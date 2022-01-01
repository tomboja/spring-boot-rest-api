package com.tomboja.bootrest.repo;

import com.tomboja.bootrest.domain.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/31/21
 */

public class CustomSessionRepositoryImpl implements CustomSessionRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Session> getCustomSessions() {
        return entityManager
                .createQuery("select s from sessions s where s.speakers.size > 1")
                .getResultList();
    }
}
