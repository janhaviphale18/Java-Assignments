import java.sql.*;

public class Exercise2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        String query =
            "SELECT emp_id, emp_name, department, salary " +
            "FROM employees";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Employee Records (one by one):");
            System.out.println("------------------------------");

            while (rs.next()) {
                System.out.println(
                    "Row " + rs.getRow() + ": " + format(rs)
                );
            }

            System.out.println("------------------------------");

            if (rs.last()) {
                System.out.println("Last record : " + format(rs));
            }

            if (rs.previous()) {
                System.out.println("Previous record : " + format(rs));
            }

            if (rs.first()) {
                System.out.println("First record : " + format(rs));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    static String format(ResultSet rs) throws SQLException {
        return rs.getInt("emp_id") + " | " +
               rs.getString("emp_name") + " | " +
               rs.getString("department") + " | " +
               rs.getDouble("salary");
    }
}