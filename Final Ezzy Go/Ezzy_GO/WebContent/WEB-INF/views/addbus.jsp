<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="baselayout.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Ezzy Go | Agent Bus Entry</title>
</head>
<body>
	<div align="center">
		<form:form action="showlayout" modelAttribute="busModel" method="post">
			<table>
				<tr>
					<td><form:label path="busName">Bus Name</form:label></td>
					<td><form:input path="busName" /></td>
				</tr>
				<tr>
					<td><form:label path="passingNumber">Vehicle Registration No.</form:label></td>
					<td><form:input path="passingNumber" /></td>
				</tr>
				<tr>
					<td><form:label path="ac">Air Conditioner</form:label></td>
					<td><form:radiobutton path="ac" value="Y" />AC
						&nbsp;&nbsp;&nbsp;<form:radiobutton path="ac" value="N" />Non-AC</td>
				</tr>
				<tr>
					<td><form:label path="busType">Seat Type</form:label></td>
					<td><form:select path="busType">
							<form:option value="seating">Seating</form:option>
							<form:option value="sleeping">Sleeping</form:option>
							<form:option value="mixed">Mixed</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="doubleDecker">Bus Deck</form:label></td>
					<td><form:radiobutton path="doubleDecker" value="N" />Single&nbsp;&nbsp;&nbsp;<form:radiobutton
							path="doubleDecker" value="Y" />Double</td>
				</tr>
				<tr>
					<td><form:label path="busStructure">Bus Structure</form:label></td>
					<td><form:select path="busStructure">
							<form:option value="1x2">1 x 2</form:option>
							<form:option value="2x2">2 x 2</form:option>
							<form:option value="2x3">2 x 3</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Fill Bus Layout" /></td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>