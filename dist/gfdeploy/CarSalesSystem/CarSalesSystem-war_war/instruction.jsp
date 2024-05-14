<%-- 
    Document   : updatecar
    Created on : 23 Feb 2023, 15:23:13
    Author     : wongtiksoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Car Details Page</title>
    </head>
    <body>
        <h2>Update Car Details Form</h2>
        <form  action="AddCar" method="POST">
        <fieldset>
            <legend>Car Details</legend>
            
            Brand: <input type="text" name="brand" /><br /><br />
            Model: <input type="text" name="model" /><br /><br />
            Manufacturing Year : <input type="text" name="caryear" /><br /><br />
            Price: <input type="text" name="price" /><br /><br />
            Status: <br />
            <input type="radio" name="status" value="available" checked />Available<br />
            <input type="radio" name="status" value="booked" />Booked<br />
            <input type="radio" name="status" value="paid" />Paid<br /><br />
            Age: 
            <select name = "age">
                <option value="1">&lt; 1 year old</option>
                <option value="99">1 to 99 years old</option>
                <option value="100">&gt; 99 years old</option>
            </select>
           
        </fieldset>
        <fieldset>
            <legend>Instructions</legend>
            <textarea rows="5" cols="30" name="instruction"></textarea>
        </fieldset>
 
        <input type="submit" value="SUBMIT" />
        <input type="reset" value="CLEAR" />
        </form>
    </body>
</html>
