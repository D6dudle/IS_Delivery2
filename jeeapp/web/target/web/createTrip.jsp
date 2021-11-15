<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/14/2021
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Trip</title>
</head>
<body>
    <form action='createTrip' method='post'>
        <div style="text-align:center;">
            Departure Date: <input id="departureDate" type="date" name='departureDate'>
            <br/><br/>
            Departure Point: <input id="departurePoint" type='text' name='departurePoint'/>
            <br/><br/>
            Destination Point: <input id="destinationPoint" type='text' name='destinationPoint'/>
            <br/><br/>
            Capacity: <input id="maxCapacity" type='number' name='maxCapacity' min="0"/>
            <br/><br/>
            Price: <input id="price" type='number' name='price' min="0" step="0.01"/>
            <br/><br/>
            <input type='submit' value='Create Trip'/>
        </div>
    </form>
    <div style="text-align:center;">
        <br/><br/>
         <a href="mainManager.jsp">Back</a>
        <br/><br/>
        <form action='logOut' method='post'>
            <input type='submit' value='Log Out'/>
        </form>
    </div>
</body>
</html>
