package com.example.hotelreservation.controller;


import com.example.hotelreservation.model.Author;
import com.example.hotelreservation.service.AuthorService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private static final Logger logger = LogManager.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        logger.error("Fetching all authors");
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{name}")
    public Author getAuthorByName(String name) {
        try {
            logger.info("Fetching all authors " + name);
            return authorService.getAuthorByName(name);
        } catch(Exception e) {
            logger.error("No author found");
            return null;
        }
    }

}
