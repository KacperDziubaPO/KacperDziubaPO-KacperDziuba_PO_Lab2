package system;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BorrowerDB extends DB {
    private final List<Borrower> allBorrowers = new ArrayList<>();
    private final List<Borrower> borrowersWithoutLoans = new ArrayList<>();
    private final Connection connection = super.getConnection();
    private Statement statement;
    private int cardId = 1000;
    private String libCardId;


    public void createBorrower(String nameText, String lastNameText, String peselText, String phoneNumberText) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO borrowers(name, secondname, Pesel, libCardNumber, phoneNumb, password, priviliges) VALUES ( ?, ?, ?, ?, ?, ?,?)");
        stmt.setString(1, nameText);
        stmt.setString(2, lastNameText);
        stmt.setString(3, peselText);
        generateLibCardId();
        stmt.setString(4, libCardId);
        stmt.setString(5, phoneNumberText);
        stmt.setString(6, generatePassword(nameText, lastNameText, peselText));
        stmt.setString(7, "BOR");
        stmt.executeUpdate();

    }

    private void generateLibCardId() throws SQLException {
        selectAllBorrowers();
        int randomNumber = new Random().nextInt(9000) + 1000;
        System.out.println(randomNumber);
        for (Borrower allBorrower : allBorrowers) {
            if (!allBorrower.getLibCardId().equalsIgnoreCase(String.valueOf(randomNumber))) {
                libCardId = String.valueOf(randomNumber);
                break;
            }
        }
    }


    private String generatePassword(String name, String lastname, String pesel) {
        StringBuilder stringBuilder = new StringBuilder();
        return String.valueOf(stringBuilder.append(name, 0, 2).append(lastname, 0, 2).append(pesel, pesel.length() - 3, pesel.length())).toUpperCase();
    }


    public void selectAllBorrowers() throws SQLException {
        statement = connection.createStatement();
        statement.executeQuery("Select * from borrowers;");
        addBorrowersToList(allBorrowers);
    }


    public void selectBorrowersWithoutLoans() throws SQLException {
        statement = connection.createStatement();
        String query = "select borrower_id, name, secondname, pesel, libCardNumber, phoneNumb from borrowers where borrower_id not in (select borrower_Id from Loans);";
        statement.executeQuery(query);
        addBorrowersToList(borrowersWithoutLoans);
    }

    public void selectBorrowersWithLoans() throws SQLException {
        statement = connection.createStatement();
        String query = "select borrower_id, name, secondname, pesel, libCardNumber, phoneNumb from borrowers where borrower_id in (select borrower_Id from Loans);";
        statement.executeQuery(query);
        addBorrowersToList(borrowersWithoutLoans);
    }

    private void addBorrowersToList(List<Borrower> borrowers) throws SQLException {
        ResultSet rs = statement.getResultSet();
        while (rs.next()) {
            int id = rs.getInt("borrower_id");
            String name = rs.getString("name");
            String secondname = rs.getString("secondname");
            String pesel = rs.getString("Pesel");
            String libCardNumber = rs.getString("libCardNumber");
            String phoneNumber = rs.getString("phoneNumb");

            borrowers.add(new Borrower(id, name, secondname, pesel, libCardNumber, phoneNumber));
        }
    }


    public List<Borrower> getAllBorrowers() {
        return allBorrowers;
    }

    public List<Borrower> getBorrowersWithoutLoans() {
        return borrowersWithoutLoans;
    }

    public Borrower showBorrowerWith(String libCardId) throws SQLException {
        selectAllBorrowers();
        Borrower selected = null;
        for (Borrower borrower : allBorrowers) {
            if (borrower.getLibCardId().equalsIgnoreCase(libCardId)) {
                selected = borrower;
            }
        }
        return selected;
    }


}
