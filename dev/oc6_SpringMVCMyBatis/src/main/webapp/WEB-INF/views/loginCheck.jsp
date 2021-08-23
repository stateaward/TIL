<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>
<!-- 로그인 했는지. 안했는지 체크
	 sessionScope.id 가 더욱 정확 | session은 java의 내장객체
 -->
<c:if test="${id == null}">
	<a href="login.bod">[로그인]</a>
	<br>
</c:if>

<c:if test="${!empty id}">
	welcome, ${id} !!<br>
	<a href="logout.bod">[로그아웃]</a>
	<br>
</c:if>

</body>
</html>