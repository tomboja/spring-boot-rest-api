package com.tomboja.bootrest.repo;

import com.tomboja.bootrest.domain.Session;

import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/31/21
 */

public interface CustomSessionRepository {
    // We can add any custom repository interface we want here, and provide the impl
    // that we want. The following is just an example
    List<Session> getCustomSessions();
}
