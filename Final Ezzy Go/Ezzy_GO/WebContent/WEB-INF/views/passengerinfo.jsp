<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="baselayout.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.sorg/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger info</title>
</head>
<body>
	No. of seats:
	<form action="SubmitPassengers">
		<table border=1>
			<c:forEach begin="1" end="5" var="i">
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name${i}"></td>
					<td>Age:</td>
					<td><input type="text" name="age${i}"></td>
					<td>Gender:</td>
					<td><input type="radio" name="gender${i}" value="M">Male
						<input type="radio" name="gender" value="F">Female</td>
					<td><input type="hidden" name="seatId${i}" value="">
				</tr>
			</c:forEach>

		</table>
		<input type="submit" value="Payment">
	</form>
</body>
</html>