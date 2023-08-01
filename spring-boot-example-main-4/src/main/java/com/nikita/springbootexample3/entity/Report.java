package com.nikita.springbootexample3.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@ToString
@Entity
public class Report implements Serializable{
    @Id
    private Integer id;
    private String test;
    private String status;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "did")
    private Doctor doctor;

    public Report(Integer id, String test, String status, Patient temp1, Doctor temp) {
        this.id = id;
        this.test = test;
        this.status = status;
    }
}
