

import com.company.*;
import com.company.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SwingApp extends JFrame {
    private JPanel panel1;
    private JRadioButton trapezRadioButton;
    private JRadioButton trójkątRadioButton;
    private JRadioButton prostokątRadioButton;
    private JRadioButton kwadratRadioButton;
    private JRadioButton sześcianRadioButton;
    private JRadioButton prostopadłościanRadioButton;
    private JRadioButton walecRadioButton;
    private JRadioButton kulaRadioButton;
    private JButton obilczButton;
    private JButton wyczyśćButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private ButtonGroup group = new ButtonGroup();
    private List<JTextField> textFields = new ArrayList<>();
    private String selectedFigure;


    public SwingApp() {
        textFields.add(textField1);
        textFields.add(textField2);
        textFields.add(textField3);
        textFields.add(textField4);
        textFields.add(textField5);
        textFields.add(textField6);
        textFields.add(textField7);

        group.add(kwadratRadioButton);
        group.add(prostokątRadioButton);
        group.add(trójkątRadioButton);
        group.add(trapezRadioButton);
        group.add(sześcianRadioButton);
        group.add(kulaRadioButton);
        group.add(walecRadioButton);
        group.add(prostopadłościanRadioButton);

        setDefaultFieldsIneditable();

        chooseSquare();
        chooseRectangle();
        chooseTriangle();
        chooseTrapezoid();
        chooseCuboid();
        chooseCube();
        chooseCylinder();
        chooseSphere();
        inputDigits(textField1);
        inputDigits(textField2);
        inputDigits(textField3);
        inputDigits(textField4);

        pressResetButton();
    }

    private void setDefaultFieldsIneditable() {
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);
        textField6.setEditable(false);
        textField7.setEditable(false);
    }

    private void chooseSquare() {
        kwadratRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (kwadratRadioButton.isSelected()) {
                    selectedFigure = kwadratRadioButton.getText();
                    pressObliczButton();

                    textField1.setEditable(true);
                    textField2.setEditable(false);
                    textField3.setEditable(false);
                    textField4.setEditable(false);
                    textField5.setEditable(true);
                    textField6.setEditable(false);
                    textField7.setEditable(true);
                }
                if (!kwadratRadioButton.isSelected()) {
                    textField1.setEditable(false);
                    textField5.setEditable(false);
                    textField7.setEditable(false);
                }
            }
        });

    }

    private void chooseCube() {
        sześcianRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (sześcianRadioButton.isSelected()) {
                    selectedFigure = sześcianRadioButton.getText();
                    pressObliczButton();

                    textField1.setEditable(true);
                    textField2.setEditable(false);
                    textField3.setEditable(false);
                    textField4.setEditable(false);
                    textField5.setEditable(true);
                    textField6.setEditable(true);
                    textField7.setEditable(false);
                }
                if (!sześcianRadioButton.isSelected()) {
                    textField1.setEditable(false);
                    textField5.setEditable(false);
                    textField6.setEditable(false);
                }
            }
        });

    }

    private void chooseTriangle() {
        trójkątRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (trójkątRadioButton.isSelected()) {
                    selectedFigure = trójkątRadioButton.getText();
                    pressObliczButton();

                    textField1.setEditable(true);
                    textField3.setEditable(true);
                    textField2.setEditable(false);
                    textField4.setEditable(false);
                    textField5.setEditable(true);
                    textField6.setEditable(false);
                    textField7.setEditable(true);
                }
                if (!trójkątRadioButton.isSelected()) {
                    textField1.setEditable(false);
                    textField3.setEditable(false);
                    textField5.setEditable(false);
                    textField7.setEditable(false);
                }
            }
        });
    }

    private void chooseRectangle() {
        prostokątRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (prostokątRadioButton.isSelected()) {
                    selectedFigure = prostokątRadioButton.getText();
                    pressObliczButton();

                    textField1.setEditable(true);
                    textField2.setEditable(true);
                    textField3.setEditable(false);
                    textField4.setEditable(false);
                    textField5.setEditable(true);
                    textField6.setEditable(false);
                    textField7.setEditable(true);

                }
                if (!prostokątRadioButton.isSelected()) {
                    textField1.setEditable(false);
                    textField2.setEditable(false);
                    textField5.setEditable(false);
                    textField7.setEditable(false);
                }
            }
        });
    }

    private void chooseCuboid() {
        prostopadłościanRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (prostopadłościanRadioButton.isSelected()) {
                    selectedFigure = prostopadłościanRadioButton.getText();
                    pressObliczButton();

                    textField1.setEditable(true);
                    textField2.setEditable(true);
                    textField3.setEditable(false);
                    textField4.setEditable(false);
                    textField5.setEditable(true);
                    textField6.setEditable(true);
                    textField7.setEditable(false);
                }
                if (!prostopadłościanRadioButton.isSelected()) {
                    textField1.setEditable(false);
                    textField5.setEditable(false);
                    textField6.setEditable(false);
                }
            }
        });
    }

    private void chooseTrapezoid() {
        trapezRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (trapezRadioButton.isSelected()) {
                    selectedFigure = trapezRadioButton.getText();
                    pressObliczButton();

                    textField1.setEditable(true);
                    textField2.setEditable(true);
                    textField3.setEditable(true);
                    textField4.setEditable(false);
                    textField5.setEditable(true);
                    textField6.setEditable(false);
                    textField7.setEditable(false);

                }
                if (!trapezRadioButton.isSelected()) {
                    textField1.setEditable(false);
                    textField2.setEditable(false);
                    textField4.setEditable(false);
                    textField5.setEditable(false);
                    textField7.setEditable(false);
                }
            }
        });
    }

    private void chooseCylinder() {
        walecRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (walecRadioButton.isSelected()) {
                    selectedFigure = walecRadioButton.getText();
                    pressObliczButton();

                    textField1.setEditable(false);
                    textField2.setEditable(false);
                    textField3.setEditable(true);
                    textField4.setEditable(true);
                    textField5.setEditable(true);
                    textField6.setEditable(true);
                    textField7.setEditable(false);

                }
                if (!walecRadioButton.isSelected()) {
                    textField1.setEditable(false);
                    textField2.setEditable(false);
                    textField4.setEditable(false);
                    textField5.setEditable(false);
                    textField7.setEditable(false);
                }
            }
        });
    }

    private void chooseSphere() {
        kulaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (kulaRadioButton.isSelected()) {
                    selectedFigure = kulaRadioButton.getText();
                    pressObliczButton();

                    textField1.setEditable(false);
                    textField2.setEditable(false);
                    textField3.setEditable(false);
                    textField4.setEditable(true);
                    textField5.setEditable(true);
                    textField6.setEditable(true);
                    textField7.setEditable(false);

                }
                if (!kulaRadioButton.isSelected()) {
                    textField1.setEditable(false);
                    textField2.setEditable(false);
                    textField4.setEditable(false);
                    textField5.setEditable(false);
                    textField7.setEditable(false);
                }
            }
        });
    }

    private void clearUnactiveField() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }

    private void pressObliczButton() {
        obilczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double value1;
                double value2;
                double value3;


                switch (selectedFigure) {
                    case "Kwadrat":
                        value1 = Double.parseDouble(textField1.getText());
                        Square square = new Square(value1);
                        square.calculateField();
                        textField5.setText(String.valueOf(square.getField()));
                        square.calculatePerimeter();
                        textField7.setText(String.valueOf(square.getPerimeter()));
                        break;
                    case "Prostokąt":
                        value1 = Double.parseDouble(textField1.getText());
                        value2 = Double.parseDouble(textField2.getText());

                        Rectangle rectangle = new Rectangle(value1, value2);
                        rectangle.calculateField();
                        rectangle.calculatePerimeter();
                        textField5.setText(String.valueOf(rectangle.getField()));
                        textField7.setText(String.valueOf(rectangle.getPerimeter()));
                        break;
                    case "Trójkąt":
                        value1 = Double.parseDouble(textField1.getText());
                        value2 = Double.parseDouble(textField3.getText());

                        Triangle triangle = new Triangle(value1, value2);
                        triangle.calculateField();
                        triangle.calculatePerimeter();
                        textField5.setText(String.valueOf(triangle.getField()));
                        textField7.setText(String.valueOf(triangle.getPerimeter()));
                        break;
                    case "Trapez":
                        value1 = Double.parseDouble(textField1.getText());
                        value2 = Double.parseDouble(textField2.getText());
                        value3 = Double.parseDouble(textField3.getText());

                        Trapezoid trapezoid = new Trapezoid(value1, value2, value3);
                        trapezoid.calculateField();
                        //trapezoid.calculatePerimeter();
                        textField5.setText(String.valueOf(trapezoid.getField()));
                        //textField7.setText(String.valueOf(trapezoid.getPerimeter()));
                        break;
                    case "Sześcian":
                        value1 = Double.parseDouble(textField1.getText());
                        Cube cube = new Cube(value1);
                        cube.calculateField();
                        cube.calculateVolume();
                        textField5.setText(String.valueOf(cube.getField()));
                        textField6.setText(String.valueOf(cube.getVolume()));
                        break;
                    case "Prostopadłościan":
                        value1 = Double.parseDouble(textField1.getText());
                        value2 = Double.parseDouble(textField2.getText());
                        Cuboid cuboid = new Cuboid(value1, value2);
                        cuboid.calculateField();
                        cuboid.calculateVolume();
                        textField5.setText(String.valueOf(cuboid.getField()));
                        textField6.setText(String.valueOf(cuboid.getVolume()));
                        break;
                    case "Walec":
                        value1 = Double.parseDouble(textField3.getText());
                        value2 = Double.parseDouble(textField4.getText());
                        Cylinder cylinder = new Cylinder(value1, value2);
                        cylinder.calculateField();
                        cylinder.calculateVolume();
                        textField5.setText(String.valueOf(cylinder.getField()));
                        textField6.setText(String.valueOf(cylinder.getVolume()));
                        break;
                    case "Kula":
                        value1 = Double.parseDouble(textField4.getText());
                        Sphere sphere = new Sphere(value1);
                        sphere.calculateField();
                        sphere.calculateVolume();
                        textField5.setText(String.valueOf(sphere.getField()));
                        textField6.setText(String.valueOf(sphere.getVolume()));
                        break;
                }
            }
        });
    }

    private void pressResetButton() {
        wyczyśćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (JTextField textField : textFields) {
                    textField.setText("");
                    textField.setEditable(false);
                }
                group.clearSelection();
            }
        });
    }

    private void inputDigits(JTextField jTextField) {
        jTextField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {
                System.out.println(textField1.getText());

            }

            @Override
            public void caretPositionChanged(InputMethodEvent inputMethodEvent) {

            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingApp swingApp = new SwingApp();
                swingApp.createWindow();
            }
        });

    }


    public void createWindow() {
        JFrame frame = new JFrame("Figury geometryczne-kalkulator");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setContentPane(new SwingApp().panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500, 300);


    }


}
