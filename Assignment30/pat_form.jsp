<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>
<%
    String id = request.getParameter("id");
    String name = "", age = "", disease = "", status = "Admitted";
    String title = "Add Patient";

    if (id != null) {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM patients WHERE patient_id = ?"
        );

        ps.setInt(1, Integer.parseInt(id));
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            name = rs.getString("name");
            age = String.valueOf(rs.getInt("age"));
            disease = rs.getString("disease");
            status = rs.getString("treatment_status");
            title = "Update Patient";
        }

        rs.close();
        ps.close();
        con.close();
    }

    String[] options = {
        "Admitted", "Under Treatment", "Recovered", "Discharged"
    };
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

        <form action="pat_save.jsp" method="post">
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
                    <td>Age</td>
                    <td>
                        <input type="number" name="age"
                            value="<%= age %>" required>
                    </td>
                </tr>
                <tr>
                    <td>Disease</td>
                    <td>
                        <input type="text" name="disease"
                            value="<%= disease %>" required>
                    </td>
                </tr>
                <tr>
                    <td>Treatment Status</td>
                    <td>
                        <select name="status">
                            <% for (String o : options) { %>
                                <option value="<%= o %>"
                                    <%= o.equals(status) ? "selected" : "" %>>
                                    <%= o %>
                                </option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form>

        <p><a href="pat_list.jsp">Back to list</a></p>
    </div>
</body>
</html>