package system;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Loan {
    private final int borrowerId;
    private final int bookId;
    private final LocalDate issuedDate;
    private final LocalDate dateReturned;

    public Loan(int borrowerId, int bookId) {
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.issuedDate = LocalDate.now();
        this.dateReturned = issuedDate.plusWeeks(3);


    }


    public int getBorrowerId() {
        return borrowerId;
    }

    public int getBookId() {
        return bookId;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "borrowerId=" + borrowerId +
                ", bookId=" + bookId +
                ", issuedDate=" + issuedDate +
                ", dateReturned=" + dateReturned +
                '}';
    }
}

