package com.tomboja.bootrest.repo;

import com.tomboja.bootrest.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

public interface SessionRepository extends JpaRepository<Session, Long> {

    //@Query("select s from sessions s where s.sessionName like concat('%', ?1, '%')")
    public List<Session> findBySessionNameContains(String sessionName);

    // Find sessions with a given length
    // THE FOLLOWING 3 MEAN THE SAME THING
    //@Query("select s from sessions s where s.sessionLength = ?1")
    public List<Session> findBySessionLength(Integer sessionLength);
    public List<Session> findBySessionLengthIs(Integer sessionLength);
    public List<Session> findBySessionLengthEquals(Integer sessionLength);

    // Opposite of the above
    //@Query("select s from sessions s where s.sessionLength <> ?1")
    public List<Session> findBySessionLengthNot(Integer sessionLength);

    //@Query("select s from sessions s where s.sessionName like ?1")
    public List<Session> findBySessionNameLike(String str);

    //@Query("select s from sessions s where s.sessionName not like ?1")
    public List<Session> findBySessionNameNotLike(String str);

    // The following three have exactly the same meaning
    //@Query("select s from sessions s where s.sessionName like concat(?1, '%')")
    public List<Session> findBySessionNameStartingWith(String str);
    public List<Session> findBySessionNameStartsWith(String str);
    public List<Session> findBySessionNameIsStartingWith(String str);


}
