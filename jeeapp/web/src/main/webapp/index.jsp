<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form action='login' method='post'>
            Email: <input type='text' name='email'/>
            <br/><br/>
            Password: <input type='password' name='password'/>
            <br/><br/>
            <input type='submit' value='login'/>
        </form>
        <form action='<%= request.getContextPath() %>/register.jsp' method='get'>
            <input type='submit' value='Create User'/>
        </form>
    </body>
</html>
