package com.example.controller;

import com.example.model.Books;
import com.example.service.LibraryService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class LibraryController {

    private final LibraryService libraryService;


    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public List<Books> getAllBooks(@PathParam("filter") String filter) {
        List<Books> books = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            books = libraryService.findByGenreContains(filter);
        } else {
            books= libraryService.findAll();
        }
        return books;
    }
}
