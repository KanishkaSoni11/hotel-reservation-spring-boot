package com.example.hotelreservation.dao;


import com.example.hotelreservation.model.Author;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

  @Override
  public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
    Author author = new Author();
    author.setName(rs.getString("name"));
    author.setBooksWritten(rs.getInt("books_written"));
    return author;
  }
}
