package com.tomboja.bootrest.repo;

import com.tomboja.bootrest.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

public interface SessionRepository extends JpaRepository<Session, Long> {

}
