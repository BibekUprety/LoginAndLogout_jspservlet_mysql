<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<div class="box">
    <h1 style="color:#8B008B;">Login</h1>
    <div class="sub">
        <form method="POST" action="loginController">

            <label class="lbl">Username</label><br><input type="username" name="username" class="label"><br>
            <label class="lbl">Password</label><br><input type="password" name="password" class="label"><br>
            <button class="btn">LOGIN</button>

        </form>
    </div>
</div>
</body>
</html>