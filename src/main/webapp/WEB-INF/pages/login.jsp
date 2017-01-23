<%--
  User: alexnevsky
  Date: 24.11.13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<title>My Dear Friend</title>
</head>
<body>
<h1>Hello, My Dear Friend!</h1>

<form action="<c:url value="/say" />" method="post" name="sayForm">
	Say something... <input type="text" name="message">
	<br /> <br />
	<a href="#" onclick="document.forms['sayForm'].submit(); return false;">Send</a>
</form>
<p>------------------------------------------------</p>
<p><a href="<c:url value="/" />">Home</a></p>
</body>
</html>