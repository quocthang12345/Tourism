 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title><dec:title default="Khách Sạn" /></title>

    <!-- css -->
    <%-- <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" /> --%>
    <link href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all"/> 
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/web/css/hotel.css' />" rel="stylesheet" type="text/css" media="all"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.min.js'/>"></script>
    
</head>
<body>
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->

    <img src="<c:url value='/template/image/anh20.jpg'/>" class="img-fluid" style="width:100%; max-height: 400px;" alt="Discount">
    
    <div class="container">
    	<dec:body/>
    </div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->
	
	<script type="text/javascript" src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	
</body>
</html> 