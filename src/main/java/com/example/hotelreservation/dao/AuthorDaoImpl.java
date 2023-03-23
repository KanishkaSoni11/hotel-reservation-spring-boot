package com.example.hotelreservation.dao;


import com.example.hotelreservation.model.Author;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

  private final JdbcTemplate jdbcTemplate;

  public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Author getAuthorFromName(String name) {
    String sql = "select * from author where name = ?";
    return jdbcTemplate.queryForObject(sql,
            new Object[]{ name }, new AuthorRowMapper());
  }

  @Override
  public List<Author> getAllAuthors() {
    String sql = "select * from author;";
    return jdbcTemplate.query(sql,
            new AuthorRowMapper());
  }
}
