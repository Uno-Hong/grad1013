<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>어디가 좋아?</title>
<!-- 네이버 api -->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3fmcy9j37w"></script>
<!-- 구글 api -->
<!-- <script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyBXlIrTBg49z6-ughr5Lj-KE6ctFDXvNzM" ></script> -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">
@media all and (max-width: 500px) {
	#body_menu {
		min-width: 50%;
		width: auto;
		margin-left: 5%;
		margin-right: 5%;
	}
	#image_slide {
		height: 20vh;
	}
	#slide {
		height: 20vh;
	}
	#slide ul {
		width: 20vw;
	}
	img {
		width: 60vw;
		height: 20vh;
	}
}
</style>
</head>
<body style="background: #E1E1E1;">
	<!-- start header div -->
	<div id="header_menu">
		<%@ include file="/include/header.jspf"%>
	</div>
	<!-- end header div -->


	<div class="container">
		<div id="image_slide">
			<script> $('.carousel').carousel({ interval: 2000 //기본 5초 }) </script>

			<div id="demo" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<!-- 슬라이드 쇼 -->
					<div class="carousel-item active">
						<!--가로-->
						<img class="d-block w-100" src="/grad/img/slide_image_1.jpg"
							alt="First slide">
						<div class="carousel-caption d-none d-md-block">
							<h5>TEST 중입니다.</h5>
							<p>test 중입니다.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="/grad/img/slide_image_2.jpg"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="/grad/img/slide_image_3.jpg"
							alt="Third slide">
					</div>
					<!-- / 슬라이드 쇼 끝 -->
					<!-- 왼쪽 오른쪽 화살표 버튼 -->
					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<!-- <span>Previous</span> -->
					</a> <a class="carousel-control-next" href="#demo" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<!-- <span>Next</span> -->
					</a>

					<!-- / 화살표 버튼 끝 -->
					<!-- 인디케이터 -->
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

	<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading">좋아요 순 명소</h2>
				<h3 class="section-subheading text-muted">사용자가 누른 좋아요를 토대로
					인기명소를 골랐어요~!</h3>
			</div>
			<div class="row">
				<div class="col-lg-4 col-sm-6 mb-4">
					<!-- Portfolio item 1-->
					<div class="portfolio-item">
						<a class="portfolio-link" href="test_1.jsp"> <img
							class="img-fluid" src="/grad/img/slide_image_1.jpg" id="image_1">
						</a>

						<div class="portfolio-caption">
							<div class="portfolio-caption-heading text-center">테스트 1</div>
							<div class="portfolio-caption-subheading text-muted">테스트 1</div>
						</div>

					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4">
					<!-- Portfolio item 2-->
					<div class="portfolio-item">
						<a class="portfolio-link" href="test_1.jsp"> <img
							class="img-fluid" src="/grad/img/slide_image_2.jpg" alt="...">
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">테스트 2</div>
							<div class="portfolio-caption-subheading text-muted">테스트 2</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4">
					<!-- Portfolio item 3-->
					<div class="portfolio-item">
						<a class="portfolio-link" href="test_1.jsp"> <img
							class="img-fluid" src="/grad/img/slide_image_3.jpg" alt="...">
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">테스트 2</div>
							<div class="portfolio-caption-subheading text-muted">테스트 2</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading">좋아요 순 맛집</h2>
				<h3 class="section-subheading text-muted">사용자가 누른 좋아요를 토대로
					인기맛집를 골랐어요~!</h3>
			</div>
			<div class="row">
				<div class="col-lg-4 col-sm-6 mb-4">
					<!-- Portfolio item 1-->
					<div class="portfolio-item">
						<a class="portfolio-link" href="test_1.jsp"> <img
							class="img-fluid" src="/grad/img/slide_image_1.jpg">
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading text-center">테스트 1</div>
							<div class="portfolio-caption-subheading text-muted">테스트 1</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4">
					<!-- Portfolio item 2-->
					<div class="portfolio-item">
						<a class="portfolio-link" href="test_1.jsp"> <img
							class="img-fluid" src="/grad/img/slide_image_2.jpg" alt="...">
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">테스트 2</div>
							<div class="portfolio-caption-subheading text-muted">테스트 2</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4">
					<!-- Portfolio item 3-->
					<div class="portfolio-item">
						<a class="portfolio-link" href="test_1.jsp"> <img
							class="img-fluid" src="/grad/img/slide_image_3.jpg" alt="...">
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">테스트 2</div>
							<div class="portfolio-caption-subheading text-muted">테스트 2</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



	<div id="footer_menu"></div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>