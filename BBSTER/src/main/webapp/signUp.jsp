<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="bb" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
	<!-- Basic need -->
	<title>회원가입</title>
	<meta charset="UTF-8">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="">
	<link rel="profile" href="#">

    <!--Google Font-->
    <link rel="stylesheet" href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
	<!-- Mobile specific meta -->
	<meta name=viewport content="width=device-width, initial-scale=1">
	<meta name="format-detection" content="telephone-no">

	<!-- CSS files -->
	<link rel="stylesheet" href="css/plugins.css">
	<link rel="stylesheet" href="css/style.css">

</head>
<body>
<!-- header section-->
<bb:header/>
<!-- end of header section-->
	    
<div class="buster-light">
	<div class="page-single">
		<div class="container">
				<div class="searh-form">
						<br><br><br>
						<h4 class="sb-title">SIGN UP</h4>
						<br><br>
						<form class="form-style-1" action="ctrlM.jsp?action=insert_M">
							<div class="row">
								<div class="col-md-12 form-it">
									<label>아이디</label>
									<input type="text" name="mid" id="signup_form_id" maxlength="15" placeholder="5자리 이상 입력해주세요." required="required" />
								</div>
								<div class="col-md-12 form-it">
									<label>비밀번호</label> <!-- 비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식 -->
									<input type="password" name="mpw" id="signup_form_password" maxlength="25" placeholder="영문, 숫자, 특수문자 8~25자리를 입력해주세요." pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$" required="required" />
								</div>
								<div class="col-md-12 form-it">
									<label>비밀번호 확인</label> <!-- 비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식 -->
									<input type="password" name="mpw" id="signup_form_password_re" maxlength="25" placeholder="비밀번호 재입력" pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$" required="required" />
								</div>
								<div class="col-md-12 form-it">
									<label>이름</label>
									 <input type="text" name="mname" id="signup_form_Name" maxlength="15" placeholder="이름을 입력해주세요." required="required" />
								</div>
								<div class="col-md-12 form-it">
									<label>별명</label>
									 <input type="text" name="nickname" id="signup_form_Nickname" maxlength="15" placeholder="사용하실 별명을 입력해주세요." required="required" />
								</div>
								<div class="col-md-12 form-it">
									<label>휴대폰 번호</label> <!-- 010-xxxx-xxxx 정규식 -->
									<input type="text" name="mphone" id="signup_form_phoneNumber" placeholder="010-xxxx-xxxx" pattern="01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$" required="required" />
								</div>
								<div class="col-md-12 form-it">
									<label>이메일</label> <!-- 이메일 정규식 -->
									 <input type="email" name="memail" id="signup-form-email" placeholder="아이디@메일주소" pattern="([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$" required="required" />
								</div>
								<div class="col-md-12 ">
									<input class="submit" type="submit" value="가입 완료하기"  onclick="joinFormCheck()">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

<!-- footer section-->
<bb:footer/>
<!-- end of footer section-->

<script src="js/jquery.js"></script>
<script src="js/plugins.js"></script>
<script src="js/plugins2.js"></script>
<script src="js/custom.js"></script>
<script src="js/signUp.js"></script>
</body>
</html>