<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Địa Điểm</title>
</head>
<body>
<div class="row">
		<div class="card col-4">
			<div class="jumbotron" style="margin-top:50%; background-color: default;">
				<div class="card-body">
				<label>Chọn nơi bạn muốn tham quan</label>
					<hr class="my-0">
					<br>
						<select id="end" style="width: 50%;" >
						  <option value="">Lựa chọn địa điểm </option>
					      <option value="bana">Bà Nà Hills</option>
					      <option value="hoian">Phố Cổ Hội An</option>
					      <option value="nguhanhson">Ngũ Hành Sơn</option>
					      <option value="mykhe">Biển Mỹ Khê</option>
					      <option value="haivan">Hải Vân Quan</option>
					      <option value="cuadai">Biển Cửa Đại</option>
					      <option value="dinhbanco">Đỉnh bàn cờ</option>
					    </select>
					<hr class="my-1">
				</div>
			</div>
		</div>
		<div class="col-8" id="googleMap" style="width:1500px;height:700px;"></div>
</div>
</body>
</html>