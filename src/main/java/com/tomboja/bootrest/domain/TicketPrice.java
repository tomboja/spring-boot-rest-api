package com.tomboja.bootrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/30/21
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ticket_prices")
@NamedQuery(
        name = "TicketPrice.namedFindTicketsByPricingCategoryName",
        query = "select tp from TicketPrice tp where tp.pricingCategory.pricingCategoryName = :name"
)
@NamedNativeQuery( // This is treated as native SQL rather than JPQL
        name = "TicketPrice.nativeFindTicketsByCategoryWithWorkshop",
        query = "select tp.* from ticket_prices tp " +
                "left join ticket_types tt on tp.ticket_type_code = tt.ticket_type_code " +
                "left join pricing_categories pc on tp.pricing_category_code = pc.pricing_category_code " +
                "where tt.includes_workshop = true and pc.pricing_category_name = :name",
        resultClass = TicketPrice.class
)
public class TicketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_price_id")
    private Long ticketPriceId;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @ManyToOne // @ManyToOne are Eager loaded
    @JoinColumn(name = "ticket_type_code", nullable = false, updatable = false)
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "pricing_category_code", nullable = false, updatable = false)
    private PricingCategory pricingCategory;
}
