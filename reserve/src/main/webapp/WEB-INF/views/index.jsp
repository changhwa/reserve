<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title></title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport" content="width=device-width">

<link rel="stylesheet"
	href="/reserve/resources/_Shared/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/reserve/resources/css/jqueryui/jquery-ui-1.8.22.custom.css">
<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
	font-size: 12px;
}
</style>
<link rel="stylesheet"
	href="/reserve/resources/_Shared/bootstrap/css/bootstrap-responsive.min.css">
<link rel="stylesheet"
	href="/reserve/resources/_Shared/bootstrap/css/style.css">

<!--[if lt IE 9]>
  <script src="js/libs/html5-3.4-respond-1.1.0.min.js"></script>
  <![endif]-->
</head>
<body>
	<!--[if lt IE 7]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Project name</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
					<ul class="nav pull-right">
						<li><a href="">Login</a></li>
						<li><a href="">Register</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="mainLeftBar" class="span4">
				<div id="leftLogin">
					<legend>Login</legend>
					<form action="" class="form-inline">
						<input type="text" class="input-small" placeholder="Email">
						<input type="password" class="input-small" placeholder="Password">
						<button type="submit" class="btn">Sign in</button>
					</form>
					&nbsp;
					<button type="submit" class="btn">회원가입</button>
					<button class="btn" type="submit">아이디 비밀번호찾기</button>
				</div>
				<br/>
				<div id="speedReserve">
					<legend>항공</legend>
					<form>
						<div>
							<table border="0">
								<tr>
									<td><label>종류</label></td>
									<td>
										<input type="radio" id="selAirplaneKinds" name="selAirplaneKinds"> 편도
										<input type="radio" id="selAirplaneKinds" name="selAirplaneKinds"> 왕복
									</td>
								</tr>
								<tr>
									<td><label>출발/도착지</label></td>
									<td>
										<select name="startAirport" id="startAirport" class="span5" style="float:left;margin-right:10px;">
											<option value="">런던공항</option>
											<option value="">히드로공항</option>
											<option value="">인천공항</option>
											<option value="">삿포로공항</option>
											<option value="">뉴욕공항</option>
										</select>
										<select name="arriveAirport" id="arriveAirport" class="span5">
											<option value="">런던공항</option>
											<option value="">히드로공항</option>
											<option value="">인천공항</option>
											<option value="">삿포로공항</option>
											<option value="">뉴욕공항</option>
										</select>
									</td>
								</tr>
								<tr>
									<td><label>출발일</label></td>
									<td>
										<div class="input-append">
      										<input class="span9" id="startDate" name="startDate" type="text">
											<span class="add-on">
												<i class="icon-calendar"></i>
											</span>
										</div>
									</td>
								</tr>
								<tr>
									<td><label>도착일</label></td>
									<td>
										<div class="input-append">
      										<input class="span9" id="arriveDate" name="arriveDate" type="text">
											<span class="add-on">
												<i class="icon-calendar"></i>
											</span>
										</div>
									</td>
								</tr>
								<tr>
									<td><label>승객수</label></td>
									<td>
										<div class="input-append">
	      									<input class="span9" id="personNum" name="personNum" type="text">
												<span class="add-on">명</span>
										</div>
									</td>
								</tr>
								
								<tr>
									<td colspan="2" align="center"><button type="submit" class="btn">예약하기</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
				<br/>
				<div id="scheduleSearch">
					<legend>스케쥴검색</legend>
					<div>
						<form class="form-inline">
							<table border="0">
								<tr>
									<td>
										<select class="span12">
											<option>출발일</option>
											<option>도착일</option>
										</select>
									</td>
									<td>
										<div class="input-append">
	     									<input class="span10" id="arriveDate" name="arriveDate" type="text">
											<span class="add-on">
												<i class="icon-calendar"></i>
											</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<select class="span12">
											<option>출발지</option>
											<option>도착지</option>
										</select>
									</td>
									<td>
										<div class="input-append">
	     									<input class="span10" id="arriveDate" name="arriveDate" type="text">
											<span class="add-on">
												<i class="icon-search"></i>
											</span>
										</div>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<!-- 검색결과 -->
					<div>
						<table class="table table-striped">
							<thead>
								<td>출발일</td>
								<td>도착일</td>
								<td>출발지</td>
								<td>도착지</td>
								<td>좌석수</td>
							</thead>
							<tbody>
								<tr>
									<td>2012-10-02 09:00</td>
									<td>2012-10-03 11:00</td>
									<td>인천</td>
									<td>뉴욕</td>
									<td>20석</td>
								</tr>
								<tr>
									<td>2012-10-02 11:00</td>
									<td>2012-10-03 13:00</td>
									<td>인천</td>
									<td>뉴욕</td>
									<td>10석</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div id="mainBar" class="span8">
				<div id="mainSlide">
					<img src="/reserve/resources/image/main/slide.png">
				</div>
				<br/>
				<div class="rowfluid">
					<div class="span4">
						<div id="notice">
							<legend>공지사항</legend>
							<table border="0">
								<tr>
									<td>환절기 유의</td>
								</tr>
								<tr>
									<td>뉴욕행 비행기 연착안내</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="span4">
						<div id="event">
							<legend>이벤트</legend>
							<table border="0">
								<tr>
									<td>비행기 50%할인이벤트</td>
								</tr>
								<tr>
									<td>마일리지 적립금 10%이벤트</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/reserve/resources/_Shared/js/lib/jquery-1.7.2.js"></script>
	<script
		src="/reserve/resources/_Shared/bootstrap/js/libs/bootstrap/bootstrap.min.js"></script>
	<script src="/reserve/resources/_Shared/bootstrap/js/plugins.js"></script>
	<script src="/reserve/resources/_Shared/bootstrap/js/script.js"></script>
	<script src="http://code.jquery.com/ui/1.8.22/jquery-ui.min.js"
		type="text/javascript"></script>
	<script>
		var _gaq = [ [ '_setAccount', 'UA-XXXXX-X' ], [ '_trackPageview' ] ];
		(function(d, t) {
			var g = d.createElement(t), s = d.getElementsByTagName(t)[0];
			g.src = ('https:' == location.protocol ? '//ssl' : '//www')
					+ '.google-analytics.com/ga.js';
			s.parentNode.insertBefore(g, s)
		}(document, 'script'));
	</script>
	<script type="text/javascript">
		
	</script>

</body>
</html>
