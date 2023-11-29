package com.example.service;


import com.example.model.LibraryUser;
import com.example.repository.LibraryUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryUserImpl implements LibraryUserService {

    private final LibraryUserRepository libraryUserRepository;

    public LibraryUserImpl(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }


    @Override
    public LibraryUser save(LibraryUser libraryUser) {
        return libraryUserRepository.save(libraryUser);
    }

    @Override
    public LibraryUser findById(long id) {
        return libraryUserRepository.findById(id).orElse(new LibraryUser(""));
    }

    @Override
    public List<LibraryUser> findByNameContains(String filter) {
        return libraryUserRepository.findByNameContains(filter);
    }

    @Override
    public List<LibraryUser> findAll() {
        List<LibraryUser> users = new ArrayList<>();
        Iterable<LibraryUser> librariesItr = libraryUserRepository.findAll();
        librariesItr.forEach(users::add);
        return users;
    }


}
