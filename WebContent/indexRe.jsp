<%@page import="java.io.Console"%>
<%@page import="dao.CampaignDAOImpl"%>
<%@page import="dao.CampaignDAO"%>
<%@page import="pojo.Campaign"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="dao.MaskDAOImpl"%>
<%@page import="dao.MaskDAO"%>
<%@page import="pojo.Reservation"%>
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
		String name = request.getParameter("name");
		String IDnum = request.getParameter("IDnum");
		String PhoneNum = request.getParameter("PhoneNum");
		String masknum = request.getParameter("masknum");
		if(name!=null&&IDnum!=null&&PhoneNum!=null&&masknum!=null){
	%>
	<jsp:forward
		page="order?name=<%=name %>&id=<%=IDnum %>&tel=<%=PhoneNum %>&number=<%=masknum %>"></jsp:forward>
	<%} %>
</body>
</html>