package com.example.repository;

import com.example.model.Books;
import com.example.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    List<Movie> findByGenreContains(String filter);

    List<Movie> findByDirector(String director);

}
