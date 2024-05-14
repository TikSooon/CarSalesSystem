<%-- 
    Document   : editinformation
    Created on : 23 Feb 2023, 15:47:49
    Author     : wongtiksoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Information Page</title>
    </head>
    <body>
        <%@ include file = "header/staffheader.html" %><br>
        <h2>Edit Car Details Form</h2>
        <form  action="EditCars" method="POST">
        <fieldset>
            <legend>Car Details</legend>
            
            Brand: <input type="text" name="brand" value="${cardata.brand}"/><br /><br />
            Model: <input type="text" name="model" value="${cardata.model}"/><br /><br />
            Manufacturing Year: <input type="text" name="caryear" value="${cardata.caryear}"/><br /><br />
            Price: <input type="text" name="price" value="${cardata.price}" /><br /><br />
            Status: <input type="text" name="status" value="${cardata.status}" disabled/><br /><br />
            Salesman: <input type="text" name="salesman" value="${cardata.salesman.name}" disabled /><br /><br />
            Booked Customer: <input type="text" name="bookedcustomer" value="${cardata.bookedcustomer.name}" disabled/>
            
        </fieldset><br>
        
        <input type="submit" value="SUBMIT" />
        <button onclick="location.href='ManageCars'" type="button">
         CANCEL</button>
        <input type="hidden" name="id" value="${param.id}"/>
        </form>
        <p>${requestScope.message}</p>
    </body>
</html>
