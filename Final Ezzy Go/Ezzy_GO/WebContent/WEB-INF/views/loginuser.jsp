<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="baselayout.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.FieldError {
	color: red;
}
</style>

<title>Ezzy Go | Login Page</title>

</head>
<body>
	<h2 style="color: green;">&nbsp;&nbsp;&nbsp;&nbsp; ${msg}</h2>

	<div style="padding: 1px">

		<fieldset
			style="position: relative; left: 20px; width: 715px; height: 300px">

			<legend align="left">
				<strong>&nbsp;Login&nbsp;</strong>
			</legend>

			<form:form action="loginUser" modelAttribute="userModel"
				method="post">

				<table style="margin-top: 20px; font-size: 18px;" cellpadding="10px"
					cellspacing="10px">

					<tr style="padding-top: 10px">

						<td><h2>
								<form:label path="email">Email Address</form:label>
							</h2></td>
						<td><form:input path="email" readonly="false"
								placeholder="email" /></td>
					</tr>
					<tr style="padding-top: 10px">
						<td><h2>
								<form:label path="password">Password</form:label>
							</h2></td>
						<td><form:password path="password" placeholder="Password" /></td>
					</tr>
					<tr style="margin-top: 20px;">
						<td colspan="2"><input type="submit" value="Login"></td>
					</tr>
				</table>
				<br>
				<br>
			</form:form>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="/Ezzy_GO/user/forgot" class="bul">Forgot
				Password...?</a> <br> <br>&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="/Ezzy_GO/user/showCustomerRegister" class="bul">New
				Customer...?</a> <br> <br>&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="/Ezzy_GO/user/showAgentRegister" class="bul">Agent
				Register</a>

		</fieldset>
	</div>
</body>
</html>