<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="layout/navbar.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>ChatPage Company</title>

<script src="<c:url value='/webjars/jquery/jquery.min.js' />"></script>

</head>
<body>
<h6>ChatPage Company</h6>
	<div>
		<label>用戶:</label>${userId} <label>密碼:</label>${password} <br>
		
		<form method="get" action=" /queryGroupMessage">
		<input  type="hidden"  name="senderId" />
		<label>receiverId:</label><input  type="text" name="receiverId" />
		<input type="submit" value="查詢">
		</form>
		
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
<c:set var="receiverId" value="${messages.receiverId}"/>
<c:set var="senderId" value="${messages.senderId}"/>
			<hr>
		</c:forEach>
			<span class=edit-link> 
<%-- 			<a href="${contextRoot}/deleteMessageByGroup?sendeId=${m}&receiverId=${k}" --%>
			<a href="${contextRoot}/deleteMessageByGroup/${receiverId}/${senderId}"
				onclick="return confirm ('真的要刪除嗎?')">
					<button class="btn btn-danger">刪除</button>
			</a>
			</span>
	</div>
	<br>
</body>
</html>