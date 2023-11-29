package com.example.controller;

import com.example.model.Lendable;
import com.example.model.LibraryUser;
import com.example.service.LibraryUserService;
import jakarta.websocket.server.PathParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class LibraryUserController {
    private final LibraryUserService libraryUserService;

    public LibraryUserController(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }


    @GetMapping("/users")
    public List<LibraryUser> getAllUsers(@PathParam("filter") String filter) {
        List<LibraryUser> users = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            users = libraryUserService.findByNameContains(filter);
        } else {
            users = libraryUserService.findAll();
        }
        return users;
    }

    @GetMapping("/users/{id}")
    public LibraryUser getUserById(@PathVariable long id) {
        return libraryUserService.findById(id);

    }



}
