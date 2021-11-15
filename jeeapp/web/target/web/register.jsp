<%--
  Created by IntelliJ IDEA.
  User: Henri
  Date: 11/13/2021
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register</title>
    </head>
    <body>
        <div style="text-align:center;">
            <form action='register' method='post'>
                Name: <input type='username' name='username'/>
                <br/><br/>
                Birth date: <input id="dob" type="date" name='dob'>
                <br/><br/>
                Email: <input type='text' name='email'/>
                <br/><br/>
                Password: <input type='password' name='password'/>
                <br/><br/>
                Password: <input type='password' name='passwordCopy'/>
                <br/><br/>
                <input type='submit' value='register'/>
            </form>
        </div>
    </body>
</html>

