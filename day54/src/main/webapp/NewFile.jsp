<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
</head>
<body>

<form action="test.do" method="post" enctype="multipart/form-data">
	<input type="text" name="mid">
	<input type="file" name="fileName">
	<input type="submit" value="확인">
</form>

<hr>

<img alt="${img}" src="images/${img}">

</body>
</html>