<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link  type="text/css" rel="stylesheet" href="css/style.css"/>
        <script type="text/javascript" src="scripts/bookAutoComplete.js"></script>
        <title>LibGrp1</title>
    </head>
    <body>
        <header>
            <a href="index.jsp"><h1>LibGrp1</h1></a>
            <div id="caddie">
                 <c:if test="${sessionScope.taillePanier > 0}">
                    <span id="taillePanier"><c:out value="${sessionScope.taillePanier}"/></span>
                 </c:if>
                 
                <c:import url="/accueil?div=compteurPanier"/>
                <c:url value="/accueil?vue=detailsPanier" var="url01"/>
                <a href="${url01}" flush="false">
                    <img id="caddieLogo" src="images/caddie.jpg" alt="caddie"/>
                </a>
            </div>
        </header>