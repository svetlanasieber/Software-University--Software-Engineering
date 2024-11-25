package com.example.springintro.service.impl;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorCopies;
import com.example.springintro.model.entity.Book;
import com.example.springintro.repository.AuthorRepository;
import com.example.springintro.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(row -> {
                    String[] fullName = row.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1,
                        authorRepository.count() + 1);

        return authorRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<String> getAllAuthorsOrderByCountOfTheirBooks() {
        return authorRepository
                .findAllByBooksSizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllNamesEndingWith(String ending) {
        List<Author> authors = authorRepository.findByFirstNameEndingWith(ending);

        return authors.stream()
            .map(a -> String.format("%s %s", a.getFirstName(), a.getLastName()))
            .toList();

    }

    @Override
    public List<String> getAllByBookCopiesCount() {
        List<Author> all = authorRepository.findAll();

        Map<String, Integer> copiesByAuthor = new HashMap<>();
        for (Author author : all) {
            String key = author.getFirstName() + " " + author.getLastName();

            int copies = author.getBooks()
                    .stream()
                    .mapToInt(Book::getCopies)
                    .sum();

            copiesByAuthor.put(key, copies);
        }

        return copiesByAuthor
            .entrySet()
            .stream()
            .sorted((l, r) -> r.getValue() - l.getValue())
            .map(e -> String.format("%s - %d", e.getKey(), e.getValue()))
            .toList();
    }

    @Override
    public List<String> getAllByBookCopiesCountClever() {
        List<AuthorCopies> result = authorRepository.findAuthorsByBookCopiesCount();

        return List.of();
    }

    @Override
    public int findBookCountForAuthor(String firstName, String lastName) {
        int bookCount = authorRepository.findBookCount(firstName, lastName);

        return 0;
    }
}
