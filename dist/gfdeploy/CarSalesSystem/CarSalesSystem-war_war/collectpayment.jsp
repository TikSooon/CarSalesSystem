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
        <title>Collect Payment Page</title>
    </head>
    <body>
        <%@ include file = "header/salesmanheader.html" %><br>
        <h2>Collect Payment Form</h2>
        <form  action="CollectPayment" method="POST">
        <fieldset>
            <legend>Payment Details</legend>
            
                Brand: ${cardata.brand}<br /><br />
                Model: ${cardata.model}<br /><br />
                Manufacturing Year: ${cardata.caryear}<br /><br />
                Price: ${cardata.price} <br /><br />
                Status: ${cardata.status} <br /><br />
                Salesman: ${cardata.salesman.name}<br /><br />
                Booked Customer: ${cardata.bookedcustomer.name}

        </fieldset>
        <fieldset>
            <legend>Comment</legend>
            <textarea rows="5" cols="30" name="comment"></textarea>
        </fieldset>

        <input type="submit" value="SUBMIT" />
        <button onclick="location.href='SalesmanSearchCar'" type="button">
         CANCEL</button>
        <input type="hidden" name="id" value="${cardata.carid}"/>
        </form>
    </body>
</html>
