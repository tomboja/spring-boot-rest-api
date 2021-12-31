package com.tomboja.bootrest.repo;

import com.tomboja.bootrest.domain.TicketPrice;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/30/21
 */

public interface TicketPriceRepository extends JpaRepository<TicketPrice, Long> {

    // Can be written in JPQL in either of the following
    // @Query("select t from TicketPrice t where t.basePrice < :price " +
    //        "and t.ticketType.includesWorkshop")
    @Query("select t from TicketPrice t where t.basePrice < :price " +
            "and t.ticketType.includesWorkshop = true")
    List<TicketPrice> getTicketPricesUnderPriceWithWorkshops(@Param("price") BigDecimal price);

    // Using names query defined on the entity, we don't need to write the JPQL
    // for the repository method. NOTE: Jpql for this is defined in the Entity
    List<TicketPrice> namedFindTicketsByPricingCategoryName(@Param("name") String name);

    // This is a NATIVE named query: meaning it definition is regarded as SQL rather than JPQL
    List<TicketPrice> nativeFindTicketsByCategoryWithWorkshop(@Param("name") String name);

    // @Modifying - try updating with this
}
