<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>인덱스 페이지</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="name"/>님 환영합니다.
</sec:authorize>
<ul>
	<li><a href="<c:url value='/homeMain' />">홈으로</a></li>
	<sec:authorize access="! isAuthenticated()">
	<a href="<c:url value='/login' />">로그인</a>
	<a href="<c:url value='/user/memberForm' />">회원가입</a>
	</sec:authorize>
	
	<sec:authorize access="hasAuthority('USER')">
	<li><a href="<c:url value='/memberMain' />">회원메인</a></li>
	</sec:authorize>
	
	<sec:authorize access="hasAuthority('USER_MANAGER')">
	<li><a href="<c:url value='/managerMain' />">사용자 관리자</a></li>
	</sec:authorize>

	<sec:authorize access="hasAuthority('USER_ADMIN')">
	<li><a href="<c:url value='/adminMain' />">어드민 관리자</a></li>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
	 <form:form action="/controller/logout" method="POST">
        <input type="submit" value="로그아웃" />
    </form:form>
	</sec:authorize>
</ul>
</body>
</html>
