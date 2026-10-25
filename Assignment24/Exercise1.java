import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Exercise1 extends JFrame {
    Connection con;
    JTextField id, title, author, price;
    DefaultTableModel model;

    Exercise1() {
        setTitle("Library Management System");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db",
                "root", "YOUR_MYSQL_PASSWORD"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Connection failed: " + e.getMessage()
            );
        }

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));

        id = new JTextField();
        title = new JTextField();
        author = new JTextField();
        price = new JTextField();

        form.add(new JLabel("Book ID:"));
        form.add(id);
        form.add(new JLabel("Title:"));
        form.add(title);
        form.add(new JLabel("Author:"));
        form.add(author);
        form.add(new JLabel("Price:"));
        form.add(price);

        add(form, BorderLayout.NORTH);

        model = new DefaultTableModel(
            new String[]{"Book ID", "Title", "Author", "Price"}, 0
        );

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        JButton deleteButton = new JButton("Delete Book");

        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(deleteButton);
        add(buttons, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());
        deleteButton.addActionListener(e -> deleteBook());

        viewBooks();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void addBook() {
        try {
            String sql = "INSERT INTO books VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id.getText()));
            ps.setString(2, title.getText());
            ps.setString(3, author.getText());
            ps.setDouble(4, Double.parseDouble(price.getText()));

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(
                this, "Book added successfully!"
            );

            viewBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }

    void viewBooks() {
        try {
            model.setRowCount(0);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price")
                });
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }

    void deleteBook() {
        try {
            String input = JOptionPane.showInputDialog(
                this, "Enter Book ID to delete:"
            );

            if (input == null || input.trim().isEmpty()) {
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM books WHERE book_id = ?"
            );

            ps.setInt(1, Integer.parseInt(input));
            int count = ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(
                this, count > 0 ? "Book deleted!" : "Book not found."
            );

            viewBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exercise1());
    }
}