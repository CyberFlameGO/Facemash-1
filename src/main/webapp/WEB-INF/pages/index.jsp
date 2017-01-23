<%--
  User: alexnevsky
  Date: 04.10.13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<meta name="description" content="Facemash. The Social Network. Who's Hotter? Click to Choose."/>
	<meta name="keywords" content="Facemash, Celebrities, Rating"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Facemash</title>
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
<div id="fb-root"></div>
<script>(function (d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) return;
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=403667559706541";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>
<table cellspacing="0" class="facemash">
	<tr class="facemash">
		<th class="facemash"><a href="<c:url value="/" />" class="facemash">FACEMASH</a></th>
	</tr>
	<tr class="facemash">
		<td class="facemash">
			<p class="firstline">Were we let in for our looks? No. Will we be judged on them? Yes.</p>

			<p class="seconline">Who's Hotter? Click to Choose.</p>

			<div id="hotfaces" class="displaybox">
				<div id="imgBlock">
					<table border="0" align="center" class="images">
						<tr>
							<td align="center">
								<form action="<c:url value="/left" />" method="post" name="leftFaceForm">
									<input type="hidden" name="mode" value="<c:out
									value="${mode}" escapeXml="false"/>">
									<input type="hidden" name="leftId" value="<c:out
									value="${leftFace.id}" escapeXml="false"/>">
									<input type="hidden" name="rightId" value="<c:out
									value="${rightFace.id}" escapeXml="false"/>">
									<input type="hidden" name="faceIdArrayToNextPage" value="<c:forEach
					items="${faceIdArrayToNextPage}" var="faceId"><c:out value="${faceId}" escapeXml="false"/>,</c:forEach>-1">
									<a href="#" class="hotname"
									   onclick="document.forms['leftFaceForm'].submit(); return false;">
										<p>
											<img src="<c:url value="${leftFace.pathToImage}" />"
											     align="middle" height="320"/>
										</p>
										<c:out value="${leftFace.firstName}" escapeXml="false"/>
										<c:out value="${leftFace.lastName}" escapeXml="false"/>
									</a>
								</form>
							</td>
							<td>&nbsp; OR &nbsp;</td>
							<td align="center">
								<form action="<c:url value="/right" />" method="post" name="rightFaceForm">
									<input type="hidden" name="mode" value="<c:out
									value="${mode}" escapeXml="false"/>">
									<input type="hidden" name="leftId" value="<c:out
									value="${leftFace.id}" escapeXml="false"/>">
									<input type="hidden" name="rightId" value="<c:out
									value="${rightFace.id}" escapeXml="false"/>">
									<input type="hidden" name="faceIdArrayToNextPage" value="<c:forEach
					items="${faceIdArrayToNextPage}" var="faceId"><c:out value="${faceId}" escapeXml="false"/>,</c:forEach>-1">
									<a href="#" class="hotname"
									   onclick="document.forms['rightFaceForm'].submit(); return false;">
										<p>
											<img src="<c:url value="${rightFace.pathToImage}" />"
											     align="middle" height="320"/>
										</p>
										<c:out value="${rightFace.firstName}" escapeXml="false"/>
										<c:out value="${rightFace.lastName}" escapeXml="false"/>
									</a>
								</form>
							</td>
						</tr>
						<tr>
							<td align="center">&nbsp;</td>
							<td align="center">
								<p class="next"><a href="<c:url value="/next?mode=${mode}" />" class="next"
								                   title="Next Players">&rarr;</a></p>
							</td>
							<td align="center"></td>
						</tr>
					</table>
				</div>
			</div>
			<br /><br />
			<br /><br />
			<br /><br />
			<span style="color:darkred;">&nbsp;&nbsp;<c:out value="${message}" escapeXml="false"/>&nbsp;&nbsp;</span>
			<br/>
			<div class="fb-like" data-href="https://www.facebook.com/facemash.service"
			     data-width="" data-height=""
			     data-colorscheme="light" data-layout="button_count" data-action="like" data-show-faces="true"
			     data-send="false">
			</div>
			<ul class="uppercase">
				<li>
					<a href="<c:url value="/?mode=boysFacebook" />" class="upperlink"
					   style="color:red;" >Facebook [Boys]</a>
				</li>
				|
				<li>
					<a href="<c:url value="/?mode=girlsFacebook" />" class="upperlink"
					   style="color:deeppink;" >Facebook [Girls]</a>
				</li>
				|
				<li>
					<a href="<c:url value="/?mode=girls" />" class="upperlink"
					   style="color:deeppink;" >Celebrities [Girls]</a>
				</li>
				|
				<li>
					<a href="<c:url value="/?mode=boys" />" class="upperlink"
					   style="color:red;" >Celebrities [Boys]</a>
				</li>
			</ul>

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
