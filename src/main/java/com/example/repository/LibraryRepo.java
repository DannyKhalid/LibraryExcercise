package com.example.repository;


import com.example.model.Books;
import com.example.model.Library;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends CrudRepository<Library, Long> {


    List<Library> findByTitleContains(String filter);
    @Query("SELECT b FROM Books b")
    List<Library> findAllBooks();
    @Query("SELECT b FROM Books b")
    List<Library> bookFindByTitleContains(String filter);


    @Query("SELECT b FROM Movie b")
    List<Library> findAllMovies();
    @Query("SELECT b FROM Movie b")
    List<Library> movieFindByTitleContains(String filter);

    @Query("SELECT b FROM Periodicals b")
    List<Library> findAllPeriodicals();
    @Query("SELECT b FROM Periodicals b")
    List<Library> periodicalsFindByTitleContains(String filter);


}
