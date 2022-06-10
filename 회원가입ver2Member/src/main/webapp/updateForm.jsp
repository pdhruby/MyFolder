<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 로그인이 되어있지 않으면 여기는 진입 불가
	if(session.getAttribute("memberVO")==null){
		response.sendRedirect(request.getContextPath());
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<%-- 부트스트랩을 사용하기 위한 준비 시작 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- 부트스트랩을 사용하기 위한 준비 끝 --%>
<%-- 다음 우편번호 API --%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$(function(){

});

function daumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postCode').value = data.zonecode;
            document.getElementById("addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addr2").focus();
        }
    }).open();
}

// 폼검증하는 자바스크립트 함수
function formCheck(){
	var value = $("#password").val();
	if(value==null || value.trim().length==0){
		alert('사용자 비빌번호는 반드시 입력해야 합니다.');
		$("#password").val("");
		$("#password").focus();
		return false;
	}
	var value = $("#name").val();
	if(value==null || value.trim().length==0){
		alert('사용자 이름은 반드시 입력해야 합니다.');
		$("#name").val("");
		$("#name").focus();
		return false;
	}
	var value = $("#email").val();
	if(value==null || value.trim().length==0){
		alert('이메일 주소는 반드시 입력해야 합니다.');
		$("#email").val("");
		$("#email").focus();
		return false;
	}
	var value = $("#phone").val();
	if(value==null || value.trim().length==0){
		alert('전화번호는 반드시 입력해야 합니다.');
		$("#phone").val("");
		$("#phone").focus();
		return false;
	}
	var value = $("#postCode").val();
	if(value==null || value.trim().length==0){
		alert('우편번호는 반드시 입력해야 합니다.');
		$("#postCode").val("");
		$("#postCode").focus();
		return false;
	}
	var value = $("#addr2").val();
	if(value==null || value.trim().length==0){
		alert('상세 주소는 반드시 입력해야 합니다.');
		$("#addr2").val("");
		$("#addr2").focus();
		return false;
	}
}
</script>

<style type="text/css">
	.title { font-size: 18pt;text-align: center; padding: 10px; font-weight: bold;}
</style>
</head>
<body>
	<div class="container" style="border: 1px solid gray;padding: 15px;margin-top: 30px;border-radius: 30px;">
		<form action="updateOk.jsp" method="post" onsubmit="return formCheck();">
			<div class="title" >회원 정보 수정</div>
			<div class="mb-3 row">
				<%-- idx는 숨겨서 넘기자 --%>
				<input type="hidden" name="idx" value="${memberVO.idx }" />
				
			  	<label for="userid" class="col-sm-2 col-form-label">사용자 아이디</label>
			  	<div class="col-sm-2">
				<input type="text" class="form-control" id="userid" name="userid" readonly value="${memberVO.userid }">
				</div>
				<div class="col-sm-1 col-form-label" id="msg"></div>
				<div class="col-sm-2"></div>
			  	<label for="password" class="col-sm-2 col-form-label">사용자 비밀번호</label>
			  	<div class="col-sm-3">
				<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호입력"  required>
				</div>
			</div>
			<div class="mb-3 row">
			  	<label for="name" class="col-sm-2 col-form-label">사용자 이름</label>
			  	<div class="col-sm-3">
				<input type="text" class="form-control" id="name" name="name" value="${sessionScope.memberVO.name }" required>
				</div>
				<div class="col-sm-2"></div>
			  	<label for="newPassword" class="col-sm-2 col-form-label">새로운 비번</label>
			  	<div class="col-sm-3">
				<input type="password" class="form-control" id="newPassword" name="newPassword">
				</div>
			</div>
			<div class="mb-3 row">
			  	<label for="email" class="col-sm-2 col-form-label">사용자 이메일</label>
			  	<div class="col-sm-3">
				<input type="email" class="form-control" id="email" name="email" value="${sessionScope.memberVO.email }"  readonly>
				</div>
				<div class="col-sm-2"></div>
			  	<label for="phone" class="col-sm-2 col-form-label">사용자 전화번호</label>
			  	<div class="col-sm-3">
				<input type="tel" class="form-control" id="phone" name="phone" value="${sessionScope.memberVO.phone }"  required>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-2">
			  	  <label for="gender1" class="col-sm-2 col-form-label">남자</label>
				  <input class="form-check-input" type="radio" name="gender" id="gender1"  value="M" ${memberVO.gender=='M' ? "checked='checked'" : ""}>
				</div>
				<div class="col-sm-2">
			  	  <label for="gender2" class="col-sm-2 col-form-label">여자</label>
				  <input class="form-check-input" type="radio" name="gender" id="gender2" value="F" ${memberVO.gender=='F' ? "checked='checked'" : ""}>
				 </div> 
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label" for="postCode">우편번호</label>
				<div class="col-sm-2">
				  <input class="form-control" type="text" name="postCode" id="postCode" readonly  required value="${memberVO.postCode }">
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-2">
				  <input type="button" class="btn-check" id="zipCodebtn" onclick="daumPostcode();">
				  <label class="btn btn-outline-primary" for="zipCodebtn">우편번호찾기</label>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label" for="addr1">주소</label>
				<div class="col-sm-10">
				  <input class="form-control" type="text" name="addr1" id="addr1" readonly  required value="${memberVO.addr1 }">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label" for="addr2">상세주소</label>
				<div class="col-sm-10">
				  <input class="form-control" type="text" name="addr2" id="addr2"  required  value="${memberVO.addr2 }">
				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-12" style="text-align: right;">
					  <input type="submit" class="btn-check" id="submitBtn" >
					  <label class="btn btn-outline-success" for="submitBtn">정보수정</label>
					  <input type="reset" class="btn-check" id="resetBtn" >
					  <label class="btn btn-outline-success" for="resetBtn">다시쓰기</label>
					  <input type="button" class="btn-check" id="cancelBtn" onclick="location.href='${pageContext.request.contextPath}'">
					  <label class="btn btn-outline-success" for="cancelBtn">돌아가기</label>
				</div>
			</div>
		</form>
	</div>
</body>
</html>