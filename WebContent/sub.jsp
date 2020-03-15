<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("total");
		%>
		<jsp:forward page="next?total=<%=num %>"></jsp:forward>
</body>
</html>