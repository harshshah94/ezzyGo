<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="baselayout.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BusList</title>
</head>
<body>
	<table style="border-collapse: separate; border-spacing: 5px;">
		<tr>
			<td>from: ${sourceCity.cityName}</td>
		</tr>
		<tr>
			<td>To: ${destinationCity.cityName}</td>
		</tr>
		<tr>
			<td>Seats: ${seatsRequired}</td>
		</tr>
	</table>
	<c:choose>
		<c:when test="${empty scheduleData}">
			<h4>Sorry... no bus found for this route</h4>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>BusName</th>
					<th>BusDetails</th>
					<th>Departure</th>
					<th>Arrival</th>
					<th>Seating Price</th>
					<th>Sleeping price</th>
					<th></th>
				</tr>
				<c:forEach items="${scheduleData}" var="schedule">
					<tr>
						<form:form action="ViewSeats" modelAttribute="schedule">
							<form:hidden path="routeId" value="${schedule.routeId}" />
							<td>${schedule.busDetail.busName}</td>
							<td>${schedule.busDetail.busStructure}and
								${(schedule.busDetail.ac != 'Y') ? 'Non-AC' : 'AC'}</td>

							<td><fmt:formatDate pattern="h:mm a"
									value="${schedule.departureTime}" /></td>
							<td><fmt:formatDate pattern="h:mm a"
									value="${schedule.arrivalTime}" /></td>
							<td>${schedule.seatFare}</td>
							<td>${schedule.sleepFare}</td>
							<td><input type="submit" value="view seats"></td>
						</form:form>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>