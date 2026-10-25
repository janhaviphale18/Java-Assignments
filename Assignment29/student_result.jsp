<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
    // Read data sent by the form
    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name");
    String rollNo = request.getParameter("rollNo");
    String course = request.getParameter("course");
    int marks = Integer.parseInt(request.getParameter("marks"));
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="box">
        <h2>Student Information</h2>

        <table>
            <tr><th>Name</th><td><%= name %></td></tr>
            <tr><th>Roll Number</th><td><%= rollNo %></td></tr>
            <tr><th>Course</th><td><%= course %></td></tr>
            <tr><th>Marks</th><td><%= marks %> / 100</td></tr>
        </table>

        <% if (marks >= 40) { %>
            <p class="ok">Result: Pass</p>
        <% } else { %>
            <p class="bad">Result: Fail</p>
        <% } %>
    </div>
</body>
</html>