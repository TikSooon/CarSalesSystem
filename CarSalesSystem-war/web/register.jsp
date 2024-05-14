
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <a href="login.jsp">Login Page</a>
        <br><br>
        <h2>Registration Page</h2>
        <br>
        <form action="Register" method="POST">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username" size="20" required></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" size="20" required></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="email" name="email" size="20" required></td>
                </tr>
                <tr>
                    <td>Contact: </td>
                    <td><input type="tel" name="contact" pattern="[0-9]{10-11}" required></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" size="20" required></td>
                </tr>
                <tr>
                    <td>Registration Type: </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="type" value="salesman" checked><label for="salesman">Salesman</label><br>
                        <input type="radio" name="type" value="customer"><label for="customer">Customer</label><br>
                    </td>
                </tr>
            </table>
            <p><input type="submit" value="Register"></p>
        </form>
        <p>${requestScope.message}</p>
    </body>
</html>
