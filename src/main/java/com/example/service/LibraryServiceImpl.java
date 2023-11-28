package com.example.service;

import com.example.model.Books;
import com.example.model.Library;
import com.example.model.Movie;
import com.example.model.Periodicals;
import com.example.repository.LibraryRepo;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<Library> findAllBooks() {
        List<Library> books = new ArrayList<>();
        Iterable<Library> librariesItr = libraryRepo.findAllBooks();
        librariesItr.forEach(books::add);
        return books;
    }

    @Override
    public List<Library> findAllMovies() {
        List<Library> movies = new ArrayList<>();
        Iterable<Library> librariesItr = libraryRepo.findAllMovies();
        librariesItr.forEach(movies::add);
        return movies;
    }

    @Override
    public List<Library> findAllPeriodicals() {
        List<Library> periodicals = new ArrayList<>();
        Iterable<Library> librariesItr = libraryRepo.findAllPeriodicals();
        librariesItr.forEach(periodicals::add);
        return periodicals;
    }

    @Override
    public Library save(Library library) {
        return libraryRepo.save(library);
    }

    @Override
    public List<Library> findByTitleContains(String filter) {
        return libraryRepo.findByTitleContains(filter);
    }

    @Override
    public List<Library> findByTitleContainsBooks(String filter) {
        return libraryRepo.bookFindByTitleContains(filter);
    }

    @Override
    public List<Library> movieFindByTitleContains(String filter) {
        return libraryRepo.movieFindByTitleContains(filter);
    }

    @Override
    public List<Library> periodicalsFindByTitleContains(String filter) {
        return libraryRepo.periodicalsFindByTitleContains(filter);
    }

    @Override
    public void delete(long id) {
        libraryRepo.deleteById(id);
    }

//    @Override
//    public Library findById(long id) {
//        Optional<Library> books = libraryRepo.findById(id);
//        return (Books) books.orElseGet(() -> new Books("Nothing found"));
//    }

    @Override
    public Books findBooksById(long id) {
        Optional<Library> library = libraryRepo.findById(id);
        if (library.isPresent() && library.get() instanceof Books) {
            return (Books) library.get();
        } else {return new Books("Nothing found");

        }
    }



    @Override
    public Movie findMovieById(long id) {
        Optional<Library> library = libraryRepo.findById(id);
        if (library.isPresent() && library.get() instanceof Movie) {
            return (Movie) library.get();
        } else {return new Movie("Nothing found");

        }
    }


    @Override
    public Periodicals findPeriodicalsById(long id) {
        Optional<Library> library = libraryRepo.findById(id);
        if (library.isPresent() && library.get() instanceof Periodicals) {
            return (Periodicals) library.get();
        } else {return new Periodicals("Nothing found");

        }
    }
}
