import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRecords {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM students"
            );

            System.out.println("Student Records:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("roll_no") + " " +
                    rs.getString("name") + " " +
                    rs.getString("course") + " " +
                    rs.getDouble("marks")
                );
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}