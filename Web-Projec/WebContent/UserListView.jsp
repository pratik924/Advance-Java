<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List list = (List) request.getAttribute("list");
	%>
	<%@ include file="Header.jsp"%>
	<div align="center">
		<h2>UserList</h2>
		<form action="UserlistCtl" method="post">
			<table border="1px" width="100%">
				<tr style="background-color: skyblue">
					<th>S.NO</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>DOB</th>
				</tr>
				<%
				Iterator<UserBean> it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = it.next();
				
				%>
				<tr align="center" style="background-color: skyblue">
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getDob() %></td>
					</tr>
					<%
					}
					%>
</table>


					</form>
					</div>
</body>
</html>