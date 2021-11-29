package com.tomboja.bootrest.service;

import com.tomboja.bootrest.domain.Session;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

@Service
public interface SessionService {
    public List<Session> list();
    public  Session get(Long id);
    public Session create(final Session session);
}
