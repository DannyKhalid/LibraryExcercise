package com.example.service;

import com.example.model.Books;
import com.example.repository.LibraryRepo;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepo libraryRepo;

    public LibraryServiceImpl(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }


    @Override
    public List<Books> findAll() {

        List<Books> libraries = new ArrayList<>();
        Iterable<Books> messageIts = libraryRepo.findAll();
        messageIts.forEach(libraries::add);

        return libraries;

    }

    @Override
    public List<Books> findByGenreContains(String filter) {
      return libraryRepo.findByGenreContains(filter);

    }
}
