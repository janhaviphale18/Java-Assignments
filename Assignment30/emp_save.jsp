<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");

    String action = request.getParameter("action");

    Connection con = getConnection();
    PreparedStatement ps = null;

    if ("add".equals(action)) {
        // CREATE
        ps = con.prepareStatement(
            "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)"
        );

        ps.setString(1, request.getParameter("name"));
        ps.setString(2, request.getParameter("department"));
        ps.setInt(3, Integer.parseInt(request.getParameter("salary")));

    } else if ("update".equals(action)) {
        // UPDATE
        ps = con.prepareStatement(
            "UPDATE employees SET name = ?, department = ?, salary = ? WHERE emp_id = ?"
        );

        ps.setString(1, request.getParameter("name"));
        ps.setString(2, request.getParameter("department"));
        ps.setInt(3, Integer.parseInt(request.getParameter("salary")));
        ps.setInt(4, Integer.parseInt(request.getParameter("id")));

    } else if ("delete".equals(action)) {
        // DELETE
        ps = con.prepareStatement(
            "DELETE FROM employees WHERE emp_id = ?"
        );

        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    }

    if (ps != null) {
        ps.executeUpdate();
        ps.close();
    }

    con.close();

    // Return to the employee list
    response.sendRedirect("emp_list.jsp");
%>