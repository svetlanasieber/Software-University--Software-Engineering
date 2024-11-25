package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByTitle(String title);
    Book getBookByTitle(String title);

    List<Book> findByAgeRestriction(AgeRestriction restriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType type, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

//    List<Book> findByPriceNotBetween(BigDecimal lower, BigDecimal upper);

    List<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findByReleaseDateBefore(LocalDate parsed);

    List<Book> findByAuthorLastNameEndingWith(String ending);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title) > :length")
    int countByTitleSizeGreaterThan(int length);

    BookInfo findByTitle(String title);

    @Query("UPDATE Book AS b SET b.copies = b.copies + :count WHERE b.releaseDate > :parsed")
    @Modifying
    @Transactional
    int updateBookCopiesReleasedAfter(LocalDate parsed, int count);

    @Transactional
    int deleteByCopiesLessThan(int count);

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByTitleContainingIgnoreCase(String search);
}
