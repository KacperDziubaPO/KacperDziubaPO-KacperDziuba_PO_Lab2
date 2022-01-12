package system;


import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class BorrowerWindow extends JFrame {
    private JPanel panel1;
    private JButton zwróćKsiążkęButton;
    private JButton logoutButton;
    private JButton loanBookButton;
    private JLabel actualUser;
    private boolean logged;
    private LoginWindow loginWindow = new LoginWindow();
    private int actualUserId;





    public void openLoansWindow() {
        System.out.println("a: " + actualUserId);
        loanBookButton.addActionListener(actionEvent -> {
            LoanWindow loanWindow = null;
            try {
                loanWindow = new LoanWindow();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            loanWindow.createWindow();
            loanWindow.setUserId(actualUserId);
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
