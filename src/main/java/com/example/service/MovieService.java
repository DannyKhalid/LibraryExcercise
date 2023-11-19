package com.example.service;

import com.example.model.Books;
import com.example.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    List<Movie> findByGenreContains(String filter);


    List<Movie> findByDirector(String director);
}
