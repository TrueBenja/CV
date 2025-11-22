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
    <script src="js/todo-register.js" defer></script>
    <title>Register</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<main>
    <h1>Login</h1>
    <c:if test="${not empty message}">
        <p class="error-message">${message}</p>
    </c:if>

    <fieldset>
        <form action="todo-register" method="post">
            <p>
                <label for="username">Username: </label>
                <input type="text" name="username" id="username" pattern="^\w{1,15}$"><br>
                <label for="password">Password: </label>
                <input type="password" name="password", id="password" pattern="^\w{12,}$">
            </p>
            <input type="submit" value="Registrer">
        </form>
    </fieldset>
    <p>Already registered an account? <a href="todo-login">Login</a></p>
</main>
</body>
</html>