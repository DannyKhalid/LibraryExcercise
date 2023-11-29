package com.example.service;

import com.example.model.Books;
import com.example.model.Lendable;
import com.example.model.Movie;
import com.example.model.Periodicals;

import java.util.List;

public interface LibraryService {

    List<Lendable> findAll();

    List<Lendable> findAllBooks();

    List<Lendable> findAllMovies();

    List<Lendable> findAllPeriodicals();

    Lendable save(Lendable library);

    List<Lendable> findByTitleContains(String filter);


    List<Lendable> findByTitleContainsBooks(String filter);

    List<Lendable> movieFindByTitleContains(String filter);

    List<Lendable> periodicalsFindByTitleContains(String filter);


    void delete(long id);

    Books findBooksById(long id);

    Movie findMovieById(long id);

    Periodicals findPeriodicalsById(long id);
}
