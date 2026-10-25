import java.sql.*;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = sc.nextLine();

        String query =
            "SELECT name, role FROM hospital_staff " +
            "WHERE login_id = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, loginId);
            ps.setString(2, loginPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");

                System.out.println("Login successful!");
                System.out.println("Welcome, " + name);
                System.out.println("Role: " + role);

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Doctor access granted.");
                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Nurse access granted.");
                }

            } else {
                System.out.println("Invalid login ID or password.");
                System.out.println("Access denied.");
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