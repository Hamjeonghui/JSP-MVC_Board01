<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="controller.jsp" method="post">
<c:choose>
<c:when test="${member!=null}">
	${member}님, 환영합니다! :D
	<input type="hidden" name="action" value="logout">
	<input type="submit" value="로그아웃">
</c:when>
<c:otherwise>
	<a href="javascript:newMember()">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="hidden" name="action" value="login">
	아이디: <input type="text" name="mid" required> 비밀번호: <input type="password" name="mpw" required>
	<input type="submit" value="로그인">
</c:otherwise>
</c:choose>
</form>
