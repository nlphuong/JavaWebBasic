<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/student/add.html">add</a>
	<table>

		<c:forEach var="o" items="${list}">
			<tr>
				<td>${o.lastName}${o.firstName}</td>
				<td>${o.gender}</td>
				<td>${o.dateOfBirth}</td>
				<td>${o.placeOfBirth}</td>
				<td>${o.subject}</td>
				<td><a
					href="${pageContext.request.contextPath}/student/delete/${o.id}.html">delete</a>
				</td>
				<td><a
					href="${pageContext.request.contextPath}/student/edit/${o.id}.html">edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>