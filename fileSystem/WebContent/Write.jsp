<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/MemberListScore.css">

</head>
<body>

<div>
	<h1>파일 업로드</h1>
	<p>단일 파일 업로드 및 다운로드</p>
	<hr />
</div>

<div>
	<form action="WriteOk.jsp" method="post" enctype="multipart/form-data">
		작성자 :
		<input type="text" name="userName">
		<br /><br />
		
		제목 :
		<input type="text"  name="subject"/>
		<br /><br />
		
		파일 :
		<input type="file" name="uploadFile" />
		<br /><br />
		
		<button type="submit"> 파일올리기</button>
	</form>
</div>


</body>
</html>