package com.tomboja.bootrest.domain;

import lombok.*;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    private int id;
    private String code;
    private String name;
}
