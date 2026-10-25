<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="box">
        <h2>User Registration</h2>

        <form action="register_result.jsp" method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td>
                        <input type="text" name="phone"
                               pattern="[0-9]{10}" required>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="password" name="password" required>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>