import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDetails {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT product_id, product_name, quantity, price FROM products"
            );

            System.out.println("Product Details");
            System.out.println("----------------------------------------");
            System.out.printf("%-12s %-15s %-10s %-10s%n",
                "Product ID", "Product Name", "Quantity", "Price");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                System.out.printf("%-12d %-15s %-10d %-10.2f%n",
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}