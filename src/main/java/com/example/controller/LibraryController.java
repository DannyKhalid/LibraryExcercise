package com.example.controller;

import com.example.model.Books;
import com.example.model.Lendable;
import com.example.model.Movie;
import com.example.model.Periodicals;
import com.example.service.LibraryService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class LibraryController {

    private final LibraryService libraryService;


    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/library")
    public List<Lendable> getAllLibraries(@PathParam("filter") String filter) {
        List<Lendable> libraries = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            libraries = libraryService.findByTitleContains(filter);
        }
        if (StringUtils.isNoneBlank((filter))){
            libraries = libraryService.findByAuthorContains(filter);
        }
        else {
            libraries = libraryService.findAll();
        }
        return libraries;
    }

    @GetMapping("/books")
    public List<Lendable> getAllBooks(@PathParam("filter") String filter) {
        List<Lendable> books = Collections.emptyList();
        log.debug(filter);
        if (StringUtils.isNoneBlank(filter)) {
            books = libraryService.findByTitleContainsBooks(filter);
        } else {
            books = libraryService.findAllBooks();
        }
        return books;
    }

    @GetMapping("/books/{id}")
    public Lendable getBookById(@PathVariable long id) {

        return libraryService.findBooksById(id);

    }

    @GetMapping("/movies/{id}")
    public Lendable getMovieById(@PathVariable long id) {

        return libraryService.findMovieById(id);

    }

    @GetMapping("/periodicals/{id}")
    public Lendable getPeriodicalsById(@PathVariable long id) {

        return libraryService.findPeriodicalsById(id);

    }

    @GetMapping("/movies")
    public List<Lendable> getAllMovies(@PathParam("filter") String filter) {
        List<Lendable> movies = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            movies = libraryService.movieFindByTitleContains(filter);
        } else {
            movies = libraryService.findAllMovies();
        }
        return movies;
    }

    @GetMapping("/periodicals")
    public List<Lendable> getAllPeriodicals(@PathParam("filter") String filter) {
        List<Lendable> periodicals = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            periodicals = libraryService.periodicalsFindByTitleContains(filter);
        } else {
            periodicals = libraryService.findAllPeriodicals();
        }
        return periodicals;
    }

    @PostMapping("/movies")
    public Lendable createMovie(@RequestBody Movie movie){
        return libraryService.save(movie);
    }

    @PutMapping("/movies")
    public Lendable updateMovie(@RequestBody Movie movie){
        return libraryService.save(movie);
    }

    @DeleteMapping("movies/{id}")
    public void deleteMovie(@PathVariable long id) {
        libraryService.delete(id);
    }

    @PostMapping("/books")
    public Lendable createBook(@RequestBody Books books){
        return libraryService.save(books);
    }

    @PutMapping("/books")
    public Lendable updateBook(@RequestBody Books books){
        return libraryService.save(books);
    }

    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable long id) {
        libraryService.delete(id);
    }

    @PostMapping("/periodicals")
    public Lendable createPeriodical(@RequestBody Periodicals periodicals){
        return libraryService.save(periodicals);
    }

    @PutMapping("/periodicals")
    public Lendable updatePeriodical(@RequestBody Periodicals periodicals){
        return libraryService.save(periodicals);
    }

    @PutMapping("/periodicals/{id}")
    public Lendable updatePeriodicalId(@RequestBody Periodicals periodicals){
        return libraryService.save(periodicals);
    }

    @DeleteMapping("periodicals/{id}")
    public void deletePeriodical(@PathVariable long id) {
        libraryService.delete(id);
    }



}
