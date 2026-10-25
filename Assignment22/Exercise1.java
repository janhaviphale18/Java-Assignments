import java.sql.*;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/login_db";
        String user = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();

        String query =
            "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, loginPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + username);
            } else {
                System.out.println("Invalid username or password.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        sc.close();
    }
}