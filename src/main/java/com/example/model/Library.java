package com.example.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@DiscriminatorColumn(name = "Library")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Setter
public class Library {

    @Id
    @GeneratedValue
    private long Id;

    private String title;


    @JsonBackReference
    @ManyToOne
    private LibraryUser libraryUser;

}
