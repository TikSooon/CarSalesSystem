<%-- 
    Document   : staffeditinformation
    Created on : 23 Feb 2023, 15:43:30
    Author     : wongtiksoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Staff Information Page</title>
    </head>
    <body>
        <%@ include file = "header/staffheader.html" %><br>
        <h2>Edit Staff Information Form</h2>
        <form  action="EditStaff" method="POST">
        <fieldset>
            <legend>Staff Details</legend>
            
            Name: <input type="text" name="name" value="${staffdata.name}"required/><br /><br />
            Email: <input type="email" name="email" value="${staffdata.email}" required/><br /><br />
            Contact: <input type="tel" name="contact" pattern="[0-9]{10-11}" value="${staffdata.contact}" required/><br />
            
        </fieldset><br>
 
        <input type="submit" value="SUBMIT" />
        <input type="hidden" name="id" value="${param.id}" />
        </form>
        <p>${requestScope.message}</p>
    </body>
</html>
