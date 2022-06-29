<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>ChatPage Admin</title>

<script src="<c:url value='/webjars/jquery/jquery.min.js' />"></script>

</head>
<body>

	<div align='center'>

		<div align='center'>
			<label>用戶:</label>${userId} <label>密碼:</label>${password}
		</div>

		<p>訊息</p>
		<c:forEach var="messages" items="${newMessage}">
			<c:out value="${messages.senderId}" />
			<br>
			<c:out value="${messages.receiverId}" />
			<br>
			<c:out value="${messages.text}" />
			<br>
			<c:out value="${messages.created}" />
			<br>
		</c:forEach>

		
	</div>
</body>
</html>