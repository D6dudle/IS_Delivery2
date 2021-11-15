<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ticket Purchase</title>
</head>
<body>
    <div style="text-align:center;">
        <form action='buyTicket' method='post'>
            <!-- Colocar aqui dados da viagem -->

            Number of Tickets: <input id="numberOfTickets" type="number" name='numberOfTickets'>

            <c:forEach var = "i" begin = "1" end = "${numberOfTickets}">
                Lugar ${i} <select name="lugar${i}" id="lugar${i}">
                                <c:forEach var="item" items="${lugares}"> <!-- Adicionar à classe Trip -->
                                    <option value="item">item</option> <!-- Devolver este valor -->
                                </c:forEach>
                            </select>
            </c:forEach>
            <a href="main.jsp">Back</a>
            <input id="buy" type="submit" value="Buy" />
        </form>
    </div>
</body>
</html>
