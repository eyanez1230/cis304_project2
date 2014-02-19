
public class Book extends Product {

    String author;
    int pages;

    // Class consutrctor
    Book(String ID, String name, String medium, String author, String genre, int pages, int qty, String imageURL) {
        super(ID, name, genre, medium, qty, imageURL);
        this.author = author;
        this.pages = pages;

    }

    // Overwrite Java's to string to output with line breaks
    public String toString() {
        String msg = "";
        msg += super.toString();
        msg += "Author: " + author + "\n";
        msg += "Pages: " + pages + "\n";

        return msg;
    }
}
