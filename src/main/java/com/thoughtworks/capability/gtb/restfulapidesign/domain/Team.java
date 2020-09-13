package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    Integer teamId;
    String teamName;
    List<Student> studentsList;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String note;
}
