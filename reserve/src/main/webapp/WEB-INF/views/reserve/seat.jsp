<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/reserve/resources/css/reserve/seat.css" rel="stylesheet"
	type="text/css" />

</head>
<body>

	<div id="seat">

		<c:forEach var="num" items="${seatNum}" varStatus="status">

			<c:choose>
				<c:when test="${num=='0' }">
					<div class="blankSeat"></div>
				</c:when>
				<c:when test="${num=='1' }">
					<div id="seatName${status.count }" class="noReserveSeat"
						onclick="selectedSeat(${status.count})"></div>
				</c:when>
				<c:when test="${num=='2' }">
					<div class="reserveSeat"></div>
				</c:when>
				<c:when test="${num=='3' }">
					<br />
				</c:when>
			</c:choose>

		</c:forEach>

	</div>
	<div><button class="btn" onclick="reserveSubmit()">확인 </button></div>

	<input type="hidden" name="airinformCode" id="airinformCode" value="${param.airinformCode}" />

	<script type="text/javascript"
		src="/reserve/resources/_Shared/js/lib/jquery-1.7.2.js"></script>
	<script type="text/javascript"
		src="/reserve/resources/_Shared/js/util/stringUtil.js"></script>
	<script type="text/javascript">
		
		var selectNum = 1;
		var returnVal=new Array();
		
		function selectedSeat(num){
			
			var personTotal = parseInt($("#adultNum").val())+parseInt($("#childNum").val());
			
			var seatId = $("#seatName"+num); 
			
			var selectSeatNum="";
			
			if(selectNum<=personTotal && seatId.hasClass("noReserveSeat")){
				seatId.removeClass("noReserveSeat");
				seatId.addClass("reserveSeat");
				selectNum++;
				returnVal.push(num);
				
			}

			else if(seatId.hasClass("reserveSeat")){
				seatId.removeClass("reserveSeat");
				seatId.addClass("noReserveSeat");
				selectNum--;
				returnVal = removeArray(returnVal, num);

			}
			
			else{
				alert('선택인원을 초과하였습니다');
			}
			console.log('selectNum: '+selectNum);
			console.log('num: '+num);
			console.log('selectSeatNum:' +selectSeatNum);
		}
		
		function reserveSubmit(){
			$.ajax({
				type:"POST",
				url: "/reserve/reserv/process",
				dataType: "txt",
				data:"seatNum="+returnVal+"&airinformCode="+$("#airinformCode").val(),
				success: function(msg){
					alert('success');
				},
				fail: function(msg){
					alert('fail');
				}
			});		
		}
		
		
		
	</script>
</body>
</html>