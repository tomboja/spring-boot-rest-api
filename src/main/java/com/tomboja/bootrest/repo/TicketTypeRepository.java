package com.tomboja.bootrest.repo;

import com.tomboja.bootrest.domain.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/30/21
 */

public interface TicketTypeRepository extends JpaRepository<TicketType, String> {

    //@Query("select t from TicketType t where t.includesWorkshop = true")
    public List<TicketType> findByIncludesWorkshopTrue();
    public List<TicketType> findByIncludesWorkshopIsTrue();

    //@Query("select t from TicketType t where t.includesWorkshop = false")
    public List<TicketType> findByIncludesWorkshopFalse();
    public List<TicketType> findByIncludesWorkshopIsFalse();



}
