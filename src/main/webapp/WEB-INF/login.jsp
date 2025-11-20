<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <title>Login</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<main>
    <h1>Login</h1>
    <fieldset>
        <form action="todo_login" method="post">
            <p>
                <label for="username">Username: </label>
                <input type="text" name="username" id="username">
            </p>
            <input type="submit" value="Login">
        </form>
    </fieldset>
</main>
</body>
</html>