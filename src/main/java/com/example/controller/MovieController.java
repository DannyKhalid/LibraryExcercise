package com.example.controller;

import com.example.model.Books;
import com.example.model.Movie;
import com.example.service.MovieService;
import jakarta.websocket.server.PathParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllBooks(@PathParam("filter") String filter) {
        List<Movie> movies = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            movies = movieService.findByGenreContains(filter);
        } else {
            movies = movieService.findAll();
        }
        return movies;
    }

    @GetMapping("/movies/search")
    public List<Movie> searchByDirector(@PathParam("director") String director) {
        return movieService.findByDirector(director);
    }


}
