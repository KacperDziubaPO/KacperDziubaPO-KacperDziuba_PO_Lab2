package system;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoansDB extends DB {
    private final List<Loan> loans = new ArrayList<>();
    private final Connection connection = super.getConnection();
    private Statement statement;

    public void createLoan(int userId, int bookId) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO loans (borrower_id, book_Id, issuedDate, returnDate) VALUES ( ?, ?, ?, ?)");
        stmt.setString(1, String.valueOf(userId));
        stmt.setString(2, String.valueOf(bookId));
        stmt.setString(3, String.valueOf(LocalDate.now()));
        stmt.setString(4, String.valueOf(LocalDate.now().plusWeeks(3)));
        stmt.executeUpdate();
    }


    public void addLoansToList() throws SQLException {
        if (!loans.isEmpty()) {
            loans.clear();
            statement.getConnection().createStatement();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("borrower_id");
                int book_id = rs.getInt("book_id");
                loans.add(new Loan(id, book_id));
            }
        }

    }


    public int getNumberOfBooks(int id) throws SQLException {
        int booksNumber = 0;
        String query = "select borrower_Id, COUNT(*) number from loans where borrower_Id =" + id + ";";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            booksNumber = resultSet.getInt("number");
        }
        return booksNumber;
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
