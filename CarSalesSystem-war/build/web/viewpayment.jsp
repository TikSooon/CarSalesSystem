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
        <title>Manage Payment Page</title>
    </head>
    <body>
        <%@ include file = "header/customerheader.html" %><br>
        <h2>View Payment Page</h2>
        
        
        <form action="CustomerPayment" method="POST">
            Search Payment: <input type="text" name="search" size="30">
            <input type="submit" value="Go"><br>
        </form>
        
        <p>${requestScope.msg}</p>
        
        <table border="1">
        <tr>
        <th>Payment ID</th>
        <th>Date</th>
        <th>Salesman</th>
        <th>Car Brand</th>
        <th>Car Model</th>
        <th>Car Manufacturing Year</th>
        <th>Car Price</th>
        <th>Feedback</th>
        <th>Rating</th>
        <th>Actions</th>
        </tr> 
        
        <c:forEach items="${requestScope.paymentresult}" var="payment">
            <tr>
            <td>${payment.paymentid}</td>
            <td>${payment.date}</td>
            <td>${payment.salesman.name}</td>
            <td>${payment.car.brand}</td>
            <td>${payment.car.model}</td>
            <td>${payment.car.caryear}</td>
            <td>${payment.car.price}</td>
            <td>${payment.feedback}</td>
            <td>${payment.rating}</td>
            <td><a href="RetrievePayment?id=${payment.paymentid}">Give Feedback</a></td>
            </tr> 
            
        </c:forEach>
        </table>    
        
    </body>
</html>
