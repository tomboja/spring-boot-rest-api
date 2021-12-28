package com.tomboja.bootrest.service;

import com.tomboja.bootrest.domain.Session;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

public interface SessionService {
    public List<Session> listSessions();

    public Session getSession(Long id);

    public Session saveSession(final Session session);

    public boolean deleteSession(Long id);

    public Session updateSession(Long id, Session session);
}
