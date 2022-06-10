<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script src="https://kit.fontawesome.com/3c36eed32b.js" ></script>
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/app.css" />
</head>

<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">
					<form action="${pageContext.request.contextPath }/loginOk.jsp" method="post" class="form-horizontal">
						<%-- 로그인 실패시 에러메세지 출력 --%>
						<c:if test="${not empty error }">
							<div style="color: red;font-size: 15pt;">${error }</div>
						</c:if>
						<%-- 로그아웃시 메세지 출력 --%>
						<c:if test="${not empty msg }">
							<div style="color: green;font-size: 15pt;">${msg }</div>
						</c:if>
						
						<div class="input-group input-sm">
							<label class="input-group-addon" for="username">
							<i class="fa-solid fa-user" style="font-size: 20pt;margin-right: 5px;color:green;"></i>
							</label> <input type="text" class="form-control"
								id="username" name="userid" placeholder="Enter Username" required>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password"><i class="fa-solid fa-lock" style="font-size: 20pt;margin-right: 5px;color:red;"></i></label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="Enter Password" required>
						</div>
						<div class="form-actions">
							<input type="submit"
								class="btn btn-block btn-primary btn-default" value="Log in">
						</div>
						<div style="text-align: center;margin: 15px;">
							[<a href="findUserid.jsp">아이디찾기</a>] 
							&nbsp;&nbsp;&nbsp;
							[<a href="findPassword.jsp">비밀번호찾기</a>]
							&nbsp;&nbsp;&nbsp;
							[<a href="${pageContext.request.contextPath }">홈으로</a>]
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>