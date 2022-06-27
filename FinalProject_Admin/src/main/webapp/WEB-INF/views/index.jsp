<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="layout/navbar.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>

<script>
	
</script>

</head>
<body>

	<form method="get" action="/loginAndViewAllMessages">
		<div align='center'>
		
			<div>
			UserId:<input  type="text" name="userId" />
			</div>
			<br/>

			<div>
			Password:<input  type="text" name="password" />
			</div>
				<input type="submit" value="登入">
		</div>
	</form>
<!-- 		<div align='center'> -->
<%-- 			<h6><a href="<c:url value='/chatpage' />">Chat Page</a></h6> --%>
<!-- 		</div> -->
</body>
</html>