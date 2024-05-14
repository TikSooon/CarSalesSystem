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
        <title>Manage Car Page</title>
    </head>
    <body>
        <%@ include file = "header/salesmanheader.html" %><br>
        <h2>Manage Car Page</h2>
        
        <form action="SalesmanSearchCar" method="POST">
        Search Car: <input type="text" name="search" size="30">
        <input type="submit" value="Go">
        </form>
       <p>${requestScope.msg}</p>
        
        <table border="1">
        <tr>
        <th>Brand</th>
        <th>Model</th>
        <th>Manufacturing Year</th>
        <th>Price</th>
        <th>Status</th>
        <th>Salesman</th>
        <th>Booked Customer</th>
        <th colspan="5">Actions</th>
        </tr> 
        
        <c:forEach items="${requestScope.carresult}" var="car">
            <tr>
            <td>${car.brand}</td>
            <td>${car.model}</td>
            <td>${car.caryear}</td>
            <td>${car.price}</td>
            <td>${car.status}</td>
            <td>${car.salesman.name}</td>
            <td>${car.bookedcustomer.name}</td>
            <td><a href="RetrieveCustomerName?id=${car.carid}">Add Customer</a></td>
            <td><a href="RetrieveCar?id=${car.carid}">Edit</td>
            <td><a href="RetrieveCarforPayment?id=${car.carid}">Collect Payment</td>
            <td><a href="CancelCar?id=${car.carid}" onclick="return confirm('Are you sure you want to cancel this car?')">Cancel Car</td>
            </tr> 
            
        </c:forEach>
        </table>    
        
    </body>
</html>
