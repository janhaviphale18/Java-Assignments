import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DATABASE()");

            if (rs.next()) {
                String databaseName = rs.getString(1);

                System.out.println(
                    "Student database is connected successfully."
                );
                System.out.println("Database Name: " + databaseName);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}