package com.example.service;

import com.example.model.LibraryUser;
import com.example.model.Movie;

import java.util.List;

public interface LibraryUserService {

    LibraryUser save(LibraryUser libraryUser);

    LibraryUser findById(long id);


    List<LibraryUser> findByNameContains(String filter);

    List<LibraryUser> findAll();
}
