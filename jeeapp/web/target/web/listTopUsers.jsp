<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/14/2021
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Top 5 Passengers (by number of trips)</title>
</head>
<body>
    <div style="text-align:center;">
        <c:forEach var="item" items="${topUsers}">
            <div>
                Nome: ${item.name}<br/>
                Email: ${item.email}<br/>
                DOB: ${item.dob}
                <br/><br/>
            </div>
        </c:forEach>
        <br/><br/>
        <a href="mainManager.jsp">Back</a>
        <br/><br/>
        <form action='logOut' method='post'>
            <input type='submit' value='Log Out'/>
        </form>
    </div>
</body>
</html>