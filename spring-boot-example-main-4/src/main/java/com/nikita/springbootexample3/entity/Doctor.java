package com.nikita.springbootexample3.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Doctor")
@Setter
@Getter
public class Doctor implements Serializable{
    @Id
    private Integer did;
    private String dname;
    private String specs;
}
