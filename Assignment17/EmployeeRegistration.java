import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Main class
public class EmployeeRegistration extends JFrame implements ActionListener {
    JLabel idLabel, nameLabel, departmentLabel, salaryLabel;
    JTextField idField, nameField, salaryField;
    JComboBox<String> departmentBox;
    JButton submitButton;

    // Constructor
    public EmployeeRegistration() {
        setTitle("Employee Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Employee ID
        idLabel = new JLabel("Employee ID:");
        idField = new JTextField();

        // Name
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        // Department
        departmentLabel = new JLabel("Department:");
        String departments[] = {"CSE", "HR", "Finance", "Marketing"};
        departmentBox = new JComboBox<>(departments);

        // Salary
        salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField();

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Add components
        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(departmentLabel);
        add(departmentBox);

        add(salaryLabel);
        add(salaryField);

        add(new JLabel());
        add(submitButton);

        setVisible(true);
    }

    // Handle button click
    public void actionPerformed(ActionEvent e) {
        String id = idField.getText();
        String name = nameField.getText();
        String department = departmentBox.getSelectedItem().toString();
        String salary = salaryField.getText();

        JOptionPane.showMessageDialog(
            this,
            "Employee Registration Successful!\n\n" +
            "Employee ID: " + id + "\n" +
            "Name: " + name + "\n" +
            "Department: " + department + "\n" +
            "Salary: " + salary
        );
    }

    // Main method
    public static void main(String[] args) {
        new EmployeeRegistration();
    }
}