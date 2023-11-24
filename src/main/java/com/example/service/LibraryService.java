package com.example.service;

import com.example.model.Library;

import java.util.List;

public interface LibraryService {

    List<Library> findAll();

    Library save(Library library);

    List<Library> findByTitleContains(String filter);





}
