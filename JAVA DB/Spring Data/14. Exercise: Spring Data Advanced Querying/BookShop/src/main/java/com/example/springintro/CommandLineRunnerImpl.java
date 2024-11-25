package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(
            CategoryService categoryService,
            AuthorService authorService,
            BookService bookService
    ) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        Scanner scanner = new Scanner(System.in);

//        String asd = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
//
//        System.out.println(asd);

//        _01(scanner);
//        _02();
//        _03();
//        _04(scanner);
//        _05(scanner);
//        _06(scanner);
//        _07(scanner);
//        _08(scanner);
//        _09(scanner);
//        _10Dummy();
//        _11(scanner);
//        _10Clever();
//        _12(scanner);
//        _13(scanner);
        _14();
    }

    private void _14() {
        int count = authorService.findBookCountForAuthor("Roger", "Porter");

        System.out.println(count);
    }

    private void _13(Scanner scanner) {
        int minCount = Integer.parseInt(scanner.nextLine());

        int deletedBooksCount = bookService.deleteWithCountLessThan(minCount);

        System.out.println(deletedBooksCount);
    }

    private void _12(Scanner scanner) {
        String date = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        long total = bookService.updateBookCopiesAfterDate(date, count);

        System.out.println(total);
    }

    private void _10Clever() {
        List<String> result = authorService.getAllByBookCopiesCountClever();

        System.out.println(result);
    }

    private void _11(Scanner scanner) {
        String title = scanner.nextLine();

        BookInfo bookInfo = bookService.findBookInfo(title);

        System.out.println(bookInfo.getTitle() + " " + bookInfo.getEditionType().name());
    }

    private void _10Dummy() {
        List<String> result = authorService.getAllByBookCopiesCount();

        System.out.println(result);
    }

    private void _09(Scanner scanner) {
        String input = scanner.nextLine();
        int length = Integer.parseInt(input);

        int result = bookService.findBookCountByTitleLength(length);

        System.out.println(result);
    }

    private void _08(Scanner scanner) {
        String nameEnding = scanner.nextLine();

        List<Book> result = bookService.findByAuthorName(nameEnding);

        result.forEach(b -> System.out.printf("%s (%s %s)",
                b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
    }

    private void _07(Scanner scanner) {
        String search = scanner.nextLine();

        List<String> result = bookService.findNamesWith(search);

        System.out.println(result);
    }

    private void _06(Scanner scanner) {
        String ending = scanner.nextLine();

        List<String> result = authorService.getAllNamesEndingWith(ending);

        System.out.println(result);
    }

    private void _05(Scanner scanner) {
        String input = scanner.nextLine();

        List<Book> result = bookService.findBooksReleasedBefore(input);

//        result.forEach(b -> System.out.println(b.shortInfo()));

        for (Book book : result) {
            System.out.println(book.shortInfo());
        }
    }

    private void _04(Scanner scanner) {
        String input = scanner.nextLine();
        int year = Integer.parseInt(input);

        List<String> result = bookService.findBookNotReleasedIn(year);

        System.out.println(result);
    }

    private void _03() {
        List<String> result = bookService
            .findByPriceOutsideOf(BigDecimal.valueOf(5), BigDecimal.valueOf(40));

        System.out.println(result);
    }

    private void _02() {
        List<String> result = bookService.findGoldenBooksTitles();

        System.out.println(result);
    }

    private void _01(Scanner scanner) {
        String input = scanner.nextLine();

        List<String> titles = bookService.findTitlesByAgeRestriction(input);

        System.out.println(titles);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
