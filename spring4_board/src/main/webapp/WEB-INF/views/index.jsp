<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="include/header.jsp" %>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<%@ include file="include/footer.jsp" %>
</body>
</html>