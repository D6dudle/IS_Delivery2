<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trips</title>
</head>
<body>
    <form action='localhost:8080/web/main' method='post'>
        <div style="text-align:center;">
            Filter by date:
            <br/><br/>
            From day: <input id="de" type="date" name='de'>
            To day: <input id="a" type="date" name='a'>
            At day: <input id="at" type="date" name='at'>
            <form action="filterTrips" method='post'>
                <input id="filterTrips" type="submit" value="Filter" />
            </form>
            <br/><br/>
            <c:forEach var="item" items="${trips}">
                <div>${item}</div>
                <form action="listTripTravelers" method='get'>
                    <input id="listTripTravelers" type="submit" value="List Passengers" />
                </form>
                <form action="deleteTrip" method='post'>
                    <input id="deleteTrip" type="submit" value="Delete Trip" />
                </form>
                <br/><br/>
            </c:forEach>
            <a href="main.jsp">Back</a>
            <br/><br/>
            <form action='logOut' method='post'>
                <input type='submit' value='Log Out'/>
            </form>
        </div>
    </form>
</body>
</html>
