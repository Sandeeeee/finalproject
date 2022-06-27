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
<title>DeletePage Admin</title>

<script src="<c:url value='/webjars/jquery/jquery.min.js' />"></script>

</head>
<body>
<h2>刪除畫面</h2>

		<label>用戶:</label>${userId} <label>密碼:</label>${password} <br>
		<p>訊息刪除 </p>

			
		<form method="get" action=" /deleteMessageByGroup">
		<label> senderId:</label> <input  type="text" name="senderId" />
		<label>receiverId:</label><input  type="text" name="receiverId" />
		<input type="submit" value="查詢">
		</form>

</body>
</html>