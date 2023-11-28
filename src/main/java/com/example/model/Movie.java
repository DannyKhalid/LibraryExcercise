package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Movie extends Library{



    private String leadActor;
    private String director;
    private String screenWriter;
    private String releaseDate;
    private int Rating;
    private String genre;

    public Movie(String genre){
        this.genre = genre;
    }

}
