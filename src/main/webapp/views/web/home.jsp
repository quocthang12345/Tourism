<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html">
<title>Trang chủ</title>
</head>
<body>
	<div class="container">
		    <div class="row" style="margin-top:3%;margin-bottom:3%">
		      <div class="carousel carousel-fade slide" data-ride="carousel" id="carousel_example">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="<c:url value='/template/image/anh10.jpg'/>" alt="Dịch vụ" class="img-thumbnail">
						</div>
						<div class="carousel-item">
							<img src="<c:url value='/template/image/anh11.jpg'/>" alt="Tiện ích" class="img-thumbnail">
						</div>
						<div class="carousel-item">
							<img src="<c:url value='/template/image/anh9.jpg'/>" alt="Danh Lam thắng cảnh" class="img-thumbnail">
						</div>
					</div>
						<ol class="carousel-indicators">
							<li class="active" data-target="#carousel_example" data-slide-to="0"></li>
							<li data-target="#carousel_example" data-slide-to="1"></li>
							<li data-target="#carousel_example" data-slide-to="2"></li>
						</ol>
						<a style="margin-top: 20%;" href="#carousel_example"  class="carousel-control-prev carousel-control-prev-icon" data-slide="prev"></a>
						<a style="margin-top: 20%;" href="#carousel_example" class="carousel-control-next carousel-control-next-icon" data-slide="next"></a>
				</div>
			</div>

			
			
			
			<div class="row">
				<div class="toast-header" style="margin-left:10px;color:gray;font-style:bold;">
					<h3> Hotel</h3>
				</div>
			</div>
			<hr>
		    <!-- Page Features -->
		    <div class="row text-center">
		    <c:forEach var="i" items="${item.getResultList()}">
			  <div class="col-lg-3 col-md-6 mb-4">
		        <div class="card h-100">
		          <img class="card-img-top" src="<c:url value='${i.getThumbnail()}'/>" alt="">
		          	<div class="card-body">
		            	<h4 class="card-title">${i.getNameItem()}</h4>
		            	<p class="card-text">Price: ${i.getTotalPrice()}</p>
		            	<input type="hidden" name="ItemID" value="${i.getItemID()}"/>
		         	 </div>
		          <div class="card-footer">
		            <a href='<c:url value="/thue-muon?action=rent&id=${i.getItemID()}"/>' style="width:50%;" class="btn btn-primary">Rent</a>
		          </div>
		        </div>
		      </div>		
			</c:forEach>	
			</div>    
		 	
		 	<div class="row">
				<div class="toast-header" style="margin-left:10px;color:gray;font-style:bold;">
					<h3> Villa</h3>
				</div>
			</div>
			<hr>
		    <!-- Page Features -->
		    <div class="row text-center">
		    <c:forEach var="i" items="${itemVilla.getResultList()}">
			  <div class="col-lg-3 col-md-6 mb-4">
		        <div class="card h-100">
		          <img class="card-img-top" src="<c:url value='${i.getThumbnail()}'/>" alt="">
		          	<div class="card-body">
		            	<h4 class="card-title">${i.getNameItem()}</h4>
		            	<p class="card-text">Price: ${i.getTotalPrice()}</p>
		            	<input type="hidden" name="ItemsID" value="${i.getItemID()}"/>
		         	 </div>
		          <div class="card-footer">
		            <a href='<c:url value="/thue-muon?action=rent&id=${i.getItemID()}"/>' style="width:50%;" class="btn btn-primary">Rent</a>
		          </div>
		        </div>
		      </div>		
			</c:forEach>
		      

		 </div>
	</div>
</body>
</html>
