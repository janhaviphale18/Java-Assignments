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
            "INSERT INTO patients (name, age, disease, treatment_status) VALUES (?, ?, ?, ?)"
        );

        ps.setString(1, request.getParameter("name"));
        ps.setInt(2, Integer.parseInt(request.getParameter("age")));
        ps.setString(3, request.getParameter("disease"));
        ps.setString(4, request.getParameter("status"));

    } else if ("update".equals(action)) {
        // UPDATE
        ps = con.prepareStatement(
            "UPDATE patients SET name = ?, age = ?, disease = ?, treatment_status = ? WHERE patient_id = ?"
        );

        ps.setString(1, request.getParameter("name"));
        ps.setInt(2, Integer.parseInt(request.getParameter("age")));
        ps.setString(3, request.getParameter("disease"));
        ps.setString(4, request.getParameter("status"));
        ps.setInt(5, Integer.parseInt(request.getParameter("id")));

    } else if ("delete".equals(action)) {
        // DELETE
        ps = con.prepareStatement(
            "DELETE FROM patients WHERE patient_id = ?"
        );

        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    }

    if (ps != null) {
        ps.executeUpdate();
        ps.close();
    }

    con.close();

    response.sendRedirect("pat_list.jsp");
%>