<%-- 
    Document   : managestaff
    Created on : 24 Feb 2023, 15:38:06
    Author     : wongtiksoon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Staff Page</title>
    </head>
    <body>
        <%@ include file = "header/staffheader.html" %><br>
        <h2>Manage Staff Page</h2>
        
        <form action="SearchStaff" method="POST">
        Search Staff: <input type="text" name="search" size="30">
        <input type="submit" value="Go">
        </form>
        
        <p>${requestScope.msg}</p>
        
        <table border="1">
        <tr>
        <th>Username</th>
        <th>Staff Name</th>
        <th>Email</th>
        <th>Contact</th>
        <th colspan="2">Actions</th>
        </tr> 
       
        <c:forEach items="${requestScope.staffresult}" var="staff">
            <tr>
            <td>${staff.username}</td>
            <td>${staff.name}</td>
            <td>${staff.email}</td>
            <td>${staff.contact}</td>
            
            <td><a href="RetrieveStaff?id=${staff.staffid}">Edit</td>
            <td><a href="DeleteStaff?id=${staff.staffid}" onclick="return confirm('Are you sure you want to delete this staff?');">Delete</td>
            </tr> 
        </c:forEach>
            
        </table>
    </body>
</html>
