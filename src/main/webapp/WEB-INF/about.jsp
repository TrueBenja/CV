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
    <title>Om meg</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<main>
    <h1>Om meg</h1>
    <img id="my-picture" src="images/bilde_av_meg.jpg" alt="Bilde av meg">
    <p>Jeg heter Benjamin, og jeg er dataingeniørstudent ved HVL. Dette er mitt forsøk på en CV-like nettside for å vise hva jeg kan.</p>
    <p>Jeg kan ikke si jeg er noe front-end spesialist, men jeg prøver.</p>
</main>
</body>
</html>