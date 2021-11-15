<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My Tickets</title>
</head>
<body>
    <div style="text-align:center;">
        <c:forEach var="item" items="${myTicketList}">
            <form action='cancelTicket' method='post'>
                Partida: <input id="departure" type="text" value="${item.trip.departurePoint}"readonly/><br>
                Destino: <input id="destination" type="text" value="${item.trip.destinationPoint}"readonly/><br>
                Data: <input id="destination" type="text" value="${item.trip.date}"readonly/><br>
                <input type='submit' name="submit" value='Cancel Ticket ID:${item.id}'/>
            </form>
        </c:forEach>
        <br/><br/>
        <a href="main.jsp">Back</a>
        <br/><br/>
        <form action='logOut' method='post'>
            <input type='submit' value='Log Out'/>
        </form>
    </div>
</body>
</html>
