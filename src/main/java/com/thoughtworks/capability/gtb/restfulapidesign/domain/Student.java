package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Gender gender;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String note;
}
