<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="login-wrap">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
			<input id="tab-2" type="radio" name="tab" class="for-pwd"><label for="tab-2" class="tab">Forgot Password</label>
			<div class="login-form">
				<div class="sign-in-htm">
				<form action="<c:url value='/dang-nhap'/>" id="formLogin" method="post">
				<c:if test="${not empty message}">
					<div class="row">
						<div class="alert alert-${alert}" style="width:100%; text-align: center; color:red; font-size:20px;">${message}</div>
					</div>
				</c:if>	
					<div class="group">
						<label for="user" class="label">Username</label>
						<input id="Username" name="Username" type="text" class="input" placeholder="Username">
					</div>
					<div class="group">
						<label for="pass" class="label">Password</label>
						<input id="Password" name="Password" type="password" class="input" data-type="password" placeholder="Password">
					</div>
					<input type="hidden" value="login" name="action"/>
					<div class="group">
						<button type="submit" class="button">Đăng Nhập</button>
					</div>
				</form>
					<div class="hr"></div>
				</div>
				<div class="for-pwd-htm">
					<div class="group">
						<label for="user" class="label">Username or Email</label>
						<input id="user" type="text" class="input">
					</div>
					<div class="group">
						<input type="submit" class="button" value="Reset Password">
					</div>
					<div class="hr"></div>
				</div>
			</div>
		</div>
</div>

</body>
</html>