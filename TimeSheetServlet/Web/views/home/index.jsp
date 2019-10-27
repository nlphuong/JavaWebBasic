<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://Helloword.com/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Attendance For Students by Week</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" >
</head>
<body>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th rowspan="2">Họ tên</th>
				<th rowspan="2">Giới Tính</th>
				<th rowspan="2">Ngày sinh</th>
				<th rowspan="2">Nơi sinh</th>
				<th rowspan="2">Bộ môn</th>
				<c:forEach var="d" items="${dates}">
					<th>${d}</th>
				</c:forEach>
			</tr>
			<tr>
				<th>Thứ hai</th>
				<th>Thứ ba</th>
				<th>Thứ tư</th>
				<th>Thứ năm</th>
				<th>Thứ sáu</th>
				<th>Thứ bảy</th>
				<th>CN</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="o" items="${list}">
				<tr data-id="${o.id}">
					<td>${o.lastName}${o.firstName}</td>
					<!--  <td><c:choose>
							<c:when test="${o.gender==0}">
					Nam
					</c:when>
							<c:otherwise>
					Nu
					</c:otherwise>
						</c:choose></td>-->
					<td>${gender[o.gender]}</td>
					<td>${o.dateOfBirth}</td>
					<td>${o.placeOfBirth}</td>
					<td>${o.subject}</td>
					<c:forEach var="i" begin="0" end="6">
						<td>
						<f:select cssClass="chk" checked="${o.timesheet[i]}" value="${dates[i]}"/>
						</td>
						<!--<c:choose>
								<c:when test="${o.timesheet[i]}">
									<input type="checkbox" value="${dates[i]}" class="chk"
										checked="checked">

								</c:when>
								<c:otherwise>
									<input type="checkbox" value="${dates[i]}" class="chk">
								</c:otherwise>
							</c:choose></td>-->
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<script type="text/javascript">
			var a = document.getElementsByClassName('chk');
			for (var i = a.length - 1; i >= 0; i--) {
				a[i].onclick = function() {
					//alert(this.value);
					var d = this.value;
					var id = this.parentNode.parentNode.getAttribute('data-id');
					//alert(id);
					var xhr = new XMLHttpRequest();
					xhr.open('POST','${pageContext.request.contextPath}/attendance/add.html');
					xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
					xhr.send('id=' + id + '&d=' + d);
					xhr.onload = function() {
						alert(xhr.response);
					}
				}
			}
		</script>
	</div>
</body>
</html>