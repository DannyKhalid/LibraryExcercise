package com.example.repository;


import com.example.model.LibraryUser;
import com.example.model.Movie;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, Long> {

    List<LibraryUser> findByNameContains(String filter);
}
