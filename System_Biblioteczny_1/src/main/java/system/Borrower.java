package system;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Borrower extends Person {
    private int cardId = 1000;
    private int id;
    private String libCardId;

    public Borrower(int id, String name, String surname, String PESEL, String libCardId, String phoneNumber) {
        super(name, surname, PESEL, phoneNumber);
        this.id = id;
        this.libCardId = libCardId;
    }

    public int getId() {
        return id;
    }

    public String getLibCardId() {
        return libCardId;
    }

    @Override
    public String toString() {
        return "Reader: " +
                id + ", " +
                super.getFullData() + ", karta bibl.: " + libCardId;
    }
}
