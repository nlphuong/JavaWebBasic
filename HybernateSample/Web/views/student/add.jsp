<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="" method="post">
		<p>
			<label>FirstName</label> <input type="text" name="firstName">
		</p>
		<p>
			<label>LastName</label> <input type="text" name="lastName">
		</p>
		<p>
			<label>Gender</label> <select name="gender">
				<option value="0">Nam</option>
				<option value="1">Nu</option>
			</select>
		</p>
		<p>
			<label>Ngay Sinh</label> <input type="date" name="dateOfBirth">
		</p>
		<p>
			<label>Noi Sinh</label> <input type="text" name="placeOfBirth">
		</p>
		<p>
			<label>Bo Mon</label> <input type="text" name="subject">
		</p>
		<p>
			<button>Save</button>
		</p>
	</form>
</body>
</html>