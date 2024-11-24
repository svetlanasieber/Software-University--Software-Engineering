package BookSell;

public class Book {

 
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

   
    public void sell() {
        System.out.printf("Book with title: %s was successfully sold for: %.2f", this.title, this.price);
    }
}
