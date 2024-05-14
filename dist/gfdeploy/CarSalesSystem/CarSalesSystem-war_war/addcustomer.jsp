<%-- 
    Document   : editinformation
    Created on : 23 Feb 2023, 15:47:49
    Author     : wongtiksoon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Page</title>
    </head>
    <body>
        <%@ include file = "header/salesmanheader.html" %><br>
        <h2>Customer Booking Form</h2>
        <form  action="AddCustomer" method="POST">
        <fieldset>
            <legend>Car Details</legend>
            
                Brand: ${cardata.brand}<br /><br />
                Model: ${cardata.model}<br /><br />
                Manufacturing Year: ${cardata.caryear}<br /><br />
                Price: ${cardata.price} <br /><br />
                Status: ${cardata.status} <br /><br />
                Salesman: ${cardata.salesman.name}<br /><br />
                Booked Customer: 
                <select name = "bookedcustomer">
                    <c:forEach items="${validcustomer}" var="customer">
                        <option value="${customer.customerid}">${customer.name}</option>
                    </c:forEach>
                </select>

        </fieldset><br>

        <input type="submit" value="SUBMIT" />
        <button onclick="location.href='SalesmanSearchCar'" type="button">
         CANCEL</button>
        <input type="hidden" name="id" value="${cardata.carid}"/>
        </form>
    </body>
</html>
