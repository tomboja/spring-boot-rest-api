package com.tomboja.bootrest.models;

import com.tomboja.bootrest.domain.TicketPrice;
import com.tomboja.bootrest.repo.TicketPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/30/21
 */

@SpringBootTest
public class TicketPriceTest {
    @Autowired
    private TicketPriceRepository repository;

    @Test
    public void shouldFindTicketPricesUnderGivenMaxWithWorkshop() {
        List<TicketPrice> ticketPrices = repository
                .getTicketPricesUnderPriceWithWorkshops(BigDecimal.valueOf(1000));
        assertEquals(1, ticketPrices.size());
    }

    @Test // namedFindTicketsByPricingCategoryName
    public void shouldFindTicketsByPriceCategoryName() {
        List<TicketPrice> regularTickets = repository
                .namedFindTicketsByPricingCategoryName("Regular");

        assertEquals(3, regularTickets.size());
    }

    @Test // nativeFindTicketsByCategoryWithWorkshop
    public void shouldFindTicketsByCategoryWithWorkshop() {
        List<TicketPrice> ticketPrices = repository
                .nativeFindTicketsByCategoryWithWorkshop("Regular");
        System.out.println("ticketPrices.size() = " + ticketPrices.size());
        assertEquals(1, ticketPrices.size());
    }
}
