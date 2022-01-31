package system;


import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class BorrowerWindow extends JFrame {
    private final LoansDB loansDB = new LoansDB();
    private final BookDB bookDB = new BookDB();
    private JPanel panel1;
    private JButton ReturnBookButton;
    private JButton logoutButton;
    private JButton loanBookButton;
    private JTextField textField1;
    private JLabel actualUser;
    private boolean logged;
    private final LoginWindow loginWindow = new LoginWindow();
    private int actualUserId;


    public BorrowerWindow() throws SQLException {
        openLoansWindow();

        returnBook();
    }

    private void returnBook() {
        ReturnBookButton.addActionListener(actionEvent -> {
            try {
                for (Book borrowedBook : bookDB.getBorrowedBooks()) {
                    if (borrowedBook.getTitle().equalsIgnoreCase(textField1.getText())) {
                        bookDB.updateBookToBeAvailable(borrowedBook.getBookId());
                        loansDB.deleteLoan(borrowedBook.getBookId());
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            for (Book book : bookDB.getBooks()) {
                System.out.println(book);
            }
        });
    }

    public void openLoansWindow() {

        loanBookButton.addActionListener(actionEvent -> {
            LoanWindow loanWindow;
            try {
                loanWindow = new LoanWindow();
                if (!loanWindow.isActive()) {
                    loanWindow.createWindow();
                    loanWindow.setUserId(actualUserId);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            dispose();
        });
    }

    public void logoutButtonClick() {
        logoutButton.addActionListener(actionEvent -> {
            System.out.println(logged);
            if (logged) {
                dispose();
                loginWindow.createWindow();
            }
        });
    }

    public void createWindow() {
        this.setTitle("System Biblioteczny");
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setContentPane(this.panel1);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setResizable(false);


    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void setActualUserId(int actualUserId) {
        this.actualUserId = actualUserId;
    }
}
