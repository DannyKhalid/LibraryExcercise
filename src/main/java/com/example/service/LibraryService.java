package com.example.service;

import com.example.model.Books;


import java.util.List;

public interface LibraryService {

    List<Books> findAll();

    List<Books> findByGenreContains(String filter);
}
