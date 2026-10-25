import java.sql.*;

public class Exercise1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/resultset_demo";
        String user = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        String query =
            "SELECT roll_no, name, course, marks FROM students";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Displaying records one by one:");
            System.out.println();

            int count = 0;

            while (rs.next()) {
                count++;

                int rollNo = rs.getInt("roll_no");
                String name = rs.getString("name");
                String course = rs.getString("course");
                double marks = rs.getDouble("marks");

                System.out.println("Record " + count);
                System.out.println("Roll No : " + rollNo);
                System.out.println("Name : " + name);
                System.out.println("Course : " + course);
                System.out.println("Marks : " + marks);
                System.out.println("----------------------");
            }

            System.out.println("Total records displayed: " + count);

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}