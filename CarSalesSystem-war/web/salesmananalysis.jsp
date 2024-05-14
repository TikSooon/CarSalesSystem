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
        <title>Salesman Analysis Page</title>
    </head>
    <body>
        <%@ include file = "header/staffheader.html" %><br>
        <h2>Salesman Analysis Page</h2>
        
        
        <form action="SearchAnalysis" method="POST">
            Search Salesman: <input type="text" name="search" size="30">
            <input type="submit" value="Go"><br>
            Sort By: <br>
            <input type="radio" name="filter" value="none" checked>None
            <input type="radio" name="filter" value="revenue">Revenue
            <input type="radio" name="filter" value="carsold">Total Cars Sold
            <input type="radio" name="filter" value="rating">Rating
        </form>
        
        <br>
        <table border="1">
        <tr>
            <th>Salesman ID</th>
            <th>Salesman</th>
            <th>Revenue</th>
            <th>Total Cars Sold</th>
            <th>Average Rating</th>
        </tr> 
        
        <c:forEach items="${requestScope.analysisresult}" var="analysis">
            <tr>
                <td>${analysis.sales.salesmanid}</td>
                <td>${analysis.sales.name}</td>
                <td>${analysis.price}</td>
                <td>${analysis.carsold}</td>
                <td>${analysis.rating}</td>
            </tr> 
        </c:forEach>
        </table>    
    </body
</html>
