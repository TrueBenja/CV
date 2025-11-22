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
    <title>Hjem</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<main>
    <h1>Hjem</h1>
    <c:if test="${not empty visitedBefore}">
        <p>${visitedBefore}</p>
    </c:if>
    <p>Velkommen til min nettside! Her vil du få informasjon om hvem jeg er, og hva jeg har å tilby.</p>
</main>
</body>
</html>