package com.example.repository;


import com.example.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends CrudRepository<Library, Long> {


    List<Library> findByTitleContains(String filter);
}
