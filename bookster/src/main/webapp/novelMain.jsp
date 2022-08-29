<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="bb" %>    
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
	<!-- Basic need -->
	<title>소설메인페이지</title>
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
<div class="top-search">
	<form action="novelMain.do" method="post">
	    	<select name="searchCondition">
				<option selected value="NTITLE">소설명</option>
				<option value="NGENRE">장르</option>
				<option value="NWRITER">작가</option>
			</select>
			<input type="text" name="searchContent" placeholder="작품명, 장르, 작가를 검색해 보세요.">
			<input type="submit" value="검색">
	</form>
</div>	    
<div class="buster-light">
<div class="page-single">
	<div class="container">
		<div class="row ipad-width">
			<div class="col-md-8 col-sm-12 col-xs-12">
				<div class="topbar-filter">
					<p>소설&nbsp;<span>${fn:length(datas)}</span>&nbsp;in total</p>
					<label name="searchCondition">장르:</label>
					<select name="searchContent">
						<option selected value="판타지">판타지</option>
						<option value="로맨스">로맨스</option>
						<option value="무협">무협</option>
						<option value="로판">로판</option>
						<option value="현판">현판</option>
					</select>
					<a href="movielist.html" class="list"><i class="ion-ios-list-outline "></i></a>
					<a  href="moviegrid.html" class="grid"><i class="ion-grid active"></i></a>
				</div>
				<div class="flex-wrap-movielist">
				<c:forEach var="n" items="${datas}" begin="1" end="20" step="1">
						<div class="movie-item-style-2 movie-item-style-1">
							<img class="image" src="${n.nimg}" alt="" width="140" height="200">
							<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6>${n.ntitle}</h6>
								<p class="rate"><i class="ion-android-star"></i><span>${n.nwriter}</span></p>
							</div>
						</div>
					</c:forEach>					
						
				</div>		
				<div class="topbar-filter">
					<label>Movies per page:</label>
					<select>
						<option value="range">20 Movies</option>
						<option value="saab">10 Movies</option>
					</select>
					
					<div class="pagination2">
						<span>Page ${data[1].ncnt} of 5:</span>
						<a href="novelMain.do?cnt=20">1</a>
						<a href="novelMain.do?cnt=40">2</a>
						<a href="novelMain.do?cnt=60">3</a>
						<a href="novelMain.do?cnt=80">4</a>
						<a href="novelMain.do?cnt=100">5</a>
						<a href="#"><i class="ion-arrow-right-b"></i></a>
					</div>
				</div>
			</div>
			<!-- 사이드바 주석처리
			<div class="col-md-4 col-sm-12 col-xs-12">
				<div class="sidebar">
					<div class="searh-form">
						<h4 class="sb-title">소설 검색</h4>
						<form class="form-style-1" action="NovelMain.do">
							<div class="row">
								<div class="col-md-12 form-it">
									<label>제목</label>
									
									<input type="text" placeholder="제목을 입력해주세요">
								</div>
								<div class="col-md-12 form-it">
									<label>장르</label>
									<div class="group-ip">
										<select name="searchCondition" multiple="" class="ui fluid dropdown">
											<option value="">장르를 선택해주세요.</option>
											<option selected value="판타지">판타지</option>
											<option value="로맨스">로맨스</option>
											<option value="무협">무협</option>
											<option value="로판">로판</option>
											<option value="현판">현판</option>
										</select>
									</div>	
								</div>
								<div class="col-md-12 form-it">
									<label>작가</label>
									<input type="text" placeholder="작가를 입력해주세요.">
								</div>
								
								<div class="col-md-12 ">
									<input type="submit" value="검색" class="submit" >
								</div>
							</div>
						</form>
					</div>
					<div class="ads">
						<img src="images/uploads/ads1.png" alt="">
					</div>
					<div class="sb-facebook sb-it">
						<h4 class="sb-title">Find us on Facebook</h4>
						<iframe src="" data-src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Fhaintheme%2F%3Ffref%3Dts&tabs=timeline&width=340&height=315px&small_header=true&adapt_container_width=false&hide_cover=false&show_facepile=true&appId"  height="315" style="width:100%;border:none;overflow:hidden" ></iframe>
					</div>
					<div class="sb-twitter sb-it">
						<h4 class="sb-title">Tweet to us</h4>
						<div class="slick-tw">
							<div class="tweet item" id="599202861751410688">
							</div>
							<div class="tweet item" id="297462728598122498">
							</div>
						</div>					
					</div>
				</div>
			</div>
			-->
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
</body>
</html>