<%--
  Created by IntelliJ IDEA.
  User: patou
  Date: 14/11/2018
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<li>Titre : ${film.titre}</li>
<li><img height="300" width="300" src="/affiche/${film.id}"></li>
<li> Note :${film.note}</li>
</ul>
<c:if test="${connecté == true}">
    <a href="/session">ma session</a>
</c:if>


</body>
</html>
