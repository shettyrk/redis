package com.nikita.springbootexample3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @OneToOne
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
