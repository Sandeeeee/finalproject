<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="layout/navbar.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin ChatPage Entrance</title>

<script>
	
</script>

</head>
<body>
<h6>Admin ChatPage Login</h6>
	<form method="get" action="/loginAndViewAllMessagesAdmin">
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

</body>
</html>