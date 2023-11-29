package com.example.repository;


import com.example.model.Lendable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends CrudRepository<Lendable, Long> {


    List<Lendable> findByTitleContains(String filter);
    @Query("SELECT b FROM Books b")
    List<Lendable> findAllBooks();


    @Query("SELECT b FROM Books b where b.title like %?1%")
    List<Lendable> bookFindByTitleContains(String filter);


    @Query("SELECT m FROM Movie m")
    List<Lendable> findAllMovies();
    @Query("SELECT m FROM Movie m where m.title like %?1%")
    List<Lendable> movieFindByTitleContains(String filter);

    @Query("SELECT p FROM Periodicals p")
    List<Lendable> findAllPeriodicals();
    @Query("SELECT p FROM Periodicals p where p.title like %?1%")
    List<Lendable> periodicalsFindByTitleContains(String filter);


}
