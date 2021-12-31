package com.tomboja.bootrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
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
@Table(name = "pricing_categories")
public class PricingCategory {
    @Id
    @Column(name = "pricing_category_code")
    private String pricingCategoryCode;

    @Column(name = "pricing_category_name")
    private String pricingCategoryName;

    @Column(name = "pricing_start_date")
    private Date pricingStartDate;

    @Column(name = "pricing_end_date")
    private Date pricingEndDate;

    @OneToMany(mappedBy = "ticketType")
    @JsonIgnore
    private List<TicketPrice> ticketPrices;
}
