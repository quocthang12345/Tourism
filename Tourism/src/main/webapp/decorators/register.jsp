<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
 	<title><dec:title default="Đăng Ký" /></title>
	<link href="<c:url value='/template/register/register.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' />" rel="stylesheet" id="bootstrap-css">
	<script src="<c:url value='//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='//code.jquery.com/jquery-1.11.1.min.js' />"></script>
</head>
<body>
    <div class="container register-form">
    	<dec:body/>
    </div>
</body>
</html> 