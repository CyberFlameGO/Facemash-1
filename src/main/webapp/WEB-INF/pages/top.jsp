<%--
  User: alexnevsky
  Date: 15.10.13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<meta name="description" content="Facemash Celebrities Top 100"/>
	<meta name="keywords" content="Facemash, Celebrities, Top 100, Top, Rating"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Top 100 - Facemash</title>
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
			<h3>Top Faces</h3>

			<div id="imgBlock">
				<table border="0" align="center" class="images">
					<c:forEach items="${girlsTop}" var="gTop" varStatus="gStatus">
						<tr>
							<td align="center">
								<a href="https://www.facebook.com/<c:url value="${gTop.id}" />" class="hotname">
									<p>
										<img src="<c:url value="${gTop.pathToImage}" />" alt=" <c:out
										value="${gTop.firstName}" escapeXml="false"/> <c:out
										value="${gTop.lastName}" escapeXml="false"/>"
										     align="bottom" height="320" width="216"/>
									</p>
									#<c:out value="${gStatus.count}" escapeXml="false"/>.
									<c:out value="${gTop.firstName}" escapeXml="false"/>
									<c:out value="${gTop.lastName}" escapeXml="false"/>
									(<fmt:formatNumber var="gRating"
									                   value="${(gTop.rating / maxGirlsRating) * 100}"
									                   maxFractionDigits="2"/><c:out value="${gRating}"
									                                                 escapeXml="false"/>%)
								</a>
								<br/><br/>
							</td>
							<td align="center">
								&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							</td>
							<td align="center">
								<a href="https://www.facebook.com/<c:url
								value="${boysTop[gStatus.count - 1].id}" />" class="hotname">
									<p>
										<img src="<c:url value="${boysTop[gStatus.count - 1].pathToImage}" />" alt="
										 <c:out
										value="${boysTop[gStatus.count - 1].firstName}" escapeXml="false"/> <c:out
										value="${boysTop[gStatus.count - 1].lastName}" escapeXml="false"/>"
										     align="bottom" height="320" width="216" />
									</p>
									#<c:out value="${gStatus.count}" escapeXml="false"/>.
									<c:out value="${boysTop[gStatus.count - 1].firstName}" escapeXml="false"/>
									<c:out value="${boysTop[gStatus.count - 1].lastName}" escapeXml="false"/>
									(<fmt:formatNumber var="bRating"
									                   value="${(boysTop[gStatus.count - 1].rating / maxBoysRating) * 100}"
									                   maxFractionDigits="2"/><c:out value="${bRating}"
									                                                 escapeXml="false"/>%)
								</a>
								<br/><br/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
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
