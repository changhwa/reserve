<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/reserve/resources/css/reserve/seat.css" rel="stylesheet"
	type="text/css" />
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var="num" items="${seatNum}">
	
	
		<c:choose>
			<c:when test="${num=='0' }">
				<div class="blankSeat"></div>
			</c:when>
			<c:when test="${num=='1' }">
				<div class="noReserveSeat"></div>
			</c:when>
			<c:when test="${num=='2' }">
				<div class="reserveSeat"></div>
			</c:when>
			<c:when test="${num=='3' }">
				<br/>
			</c:when>

		</c:choose>
	</c:forEach>
</body>
</html>