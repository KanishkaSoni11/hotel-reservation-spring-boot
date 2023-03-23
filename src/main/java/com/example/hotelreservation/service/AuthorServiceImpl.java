package com.example.hotelreservation.service;


import com.example.hotelreservation.dao.AuthorDao;
import com.example.hotelreservation.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

  @Autowired
  private AuthorDao authorDao;


  @Override
  public List<Author> getAllAuthors() {
    return authorDao.getAllAuthors();
  }

  @Override
  public Author getAuthorByName(String name) {
    return authorDao.getAuthorFromName(name);
  }
}
