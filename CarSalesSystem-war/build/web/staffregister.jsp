<%-- 
    Document   : staffregister
    Created on : 22 Feb 2023, 16:00:09
    Author     : wongtiksoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Registration</title>
    </head>
    <body>
        <%@ include file = "header/staffheader.html" %><br>
        <h2>Register User Form</h2>
        <form  action="AddStaff" method="POST">
        <fieldset>
            <legend>User Details</legend>
            
            Username: <input type="text" name="username" required/><br /><br />
            Name: <input type="text" name="name" required/><br /><br />
            Contact: <input type="tel" name="contact" pattern="[0-9]{10-11}" required><br /><br />
            Email: <input type="email" name="email" required/><br /><br />
            Password: <input type="password" name="password" required/><br /><br />
            Registration Type:<br><br>
            <input type="radio" name="type" value="staff" checked><label for="staff">Staff</label><br>
            <input type="radio" name="type" value="salesman"><label for="salesman">Salesman</label><br>
            <input type="radio" name="type" value="customer"><label for="customer">Customer</label><br>
            
            
        </fieldset><br>
 
 
        <input type="submit" value="SUBMIT" />
        <input type="reset" value="CLEAR" />
        </form>
        <p>${requestScope.message}</p>
    </body>
</html>
