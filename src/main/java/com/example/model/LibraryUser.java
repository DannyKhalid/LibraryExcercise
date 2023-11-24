package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class LibraryUser {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String address;
    private int phoneNumber;
    private String email;

    @JsonBackReference
    @OneToMany(mappedBy = "libraryUser")
    List<Library> libraries;
}
