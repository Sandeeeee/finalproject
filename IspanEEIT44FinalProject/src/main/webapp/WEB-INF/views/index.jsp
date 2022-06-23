<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<form method="get" action="/finalproject/login">
		<div align='center'>
			<h3>ID :</h3>
			<input  type="text" name="companyId" />
			<br/><br/>
				<input type="submit" value="登入">
		</div>
	</form>
		<div align='center'>
			<h6><a href="<c:url value='/chatpage' />">Chat Page</a></h6>
		</div>
</body>
</html>