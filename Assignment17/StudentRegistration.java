import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Main class
public class StudentRegistration extends JFrame implements ActionListener {
    JLabel nameLabel, rollLabel, courseLabel, genderLabel;
    JTextField nameField, rollField;
    JComboBox<String> courseBox;
    JRadioButton maleButton, femaleButton;
    JButton submitButton;

    // Constructor
    public StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(400, 350);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        // Roll Number
        rollLabel = new JLabel("Roll Number:");
        rollField = new JTextField();

        // Course
        courseLabel = new JLabel("Course:");
        String courses[] = {"CSE", "IT", "ECE", "Mechanical"};
        courseBox = new JComboBox<>(courses);

        // Gender
        genderLabel = new JLabel("Gender:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Add components
        add(nameLabel);
        add(nameField);

        add(rollLabel);
        add(rollField);

        add(courseLabel);
        add(courseBox);

        add(genderLabel);
        add(genderPanel);

        add(new JLabel());
        add(submitButton);

        setVisible(true);
    }

    // Handle button click
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String roll = rollField.getText();
        String course = courseBox.getSelectedItem().toString();

        String gender;

        if (maleButton.isSelected()) {
            gender = "Male";
        } else if (femaleButton.isSelected()) {
            gender = "Female";
        } else {
            gender = "Not selected";
        }

        JOptionPane.showMessageDialog(
            this,
            "Student Registration Successful!\n\n" +
            "Name: " + name + "\n" +
            "Roll Number: " + roll + "\n" +
            "Course: " + course + "\n" +
            "Gender: " + gender
        );
    }

    // Main method
    public static void main(String[] args) {
        new StudentRegistration();
    }
}