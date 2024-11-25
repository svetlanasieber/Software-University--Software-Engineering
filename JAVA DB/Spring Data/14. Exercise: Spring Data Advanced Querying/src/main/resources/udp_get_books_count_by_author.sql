USE `spring_data_intro`;

DROP PROCEDURE IF EXISTS udp_get_books_count_by_author;

DELIMITER $$
CREATE PROCEDURE udp_get_books_count_by_author(first_name VARCHAR(255), last_name VARCHAR(255))
BEGIN
SELECT COUNT(b.id)
FROM spring_data_intro.books b
JOIN spring_data_intro.authors a ON b.author_id = a.id
WHERE
a.first_name = first_name
AND a.last_name = last_name;
END
$$
DELIMITER ;