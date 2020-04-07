<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/12/2020
  Time: 7:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>news</title>
</head>
<body>
<a href="/home">Back to customer list</a>
    <h1>${requestScope["news"].getTitle()}</h1>
    <h1>${requestScope["news"].getDate()}</h1>
    <a><img src="${requestScope["news"].getImg()}"></a>
    <h1>${requestScope["news"].getContent()}</h1>

</body>
</html>