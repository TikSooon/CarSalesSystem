
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        
        <h2>Welcome to Car Sales System!</h2>
        
        <h4>Please login to use the system.</h4>
        <br>
        <form action="Login" method="POST">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username" size="20" required></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" size="20" required></td>
                </tr>
                 <tr>
                    <td>Login Type: </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="type" value="staff" checked><label for="staff">Staff</label><br>
                        <input type="radio" name="type" value="salesman"><label for="salesman">Salesman</label><br>
                        <input type="radio" name="type" value="customer"><label for="customer">Customer</label><br>
                    </td>
                </tr>
            </table>
            <p><input type="submit" value="Login"></p><br>
            <a href="register.jsp">New User Registration</a>
        </form>
    </body>
</html>
