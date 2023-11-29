package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
public class Lendable {

    @Id
    @GeneratedValue
    private long Id;

    private String title;



    @ManyToOne
    private LibraryUser libraryUser;


    @ManyToOne
    private Librarian librarian;








}
