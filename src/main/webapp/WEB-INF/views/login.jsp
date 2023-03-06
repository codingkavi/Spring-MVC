<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red">${errorMessage }</h1>
	<form action="login"
            method="post"
	        modelAttribute = "user">
		<input name="username" type="text" placeholder="enter username here"/>
		<input name="password" type="text" placeholder="enter password here"/>
		<input type="submit" value="Login">
	</form>
</body>
</html>