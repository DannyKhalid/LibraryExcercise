package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String leadActor;
    private String director;
    private String screenWriter;
    private String releaseDate;
    private String genre;
    private int Rating;


    @OneToOne(cascade = CascadeType.PERSIST)
    private AppUsers appUsers;
}
