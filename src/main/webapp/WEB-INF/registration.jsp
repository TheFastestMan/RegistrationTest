<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
    <label for="name">Name:
        <input type="text" name="name" id="name">
    </label><br>

    <label for="email">Email:
        <input type="text" name="email" id="email">
    </label><br>

    <label for="pwd">Password:
        <input type="password" name="pwd" id="pwd">
    </label><br>

    <input type="submit" value="Send">
</form>
</body>
</html>
