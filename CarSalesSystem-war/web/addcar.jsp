<%-- 
    Document   : AddCar
    Created on : 23 Feb 2023, 13:13:21
    Author     : wongtiksoon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Car Page</title>
    </head>
    <body>
        <%@ include file = "header/staffheader.html" %><br>
        <h2>Add Car Form</h2>
        <form  action="AddCar" method="POST">
        <fieldset>
            <legend>Car Details</legend>
            
            Brand: <input type="text" name="brand" /><br /><br />
            Model: <input type="text" name="model" /><br /><br />
            Manufacturing Year : <input type="text" name="caryear" /><br /><br />
            Price: <input type="text" name="price" /><br /><br />
            Salesman:
            <select name = "salesman">
                <c:forEach items="${validsalesman}" var="SalesmanList">
                    <option value="${SalesmanList.salesmanid}">${SalesmanList.name}</option>
                </c:forEach>
            </select>
        </fieldset><br>
 
 
        <input type="submit" value="SUBMIT" />
        <input type="reset" value="CLEAR" />
        </form>
        <p>${requestScope.msg}</p>
    </body>
</html>
