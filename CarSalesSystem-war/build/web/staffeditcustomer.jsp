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
        <%@ include file = "header/staffheader.html" %><br>
        <h2>Edit Customer Details Form</h2>
        <form  action="EditUsers" method="POST">
        <fieldset>
            <legend>Customer Details</legend>
            
            Name: <input type="text" name="name" value="${customerdata.name}" required/><br /><br />
            Email: <input type="email" name="email" value="${customerdata.email}" required/><br /><br />
            Contact: <input type="tel" name="contact" pattern="[0-9]{10-11}" value="${customerdata.contact}" required/><br /><br />
            Approved: <input type="text" name="status" value="${customerdata.approved}" disabled/>
            
        </fieldset><br>
 
        <input type="submit" value="SUBMIT" />
        <input type="hidden" name="id" value="${param.id}"/>
        <input type="hidden" name="type" value="customer"/>
        </form>
        
        <p>${requestScope.message}</p>
    </body>
</html>
