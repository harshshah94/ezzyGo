<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="baselayout.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AgentList</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty agentList }">no agent registered</c:when>
		<c:otherwise>
			<table>
				<tr>
					<td>Name</td>
					<td>Email</td>
					<td>Mobile</td>
					<td>Gender</td>
					<td>Status</td>
				</tr>
				<c:forEach items="${agentList}" var="agent">
					<tr>
						<td>${agent.firstName}${agent.lastName}</td>
						<td>${agent.email}</td>
						<td>${agent.mobile}</td>
						<td>${agent.gender eq 'M'?'Male':'Female'}</td>
						<td>${agent.status eq 'Y'?'Activated':'Not activated'}</td>

						<c:choose>
							<c:when test="${agent.status eq 'N'}">
								<td>
									<form action="ActivateAgent" method="post">

										<input type="hidden" value="${agent.email}"> <input
											type="submit" value="click to activate">

									</form>
								</td>
							</c:when>
							<c:otherwise>
								<td><input type="hidden" value="${agent.email}"> <input
									type="submit" value="click to deactivate"></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>