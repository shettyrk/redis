package com.nikita.springbootexample3.DTO;

import lombok.*;

import java.math.BigInteger;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserActionLogDTO {

    private String id;


    private String email;


    private String type;


    private String action;


    private BigInteger created_timestamp;


    private String message;


    private String status;
}
