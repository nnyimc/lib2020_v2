<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/includes/header.jsp"/>
<c:import url="/WEB-INF/includes/includeRecherche.jsp"/>
        
            <div id="devanture">
            <c:forEach items="${devanture}" var="livre">
                    <c:out escapeXml="false" value=
                           "
                           <div class='article'>
                                <h3 class='titre'>${livre['livreTitre']}</h3>
                                <img class='couverture' src='${livre['livreCouverture']}'/>

                                <a href='accueil?div=panier&add=${livre['livreIsbn']}'>
                                    <button class='achat' type='button'>Ajouter au panier</button>
                                </a>
                           </div>
                           "
                     />   
            </c:forEach> 
            </div>

<c:import url="/accueil?div=compteurPanier"/>
<c:import url="/WEB-INF/includes/footer.jsp"/>