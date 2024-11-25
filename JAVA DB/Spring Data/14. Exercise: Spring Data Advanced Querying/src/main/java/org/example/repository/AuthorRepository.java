package org.example.repository;

import org.example.model.entity.Author;
import org.example.model.entity.AuthorNamesWithTotalCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findAllByFirstNameLike(String input);

    @Query("SELECT " +
            " a.firstName AS firstName, " +
            " a.lastName AS lastName, " +
            " SUM(b.copies) AS totalCopies" +
            " FROM Author a " +
            " JOIN a.books AS b " +
            " GROUP BY b.author " +
            " ORDER BY totalCopies DESC")
    List<AuthorNamesWithTotalCopies> getWithTotalCopies();

    // @Procedure(name = "udp_get_books_count_by_author")
    @Query(value = "CALL udp_get_books_count_by_author(:first_name, :last_name);", nativeQuery = true)
    int getBooksCountByAuthor(
            @Param("first_name") String firstName,
            @Param("last_name") String lastName);
}
