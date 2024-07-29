package com.example.trapecioinv.domain.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String dni;
    private String name;
    private String lastName;
    private String email;
    private int age;
}
