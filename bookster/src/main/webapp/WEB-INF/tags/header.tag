<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--preloading-->
<div id="preloader">
    <img class="logo" src="images/logo1.png" alt="" width="119" height="58">
    <div id="status">
        <span></span>
        <span></span>
    </div>
</div>
<!--end of preloading-->
<!--login form popup-->
<div class="login-wrapper" id="login-content">
    <div class="login-content">
        <a href="#" class="close">x</a>
        <h3>로그인</h3>
        <form action="ctrlM.jsp?action=login" method="post">
        	<div class="row">
        		 <label for="username">
                    아이디
                    <input type="text" name="mid" id="username" placeholder="아이디" required="required" />
                </label>
        	</div>
           
            <div class="row">
            	<label for="password">
                    비밀번호
                    <input type="password" name="mpw" id="password" placeholder="******" required="required" />
                </label>
            </div>
            <div class="row">
            	<div class="remember">
					<div>
						<input type="checkbox" name="remember" value="Remember me"><span>로그인 상태 유지</span>
					</div>
            		<a href="#">비밀번호 찾기</a>
            	</div>
            </div>
           <div class="row">
           	 <button type="submit">로그인</button>
           </div>
        </form>
        <div class="row">
        	<p>간편하게 SNS 로그인</p>
            <div class="social-btn-2">
            	<a class="fb" href="#"><i class="ion-social-facebook"></i>Kakao</a>
            	<a class="tw" href="#"><i class="ion-social-twitter"></i>Naver</a>
            </div>
        </div>
    </div>
</div>
<!--end of login form popup-->
<!-- BEGIN | Header -->
<header class="ht-header">
	<div class="container">
		<nav class="navbar navbar-default navbar-custom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header logo">
				    <div class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					    <span class="sr-only">Toggle navigation</span>
					    <div id="nav-icon1">
							<span></span>
							<span></span>
							<span></span>
						</div>
				    </div>
				    <a href="index_light.html"><img class="logo" src="images/logo1.png" alt="" width="119" height="58"></a>
			    </div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden">
							<a href="#page-top"></a>
						</li>
						
						<li class="dropdown first">
							<a href="novelmain.jsp">
							소설
							</a>
						</li>
						<li class="dropdown first">
							<a href="community.jsp">
							커뮤니티
							</a>
						</li>
					</ul>
					<ul class="nav navbar-nav flex-child-menu menu-right">
					<c:choose>
						<c:when test="${mid!=null}">
							<li><a href="ctrlM.jsp?action=logout">로그아웃</a></li>
							<li><a href="mypage.jsp">마이페이지</a></li>
						</c:when>
						<c:otherwise>
							<li class="loginLink"><a href="#">로그인</a></li>
							<li class="btn"><a href="signUp.jsp">회원가입</a></li>
						</c:otherwise>
					</c:choose>
						
					</ul>
				</div>
			<!-- /.navbar-collapse -->
	    </nav>
	   

	   
	</div>
</header>
<!-- END | Header -->