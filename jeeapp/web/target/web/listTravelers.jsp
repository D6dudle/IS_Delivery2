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
    <title>Selected Trip Passengers</title>
</head>
<body>
    <form action='localhost:8080/web/main'>
        <div style="text-align:center;">
            <c:forEach var="item" items="${travelers}">
                <div>
                    ${item}
                    <br/><br/>
                </div>
            </c:forEach>
            <br/><br/>
            <a href="mainManager.jsp">Back</a>
            <br></br>
            <form action='logOut' method='post'>
                <input type='submit' value='Log Out'/>
            </form>
        </div>
    </form>
</body>
</html>
