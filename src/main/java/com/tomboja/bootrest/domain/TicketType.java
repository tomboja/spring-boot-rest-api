package com.tomboja.bootrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/30/21
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_types")
public class TicketType {
    @Id
    @Column(name = "ticket_type_code")
    private String ticketTypeCode;

    @Column(name = "ticket_type_name")
    private String ticketTypeName;

    @Column(name = "description")
    private String description;

    @Column(name = "includes_workshop")
    private Boolean includesWorkshop;

    @OneToMany(mappedBy = "ticketType")
    @JsonIgnore
    private List<TicketPrice> ticketPrices;
}
