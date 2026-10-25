<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%!
    // Helper method to mask the password
    String maskPassword(String pwd) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pwd.length(); i++) {
            sb.append('*');
        }

        return sb.toString();
    }

    // Helper method to escape HTML characters
    String safe(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
%>
<%
    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String password = request.getParameter("password");

    boolean valid = email.contains("@")
                    && phone.matches("[0-9]{10}");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Details</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="box">
        <h2>Registration Details</h2>

        <% if (valid) { %>
            <p class="ok">Registration submitted successfully!</p>

            <table>
                <tr>
                    <th>Name</th>
                    <td><%= safe(name) %></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><%= safe(email) %></td>
                </tr>
                <tr>
                    <th>Phone Number</th>
                    <td><%= safe(phone) %></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><%= maskPassword(password) %></td>
                </tr>
            </table>
        <% } else { %>
            <p class="bad">
                Invalid email or phone number. Please register again.
            </p>
        <% } %>
    </div>
</body>
</html>