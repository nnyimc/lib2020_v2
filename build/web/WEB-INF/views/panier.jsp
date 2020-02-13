<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  type="text/css" rel="stylesheet" href="css/style.css"/>
        <title>LibGrp1</title>
    </head>
    <body>
        <header>
            <a href="index.jsp"><h1>LibGrp1</h1></a>
        </header>
        <c:out  escapeXml="false"  value="<h2>Votre panier</h2>"/> 
        
<c:forEach items="${requestScope.detailsPanier}" var="livre">
     <c:out escapeXml="false" value=
               "
               <div class='panier'>
                    <h3 class='titre'>${livre['livreTitre']}</h3>
               </div>
               "
         />   
</c:forEach>
        
<c:out escapeXml="false" 
    value="<a href='accueil?actionPaiement=OK'><button id='achat' type='button'>Payer</button></a>" 
/>

<c:import url="/WEB-INF/includes/footer.jsp"/>
