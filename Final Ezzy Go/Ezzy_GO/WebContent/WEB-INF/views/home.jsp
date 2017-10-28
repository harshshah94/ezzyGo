<%@page import="com.app.ezzygo.utils.EzzyGoConstants"%>
<%@ include file="baselayout.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ezzy Go | Home</title>
</head>
<body>
	<h1>Home page</h1>

	<c:set var="role" scope="session" value="${loginRole}" />
	<c:out value="${role}"></c:out>
	<c:if test="${'agent'==role}">
		<p>
			<a href="/EzzyGo/bus/showAddBus">Add Bus</a> <br /> <a
				href="/EzzyGo/schedule/showAddSchedule">Add schedule</a>
		<p>
	</c:if>
	<a href="/EzzyGo/ticket/PassengerInfo">PassengerInfo</a>
	<br />
	<div align="center">
		<form:form action="/EzzyGo/search/SearchSchedule" method="get">
			<table>
				<tr>
					<td>Source city</td>
					<td><input type="text" name="sourceCity" list="cities"
						autocomplete="on"> <datalist id="cities">
							<c:forEach var="city" items="${cityList}">
								<option value="${city.cityName}"></option>
							</c:forEach>
						</datalist></td>
				</tr>
				<tr>
					<td>Destination city</td>
					<td><input type="text" name="destinationCity" list="cities"
						autocomplete="on"> <datalist id="cities">
							<c:forEach var="city" items="${cityList}">
								<option value="${city.cityName}"></option>
							</c:forEach>
						</datalist></td>
				</tr>
				<tr>
					<td>Date</td>
					<td><input type="date" name="date"></td>
				</tr>
				<tr>
					<td>Seats required</td>
					<td><input type="text" name="seatsRequired"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Search" /></td>
				</tr>
			</table>
		</form:form>


	</div>
</body>
</html>