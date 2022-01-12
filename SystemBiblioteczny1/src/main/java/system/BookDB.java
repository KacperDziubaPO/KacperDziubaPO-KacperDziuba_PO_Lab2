package system;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDB extends DB {
    private final List<Book> books = new ArrayList<>();
    private final Connection connection = super.getConnection();
    private Statement statement;

    public BookDB() throws SQLException {
        getAllBooksFromDb();
        addBooksToList();

    }

    public void createBook(String text, String bookTitleText, String bookReleaseYearText, boolean available) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO books(author, title, releaseDate, avaliable ) VALUES ( ?, ?, ?, ?)");
        stmt.setString(1, text);
        stmt.setString(2, bookTitleText);
        stmt.setString(3, bookReleaseYearText);
        int ava = 0;
        if (available) {
            ava = 1;
        }
        stmt.setString(4, String.valueOf(ava));
        stmt.executeUpdate();
    }

    private void getAllBooksFromDb() throws SQLException {
        statement = connection.createStatement();
        statement.executeQuery("Select * from books;");
    }

    private void addBooksToList() throws SQLException {
        ResultSet rs = statement.getResultSet();
        boolean available = false;
        while (rs.next()) {
            int id = rs.getInt("book_id");
            String aut = rs.getString("author");
            String tit = rs.getString("title");
            String releaseDate = rs.getString("releaseDate");
            String ava = rs.getString("avaliable");

            if (ava.equalsIgnoreCase("1"))
                available = true;

            books.add(new Book(id, aut, tit, releaseDate, available));
        }
    }

    public void showAllBooks(JList<Book> jListBooks) throws SQLException {
        DefaultListModel<Book> booksModel = new DefaultListModel<>();
        for (Book book : books) {
            booksModel.addElement(book);
        }
        jListBooks.setModel(booksModel);
    }


    public void updateAvailability(int bookId){
        for (Book book : books) {
            if(book.getBookId() == bookId){
                book.setBookAvailable();
            }
        }
    }



    public void add(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
