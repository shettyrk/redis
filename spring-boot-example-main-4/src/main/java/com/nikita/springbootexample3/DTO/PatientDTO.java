package com.nikita.springbootexample3.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDTO {
    private Integer pid;
    private String name;
    private int age;
}
