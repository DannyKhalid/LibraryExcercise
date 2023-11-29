package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Librarian {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private int phoneNumber;
    private String email;


}
