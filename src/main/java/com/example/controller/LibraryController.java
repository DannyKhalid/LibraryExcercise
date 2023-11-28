package com.example.controller;

import com.example.model.Books;
import com.example.model.Library;
import com.example.model.Movie;
import com.example.service.LibraryService;
import com.example.service.LibraryUserService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

@RestController
public class LibraryController {

    private final LibraryService libraryService;


    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/library")
    public List<Library> getAllLibraries(@PathParam("filter") String filter) {
        List<Library> libraries = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            libraries = libraryService.findByTitleContains(filter);
        } else {
            libraries = libraryService.findAll();
        }
        return libraries;
    }

    @GetMapping("/books")
    public List<Library> getAllBooks(@PathParam("filter") String filter) {
        List<Library> books = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            books = libraryService.findByTitleContainsBooks(filter);
        } else {
            books = libraryService.findAllBooks();
        }
        return books;
    }

    @GetMapping("/books/{id}")
    public Library getBookById(@PathVariable long id) {

        return libraryService.findBooksById(id);

    }

    @GetMapping("/movies/{id}")
    public Library getMovieById(@PathVariable long id) {

        return libraryService.findMovieById(id);

    }

    @GetMapping("/periodicals/{id}")
    public Library getPeriodicalsById(@PathVariable long id) {

        return libraryService.findPeriodicalsById(id);

    }

    @GetMapping("/movies")
    public List<Library> getAllMovies(@PathParam("filter") String filter) {
        List<Library> movies = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            movies = libraryService.movieFindByTitleContains(filter);
        } else {
            movies = libraryService.findAllMovies();
        }
        return movies;
    }

    @GetMapping("/periodicals")
    public List<Library> getAllPeriodicals(@PathParam("filter") String filter) {
        List<Library> periodicals = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            periodicals = libraryService.findByTitleContainsBooks(filter);
        } else {
            periodicals = libraryService.periodicalsFindByTitleContains(filter);
        }
        return periodicals;
    }

    @PostMapping("/movies")
    public Library createMovie(@RequestBody Movie movie){
        return libraryService.save(movie);
    }

    @PutMapping("/movies")
    public Library updateMovie(@RequestBody Movie movie){
        return libraryService.save(movie);
    }

    @DeleteMapping("movies/{id}")
    public void deleteMovie(@PathVariable long id) {
        libraryService.delete(id);
    }

    @PostMapping("/books")
    public Library createBook(@RequestBody Books books){
        return libraryService.save(books);
    }

    @PutMapping("/books")
    public Library updateBook(@RequestBody Books books){
        return libraryService.save(books);
    }

    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable long id) {
        libraryService.delete(id);
    }



}
