package com.example.hotelreservation.service;


import com.example.hotelreservation.model.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> getAllAuthors();

    public Author getAuthorByName(String name);
}
