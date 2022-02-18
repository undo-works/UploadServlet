<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload.jsp</title>
</head>
<body>
	<form name="upload" action="http://localhost:8080/UploadServlet/UploadServlet" method="post"
		enctype="multipart/form-data">
	
		<input type="file" name="uploadfile"/>
		<input type="submit" class="btn btn-primary" value="アップロード"/>
		
	</form>
</body>
</html>