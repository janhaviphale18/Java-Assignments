<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>
<%
    String id = request.getParameter("id");
    String name = "", department = "", salary = "";
    String title = "Add Employee";

    if (id != null) {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM employees WHERE emp_id = ?"
        );

        ps.setInt(1, Integer.parseInt(id));
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            name = rs.getString("name");
            department = rs.getString("department");
            salary = String.valueOf(rs.getInt("salary"));
            title = "Update Employee";
        }

        rs.close();
        ps.close();
        con.close();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title><%= title %></title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="box">
        <h2><%= title %></h2>

        <form action="emp_save.jsp" method="post">
            <input type="hidden" name="action"
                value="<%= (id == null) ? "add" : "update" %>">

            <input type="hidden" name="id"
                value="<%= (id == null) ? "" : id %>">

            <table>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name"
                            value="<%= name %>" required>
                    </td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td>
                        <input type="text" name="department"
                            value="<%= department %>" required>
                    </td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td>
                        <input type="number" name="salary"
                            value="<%= salary %>" required>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form>

        <p><a href="emp_list.jsp">Back to list</a></p>
    </div>
</body>
</html>