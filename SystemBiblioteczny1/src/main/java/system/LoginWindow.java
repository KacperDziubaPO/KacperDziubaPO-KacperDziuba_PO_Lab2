package system;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;


public class LoginWindow extends JFrame {
    private JPanel panel1;
    private JTextField loginInput;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JTextField messageOrErrorField;
    private LoggerDB loggerDB;


    public LoginWindow() {
        messageOrErrorField.setHorizontalAlignment(JTextField.CENTER);
        pushLoginButton();

    }


    public void pushLoginButton() {

        logInButton.addActionListener(actionEvent -> {
            try {
                if (loginInput.getText().trim().isEmpty() || passwordField.getPassword().length == 0) {
                    messageOrErrorField.setText("Wprowadź właściwe dane");
                } else {
                    createWindow();
                    loggerDB = new LoggerDB(loginInput.getText().trim(), passwordField.getPassword());
                    loggerDB.findCredentials(messageOrErrorField, this);
                    dispose();
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public void createWindow() {
        this.setTitle("System biblioteczny - logowanie");
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
