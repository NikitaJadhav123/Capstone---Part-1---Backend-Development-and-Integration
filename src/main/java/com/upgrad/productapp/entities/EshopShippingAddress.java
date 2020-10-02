package com.upgrad.productapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class EshopShippingAddress {

   @Column
   private String city;

   @Column
   private String landmark; //VARCHAR2(100) NOT NULL,

    @Column
   private String name; //varCHAR2(50)	NOT NULL,

    @Column
   private String phone;	//varCHAR2(50) NOT NULL,

    @Column
   private String state; // varchar2(50) NOT NULL,

    @Column
   private String street; // varchar2(50) NOT NULL,

    @Column
   private String zipcode; // varchar2(50) NOT NULL,


    @JsonBackReference
    @ManyToOne  //FOREIGN KEY
   private EshopUser user; // number NOT NULL,

    @OneToMany(mappedBy = "eshopShippingAddress" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<EshopOrder> orders;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id; // number PRIMARY KEY,
}
