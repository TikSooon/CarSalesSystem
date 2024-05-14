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
        <title>Edit Information Page</title>
    </head>
    <body>
        <%@ include file = "header/salesmanheader.html" %><br>
        <h2>Edit Salesman Details Form</h2>
        <form  action="EditSalesman" method="POST">
        <fieldset>
            <legend>Salesman Details</legend>

            Name: <input type="text" name="name" value="${salesmandata.name}" required/><br /><br />
            Email: <input type="email" name="email" value="${salesmandata.email}" required/><br /><br />
            Contact: <input type="tel" name="contact" pattern="[0-9]{10-11}"value="${salesmandata.contact}" required/><br />

        </fieldset><br>

        <input type="submit" value="SUBMIT" />
        <button onclick="location.href='resetpassword.jsp'" type="button">
         RESET PASSWORD</button>
        </form>
            <br>
            <p>${requestScope.message}</p>
    </body>
</html>
