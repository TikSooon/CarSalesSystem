<%-- 
    Document   : managesalesman
    Created on : 23 Feb 2023, 16:30:05
    Author     : wongtiksoon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Salesman Page</title>
    </head>
    <body>
        <%@ include file = "header/staffheader.html" %><br>
        <h2>Manage Salesman Page</h2>
        
        <form action="SearchSalesman" method="POST">
        Search Salesman: <input type="text" name="search" size="30">
        <input type="submit" value="Go"><br>
        Filter: <br>
        <input type="radio" name="filter" value="all" checked>All
        <input type="radio" name="filter" value="approved">Approved
        <input type="radio" name="filter" value="notapproved">Not Approved
        </form>
        <p>${requestScope.msg}</p>
        
        <table border="1">
        <tr>
        <th>Username</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Approved</th>
        <th colspan="2">Actions</th>
        </tr> 
        
        <c:forEach items="${requestScope.salesmanresult}" var="salesman">
            <tr>
            <td>${salesman.username}</td>
            <td>${salesman.name}</td>
            <td>${salesman.email}</td>
            <td>${salesman.contact}</td>
            <td>${salesman.approved}</td>
            
            <td><a href="RetrieveSalesman?id=${salesman.salesmanid}">Edit</td>
            <td><a href="DeleteSalesman?id=${salesman.salesmanid}" onclick="return confirm('Are you sure you want to delete this salesman?');">Delete</td>
            </tr> 
            
        </c:forEach>
        </table>    
        
    </body>
</html>
