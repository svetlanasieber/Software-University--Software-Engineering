package org.example.service;

import org.example.model.entity.Book;
import org.example.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllTitlesByAgeRestriction(String ageRestriction);

    List<String> findAllTitlesByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllTitlesAndPriceBetween(BigDecimal low, BigDecimal high);

    List<String> findTitlesByYearNotIn(int year);

    List<Book> findAllBooksBefore(LocalDate newLocalDate);

    List<String> findAllByTitleLike(String input);

    List<String> findTitlesByAuthorLastNameStartsWith(String input);

    int findBookCountByTitleLengthGreaterThan(int number);

    List<Book> findBookAllByTitleLike(String title);

    int addCopiesToBooksAfter(LocalDate localDate, int number);

    int deleteBooksWithCopiesLessThan(int copies);
}
