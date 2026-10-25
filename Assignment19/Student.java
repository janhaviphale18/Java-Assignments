import java.sql.*;

public class Student {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = "YOUR_MYSQL_PASSWORD";

    public static void main(String[] args) {
        try (Connection con =
                 DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Database connected successfully!");

            // INSERT
            String insert = "INSERT INTO student VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insert)) {
                ps.setInt(1, 4);
                ps.setString(2, "Priya");
                ps.setString(3, "CSE");
                ps.setDouble(4, 88);
                ps.executeUpdate();
                System.out.println("Student inserted successfully.");
            }

            // READ
            displayStudents(con);

            // UPDATE
            String update =
                "UPDATE student SET marks = ? WHERE roll_no = ?";
            try (PreparedStatement ps = con.prepareStatement(update)) {
                ps.setDouble(1, 95);
                ps.setInt(2, 4);
                ps.executeUpdate();
                System.out.println("Student updated successfully.");
            }

            // DELETE
            String delete = "DELETE FROM student WHERE roll_no = ?";
            try (PreparedStatement ps = con.prepareStatement(delete)) {
                ps.setInt(1, 4);
                ps.executeUpdate();
                System.out.println("Student deleted successfully.");
            }

            // Display final records
            displayStudents(con);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void displayStudents(Connection con) throws SQLException {
        String query = "SELECT * FROM student";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\nStudent Records:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("roll_no") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("course") + " | " +
                    rs.getDouble("marks")
                );
            }
        }
    }
}