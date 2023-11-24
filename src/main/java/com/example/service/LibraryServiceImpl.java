package com.example.service;

import com.example.model.Library;
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
    public List<Library> findAll() {
        List<Library> libraries = new ArrayList<>();
        Iterable<Library> librariesItr = libraryRepo.findAll();
        librariesItr.forEach(libraries::add);
        return libraries;

    }

    @Override
    public Library save(Library library) {
        return libraryRepo.save(library);
    }

    @Override
    public List<Library> findByTitleContains(String filter) {
        return libraryRepo.findByTitleContains(filter);
    }
}
