<%--
  User: alexnevsky
  Date: 17.01.14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<meta name="description" content="Facemash. The Social Network. Who's Hotter? Click to Choose."/>
	<meta name="keywords" content="Facemash, Celebrities, Rating"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Facemash - Face</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/facemash-main.css" />"/>
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push(['_setAccount', 'UA-21698633-1']);
		_gaq.push(['_trackPageview']);
		(function () {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</head>
<body>
<table cellspacing="0" class="facemash">
	<tr class="facemash">
		<th class="facemash"><a href="<c:url value="/" />" class="facemash">FACEMASH</a></th>
	</tr>
	<tr class="facemash">
		<td class="facemash">
			<p class="firstline">Facemash Game</p>

			<p class="seconline">Face Rating</p>

			<a href="#" class="hotname"
				<p>
					<img src="<c:url value="${face.pathToImage}" />"
					     align="middle" height="320"/>
				</p>
				<c:out value="${face.firstName}" escapeXml="false"/>
				<c:out value="${face.lastName}" escapeXml="false"/>
			</a>

			<br /><br />
			<c:out value="${face.rating}" escapeXml="false"/>

			<br /><br />
			<span style="color:darkred;">&nbsp;&nbsp;<c:out value="${message}" escapeXml="false"/>&nbsp;&nbsp;</span>

			<br /><br />

			<div class="footer">
				<div class="container">
					<ul>
						<li><a href="<c:url value="/about" />" class="bottom">About</a></li>
						<li><a href="<c:url value="/" />" class="bottom">Facemash</a></li>
						<li><a href="<c:url value="/top" />" class="bottom">Top 100</a></li>
						<li><a href="https://www.facebook.com/facemash.service" class="bottom">Facebook</a></li>
					</ul>
					<p class="copyright"><a href="http://www.alexnevsky.com" class="copyright">an Alex
						Nevsky production</a></p>

					<p class="copyright"><a href="http://www.atenwood.com" class="copyright">Atenwood
						&copy; 2013 &middot; From Russia with Love.</a></p>
				</div>
			</div>
		</td>
	</tr>
</table>
</body>
</html>
