package org.example.service;

import org.example.model.entity.Author;
import org.example.model.entity.AuthorNamesWithTotalCopies;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<Author> findAllByNameLike(String input);

    List<AuthorNamesWithTotalCopies> getWithTotalCopies();

    int getBooksCountByAuthor(String firstName, String lastName);
}
