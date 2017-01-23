<%--
  User: alexnevsky
  Date: 16.10.13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<meta name="description" content="About Facemash"/>
	<meta name="keywords" content="Facemash, About, The Social Network, Click"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>About Facemash</title>
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
	js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=154646374589008";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>
<table cellspacing="0" class="facemash">
	<tr class="facemash">
		<th class="facemash"><a href="<c:url value="/" />" class="facemash">FACEMASH</a></th>
	</tr>
	<tr class="facemash">
		<td class="facemash">
			<p>Facemash
				<br/>is a service that allows users to rate the attractiveness
				<br/>of people's photos submitted voluntarily by others.
			</p>
			<p>
				<img src="<c:url value="/resources/images/fm-about-1.jpg" />" width="500" border="0" alt="Facemash"
				     align="middle"/>
			</p>
			<p>
				<div class="fb-like-box" data-href="https://www.facebook.com/facemash.service" data-width="510"
			     data-height="500" data-colorscheme="light" data-show-faces="true" data-header="true"
			     data-stream="false" data-show-border="false">

			     </div>
			</p>

			<table width="100%" border="0">
				<tr>
					<td>&nbsp;</td>
					<td width="500" align="center">
						<p class="main">
							<img src="<c:url value="/resources/images/fm-about-2.jpg" />" width="500" border="0"
							     alt="Jesse Eisenberg Facemash" align="middle"/>
							<br/><br/>
							So, what if it's not even 10pm
							and it's a Tuesday night?

							The Kirkland's facebook
							is open on my desktop

							and somebody of these people with
							pretty horrendous facebook pics.
							<br/><br/>
							<img src="<c:url value="/resources/images/fm-about-3.jpg" />" width="500" border="0"
							     alt="Facemash" align="middle"/>
							<br/><br/>
							Billy Olsen's sitting here had the idea,
							putting some of the picture
							next to picture of farm animal,
							and have people vote who's hotter.
							<br/><br/>
							I'm not gonna do the farm animal but I
							like the idea of comparing two people together.
							<br/><br/>
							<img src="<c:url value="/resources/images/fm-about-4.jpg" />" width="500" border="0"
							     alt="Facemash Girls" align="middle"/>
							<br/><br/>
							It gives the whole thing a very "Turing" feel since
							people's rating of the picture is more implicit...

							Than say, choosing a number to represent each
							person's hotness like they do on hotornot. com

							The first thing we're going
							to need is a lot of picture...
							<br/><br/>
							<img src="<c:url value="/resources/images/fm-about-5.jpg" />" width="500" border="0"
							     alt="Facemash" align="middle"/>
							<br/><br/>
							Let the hacking begin!
							<br/><br/>
							<img src="<c:url value="/resources/images/fm-about-6.jpg" />" width="500" border="0"
							     alt="Andrew Garfield Facemash" align="middle"/>
							<br/><br/>
							Eduardo is here and he is going
							to have the key ingredients.
							<br/><br/>
							- Hey Mark<br/>
							- Eduardo...<br/>
							- I need you.<br/>
							- I'm here for you.<br/>
							- No, I need the algorithm you
							use to rank chess players.<br/>
							- Are you ok?<br/>
							- We're ranking girls.
							<br/><br/>
							<img src="<c:url value="/resources/images/fm-about-7.jpg" />" width="500" border="0"
							     alt="Facemash Stanford" align="middle"/>
							<br/><br/>
							- You mean others student.<br/>
							- Yup.<br/>
							- You think this such a good idea?<br/>
							- I need the algorithm, alright.
							I need the algorithm.
							<br/>
							- Each girl base rating 1400.

							At any given time "Girl A" has a rating
							R-a and "Girl B" has a rating R-b.

							When any 2 girls are matched up,

							there's an expectation of which will
							win based on their current rating, right?

							And all those expectations
							are express this way.<br/>
							<br/>
							- Let's write it.
							<br/><br/>
							<img src="<c:url value="/resources/images/fm-about-8.jpg" />" width="500" border="0"
							     alt="Facemash" align="middle"/>
							<br/><br/>
							- The one on the left.<br/>
							- The right.<br/>
							- It works.
							<br/><br/>
							<img src="<c:url value="/resources/images/fm-about-9.jpg" />" width="500" border="0"
							     alt="Facemash" align="middle"/>
							<br/><br/>
							- Who should we send it first?<br/>
							- Dwyer<br/>
							- Neal
							<br/><br/>
							<img src="<c:url value="/resources/images/fm-about-10.jpg" />" width="500" border="0"
							     alt="Facemash" align="middle"/>
							<br/><br/>
							- Who will you send it to?<br/>
							- Just to couple of people.
							Question is: who are they gonna send it to?
							<br/><br/>
							<a href="#">
							<img src="<c:url value="/resources/images/mark.jpg" />" border="0" alt="Mark
							 Zuckerberg The Social Network" align="middle"/></a>
							<br/><br/>
							<a href="https://www.facebook.com/facemash.service" class="simple">The Social Network</a>
						</p>
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			<div class="footer">
				<div class="container">
					<ul>
						<li><a href="<c:url value="/about" />" class="bottom">About</a></li>
						<li><a href="<c:url value="/" />" class="bottom">Facemash</a></li>
						<li><a href="<c:url value="/top" />" class="bottom">Top 100</a></li>
						<li><a href="https://www.facebook.com/facemash.service" class="bottom">Facebook</a></li>
					</ul>
					<p class="copyright"><a href="http://www.alexnevsky.com" class="copyright">an Alex Nevsky production</a></p>
					<p class="copyright"><a href="http://www.atenwood.com" class="copyright">Atenwood
						&copy; 2013 &middot; From Russia with Love.</a></p>
				</div>
			</div>
		</td>
	</tr>
</table>
</body>
</html>
