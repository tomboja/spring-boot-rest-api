package com.tomboja.bootrest.controller;

import com.tomboja.bootrest.domain.Session;
import com.tomboja.bootrest.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> list() {
        return sessionRepository.findAll();
    }

    public Session get(@PathVariable Long id) {
        return null;
    }
}
