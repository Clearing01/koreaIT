<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="bb" %>

<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
   <title>회원가입</title>
   <!-- Basic need -->
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
                  <form action="insertM.do" class="form-style-123" name="regForm">
                     <div class="row">
                        <div class="col-md-12 form-it">
                           <label>아이디</label> 
                           <input type="text" name="mid" id="signup_form_id" maxlength="15" onchange="check();" placeholder="5자리 이상 입력해주세요." required="required" />
                        <span class="result"></span>
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
                           <input type="button" class="submit" value="가입 완료하기"  onclick="joinFormCheck()">
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
<script type="text/javascript" src="./js/check.js" ></script> 

</body>
</html>