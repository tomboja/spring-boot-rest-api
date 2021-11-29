package com.tomboja.bootrest.service;

import com.tomboja.bootrest.domain.Session;
import com.tomboja.bootrest.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @Override
    public Session get(Long id) {
        return null;
    }

    @Override
    public Session create(Session session) {
        return null;
    }
}
