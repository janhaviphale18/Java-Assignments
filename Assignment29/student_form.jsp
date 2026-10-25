<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="box">
        <h2>Student Information Form</h2>

        <form action="student_result.jsp" method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td>Roll Number</td>
                    <td><input type="text" name="rollNo" required></td>
                </tr>
                <tr>
                    <td>Course</td>
                    <td><input type="text" name="course" required></td>
                </tr>
                <tr>
                    <td>Marks (out of 100)</td>
                    <td>
                        <input type="number" name="marks"
                               min="0" max="100" required>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>