package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("Books")
@NoArgsConstructor
@Entity
public class Books extends Library{




    private String author;
    private String genre;


}
