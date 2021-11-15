<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/14/2021
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top 5 Passengers (by number of trips)</title>
</head>
<body>
    <form action='localhost:8080/web/main'>
        <div style="text-align:center;">
            <c:forEach var="item" items="${topUsers}">
                <div>
                    ${item}
                    <br/><br/>
                </div>
            </c:forEach>
            <br/><br/>
            Manager
            <br/><br/>
            <a href="mainManager.jsp">Back</a>
            <form action='logOut' method='post'>
                <input type='submit' value='Log Out'/>
            </form>
        </div>
    </form>
</body>
</html>