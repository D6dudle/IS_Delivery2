<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trips</title>
</head>
<body>
    <div style="text-align:center;">
        Filter by date:
        <br/><br/>
        <form action="filterTrips" method='post'>
            From day: <input id="de" type="date" name='de'> ${' '}
            To day: <input id="a" type="date" name='a'> ${' '}
            At day: <input id="em" type="date" name='em'> ${' '}
            <input id="filterTrips" type="submit" value="Filter" />
        </form>
        <br/><br/>
        <c:forEach var="item" items="${trips}">
            Partida: <input id="departure" type="text" value="${item.departurePoint}" readonly disabled/>${' '}
            Destino: <input id="destination" type="text" value="${item.destinationPoint}" readonly disabled/>${' '}
            Data: <input id="destination" type="text" value="${item.date}" readonly disabled/><br/><br/>
            <form action="listTripTravelers" method='post'>
                <input name="submit" id="listTripTravelers" type="submit" value="List Passengers Trip ID:${item.id}"/>
            </form>
            <form action="deleteTrip" method='post'>
                <input name="submit" id="deleteTrip" type="submit" value="Delete Trip ID:${item.id}" />
            </form>
            <br/><br/>
        </c:forEach>
        <a href="mainManager.jsp">Back</a>
        <br/><br/>
        <form action='logOut' method='post'>
            <input type='submit' value='Log Out'/>
        </form>
    </div>
</body>
</html>
