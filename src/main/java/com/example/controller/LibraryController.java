package com.example.controller;

import com.example.model.Library;
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

    @GetMapping("/library")
    public List<Library> getAllLibraries(@PathParam("filter") String filter) {
        List<Library> libraries = Collections.emptyList();
        if (StringUtils.isNoneBlank(filter)) {
            libraries = libraryService.findByTitleContains(filter);
        } else {
            libraries = libraryService.findAll();
        }
        return libraries;
    }
}
