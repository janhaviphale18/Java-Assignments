import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ButtonDemo extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    ButtonDemo() {
        button = new JButton("Click Me");
        label = new JLabel("Button not clicked");
        button.addActionListener(this);
        setLayout(new FlowLayout());
        add(button);
        add(label);
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        label.setText("Button clicked!");
    }
    public static void main(String[] args) {
        new ButtonDemo();
    }
}