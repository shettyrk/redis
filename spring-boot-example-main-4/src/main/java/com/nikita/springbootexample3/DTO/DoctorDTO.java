package com.nikita.springbootexample3.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorDTO {
    private Integer did;
    private String dname;
    private String specs;
}
