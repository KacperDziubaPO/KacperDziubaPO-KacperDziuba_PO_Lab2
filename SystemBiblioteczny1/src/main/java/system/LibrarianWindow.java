package system;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Objects;

public class LibrarianWindow extends JFrame {
    private JPanel panel1;
    private JButton wylogujButton;
    private JButton zwróćKsiążkęButton;
    private JButton pokazWypożyczoneKsiążkiButton;
    private JButton viewBooksButton;
    private JButton addBookButton;
    private JButton addBorrower;
    private JTextField phoneNumber;
    private JTextField pesel;
    private JTextField name;
    private JTextField lastName;
    private JTextField bookAuthor;
    private JTextField bookTitle;
    private JTextField bookReleaseYear;
    private JLabel borrowerLabel;
    private JTextField cardIdInput;
    private JButton znajdźCzytelnikaButton;
    private JComboBox borrowersCombo;
    private BorrowerDB borrowerDB = new BorrowerDB();
    private BookDB bookDB = new BookDB();

    public LibrarianWindow() throws SQLException {

        borrowerAdding();
        showBorrowerWithLibCardId();

        bookAdding();
        openContentWindow();
        dispose();
        openSpecificWindow();

    }

    private void showBorrowerWithLibCardId() {
        znajdźCzytelnikaButton.addActionListener(actionEvent -> {

            Borrower borrower = null;
            try {
                borrower = borrowerDB.showBorrowerWith(cardIdInput.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (borrower != null) {
                borrowerLabel.setText(borrower.toString());
            } else borrowerLabel.setText("Taki czytelnik nie istnieje");

        });
    }

    private void showAllBorrowers() throws SQLException {
        ShowBorrowersWindow bw = new ShowBorrowersWindow();
        bw.createWindow();
        bw.allBorrowersContent(borrowerDB);

    }

    public void openSpecificWindow() {
        borrowersCombo.addActionListener(actionEvent -> {
            switch (Objects.requireNonNull(Objects.requireNonNull(borrowersCombo.getSelectedItem()).toString())) {
                case "wszystkich":
                    try {
                        showAllBorrowers();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    break;
                case "bez wypożyczeń":
                    try {
                        ShowBorrowersWindow bw = new ShowBorrowersWindow();
                        bw.createWindow();
                        bw.borrowersWithoutLoansContent(borrowerDB);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    break;
                default:
                    System.out.println("nie istnieje");
                    break;
            }
        });


    }


    private void borrowerAdding() {
        addBorrower.addActionListener(actionEvent -> {
            try {
                borrowerDB.createBorrower(name.getText(), lastName.getText(), pesel.getText(), phoneNumber.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void bookAdding() {
        addBookButton.addActionListener(actionEvent -> {
            try {
                bookDB.createBook(bookAuthor.getText(),bookTitle.getText(),bookReleaseYear.getText(),true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void openContentWindow() {
        viewBooksButton.addActionListener(actionEvent -> {
            ShowBooksWindow cw = new ShowBooksWindow();

            cw.createWindow();
            cw.booksContent();
        });
    }

    public void createWindow() {
        this.setTitle("System biblioteczny");
        this.setLayout(new FlowLayout());
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(this.panel1);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(1000, 800);
        this.setResizable(false);
        System.out.println("frame: " + Frame.getFrames().length);
    }


}
