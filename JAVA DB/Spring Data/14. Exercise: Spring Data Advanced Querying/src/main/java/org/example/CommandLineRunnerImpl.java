package org.example;

import org.example.model.entity.Book;
import org.example.model.entity.EditionType;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Please select exercise:");
        Scanner scanner = new Scanner(System.in);
        int exercise = Integer.parseInt(scanner.nextLine());
        switch (exercise) {
            case 1 -> booksTitlesByAgeRestriction01(scanner);
            case 2 -> goldenBooks02();
            case 3 -> booksByPrice03();
            case 4 -> notReleasedBooks04(scanner);
            case 5 -> booksReleasedBeforeDate05(scanner);
            case 6 -> authorsSearch06(scanner);
            case 7 -> booksSearch07(scanner);
            case 8 -> bookTitlesSearch08(scanner);
            case 9 -> countBooks09(scanner);
            case 10 -> totalBookCopies10();
            case 11 -> reducedBook11(scanner);
            case 12 -> increaseBookCopies12(scanner);
            case 13 -> removeBooks13(scanner);
            case 14 -> storedProcedure14(scanner);
            default -> System.out.println("You have entered an invalid number!");
        }

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

    }


    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

    private void booksTitlesByAgeRestriction01(Scanner scanner) {
        String ageRestriction = scanner.nextLine().toUpperCase();
        this.bookService.findAllTitlesByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void goldenBooks02() {
        this.bookService.findAllTitlesByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .forEach(System.out::println);
    }

    private void booksByPrice03() {
        this.bookService.findAllTitlesAndPriceBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(book -> System.out.println(book.getTitle() + " - " + book.getPrice()));
    }

    private void notReleasedBooks04(Scanner scanner) {
        int year = Integer.parseInt(scanner.nextLine());
        this.bookService.findTitlesByYearNotIn(year)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate05(Scanner scanner) {
        LocalDate localDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate newLocalDate = LocalDate.parse(
                localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.bookService.findAllBooksBefore(newLocalDate)
                .forEach(book -> System.out.println(
                        book.getTitle() + " " + book.getEditionType().name() + " " + book.getPrice()));
    }

    private void authorsSearch06(Scanner scanner) {
        String input = scanner.nextLine();
        this.authorService.findAllByNameLike("%" + input)
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
    }

    private void booksSearch07(Scanner scanner) {
        String input = scanner.nextLine();
        this.bookService.findAllByTitleLike("%" + input + "%")
                .forEach(System.out::println);
    }

    private void bookTitlesSearch08(Scanner scanner) {
        String input = scanner.nextLine();
        this.bookService.findTitlesByAuthorLastNameStartsWith(input + "%")
                .forEach(System.out::println);
    }

    private void countBooks09(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        int count = this.bookService.findBookCountByTitleLengthGreaterThan(number);
        System.out.printf("There are %d books with longer title than %d symbols%n", count, number);
    }

    private void totalBookCopies10() {
        this.authorService.getWithTotalCopies()
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName() + " - " + author.getTotalCopies()));
    }

    private void reducedBook11(Scanner scanner) {
        String title = scanner.nextLine();
        this.bookService.findBookAllByTitleLike(title)
                .forEach(book -> System.out.println(book.getTitle() + " " + book.getEditionType().name() + " " + book.getAgeRestriction().name() + " " + book.getPrice()));
    }

    private void increaseBookCopies12(Scanner scanner) throws ParseException {
        String input = scanner.nextLine();
        String[] date = input.split("\\s+");
        int year = Integer.parseInt(date[2]);
        String month = date[1];
        int day = Integer.parseInt(date[0]);

        Calendar calender = Calendar.getInstance();
        calender.setTime(new SimpleDateFormat("MMM", Locale.ENGLISH).parse(month));
        int monthNumber = calender.get(Calendar.MONTH) + 1;
        LocalDate localDate = LocalDate.of(year, monthNumber, day);
        int number = Integer.parseInt(scanner.nextLine());

        int booksUpdated = this.bookService.addCopiesToBooksAfter(localDate, number);
        System.out.printf("%d books are released after %s, so total of %d book copies were added%n",
                booksUpdated, input, booksUpdated * number);
    }

    private void removeBooks13(Scanner scanner) {
        int copies = Integer.parseInt(scanner.nextLine());
        int booksDeleted = this.bookService.deleteBooksWithCopiesLessThan(copies);
        System.out.println("You have deleted " + booksDeleted + " books!");
    }

    private void storedProcedure14(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        String lastName = input[1];
        int booksCount = this.authorService.getBooksCountByAuthor(firstName, lastName);
        System.out.println(firstName + " " + lastName + " has written " + booksCount + " books.");
    }


    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
}
