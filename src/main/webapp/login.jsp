<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red">${errorMessage }</h1>
	<form action="login">
		<input type="text" name="name" placeholder="enter username here">
		<input type="text" name="password" placeholder="enter password here">
		<input type="submit" value="Login">
	</form>
</body>
</html>