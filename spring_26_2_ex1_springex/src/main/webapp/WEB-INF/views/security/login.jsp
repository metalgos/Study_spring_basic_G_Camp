<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login.jsp</h1>

<c:if test="${not empty pageContext.request.userPrincipal }">
<p> is Log-In</p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal }">
<p> is Log-Out</p>
</c:if>

<!-- 로그인시 유저 아이디와 로그아웃 버튼시 디폴트 패이지 이동 경로 -->
USER ID : ${pageContext.request.userPrincipal.name}<br/>
<a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a> <br />

</body>
</html>
