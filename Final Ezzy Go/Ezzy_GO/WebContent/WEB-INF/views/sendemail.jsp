<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="baselayout.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Ezzy Go | Send Email Page</title>

</head>
<body>
	<div align="center">
		<form:form action="sendEmail" modelAttribute="userModel" method="get">
			<table>
				<tr>
					<td><form:label path="email">click continue to send and email</form:label></td>

				</tr>
				<tr>
					<td><input type="submit" value="continue" />
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>