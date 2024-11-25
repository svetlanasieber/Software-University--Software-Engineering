package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findTitlesByAgeRestriction(String ageRestriction);

    List<String> findGoldenBooksTitles();

    List<String> findByPriceOutsideOf(BigDecimal loweBound, BigDecimal upperBound);

    List<String> findBookNotReleasedIn(int year);

    List<Book> findBooksReleasedBefore(String input);

    List<String> findNamesWith(String search);

    List<Book> findByAuthorName(String nameEnding);

    int findBookCountByTitleLength(int length);

    BookInfo findBookInfo(String title);

    long updateBookCopiesAfterDate(String date, int count);

    int deleteWithCountLessThan(int minCount);
}
