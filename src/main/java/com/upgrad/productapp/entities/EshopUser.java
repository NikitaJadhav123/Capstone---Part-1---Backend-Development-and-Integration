package com.upgrad.productapp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class EshopUser {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;   //	PRIMARY KEY  // min,max validation automatically



    @Column
    private LocalDateTime created;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column //do not mention it varchar.char
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNo;

    @Column
    private String role;

    @Column
    private LocalDateTime updated;

    @Column(nullable = false)
    private String userName;

    public EshopUser(){

    }

    public EshopUser(LocalDateTime created,String email, String firstName, String lastName, String password, String phoneNo, String role, LocalDateTime updated, String userName) {
       // this.id = id;
        this.created = created;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.role = role;
        this.updated = updated;
        this.userName = userName;
    }
}