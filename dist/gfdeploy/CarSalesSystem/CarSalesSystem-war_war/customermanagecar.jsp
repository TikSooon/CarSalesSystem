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
        <title>Manage Booking Page</title>
    </head>
    <body>
        <%@ include file = "header/customerheader.html" %><br>
        <h2>Manage Booking Page</h2>
        
        <form action="CustomerSearchCar" method="POST">
        Search Booking: <input type="text" name="search" size="30">
        <input type="submit" value="Go">
        </form>
       
        
        <br><br>
        <table border="1">
        <tr>
            <th>Salesman</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Manufacturing Year</th>
            <th>Price</th>
            <th>Status</th>
        </tr> 
        
        <c:forEach items="${requestScope.carresult}" var="car">
            <tr>
            <td>${car.salesman.name}</td>
            <td>${car.brand}</td>
            <td>${car.model}</td>
            <td>${car.caryear}</td>
            <td>${car.price}</td>
            <td>${car.status}</td>
            </tr> 
            
        </c:forEach>
        </table>    
        
    </body>
</html>
