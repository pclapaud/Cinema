<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
Ordonné
<h2>Le cinema de Tomcat</h2>

        <a href="/list?name=NC">note croissant</a><br>
        <a href="/list?name=ND">note decroissant</a><br>
        <a href="/list?name=NOMC">nom croissant</a><br>
        <a href="/list?name=NOMD">nom decroissant</a>

<br><br>
<%--Cherchez film--%>
<form method="post" action="/list">Cherchez film :
    <input name="name" type="text">
    <input type="submit" action="/list">
</form>
<%--connection--%>
<form method="post" action="/session">Connection :
    <input name="nom" type="text">user
    <input name="mdp" type="password">mdp
    <input type="submit" action="/Session">
</form>
</body>
</html>
