<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
</head>
<body>
     <div style="text-align:center;">
        <form action='updateAccount' method='post'>
            Name: <input id="name" type='text' name='name' value="${name}"/>
            <br/><br/>
            Birth date: <input id="dob" type="date" name='dob' value="${dob}">
            <br/><br/>
            Old Password: <input id="oldPassword" type='password' name='oldPassword'/>
            <br/><br/>
            New Password: <input id="password" type='password' name='password'/>
            <br/><br/>
            Confirm New Password: <input id="passwordCopy" type='password' name='passwordCopy'/>
            <br/><br/>
            <input type='submit' value='Update Account'/>
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
