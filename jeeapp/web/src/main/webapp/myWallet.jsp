<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Wallet</title>
</head>
    <body>
        <div style="text-align:center;">
            <form action='updateWallet' method='post'>
                My Credit: <input id="wallet" type='number' name='wallet' step="0.01" value="${wallet}"readonly/>
                <br/><br/>
                Add Currency: <input id="income" type="number" name='income' step="0.01" value=0 min=0>
                <br/><br/>
                <input type='submit' value='Add Currency'/>
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
