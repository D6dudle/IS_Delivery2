<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ticket Purchase</title>
</head>
<body>
    <div style="text-align:center;">
        <form action='buyTickets' method='post'>
            <!-- Colocar aqui dados da viagem -->
            ID: <input id="tripId" name="tripId" type="number" value="${tripId}" readonly disabled/><br/><br/>
            Partida: <input id="departure" type="text" value="${departurePoint}" readonly disabled/>${' '}
            Destino: <input id="destination" type="text" value="${destinationPoint}" readonly disabled/><br/><br/>
            Data: <input id="date" type="date" value="${date}" readonly disabled/><br/><br/>
            Capacidade máxima: <input id="maxCapacity" type="number" value="${maxCapacity}" readonly disabled/>${' '}
            Lotação: <input id="soldTickets" type="number" value="${soldTickets}" readonly disabled/><br/><br/>
            Preço/bilhete: <input id="price" type="number" value="${price}" readonly disabled/>
            <br/><br/>
            Number of Tickets: <input id="numberOfTickets" type="number" name='numberOfTickets' min="1">
            <!--
            <c:forEach var = "i" begin = "1" end = "${numberOfTickets}">
                Lugar ${i} <select name="lugar${i}" id="lugar${i}">
                                <c:forEach var="x" begin="1" end = "${lugares}">
                                    <option value="item">item</option> <!-- Devolver este valor -->
                                </c:forEach>
                            </select>
            </c:forEach>
            -->
            <input name="submit" type="submit" value="Buy for Trip ID:${tripId}" />
        </form>
        <br/><br/>
        <a href="main.jsp">Back</a>
        <br/><br/>
        <form action='logOut' method='post'>
            <input type='submit' value='Log Out'/>
        </form>
    </div>
</body>
</html>
