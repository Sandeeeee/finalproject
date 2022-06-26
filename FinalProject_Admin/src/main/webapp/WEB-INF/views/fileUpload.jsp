<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>

<script>
	
</script>

</head>
<body>

	<form action="uploadfile" method="post" enctype="multipart/form-data">
		Please select your file to upload:<br /> <input type="file" name="myFile">
		<button type="submit" value="upload">Upload</button>
	</form>

</body>
</html>