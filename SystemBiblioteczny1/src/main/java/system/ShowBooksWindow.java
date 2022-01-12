package system;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ShowBooksWindow extends JFrame {
    private JList<Book> bookJList;
    private JPanel panel1;
    private BookDB bookDB;

    public void booksContent() {
        try {
            bookDB = new BookDB();
            bookDB.showAllBooks(bookJList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
