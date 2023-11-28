package com.example.repository;


import com.example.model.Books;
import com.example.model.Library;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends CrudRepository<Library, Long> {


    List<Library> findByTitleContains(String filter);
    @Query("SELECT b FROM Books b")
    List<Library> findAllBooks();


    @Query("SELECT b FROM Books b where b.title like %?1%")
    List<Library> bookFindByTitleContains(String filter);


    @Query("SELECT m FROM Movie m")
    List<Library> findAllMovies();
    @Query("SELECT m FROM Movie m where m.title like %?1%")
    List<Library> movieFindByTitleContains(String filter);

    @Query("SELECT p FROM Periodicals p")
    List<Library> findAllPeriodicals();
    @Query("SELECT p FROM Periodicals p where p.title like %?1%")
    List<Library> periodicalsFindByTitleContains(String filter);


}
