package com.upgrad.productapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class EshopOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // number PRIMARY KEY

    @Column
    private double amount;

    @Column
    private LocalDateTime orderDate;


    @JsonBackReference
    @ManyToOne  //foreign key
    private EshopUser eshopUser;

    @JsonBackReference
    @ManyToOne  //foreign key
    private EshopProduct eshopProduct;

    @JsonBackReference
    @ManyToOne  //foreign key
    private EshopShippingAddress eshopShippingAddress;








}
