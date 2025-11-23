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
    <title>Todo</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<main>
    <h1>Huskeliste</h1>
    <form action="add-todo" method="post">
        <label for="todo">Legg til en ting i huskelisten:</label>
        <p>
            <input type="text" name="todo" id="todo">
            <input type="submit" value="+">
        </p>
    </form>

    <form action="remove-todos" method="post">
        <ul id="todo-list">
            <c:forEach var="todo" items="${todos}">
                <li>
                    <input type="checkbox" name="todos" id="${todo}" value="${todo}"> <label for="${todo}"><c:out value="${todo}"/></label>
                </li>
            </c:forEach>
        </ul>
        <br>
        <input type="submit" value="Fjern valgte">
    </form>
    <br>
    <form action="todo-logout" method="post">
        <input type="submit" value="Logg ut">
    </form>
</main>
</body>
</html>