package com.example.service;

import com.example.model.Books;
import com.example.model.Library;
import com.example.model.Movie;
import com.example.model.Periodicals;

import java.util.List;

public interface LibraryService {

    List<Library> findAll();

    List<Library> findAllBooks();

    List<Library> findAllMovies();

    List<Library> findAllPeriodicals();

    Library save(Library library);

    List<Library> findByTitleContains(String filter);


    List<Library> findByTitleContainsBooks(String filter);

    List<Library> movieFindByTitleContains(String filter);

    List<Library> periodicalsFindByTitleContains(String filter);


    void delete(long id);

    Books findBooksById(long id);

    Movie findMovieById(long id);

    Periodicals findPeriodicalsById(long id);
}
