import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankBalance {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Bank Balance Calculator");

        // Create text fields
        JTextField balanceField = new JTextField(10);
        JTextField amountField = new JTextField(10);

        // Create buttons
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdrawal");

        // Create label
        JLabel resultLabel = new JLabel("Updated Balance: ");

        // Set layout
        frame.setLayout(new FlowLayout());

        // Add components
        frame.add(new JLabel("Initial Balance:"));
        frame.add(balanceField);

        frame.add(new JLabel("Transaction Amount:"));
        frame.add(amountField);

        frame.add(depositButton);
        frame.add(withdrawButton);

        frame.add(resultLabel);

        // Deposit button event
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance =
                    Double.parseDouble(balanceField.getText());
                double amount =
                    Double.parseDouble(amountField.getText());

                double updatedBalance = balance + amount;

                balanceField.setText(String.valueOf(updatedBalance));
                resultLabel.setText(
                    "Updated Balance: " + updatedBalance
                );
            }
        });

        // Withdrawal button event
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance =
                    Double.parseDouble(balanceField.getText());
                double amount =
                    Double.parseDouble(amountField.getText());

                double updatedBalance = balance - amount;

                balanceField.setText(String.valueOf(updatedBalance));
                resultLabel.setText(
                    "Updated Balance: " + updatedBalance
                );
            }
        });

        // Set window properties
        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}