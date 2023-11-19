package com.example.repository;


import com.example.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends CrudRepository<Books, Integer> {
    List<Books> findByGenreContains(String filter);
}
