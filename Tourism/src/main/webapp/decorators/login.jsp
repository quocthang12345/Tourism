<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><dec:title default="Đăng Nhập" /></title>

    <!-- css -->
    <%-- <link href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all"/> --%>
    <link href="<c:url value='/template/login/login.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' />" rel="stylesheet" id="bootstrap-css">
	<script src="<c:url value='//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='//code.jquery.com/jquery-1.11.1.min.js' />"></script>
    
</head>
<body>

    
    <div class="container">
    	<dec:body/>
    </div>

	
	<%-- <script type="text/javascript" src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script> --%>
	
</body>
</html>