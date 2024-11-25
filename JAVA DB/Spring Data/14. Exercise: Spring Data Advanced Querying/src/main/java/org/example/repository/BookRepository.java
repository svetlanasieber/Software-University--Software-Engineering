package org.example.repository;

import org.example.model.entity.AgeRestriction;
import org.example.model.entity.Book;
import org.example.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    // List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    @Query("SELECT b.title " +
            " FROM Book b " +
            " WHERE b.editionType LIKE :editionType " +
            " AND b.copies <= :copies")
    List<String> findAllTitlesByEditionTypeAndCopiesLessThan(
            @Param("editionType") EditionType editionType,
            @Param("copies") int copies);

    @Query("SELECT b " +
            " FROM Book b " +
            " WHERE b.price NOT BETWEEN :low AND :high")
    List<Book> findAllBooksWithPriceNotBetween(
            @Param("low") BigDecimal low,
            @Param("high") BigDecimal high);

    @Query("SELECT b.title " +
            " FROM Book b " +
            " WHERE YEAR(b.releaseDate) != :year")
    List<String> findTitlesByYearNotIn(
            @Param("year") int year);

    List<Book> findAllByReleaseDateBefore(LocalDate newLocalDate);


    @Query("SELECT b.title " +
            " FROM Book b " +
            " WHERE b.title LIKE :input")
    List<String> findTitlesLike(
            @Param("input") String input);

    @Query("SELECT b.title, b.author.lastName " +
            " FROM Book b " +
            " WHERE b.author.lastName LIKE :input")
    List<String> findTitlesByAuthorLastNameStartsWith(
            @Param("input") String input);

    @Query("SELECT COUNT(b) " +
            " FROM Book b " +
            " WHERE LENGTH(b.title) > :number")
    int findBookCountByTitleLengthGreaterThan(
            @Param("number") int number);

    List<Book> findBookByTitleLike(String title);

    @Modifying
    @Transactional
    @Query("UPDATE Book b " +
            " SET b.copies = b.copies + :number " +
            " WHERE b.releaseDate > :localDate")
    int addCopiesToBooksAfter(
            @Param("localDate") LocalDate localDate,
            @Param("number") int number);

    @Transactional
        // If I use the @Query("DELETE ...") I will have to use @Modifying as well
    int deleteByCopiesLessThan(int copies);
}
