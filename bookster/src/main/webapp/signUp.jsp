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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="crossorigin="anonymous">
</script> 
</head>
<body>
<!-- header section-->
<bb:header/>
<!-- end of header section-->
	    
<div class="buster-light">
	<div class="page-single">
		<div class="container">
				<div class="searh-form">
						<h4 class="sb-title">SIGN UP</h4>
						<br><br>
						<form action="insertM.do" class="form-style-123">
							<div class="row">
								<div class="col-md-12 form-it">
									<label>아이디</label>
									<input type="text" name="mid" id="signup_form_id" maxlength="15" placeholder="5자리 이상 입력해주세요." required="required" />
									<button class="btn" onclick="check();">중복검사</button>
									<div id="result"></div>
								</div>
								<div class="col-md-12 form-it">
									<label>비밀번호</label> 
									<input type="password" name="mpw" id="signup_form_password" maxlength="25" placeholder="영문, 숫자, 특수문자 8~25자리를 입력해주세요." required="required" />
								</div>
								<div class="col-md-12 form-it">
									<label>비밀번호 확인</label> 
									<input type="password" id="signup_form_password_re" maxlength="25" placeholder="비밀번호 재입력" required="required" />
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
									<label>휴대폰 번호</label> 
									<input type="text" name="mphone" id="signup_form_phoneNumber" placeholder="010-xxxx-xxxx" required="required" />
								</div>
								<div class="col-md-12 form-it">
									<label>이메일</label> 
									 <input type="email" name="memail" id="signup-form-email" placeholder="아이디@메일주소" required="required" />
								</div>
								<div class="col-md-12 ">
									<input type="submit" class="submit" value="가입 완료하기"  onclick="joinFormCheck()">
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
<script type="text/javascript">
function check(){
	var mid=$("#signup_form_id").val(); // id=mid의 value값
	$.ajax({
		type: 'GET', //어떤 방식으로 보낼지 "get, post"
		url: '${pageContext.request.contextPath}/check?mid='+mid, //어떤 요청을 하는지 -> mid라는 변수만들어서 사용자가 입력한 값을 확보한 상태 > DB한테 물어볼 예정 "mid라는 값이 DB에 이미 있어?" => DAO(M)로 가야함 > 이제 C가(서블릿) 작업을 할 차례구나! 
		data: {mid:mid},
		success: function(result){ // 성공했을 때
			// result 는 String
			// JS-1 : 모든데이터가 객체
			// JS-2 : 동적타이핑 지원
			console.log("로그1 ["+result+"] succes");
			if(result==1){ // 중복이 아님, 사용가능
				$("#result").text("사용 가능한 아이디입니다!");
				$("#result").css("color","blue");
				console.log("로그2 ["+result+"] succes");
			}else{ // 중복, 사용불가
				$("#result").text("이미 존재하는 아이디입니다!");
				$("#result").css("color","red");
				console.log("로그3 ["+result+"] succes");
			}
		},
		error: function(request, status, error){
			console.log("code: "+request.status);
			console.log("message: "+request.responseText);
			console.log("error: "+error);
		}
	});
}
</script>
</body>
</html>