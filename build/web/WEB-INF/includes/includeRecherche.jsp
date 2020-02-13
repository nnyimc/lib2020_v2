<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <div id="rechercheBarre">
            <form action="recherche" method="POST" accept-charset="UTF-8"> 
                <select id="typeRecherche" name="type">
                    <option value="auteur">Auteur</option>
                    <option value="isbn">ISBN</option>
                    <option value="mot_cle">Mot-Clé</option>
                    <option value="titre">Titre</option>
                    <option value="theme">Theme</option>
                </select>
                <input type="text" id="contenuRecherche" name="recherche" onkeyup="bookSuggestion()"/>
                <button id="recherche" type="submit" name="envoiRecherche">
                    <img id="loupe" src="images/loupe.jpg" alt="loupe"/>
                </button>
                <c:import url="/WEB-INF/includes/suggestion.jsp"/>
            </form>
            <p><c:out escapeXml="false" value="${message}"/></p>
        </div>
