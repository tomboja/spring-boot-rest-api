package com.tomboja.bootrest.service;

import com.tomboja.bootrest.domain.Session;
import com.tomboja.bootrest.exceptions.ResourceNotFoundException;
import com.tomboja.bootrest.repo.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 11/27/21
 */
@Service
@Transactional
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public List<Session> listSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public Session getSession(Long id) {
        return sessionRepository.getById(id);
    }

    @Override
    public Session saveSession(Session session) {
        /**
         * This returns list of session objects which in-turn is handed
         * to Jackson by spring mvc to be serialized and converted to JSON
         * to be returned to the caller.
         *
         * Jackson is a serialization library
         */
        return sessionRepository.saveAndFlush(session);
    }

    @Override
    public boolean deleteSession(Long id) {
        Optional<Session> session = Optional.ofNullable(sessionRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Session", "Id", id, "DELETE")));
        if (session.isEmpty())
            return false;
        sessionRepository.deleteById(id);
        return true;
    }

    @Override
    public Session updateSession(Long id, Session session) {
        Optional<Session> existingSession = Optional.ofNullable(sessionRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Session", "Id", id, "DELETE")));
        if (existingSession.isPresent()) {
            BeanUtils.copyProperties(session, existingSession.get(), "session_id");
            return sessionRepository.saveAndFlush(existingSession.get());
        } else return null;
    }
}
