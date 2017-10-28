<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ include file="baselayout.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewSeats</title>
</head>
<body>
	<table style="border-collapse: separate; border-spacing: 5px;">
		<tr>
			<td>from: ${sourceCity.cityName}</td>
			<td>To: ${destinationCity.cityName}</td>
			<td>Seats: ${seatsRequired}</td>
		</tr>
		<tr>
			<td>Bus Name: ${currentSchedule.busDetail.busName}</td>
		</tr>
		<tr>

			<td>${currentSchedule.busDetail.busStructure}and
				${(currentSchedule.busDetail.ac != 'Y') ? 'Non-AC' : 'AC'}</td>
		</tr>
		<tr>
			<td>Departure: <fmt:formatDate pattern="h:mm a"
					value="${currentSchedule.departureTime}" /></td>
			<td>Arrival: <fmt:formatDate pattern="h:mm a"
					value="${currentSchedule.arrivalTime}" /></td>
		</tr>
		<tr>
			<td>Seating Price: ${currentSchedule.seatFare}</td>
			<td>Sleeping price:${currentSchedule.sleepFare}</td>
		</tr>
	</table>

	<table>

	</table>
</body>
</html>