<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Section transféree en page d'accueil pour compter les références présentes dans le caddie--%>
<c:if test="${requestScope.compteurPanier > 0}">
    <span id="compteurPanier"><c:out value="${requestScope.compteurPanier}"/></span>
</c:if>