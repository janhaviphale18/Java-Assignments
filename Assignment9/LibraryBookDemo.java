class LibraryBook {
    final String isbn;
    String title;
    String author;
    double price;

    LibraryBook(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void updatePrice(double newPrice) {
        price = newPrice;
        System.out.println("Book price updated successfully.");
    }

    void displayBook() {
        System.out.println("\nLibrary Book Details");
        System.out.println("--------------------");
        System.out.println("ISBN   : " + isbn);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : Rs. " + price);
    }
}

public class LibraryBookDemo {
    public static void main(String[] args) {

        LibraryBook book = new LibraryBook(
                "978-0135166307",
                "Core Java",
                "Cay S. Horstmann",
                850
        );

        book.displayBook();

        book.updatePrice(900);

        book.displayBook();

        // book.isbn = "978-1234567890";
        // Error: cannot assign a value to final variable
    }
}