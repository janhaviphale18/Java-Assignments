import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Simple Calculator");

        // Create text fields
        JTextField firstField = new JTextField(10);
        JTextField secondField = new JTextField(10);

        // Create buttons
        JButton addButton = new JButton("Addition");
        JButton subtractButton = new JButton("Subtraction");

        // Create label
        JLabel resultLabel = new JLabel("Result: ");

        // Set layout
        frame.setLayout(new FlowLayout());

        // Add components
        frame.add(new JLabel("First Number:"));
        frame.add(firstField);

        frame.add(new JLabel("Second Number:"));
        frame.add(secondField);

        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(resultLabel);

        // Addition button event
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(firstField.getText());
                double num2 = Double.parseDouble(secondField.getText());

                double result = num1 + num2;

                resultLabel.setText("Result: " + result);
            }
        });

        // Subtraction button event
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(firstField.getText());
                double num2 = Double.parseDouble(secondField.getText());

                double result = num1 - num2;

                resultLabel.setText("Result: " + result);
            }
        });

        // Set window properties
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}