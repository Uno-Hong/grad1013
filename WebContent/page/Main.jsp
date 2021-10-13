<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>어디가 좋아?</title>
<!-- 네이버 api -->
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3fmcy9j37w"></script>
<!-- 구글 api -->
<!-- <script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyBXlIrTBg49z6-ughr5Lj-KE6ctFDXvNzM" ></script> -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">


	/* 링크 밑줄 없애기 */
	a {
		text-decoration: none;
		opacity: 1;
	}
	body a:hover {
		color: black;
		text-decoration: none; 
	}	
	#body_menu {
		min-width: 50%;
		width: auto;
		margin-left: 15%;
		margin-right: 15%;	
	}
</style>
<style type="text/css">
	#image_slide{
		height: 500px;
	}
	#slide{
		height: 500px;
		overflow: hidden;
	}
	#slide ul{ 
		width: 3600px;
		font-size: 0;
	}
	#slide ul li{
		display: inline-block;
		font-size: 0;
	}
	img {
		width: 1200px;
		height: 500px;
		vertical-align: bottom;
	}
	div {
		border: 1px solid black;
	}
	.board {
		float: left;
	}
</style>
<style type="text/css">
	#input_search {
		width: 300px;
		height: 50px;
		font-size: 18px;
		border: 1px;
		border-color: #1b5ac2;
		outline: none;
		float: center;
		
	}
	#btn_search {
		border: 0px solid;
		width: 50px;
		height: 50px;
		background: #1b5ac2;
		outline: none;
		float: center;
		color: #ffffff;
	}
	input:-ms-input-placeholder {color:#a8a8a8;}
	input::-webkit-input-placeholder {color:#a8a8a8;}
	input::-moz-placeholder {color:#a8a8a8;}
	
	#searchbar {
		display: inline-block;
		
	}
</style>
<style type="text/css">
	@media all and (max-width: 500px) {
		#body_menu { min-width: 50%; width: auto; margin-left: 5%; margin-right: 5%; }
		#image_slide { height: 20vh; }
		#slide { height: 20vh; }
		#slide ul { width: 20vw; }
		img { width: 60vw; height: 20vh;}
		
	}
</style>
<script>
	/* 
	setInterval(function(){ $('#slide>ul').delay(2500);
	$('#slide>ul').animate({marginLeft: "0px"})
	$('#slide>ul').delay(2500);
	$('#slide>ul').animate({marginLeft: "-1200px"})
	$('#slide>ul').delay(2500);
	$('#slide>ul').animate({marginLeft: "-2400px;"}) });
	 */
</script>
</head>
<body style="background: #E1E1E1;">
	<!-- start header div -->
	<div id="header_menu">
		<%@ include file="/include/header.jspf"%>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> 
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script> 
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</div>
	&nbsp&nbsp&nbsp&nbsp
	<!-- end header div -->
	
	<div id="body_menu">
		<div id	="searchbar" align="center" style="width: 400px; height: 55px; position: relative; left: 50%; margin-left: -200px;">
			<div>
				<input type="text" placeholder="검색창임" id="input_search">
				<button id="btn_search">검색</button>
			</div>
		</div>
		

<div id="image_slide">
         <script> $('.carousel').carousel({ interval: 2000 //기본 5초 }) </script> 
      <div class = "container">
       <div id="demo" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner"> 
        <!-- 슬라이드 쇼 --> 
        <div class="carousel-item active"> 
        <!--가로--> 
        <img class="d-block w-100" src="/grad/img/slide_image_1.jpg" alt="First slide"> 
        <div class="carousel-caption d-none d-md-block"> 
        <h5>TEST</h5> 
        <p>testtesttest</p> 
        </div> 
        </div> 
        <div class="carousel-item"> 
        <img class="d-block w-100" src="/grad/img/slide_image_2.jpg" alt="Second slide"> 
        </div> 
        <div class="carousel-item"> 
        <img class="d-block w-100" src="/grad/img/slide_image_3.jpg" alt="Third slide"> 
        </div> 
        <!-- / 슬라이드 쇼 끝 --> 
        <!-- 왼쪽 오른쪽 화살표 버튼 --> 
        <a class="carousel-control-prev" href="#demo" data-slide="prev"> 
        <span class="carousel-control-prev-icon" aria-hidden="true"></span> 
        <!-- <span>Previous</span> --> 
        </a> 
        <a class="carousel-control-next" href="#demo" data-slide="next"> 
        <span class="carousel-control-next-icon" aria-hidden="true"></span> 
        <!-- <span>Next</span> --> 
        </a>
       
         <!-- / 화살표 버튼 끝 --> <!-- 인디케이터 --> 
         <ul class="carousel-indicators"> 
         <li data-target="#demo" data-slide-to="0" class="active"></li> 
         <!--0번부터시작--> 
         <li data-target="#demo" data-slide-to="1"></li> 
         <li data-target="#demo" data-slide-to="2"></li> 
         </ul>
          <!-- 인디케이터 끝 -->
          </div>
          </div> 
          </div> 
          </div>




	
	<!-- end of body div -->
	
	<%-- <div id="main_map">
		<!-- map 코드 파일 include -->
		<%@ include file="./map.jspf"%>
	</div> --%>
	
	<div id="footer_menu">
		
	</div>
</body>
</html>