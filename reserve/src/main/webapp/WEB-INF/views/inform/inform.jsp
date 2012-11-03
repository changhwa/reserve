<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<title>Bootstrap, from Twitter</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- Le styles -->
		<link href="/reserve/resources/_Shared/bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="/reserve/resources/_Shared/css/airlineSchedule.css" rel="stylesheet" />

		<link href="/reserve/resources/_Shared/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

		<!-- Le fav and touch icons -->
		<link rel="shortcut icon" href="/reserve/resources/_Share/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="/reserve/resources/_Shared/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="/reserve/resources/_Share/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="/reserve/resources/_Share/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="/reserve/resources/_Share/ico/apple-touch-icon-57-precomposed.png">
	</head>

	<body  onload="initialize()">

		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a>
					<a class="brand" href="#">SEJONG_TEST</a>
					<div class="nav-collapse">
						<ul class="nav">
							<li class="active">
								<a href="#">Home</a>
							</li>
							<li>
								<a href="#about">About</a>
							</li>
							<li>
								<a href="#contact">Contact</a>
							</li>
						</ul>
					</div><!--/.nav-collapse -->
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span4">
					<div class="row span12">
						<div class="page-header">
							<h1>Airline Schedule</h1>
							<h4>Fill the value to find schdule</h4>
						</div>
					</div>
					<!--Search Condition-->
					<div class="row span12">
						<div class="row"></div>
						<div class="row span12">
							<div class="lead span3">
								From
							</div>
							<input class="span9" type="text" data-provide="typeahead" placeholder="City name or airport"/>
						</div>
						<div class="row span12">
							<div class="lead span3">
								To
							</div>
							<input class="span9" type="text" data-provide="typeahead" placeholder="City name or airport"/>
						</div>
						<div class="row span12">
							<div class="lead span4">
								Arrive date
							</div>
							<input type="date" type="text"/>
						</div>
					</div>
					<div class="row span12"  id="map_canvas" style="width:100%;"></div>
				</div>

				<!--Right AirlineSchedule page Start-->
				<div class="span8">
					<!--AirlineSchedule start-->
					<div class="span12 schedule_header accordion-group">
						<h3 class="take_off">TakeOff</h3>
						<h3 class="dur">Dur.</h3>
						<h3 class="landing">Landing</h3>
						<h3 class="route">Route</h3>
						<h3 class="fare">Fare</h3>
					</div>

					<div class="accordion" id="accordion2">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
								<div class="takeOff" >
									2012.09.21 12:31
								</div>
								<div class="dur">
									3h40m
								</div>
								<div class="landing">
									2012.09.21 16:11
								</div>
								<div class="route">
									direct
								</div>
								<div class="fare">
									500
								</div></a>
							</div>
							<div id="collapseOne" class="accordion-body in collapse" style="height: 0px; ">
								<div class="accordion-inner">
									Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo"> Collapsible Group Item #2 </a>
							</div>
							<div id="collapseTwo" class="accordion-body collapse" style="height: 0px; ">
								<div class="accordion-inner">
									Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree"> Collapsible Group Item #3 </a>
							</div>
							<div id="collapseThree" class="accordion-body collapse" style="height: 0px; ">
								<div class="accordion-inner">
									Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--AirlineSchedule Page end-->
		</div>

		<hr>

		<footer>
			<p>
				&copy; Company 2012
			</p>
		</footer>

		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-transition.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-alert.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-modal.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-dropdown.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-scrollspy.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-tab.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-tooltip.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-popover.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-button.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-collapse.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-carousel.js"></script>
		<script src="/reserve/resources/_Shared/bootstrap/js/bootstrap-typeahead.js"></script>
		<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCt_bmhtl-lQD_zpFpH0VkAUbSFGRUzsXE&sensor=false&language=ko"></script>

		<!--JQuery-->
		<script type="text/javascript">
			$(window).resize(function() {
				$('#map_canvas').height($('#map_canvas').width() * .75);
			});
		</script>

		<!--Google Map Control Script-->
		<script type="text/javascript">
			var poly;
			var map;
			var markersArray = [];

			function initialize() {
				var chicago = new google.maps.LatLng(41.879535, -87.624333);
				var mapOptions = {
					zoom : 7,
					center : chicago,
					mapTypeId : google.maps.MapTypeId.ROADMAP
				};
				map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
				$('#map_canvas').height($('#map_canvas').width() * .75);
				initPolyline();
			}

			function initPolyline() {
				var polyOptions = {
					strokeColor : '#000000',
					strokeOpacity : 1.0,
					strokeWeight : 3
				}
				poly = new google.maps.Polyline(polyOptions);
				poly.setMap(map);
			}

			function clearOverlays() {
				poly.setMap(null);
				initPolyline();
				if (markersArray) {
					for (i in markersArray) {
						markersArray[i].setMap(null);
					}
				}
			}

			function addLatLng(lat, lng) {
				var latLng = new google.maps.LatLng(lat, lng);
				var path = poly.getPath();
				path.push(latLng);
				markersArray.push(new google.maps.Marker({
					position : latLng,
					title : '#' + path.getLength(),
					map : map
				}));
			}

			function aa() {
				addLatLng(41.879535, -87.624333);
				addLatLng(41.873535, -87.622333);
				addLatLng(41.179535, -87.624333);
				addLatLng(41.379535, -87.324333);
				addLatLng(41.329535, -87.324333);
				addLatLng(41.899535, -87.924333);
				addLatLng(41.822535, -87.624113);
			}
		</script>
	</body>
</html>