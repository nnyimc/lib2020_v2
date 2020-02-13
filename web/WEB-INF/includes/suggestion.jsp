<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<c:set var="test" value="${resultatAuto}" scope="request"/>
<c:out value="${requestScope.test}"/>--%>

<c:forEach items="${requestScope.resultatAuto}" var="suggestion">
    <c:out value="${suggestion}"/>
</c:forEach>

<%-- EMPTY SCOPE?!! --%>

