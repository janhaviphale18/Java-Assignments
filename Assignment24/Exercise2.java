import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Exercise2 extends JFrame {
    Connection con;
    JTextField bookId, student, issueDate, returnDate;
    DefaultTableModel model;

    Exercise2() {
        setTitle("Book Issue Tracking System");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/book_issue_db",
                "root", "YOUR_MYSQL_PASSWORD"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Connection failed: " + e.getMessage()
            );
        }

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));

        bookId = new JTextField();
        student = new JTextField();
        issueDate = new JTextField();
        returnDate = new JTextField();

        form.add(new JLabel("Book ID:"));
        form.add(bookId);
        form.add(new JLabel("Student Name:"));
        form.add(student);
        form.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        form.add(issueDate);
        form.add(new JLabel("Return Date (YYYY-MM-DD):"));
        form.add(returnDate);

        add(form, BorderLayout.NORTH);

        model = new DefaultTableModel(
            new String[]{
                "Book ID", "Student Name", "Issue Date", "Return Date"
            }, 0
        );

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Record");
        JButton viewButton = new JButton("View Records");
        JButton deleteButton = new JButton("Delete Record");

        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(deleteButton);
        add(buttons, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addRecord());
        viewButton.addActionListener(e -> viewRecords());
        deleteButton.addActionListener(e -> deleteRecord());

        viewRecords();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void addRecord() {
        try {
            String sql = "INSERT INTO book_issues VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(bookId.getText()));
            ps.setString(2, student.getText());
            ps.setDate(3, Date.valueOf(issueDate.getText()));

            if (returnDate.getText().trim().isEmpty()) {
                ps.setNull(4, Types.DATE);
            } else {
                ps.setDate(4, Date.valueOf(returnDate.getText()));
            }

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(
                this, "Book issue record added successfully!"
            );

            viewRecords();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }

    void viewRecords() {
        try {
            model.setRowCount(0);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM book_issues"
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("student_name"),
                    rs.getDate("issue_date"),
                    rs.getDate("return_date")
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

    void deleteRecord() {
        try {
            String input = JOptionPane.showInputDialog(
                this, "Enter Book ID to delete:"
            );

            if (input == null || input.trim().isEmpty()) {
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM book_issues WHERE book_id = ?"
            );

            ps.setInt(1, Integer.parseInt(input));
            int count = ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(
                this,
                count > 0 ? "Record deleted!" : "Record not found."
            );

            viewRecords();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exercise2());
    }
}