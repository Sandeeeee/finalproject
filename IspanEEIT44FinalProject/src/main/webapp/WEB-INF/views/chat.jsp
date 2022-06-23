<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>ChatPage</title>
<script type="text/javascript">

</script>

<%-- <script src="<c:url value='/webjars/jquery/jquery.min.js' />"></script> --%>
<%-- <script src="<c:url value='/webjars/sockjs-client/sockjs.min.js' />"></script> --%>
<%-- <script src="<c:url value='/webjars/stomp-websocket/stomp.min.js' />"></script> --%>

</head>
<body>
<script>
		
</script>
	<div >
		
		<div align='center'>
<!-- 			<button id="connect" type="submit">連線</button> -->
<!-- 			<button id="disconnect" type="submit" disabled="disabled">離線</button> -->
			<a href="<c:url value='/' />">回前頁</a>
			<a href="<c:url value='/fileUpload' />">FIle Upload</a>
			<br/>
		</div>
		
		<div>
			<label for="senderId">SenderID：</label> <input type="text" id="senderId"
				value="${senderId}"> 	
		</div>
		
		<div>
			<label for="receiverId">ReceiverID:</label> <input type="text" id="receiverId" placeholder="receiverId">
		</div>
		
		<div>
			<label for="text">Text:</label><textarea id="text" name="enter your text" rows="10" cols="50"></textarea>
		</div>
		
		<div>
			<button id="send" type="submit">送出</button>
		</div>
		
		<div>
			<table id="conversation">
				
				<tr><th>回覆訊息</th></tr>
	
				<tr><td id="chatbox">
					<c:forEach var="messages" items="${newMessage}">
						留言內容: <br>
							<c:out value="${messages.text}" />
						<br>
						ReceiverID: 
							<c:out value="${messages.receiverId}" />
				
						<br>
						留言時間:
							<c:out value="${messages.created}" />
						<hr>
					</c:forEach>
				</td></tr>
			</table>
		</div>
		
	</div>
</body>
</html>