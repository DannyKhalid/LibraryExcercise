package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Periodicals extends Library {



    private String publicationDate;

    public Periodicals(String publicationDate){
        this.publicationDate = publicationDate;
    }

}
