package system;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoanWindow extends JFrame {
    private LoansDB loansDB = new LoansDB();
    private JPanel panel1;
    private JList<Book> books;
    private BookDB bookDB = new BookDB();

    private JButton confirmLoanButton;
    private JLabel selectedBook;
    private JLabel textField2;
    private JButton cancelLoanButton;
    private JComboBox<String> filtrComboBox;
    private JTextField textField1;
    private int userId;
    private boolean possible;
    private boolean available;

    public LoanWindow() throws SQLException {
        confirmLoanButton.setEnabled(true);
        setUpFiltersComboBox();


        bookDB.showAllBooks(books);
        selectBook();
        backToBorrowerWindow();


    }

    public void backToBorrowerWindow() {
        cancelLoanButton.addActionListener(actionEvent -> {
            dispose();
            BorrowerWindow borrowerWindow = new BorrowerWindow();
            borrowerWindow.createWindow();
            borrowerWindow.setLogged(true);
            borrowerWindow.logoutButtonClick();
        });
    }

    private void setUpFiltersComboBox() {
        String[] filtrationOptions = new String[2];
        filtrationOptions[0] = "tytule";
        filtrationOptions[1] = "dostępności";
        for (String filtrationOption : filtrationOptions) {
            filtrComboBox.addItem(filtrationOption);
        }
    }


    public void selectBook() {
        confirmLoanButton.addActionListener(actionEvent -> {
            try {
                checkPossibilityOfLoan();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (possible) {
                System.out.println(textField1.getText());
                selectTheBook();
            } else {
                confirmLoanButton.setEnabled(false);
                selectedBook.setText("Wypożyczono za dużo książek");
            }

        });


    }

    private void selectTheBook() {
        for (Book book : bookDB.getBooks()) {
            System.out.println(textField1.getText());

            if (book.getTitle().equalsIgnoreCase(textField1.getText())) {

                createLoan(book);

                break;
            } else {
                selectedBook.setText("Nie ma takiej książki");

            }
        }
    }

    private void createLoan(Book book) {
        confirmLoanButton.setEnabled(true);
        try {
            loansDB.createLoan(userId, book.getBookId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        selectedBook.setText("Wybrano:" + book.getTitle());
    }

    private void checkPossibilityOfLoan() throws SQLException {
        if (loansDB.getNumberOfBooks(userId) > 9) {
            confirmLoanButton.setEnabled(false);
            selectedBook.setText("Wypożyczyono za dużo książek");
            possible = false;
        } else {
            possible = true;
        }
    }




    public void createWindow() {
        setTitle("System Biblioteczny");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setContentPane(this.panel1);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 450);


    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
