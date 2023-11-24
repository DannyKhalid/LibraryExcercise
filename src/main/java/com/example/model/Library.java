package com.example.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.JOINED)

@Setter
public class Library {

    @Id
    @GeneratedValue
    private long Id;

    private String title;


//    @JsonBackReference
    @ManyToOne
    private LibraryUser libraryUser;

}
