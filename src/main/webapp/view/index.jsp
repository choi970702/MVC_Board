<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="/MyController">
		<jsp:param value="list" name="cmd"/>
		<jsp:param value="1" name="cPage"/>
	</jsp:forward>
</body>
</html>