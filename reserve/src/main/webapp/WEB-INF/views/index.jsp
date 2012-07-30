<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <title></title>
  <meta name="description" content="">
  <meta name="author" content="">

  <meta name="viewport" content="width=device-width">

  <link rel="stylesheet" href="/reserve/resources/_Shared/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/reserve/resources/css/jqueryui/jquery-ui-1.8.22.custom.css">
  <style>
  body {
    padding-top: 60px;
    padding-bottom: 40px;
  }
  </style>
  <link rel="stylesheet" href="/reserve/resources/_Shared/bootstrap/css/bootstrap-responsive.min.css">
  <link rel="stylesheet" href="/reserve/resources/_Shared/bootstrap/css/style.css">

  <!--[if lt IE 9]>
  <script src="js/libs/html5-3.4-respond-1.1.0.min.js"></script>
  <![endif]-->
</head>
<body>
<!--[if lt IE 7]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Project name</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
          <div class="row" style="">
            <div class="row-fluid">
              <div class="span1"></div>
              <div class="span5">
                <div class="control-group">
                  <label for="adultNum" class="control-label">&nbsp;어른</label>
                    <span class="controls">
                      <select name="" id="adultNum" class="input-small">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                      </select>
                    </span>
                  
                </div>
              </div>
              <div class="span6">
                <div class="control-group">
                  <label for="childNum" class="control-label">&nbsp;어린이</label>
                    <span class="controls">
                      <select name="" id="childNum" class="input-small">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                      </select>
                    </span>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="span12">
              <div class="row-fluid">
                <div class="span1"></div>
                <div class="span11">
                  <div id="date">
                    <label for="startDate">출발일</label>
                    <div id="date">
                      <input type="text" id="startDate" name="startDate" onclick="aaa()" />
                    </div>
                    <script>
                      function aaa(){
                        $("#startDate").datepicker();  
                      }
                    </script>
                  </div>
                </div>
              </div>
              
            </div>
          </div>
          <div class="row">
            <div class="span12" ></div>
          </div>
        </div>
        <div class="span6" style="background-color:blue">
          <!--Body content-->
        </div>
        <div class="span3">
        
        </div>
      </div>
    </div> <!-- /container -->
<script src="/reserve/resources/_Shared/js/lib/jquery-1.7.2.js"></script>
<script src="/reserve/resources/_Shared/bootstrap/js/libs/bootstrap/bootstrap.min.js"></script>
<script src="/reserve/resources/_Shared/bootstrap/js/plugins.js"></script>
<script src="/reserve/resources/_Shared/bootstrap/js/script.js"></script>
<script src="http://code.jquery.com/ui/1.8.22/jquery-ui.min.js" type="text/javascript"></script>
<script>
  var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
  (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
  g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
  s.parentNode.insertBefore(g,s)}(document,'script'));
</script>


</body>
</html>
