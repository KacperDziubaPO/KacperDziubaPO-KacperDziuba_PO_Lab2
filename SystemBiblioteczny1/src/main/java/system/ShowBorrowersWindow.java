package system;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ShowBorrowersWindow extends JFrame {
    private DefaultListModel<Borrower> borrowersModel = new DefaultListModel<>();
    private JList<Borrower> allBorrowers;
    private JPanel panel1;


    public void allBorrowersContent(BorrowerDB borrowerDB) throws SQLException {
        borrowerDB.getAllBorrowers().clear();
        borrowerDB.selectAllBorrowers();
        showBorrowers(borrowerDB.getAllBorrowers());
    }

    public void borrowersWithoutLoansContent(BorrowerDB borrowerDB) throws SQLException {
        borrowerDB.getBorrowersWithoutLoans().clear();
        borrowerDB.selectBorrowersWithoutLoans();
        showBorrowers(borrowerDB.getBorrowersWithoutLoans());
    }

    private void showBorrowers(List<Borrower> borrowerDB) {
        borrowersModel.clear();
        if (borrowersModel.isEmpty()) {
            for (Borrower allBorrower : borrowerDB) {
                borrowersModel.addElement(allBorrower);
            }
            allBorrowers.setModel(borrowersModel);
        }
    }

    public void createWindow() {
        this.setTitle("System biblioteczny");
        this.setLayout(new FlowLayout());
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(this.panel1);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(500, 300);
        this.setResizable(false);
        System.out.println("frame: " + Frame.getFrames().length);
    }
}
