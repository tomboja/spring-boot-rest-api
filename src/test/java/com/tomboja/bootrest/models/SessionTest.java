package com.tomboja.bootrest.models;

import com.tomboja.bootrest.domain.Session;
import com.tomboja.bootrest.repo.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/29/21
 */

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;

    @Test
    public void shouldFindSessionsContainingGivenName() {
        List<Session> sessions = repository.findBySessionNameContains("Java");
        assertEquals(10, sessions.size());
    }

    @Test
    public void shouldFindSessionsWithLengthNotEquals() {
        List<Session> sessions = repository.findBySessionLengthNot(20);
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void shouldFindSessionNamesLikeGiven() {
        // For Like queries, there need to be "xxx%", the % at the end or begging
        // or anywhere to find and match the given string.
        List<Session> sessions = repository.findBySessionNameLike("Java%");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void shouldFindSessionsNotLikeGiven() {
        // opposite of the above 'shouldFindSessionNamesLikeGiven'
        List<Session> sessions = repository.findBySessionNameNotLike("Java%");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void shouldReturnPageOfSessions() {
        // get the first page of sessions containing letter `S` in their name
        // and sort them in ascending order with 'sessionLength'
        Page<Session> firstPageSessions = repository
                .getSessionWithName("S",
                        PageRequest
                                .of(1, 5,
                                        Sort.by(Sort.Direction.ASC, "sessionLength")));

        assertTrue(firstPageSessions.getTotalElements() > 0); // Total number of elements returned from db is 27
        assertEquals(5, firstPageSessions.getContent().size());
        assertEquals(6, firstPageSessions.getTotalPages());
    }

    @Test
    public void shouldFindSessionsWithCustomRepository() {
        List<Session> sessions = repository.getCustomSessions();
        System.out.println("sessions.size() = " + sessions.size());
        assertTrue(sessions.size() > 0);
    }
}
