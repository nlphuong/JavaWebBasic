<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form method="post" modelAttribute="o">
	<f:hidden path="id"/>
		<p>
			<label>First Name</label>
			<f:input path="firstName"/>
		</p>
		<p>
			<label>Last Name</label>
			<f:input path="lastName" />
		</p>
		<p>
			<label>Gender</label> 
			<f:select path="gender" itemValue="id" itemLabel="name" items="${genders}"/>
		</p>
			<!-- <p> <select name="gender">
				<option value="0">Nam</option>
				<option value="1">Nu</option>
			</select></p>-->
		
		<p>
			<label>Ngay sinh</label>
			<f:input path="dateOfBirth" type="date" />
		</p>
		<p>
			<label>Noi sinh</label>
			<f:input path="placeOfBirth" />
		</p>
		<p>
			<label>Bo mon</label>
			<f:input path="subject" />
		</p>
		<p>
			<button>Save</button>
		</p>
	</f:form>
</body>
</html>