<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="baselayout.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/js/layout.js" var="layoutjs" />
<script type="text/javascript" src="${layoutjs}"></script>
<title>LayoutPage</title>
</head>
<body onload="generateInputBox()">

	<form action="addLayoutAndBus" method="get">
		<div id="div1_id" align="center">
			<h3>Bus Layout</h3>
			<input disabled="disabled" type="hidden" name="doubleDecker"
				id="doubleDeckerId" value="${sessionScope.bus.doubleDecker}" /><br />

			<input disabled="disabled" type="text" name="structure"
				id="structureId" value="${sessionScope.bus.busStructure}" />
		</div>
		<div id="div2_id" align="center"></div>
		<div id="div3_id" align="center"></div>
		<div id="div4_id" align="center"></div>
	</form>
</body>
</html>