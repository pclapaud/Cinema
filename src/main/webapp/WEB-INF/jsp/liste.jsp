<%--
  Created by IntelliJ IDEA.
  User: patou
  Date: 14/11/2018
  Time: 10:47
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
<c:forEach items="${requestScope['mesfilm']}" var="film" >
    <li><a href="/details/${film.id}">${film.titre}</a></li>
</c:forEach>

</body>
</html>
