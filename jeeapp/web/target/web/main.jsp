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
    <!--
        <div>
            <a href="localhost:8080/web/editAccount">
                <button>Edit Account</button>
            </a>
            <br/><br/>
            <a href="localhost:8080/web/trips">
                <button>Trips</button>
            </a>
            <br/><br/>
            <a href="localhost:8080/web/myTickets">
                <button>My Wallet</button>
            </a>
            <br/><br/>
            <a href="localhost:8080/web/myTickets">
                <button>My Tikets</button>
            </a>
        </div>
    -->

    <!-- https://stackoverflow.com/a/2906586 -->
    <form action="localhost:8080/web/editAccount">
        <input id="editAccount" type="submit" value="Edit Account" />
    </form>
    <br/><br/>
    <form action="localhost:8080/web/trips">
        <input id="trips" type="submit" value="Trips" />
    </form>
    <br/><br/>
    <form action="localhost:8080/web/myWallet">
        <input id="myWallet" type="submit" value="My Wallet" />
    </form>
    <br/><br/>
    <form action="localhost:8080/web/myTickets">
        <input id="myTickets" type="submit" value="My Tikets" />
    </form>
</body>
</html>
