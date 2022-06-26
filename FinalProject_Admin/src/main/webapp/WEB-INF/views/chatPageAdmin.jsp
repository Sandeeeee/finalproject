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
<title>ChatPage Admin</title>

<script src="<c:url value='/webjars/jquery/jquery.min.js' />"></script>

</head>
<body>

	<div>
		<label>用戶:</label>${userId} <label>密碼:</label>${password} <br>
		<p>訊息</p>
		<c:forEach var="messages" items="${page.content}">

			<c:out value="${messages.senderId}" />
			<br>
			<c:out value="${messages.receiverId}" />
			<br>
			<c:out value="${messages.text}" />
			<br>
			<c:out value="${messages.created}" />
			<br>

			<span class=edit-link> 
			<a href="${contextRoot}/deleteMessage?messageId=${messages.messageId}"
				onclick="return confirm ('真的要刪除嗎?')">
					<button class="btn btn-danger">刪除</button>
			</a>
			</span>
			<hr>
		</c:forEach>
	<!-- 分頁設定 -->
		<div class="row justify-content-center">
			<div class="col-9">

				<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
					<c:choose>
						<c:when test="${page.number != pageNumber-1}">
							<a href="${contextRoot}/message/all?p=${pageNumber}"> <c:out
									value="${pageNumber}" /></a>
						</c:when>

						<c:otherwise>
							<c:out value="${pageNumber}" />
						</c:otherwise>
					</c:choose>

					<c:if test="${pageNumber != page.totalPages}"> | </c:if>
				</c:forEach>

			</div>
		</div>
	</div>
	<br>
</body>
</html>