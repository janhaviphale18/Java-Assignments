<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Records</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="wide">
        <h2>Employee Management System</h2>

        <p><a class="btn" href="emp_form.jsp">+ Add New Employee</a></p>

        <table class="grid">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Salary</th>
                <th>Actions</th>
            </tr>

            <%
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM employees ORDER BY emp_id"
                );
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt("emp_id") %></td>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("department") %></td>
                <td><%= rs.getInt("salary") %></td>
                <td>
                    <a href="emp_form.jsp?id=<%= rs.getInt("emp_id") %>">Edit</a>
                    |
                    <a href="emp_save.jsp?action=delete&id=<%= rs.getInt("emp_id") %>"
                       onclick="return confirm('Delete this employee?');">
                        Delete
                    </a>
                </td>
            </tr>
            <%
                }

                rs.close();
                ps.close();
                con.close();
            %>
        </table>
    </div>
</body>
</html>