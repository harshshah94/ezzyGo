<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="baselayout.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddSchedule</title>
</head>
<body>
	<div align="center">
		<form:form action="addSchedule" method="post">
			<table>
				<tr>
					<td>Bus</td>
					<td><input type="text" name="bus" list="buses"
						autocomplete="on"> <datalist id="buses">
							<c:forEach var="bus" items="${busList}">
								<option value="${bus.busName}"></option>
							</c:forEach>
						</datalist></td>
				</tr>
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
					<td>Departure Date and time</td>
					<td><input type="datetime-local" name="departureTime"></td>
				</tr>
				<tr>
					<td>Arrival Date and time</td>
					<td><input type="datetime-local" name="arrivalTime"></td>
				</tr>
				<tr>
					<td>Seat fare</td>
					<td><input type="text" name="seatFare" /></td>
				</tr>
				<tr>
					<td>Sleep fare</td>
					<td><input type="text" name="sleepFare" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add Schedule" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>