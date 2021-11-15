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
            <c:forEach var="item" items="${trips}">
                <div id="${item.id}">${item}</div>
                <form action="redirectBuyTickets">
                    <input id="buyTickets" type="submit" value="Buy Tickets" />
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
