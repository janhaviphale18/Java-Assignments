import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Button Click Event");

        // Create a label
        JLabel label = new JLabel(
            "Click the button to display a message."
        );

        // Create a button
        JButton button = new JButton("Click Me");

        // Set the layout
        frame.setLayout(new FlowLayout());

        // Add components to the frame
        frame.add(label);
        frame.add(button);

        // Handle button click event
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hello .... Button Clicked.");
                JOptionPane.showMessageDialog(
                    frame,
                    "Button clicked successfully!"
                );
            }
        });

        // Set window properties
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}