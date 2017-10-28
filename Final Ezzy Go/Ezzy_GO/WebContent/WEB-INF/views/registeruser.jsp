<%@ include file="baselayout.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.FieldError {
	color: red;
}
</style>


<title>Ezzy Go | Register Page</title>
</head>
<body>

	<div style="padding: 1px">
		<form:form action="registerUser" modelAttribute="userModel"
			method="post">
			<fieldset
				style="position: relative; left: 20px; width: 715px; height: 470px"">
				<legend>
					<strong> Register User</strong>
				</legend>
				<table style="margin-top: 20px; font-size: 18px;" cellpadding="10px"
					cellspacing="10px">
					<tr style="padding-top: 10px">
						<td><form:label path="firstName">First Name</form:label></td>
						<td><form:input path="firstName" readonly="false"
								placeholder="First Name" /></td>
						<td><form:errors path="firstName" cssClass="FieldError"></form:errors></td>
					</tr>
					<tr style="padding-top: 10px">
						<td><form:label path="lastName">Last Name</form:label></td>
						<td><form:input path="lastName" readonly="false"
								placeholder="Last Name" /></td>
						<td><form:errors path="lastName" cssClass="FieldError"></form:errors></td>
					</tr>
					<tr style="padding-top: 10px">
						<td><form:label path="gender">Gender</form:label></td>
						<td><form:radiobutton path="gender" value="M" />Male<form:radiobutton
								path="gender" value="F" />Female<form:radiobutton path="gender"
								value="O" />Others</td>
						<td><form:errors path="gender" cssClass="FieldError"></form:errors></td>
					</tr>

					<tr style="padding-top: 10px">
						<c:set var="today" value="<%=new java.util.Date()%>" />
						<td><form:label path="dateOfBirth">Date of Birth</form:label></td>
						<td><input type="date" id="dateOfBirth" value="${today}"
							placeholder="Date of Birth"></td>
						<td><form:errors path="dateOfBirth" cssClass="FieldError"></form:errors></td>
					</tr>

					<tr style="padding-top: 10px">
						<td><form:label path="email">Email Address</form:label></td>
						<td><form:input path="email" readonly="false"
								plceholder="email" /></td>
						<td><form:errors path="email" cssClass="FieldError"></form:errors></td>
						<span class="FieldError">${msgToSignUp}</span>
						</td>
					</tr>
					<tr style="padding-top: 10px">
						<td><form:label path="mobile">Mobile</form:label></td>
						<td><form:input path="mobile" readonly="false"
								placeholder="Ex:9876543210" /></td>
						<td><form:errors path="mobile" cssClass="FieldError"></form:errors></td>
					</tr>

					<tr style="padding-top: 10px">
						<td><form:label path="password">Password</form:label></td>
						<td><form:password path="password" placeholder="Password" /></td>
						<td><form:errors path="password" cssClass="FieldError"></form:errors></td>
					</tr>
					<tr style="margin-top: 20px;">
						<td colspan="1"><br> <input type="submit"
							value="Register"></td>
						<td colspan="1"><br> <input type="submit" value="Cancel"></td>
					</tr>

				</table>
				<br> <br>
			</fieldset>
		</form:form>
	</div>
</body>
</html>