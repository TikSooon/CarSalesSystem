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
        <title>Feedback Page</title>
    </head>
    <body>
        <%@ include file = "header/customerheader.html" %><br>
        <h2>Feedback Form</h2>
        <form  action="Feedback" method="POST">
        <fieldset>
            <legend>Payment Details</legend>
            
                Salesman: ${paymentdata.car.salesman.name}<br /><br />
                Brand: ${paymentdata.car.brand}<br /><br />
                Model: ${paymentdata.car.model}<br /><br />
                Manufacturing Year: ${paymentdata.car.caryear}<br /><br />
                Price: ${paymentdata.car.price} <br /><br />
                Status: ${paymentdata.car.status} <br /><br />
                Rating:
                <input type="radio" name="rating" value="1">1
                <input type="radio" name="rating" value="2">2
                <input type="radio" name="rating" value="3">3
                <input type="radio" name="rating" value="4">4
                <input type="radio" name="rating" value="5" checked>5<br>
        </fieldset>
        <fieldset>
            <legend>Feedback</legend>
            <textarea rows="5" cols="30" name="feedback"></textarea>
        </fieldset>

        <input type="submit" value="SUBMIT" />
        <button onclick="location.href='CustomerPayment'" type="button">CANCEL</button>
        <input type="hidden" name="id" value="${paymentdata.paymentid}"/>
        </form>
    </body>
</html>
