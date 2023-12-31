<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 시큐리티 태그라이브러리 사용 선언 -->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login.jsp</h1>

<%-- <c:if test="${not empty pageContext.request.userPrincipal }">
<p> is Log-In</p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal }">
<p> is Log-Out</p>
</c:if> --%>
<!-- jstl c:if대신 사용 -->
<s:authorize ifAnyGranted="ROLE_USER">
<p> is Log-In</p>
</s:authorize>

<s:authorize ifNotGranted="ROLE_USER">
<p> is Log-Out</p>
</s:authorize>

<%-- USER ID : ${pageContext.request.userPrincipal.name}<br/> --%>
<!-- 유저 아이디 가져와서 사용 가능 -->
USER ID : <s:authentication property="name"/><br/>
<a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a> <br />

</body>
</html>
