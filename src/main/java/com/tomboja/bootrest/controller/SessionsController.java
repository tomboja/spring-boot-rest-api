package com.tomboja.bootrest.controller;

import com.tomboja.bootrest.domain.Session;
import com.tomboja.bootrest.exceptions.ResourceNotFoundException;
import com.tomboja.bootrest.repo.SessionRepository;
import com.tomboja.bootrest.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    private final SessionService sessionService;

    @GetMapping
    public List<Session> list() {
        return sessionService.listSessions();
    }

    @GetMapping("/{id}")
    public Session get(@PathVariable("id") Long id) {
        return sessionService.getSession(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session saveSession(@RequestBody final Session session) {
        return sessionService.saveSession(session);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return sessionService.deleteSession(id);
    }

    @PutMapping("/{id}")
    public Session update(@PathVariable("id") Long id, @RequestBody Session session) {
        return sessionService.updateSession(id, session);
    }
}
