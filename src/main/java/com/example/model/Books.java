package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Books extends Library{

    public Books(String author){
        this.author = author;
    }




    private String author;
    private String genre;


}
