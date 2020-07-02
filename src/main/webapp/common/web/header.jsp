<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
					<a class="navbar-brand" href="#">TNT<span class="fab fa-telegram-plane"></span></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu">
						<span class="icon-bar"></span>
						</button>
					<div class="collapse navbar-collapse" id="menu">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item"><a class="nav-link" href='<c:url value="/trang-chu"/>'>Trang chủ</a></li>
							<li class="nav-item"><a class="nav-link" href='<c:url value="/khach-san?action=khachsan&page=1&maxPage=5&BusinessID=&type=&sortName=TotalPrice&sortBy=DESC&find="/>'>Khách sạn</a></li>
							<li class="nav-item"><a class="nav-link" href='<c:url value="/dia-diem?action=diadiem"/>'>Địa điểm</a></li>
							<li class="nav-item"><a class="nav-link" href="#sanpham" data-toggle="tab">Blog</a></li>
						</ul>
						<c:if test="${not empty USER}">
							<form class="form-inline my-2 my-lg-0">
								<div class="form-group ">
										<a style="font-size:15px; font-weight: normal;text-decoration: none;padding:5px;" href="#">Xin chào, ${USER.getUsername()}</a>
      								<a type="button" class="btn btn-warning form-control" href='<c:url value="/thoat?action=logout"/>'> Thoát </a>
      							</div>
    						</form>
						</c:if>
						<c:if test="${empty USER}">
							<form class="form-inline my-2 my-lg-0">
								<div class="form-group ">
      								<a type="button" class="btn btn-outline-success form-control mr-lg-2" href='<c:url value="/dang-ky?action=register"/>'>Đăng ký </a>
      								<a type="button" class="btn btn-primary form-control" href='<c:url value="/dang-nhap?action=login"/>'> Đăng Nhập </a>
      							</div>
    						</form>
						</c:if>
						
					</div>
				</nav>
			</div>	
		</div>
	</div>
