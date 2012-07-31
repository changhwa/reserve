<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
              <div class="span11">
                <div class="control-group" >
                  <label for="adultNum" class="control-label">&nbsp;어른&nbsp;&nbsp;&nbsp;
                    <span class="controls">
                      <select name="adultNum" id="adultNum" class="input-medium">
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
                  </label>  
                  <label for="childNum" class="control-label">&nbsp;어린이
                    <span class="controls">
                      <select name="childNum" id="childNum" class="input-medium">
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
                  </label>
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
                    <div id="date">
                      <input type="text" id="startDate" name="startDate" onclick="aaa()" placeholder="출발일"/>
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
            <div class="span12" >
              <div class="row-fluid">
                <div class="span1"></div>
                <div class="span7">
                  <input type="text" class="input-medium search-query" placeholder="도시검색">
                </div>
                <div class="span1 offset1">
                  <button class="btn" onclick="searchCity()">Search</button>
                </div>
              </div>             
            </div>
          </div>
          <div class="row">
            <div class="span12">
              <div class="row-fluid">
                <div class="span1"></div>
                <div class="span11" id="showCity">
                  <!-- 원래는 ajax에서 구현되어야 할 부분이나 없는관계로 임시로 만들어둠..-->
                  <table class="table">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>공항</th>
                      </tr>
                    </thead>
                    <tbody>
                        <tr>
                          <td>1</td>
                          <td>히드로공항</td>
                        </tr>
                        <tr>
                          <td>2</td>
                          <td>런던공항</td>
                        </tr>
                        <tr>
                          <td>3</td>
                          <td>취리히공항</td>
                        </tr>
                        <tr>
                          <td>4</td>
                          <td>개트윅공항</td>

                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="span6">
          <div class="span12">
            <div id="schedule">
              <!--이부분 역시 ajax처리로 공항+날짜 정보에 따른 스케쥴표 출력 -->
              <table class="table well">
                <thead>
                  <th>출발시간</th>
                  <th>도착시간</th>
                  <th>소요시간</th>
                  <th>좌석수</th>
                </thead>
                <tbody>
                  <tr>
                    <td>07-30 09:00</td>
                    <td>07-30 24:00</td>
                    <td>15/h</td>
                    <td>10</td>
                  </tr>
                  <tr>
                    <td>07-30 10:00</td>
                    <td>07-31 01:00</td>
                    <td>15/h</td>
                    <td>10</td>
                  </tr>
                  <tr>
                    <td>07-31 09:00</td>
                    <td>07-31 24:00</td>
                    <td>15/h</td>
                    <td>10</td>
                  </tr>
                  <tr>
                    <td>08-01 05:00</td>
                    <td>08-01 20:00</td>
                    <td>15/h</td>
                    <td>10</td>
                  </tr>
                  <tr>
                    <td>08-01 07:00</td>
                    <td>08-01 22:00</td>
                    <td>15/h</td>
                    <td>10</td>
                  </tr>
                  <tr>
                    <td>08-01 20:00</td>
                    <td>08-02 11:00</td>
                    <td>15/h</td>
                    <td>10</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div id="seatReserve">
              <jsp:include page="/reserv/seat?airinformCode=1" />               
            </div>
          </div>
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
<script type="text/javascript">
  

</script>

</body>
</html>
