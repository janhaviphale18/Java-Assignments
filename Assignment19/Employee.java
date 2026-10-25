import java.sql.*;

public class Employee {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = "YOUR_MYSQL_PASSWORD";

    public static void main(String[] args) {
        try (Connection con =
                 DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Database connected successfully!");

            // INSERT
            String insert = "INSERT INTO employee VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insert)) {
                ps.setInt(1, 104);
                ps.setString(2, "Priya");
                ps.setString(3, "IT");
                ps.setDouble(4, 55000);
                ps.executeUpdate();
                System.out.println("Employee inserted successfully.");
            }

            // READ
            displayEmployees(con);

            // UPDATE
            String update =
                "UPDATE employee SET salary = ? WHERE emp_id = ?";
            try (PreparedStatement ps = con.prepareStatement(update)) {
                ps.setDouble(1, 60000);
                ps.setInt(2, 104);
                ps.executeUpdate();
                System.out.println("Employee updated successfully.");
            }

            // DELETE
            String delete = "DELETE FROM employee WHERE emp_id = ?";
            try (PreparedStatement ps = con.prepareStatement(delete)) {
                ps.setInt(1, 104);
                ps.executeUpdate();
                System.out.println("Employee deleted successfully.");
            }

            // Display final records
            displayEmployees(con);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void displayEmployees(Connection con) throws SQLException {
        String query = "SELECT * FROM employee";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\nEmployee Records:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("emp_id") + " | " +
                    rs.getString("emp_name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary")
                );
            }
        }
    }
}