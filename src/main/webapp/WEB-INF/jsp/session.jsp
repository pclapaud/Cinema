<%--
  Created by IntelliJ IDEA.
  User: patou
  Date: 14/11/2018
  Time: 11:09
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
Bonjour ${nomU}<br>
<c:if test="${historique !='[]'}">


votre historique:
<ul>

    <c:forEach items="${requestScope['historique']}" var="nom" >
    <li>${nom}</li>
    </c:forEach>
</ul>
</c:if>
<a href="/index.jsp">retour</a>
</body>
</html>
