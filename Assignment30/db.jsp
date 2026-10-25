<%@ page import="java.sql.*" %>
<%!
    // Common method used by every page to connect to MySQL
    Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/jspcrud",
            "root",
            "root"
        );
    }
%>