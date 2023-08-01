package com.nikita.springbootexample3.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Patient implements Serializable{
    @Id
    private Integer pid;
    private String name;
    private int age;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Report> reports;
}
