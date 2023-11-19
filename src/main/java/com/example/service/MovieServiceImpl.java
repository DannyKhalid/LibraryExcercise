package com.example.service;


import com.example.model.Movie;
import com.example.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {

        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> movie = movieRepository.findAll();
        movie.forEach(movies::add);
        return movies;
    }

    @Override
    public List<Movie> findByGenreContains(String filter) {
        return movieRepository.findByGenreContains(filter);
    }

    @Override
    public  List<Movie> findByDirector(String director){
        return movieRepository.findByDirector(director);

    }
}
