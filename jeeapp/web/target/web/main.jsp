<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    <!-- https://stackoverflow.com/a/2906586 -->
    <!-- Provavelmente terão q ser gets -->
    <div style="text-align:center;">
        <form action="redirectEditAccount" method="get">
            <input id="editAccount" type="submit" value="Edit Account" />
        </form>
        <br/><br/>
        <form action="redirectGetUserWallet" method="get">
            <input id="myWallet" type="submit" value="My Wallet" />
        </form>
        <br/><br/>
        <form action="redirectGetUserTickets" method="get">
            <input id="myTickets" type="submit" value="My Tikets" />
        </form>
        <br/><br/>
        <form action="redirectGetTrips" method="get">
            <input id="trips" type="submit" value="Trips" />
        </form>
        <br/><br/>
        <form action='logOut' method="post">
            <input type='submit' value='Log Out'/>
        </form>
    </div>
</body>
</html>
