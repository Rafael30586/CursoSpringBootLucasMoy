package com.f_rafael.customers.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
}
