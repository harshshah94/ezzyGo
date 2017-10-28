<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Ezzy Go | Master Page</title>

<spring:url value="/resources/css/images/slide1.jpg" var="slide1" />
<spring:url value="/resources/css/images/slide2.jpg" var="slide2" />
<spring:url value="/resources/css/images/slide3.jpg" var="slide3" />


<%-- <spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
<spring:url value="/resources/css/main.css" var="mainCss1" />
<link href="${mainCss}" rel="stylesheet" />
<link href="${mainCss1}" rel="stylesheet" />
 --%>
<spring:url value="/resources/css/style.css" var="styleCSS" />
<spring:url value="/resources/js/jquery-1.4.1.min.js" var="jqueryMin" />
<spring:url value="/resources/js/jquery-func.js" var="jqueryFunc" />
<spring:url value="/resources/js/jquery.jcarousel.pack.js"
	var="jqueryPack" />

<link rel="stylesheet" href="${styleCSS}" type="text/css" media="all" />
<script src="${jqueryMin}" type="text/javascript"></script>
<script src="${jqueryFunc}" type="text/javascript"></script>
<script src="${jqueryPack}" type="text/javascript"></script>

</head>

<body>
</head>
<body bgcolor="pink">

	<!-- Shell -->
	<div class="shell">
		<!-- Header -->
		<div id="header">
			<h1 id="logo">
				<a href="#">Ezzy Go | Simple to Travel</a>
			</h1>

			<!-- Cart -->
			<div id="cart">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="/Ezzy_GO/user/showCustomerRegister" class="cart-link1"
					id="reg123">Sign-Up</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a
					href="/Ezzy_GO/user/showLogin" class="cart-link1" id="val123">Login</a><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="/Ezzy_GO/user/showAgentRegister" class="cart-link1"
					id="val123">Agent Register</a> <a href="/Ezzy_GO/user/invalidate"
					class="cart-link1" id="signup123"></a>
				<div class="cl">&nbsp;</div>
			</div>
			<!-- End Cart -->

			<a id="nana">${loginUser.firstName}!!</a>

			<c:if test="${!empty loginUser}">
				<script type="text/javascript">
					document.getElementById('reg123').innerHTML = null;
					document.getElementById('val123').innerHTML = null;
					document.getElementById('name123').innerHTML = document
							.getElementById('nana').innerHTML;
					document.getElementById('signup123').innerHTML = "SignOut";
				</script>
			</c:if>

			<c:if test="${empty loginUser}">
				<script type="text/javascript">
					document.getElementById('reg123').innerHTML = "Sign-Up";
					document.getElementById('val123').innerHTML = "Login";
					document.getElementById('name123').innerHTML = null;
					document.getElementById('signup123').innerHTML = null;
				</script>
			</c:if>
			<!-- Navigation -->
			<div id="navigation">
				<ul>
					<li><a href="/Ezzy_GO/user/goToHome">Home</a></li>
					<li><a href="/Ezzy_GO/user/showPrintTicket">Print Ticket</a></li>
					<li><a href="/Ezzy_GO/user/showCancelTicket">Cancel Ticket</a></li>
					<li><a href="/Ezzy_GO/general/contactUs">Contact</a></li>
				</ul>
			</div>
			<!-- End Navigation -->
		</div>
		<!-- End Header -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			<!-- Content -->
			<div id="content">
				<!-- Content Slider -->
				<div id="slider" class="box">
					<div id="slider-holder">
						<ul>
							<li><a href="#"><img src="${slide3}" alt="" /></a></li>
							<li><a href="#"><img src="${slide1}" alt="" /></a></li>
							<li><a href="#"><img src="${slide2}" alt="" /></a></li>
						</ul>
					</div>
					<div id="slider-nav">
						<a href="#" class="active">1</a> <a href="#">2</a> <a href="#">3</a>
						<a href="#">4</a>
					</div>
				</div>

			</div>
			<!-- End Content -->
			<!-- Sidebar -->
			<div id="sidebar">
				<!-- Search -->
				<div class="box search">
					<h2>
						Third Party Adds<span></span>
					</h2>
					<div class="box-content">
						<div class="inline-field"></div>
					</div>
				</div>

				<div class="box categories">

					<h2>
						Third Party Adds <span></span>
					</h2>
					<div class="box-content"></div>
				</div>
				<div class="box categories" style="border: 0px"></div>
			</div>
		</div>



	</div>

</body>
</html>
