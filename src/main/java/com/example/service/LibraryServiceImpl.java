package com.example.service;

import com.example.model.Books;
import com.example.model.Lendable;
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
    public List<Lendable> findAll() {
        List<Lendable> libraries = new ArrayList<>();
        Iterable<Lendable> librariesItr = libraryRepo.findAll();
        librariesItr.forEach(libraries::add);
        return libraries;

    }

    @Override
    public List<Lendable> findAllBooks() {
        List<Lendable> books = new ArrayList<>();
        Iterable<Lendable> librariesItr = libraryRepo.findAllBooks();
        librariesItr.forEach(books::add);
        return books;
    }

    @Override
    public List<Lendable> findAllMovies() {
        List<Lendable> movies = new ArrayList<>();
        Iterable<Lendable> librariesItr = libraryRepo.findAllMovies();
        librariesItr.forEach(movies::add);
        return movies;
    }

    @Override
    public List<Lendable> findAllPeriodicals() {
        List<Lendable> periodicals = new ArrayList<>();
        Iterable<Lendable> librariesItr = libraryRepo.findAllPeriodicals();
        librariesItr.forEach(periodicals::add);
        return periodicals;
    }

    @Override
    public Lendable save(Lendable library) {
        return libraryRepo.save(library);
    }

    @Override
    public List<Lendable> findByTitleContains(String filter) {
        return libraryRepo.findByTitleContains(filter);
    }

    @Override
    public List<Lendable> findByAuthorContains(String author) {
        return libraryRepo.findByAuthorContains(author);
    }

    @Override
    public List<Lendable> findByTitleContainsBooks(String filter) {
        return libraryRepo.bookFindByTitleContains(filter);
    }

    @Override
    public List<Lendable> movieFindByTitleContains(String filter) {
        return libraryRepo.movieFindByTitleContains(filter);
    }

    @Override
    public List<Lendable> periodicalsFindByTitleContains(String filter) {
        return libraryRepo.periodicalsFindByTitleContains(filter);
    }

    @Override
    public void delete(long id) {
        libraryRepo.deleteById(id);
    }


    @Override
    public Books findBooksById(long id) {
        Optional<Lendable> library = libraryRepo.findById(id);
        if (library.isPresent() && library.get() instanceof Books) {
            return (Books) library.get();
        } else {return new Books("Nothing found");

        }
    }



    @Override
    public Movie findMovieById(long id) {
        Optional<Lendable> library = libraryRepo.findById(id);
        if (library.isPresent() && library.get() instanceof Movie) {
            return (Movie) library.get();
        } else {return new Movie("Nothing found");

        }
    }


    @Override
    public Periodicals findPeriodicalsById(long id) {
        Optional<Lendable> library = libraryRepo.findById(id);
        if (library.isPresent() && library.get() instanceof Periodicals) {
            return (Periodicals) library.get();
        } else {return new Periodicals("Nothing found");

        }
    }
}
