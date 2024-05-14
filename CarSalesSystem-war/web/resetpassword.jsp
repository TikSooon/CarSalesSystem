<%-- 
    Document   : editinformation
    Created on : 23 Feb 2023, 15:47:49
    Author     : wongtiksoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password Page</title>
    </head>
    <body>
        
        <h2>Reset Password Form</h2>
        <form  action="ResetPassword" method="POST">
        <fieldset>
            <legend>Reset Password</legend>

            New Password: <input type="password" name="password" "/><br /><br />
            Confirm Password: <input type="password" name="conpassword" "/><br />

        </fieldset><br>

        <input type="submit" value="SUBMIT" />
        <button onclick="location.href='Home'" type="button">CANCEL</button>
        </form>
    </body>
</html>
