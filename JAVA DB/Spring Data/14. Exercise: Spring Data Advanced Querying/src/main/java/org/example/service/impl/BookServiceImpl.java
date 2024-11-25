package org.example.service.impl;

import org.example.model.entity.*;
import org.example.repository.BookRepository;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");
                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository.findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllTitlesByAgeRestriction(String ageRestriction) {
        AgeRestriction restriction = AgeRestriction.valueOf(ageRestriction);
        return this.bookRepository.findByAgeRestriction(restriction)
                .stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllTitlesByEditionTypeAndCopiesLessThan(EditionType editionType, int copies) {
        return this.bookRepository.findAllTitlesByEditionTypeAndCopiesLessThan(editionType, copies);
    }

    @Override
    public List<Book> findAllTitlesAndPriceBetween(BigDecimal low, BigDecimal high) {
        return this.bookRepository.findAllBooksWithPriceNotBetween(low, high);
    }

    @Override
    public List<String> findTitlesByYearNotIn(int year) {
        return this.bookRepository.findTitlesByYearNotIn(year);
    }

    @Override
    public List<Book> findAllBooksBefore(LocalDate newLocalDate) {
        return this.bookRepository.findAllByReleaseDateBefore(newLocalDate);
    }

    @Override
    public List<String> findAllByTitleLike(String input) {
        return this.bookRepository.findTitlesLike(input);
    }

    @Override
    public List<String> findTitlesByAuthorLastNameStartsWith(String input) {
        return this.bookRepository.findTitlesByAuthorLastNameStartsWith(input);
    }

    @Override
    public int findBookCountByTitleLengthGreaterThan(int number) {
        return this.bookRepository.findBookCountByTitleLengthGreaterThan(number);
    }

    @Override
    public List<Book> findBookAllByTitleLike(String title) {
        return this.bookRepository.findBookByTitleLike(title);
    }

    @Override
    public int addCopiesToBooksAfter(LocalDate localDate, int number) {
        return this.bookRepository.addCopiesToBooksAfter(localDate, number);
    }

    @Override
    public int deleteBooksWithCopiesLessThan(int copies) {
        return this.bookRepository.deleteByCopiesLessThan(copies);
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);
    }
}
