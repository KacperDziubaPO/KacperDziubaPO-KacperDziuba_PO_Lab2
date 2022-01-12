package system;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;


public class LoggerDB extends DB {
    private final String login;
    private final char[] pass;
    private boolean logged;
    private BorrowerWindow borrowerWindow;

    public LoggerDB(String login, char[] pass) throws SQLException {
        System.out.println("Enter your PESEL as Login");
        this.login = login;
        System.out.println("Enter your password");
        this.pass = pass;
    }


    public void findCredentials(JTextField messageOrErrorField, LoginWindow loginWindow) throws SQLException {
        messageOrErrorField.setText("Wprowadź dane");
        String pass1 = Arrays.toString(pass).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
        String queryString = "SELECT * FROM borrowers where Pesel=\"" + this.login + "\" and password= \"" + pass1 + "\";";
        ResultSet results = super.getConnection().createStatement().executeQuery(queryString);
        while (results.next()) {


            if (!results.getString("priviliges").equalsIgnoreCase("LIB")) {
                logged = true;
                borrowerWindow = new BorrowerWindow();
                validateBorrower(queryString);
                borrowerWindow.createWindow();
            } else {
                LibrarianWindow librarianWindow = new LibrarianWindow();
                librarianWindow.createWindow();

            }

        }

    }


    private void validateBorrower(String queryString) throws SQLException {
        borrowerWindow.setLogged(logged);
        borrowerWindow.logoutButtonClick();
        ResultSet results = super.getConnection().createStatement().executeQuery(queryString);
        while (results.next()) {
            System.out.println("act: " + results.getInt("borrower_id"));
            if (borrowerWindow != null) {
                borrowerWindow.setActualUserId(results.getInt("borrower_id"));
            }
        }
        if (borrowerWindow != null) {
            borrowerWindow.openLoansWindow();
        }

    }

}
