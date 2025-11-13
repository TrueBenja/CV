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
    <title>Error</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="/">Hjem</a></li>
        <li><a href="/about">Om meg</a></li>
    </ul>
</nav>
<main>
    <h1>Error Status Code: ${status}</h1>
</main>
</body>
</html>