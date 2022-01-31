package system;


public class Book {
    private int bookId;
    private final String author;
    private final String title;
    private final String releaseYear;
    private boolean available;

    public Book(String author, String title, String data, boolean available) {
        this.author = author;
        this.title = title;
        this.releaseYear = data;
        this.available = available;
    }


    public Book(int bookId, String author, String title, String releaseYear, boolean available) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.releaseYear = releaseYear;
        this.available = available;
    }


    public boolean isAvailable() {
        return available;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setBookAvailable() {
        available = true;
    }

    @Override
    public String toString() {
        return " " + bookId +
                ", " + author +
                ", \"" + title +
                "\", " + releaseYear +
                ", " + available;
    }
}

