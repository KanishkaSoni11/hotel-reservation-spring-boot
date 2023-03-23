package com.example.hotelreservation.dao;


import com.example.hotelreservation.model.Author;

import java.util.List;

public interface AuthorDao {

    public Author getAuthorFromName(String name);

    public List<Author> getAllAuthors();

}
