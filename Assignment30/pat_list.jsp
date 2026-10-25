<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Records</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="wide">
        <h2>Patient Record Management</h2>

        <p><a class="btn" href="pat_form.jsp">+ Add New Patient</a></p>

        <table class="grid">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Disease</th>
                <th>Treatment Status</th>
                <th>Actions</th>
            </tr>

            <%
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM patients ORDER BY patient_id"
                );
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt("patient_id") %></td>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getInt("age") %></td>
                <td><%= rs.getString("disease") %></td>
                <td><%= rs.getString("treatment_status") %></td>
                <td>
                    <a href="pat_form.jsp?id=<%= rs.getInt("patient_id") %>">
                        Edit
                    </a>
                    |
                    <a href="pat_save.jsp?action=delete&id=<%= rs.getInt("patient_id") %>"
                       onclick="return confirm('Delete this patient record?');">
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