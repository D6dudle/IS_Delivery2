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
    <form action='updateAccount' method='post'>
        Username: <input id="name" type='text' name='name'/>
        <br/><br/>
        Birth date: <input id="dob" type="date" name='dob'>
        <br/><br/>
        Old Password: <input id="oldPassword" type='text' name='oldPassword'/>
        <br/><br/>
        New Password: <input id="password" type='text' name='password'/>
        <br/><br/>
        Confirm New Password: <input id="passwordCopy" type='text' name='passwordCopy'/>
        <br/><br/>
        <input type='submit' value='updateAccount'/>
    </form>
</body>
</html>
