package com.example.service;

import com.example.model.Books;
import com.example.model.Movie;
import com.example.model.Periodicals;


import java.util.List;

public interface LibraryService {

    List<Books> findAll();

    List<Books> findByGenreContains(String filter);




}
