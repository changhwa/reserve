<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>게시판 입력화면 입니다.</title>
<script type="text/javascript" language="JavaScript">
	function insertBbs() { 
		
		BbsVo BbsVo = new BbsVo();
		
		f = document.regFrm;
		
		
		var strTitle = document.getElementById("strTitle").value;
		var strContent = document.getElementById("strContent").value;
		
		if (strTitle == "") {
			alert("제목을 입력해 주세요.");
			return;
		}
		
		if (strContent == "") {
			alert("내용을 입력해 주세요.");
			return;
		}
		
		//location.href="${pageContext.request.contextPath}/bbs/insertBbs";
	
		//f.action = "${pageContext.request.contextPath}/bbs/insertBbs";
		f.action = "/reserve/bbs/insertBbs";
        f.submit();
        
	}
</script>
</head>
<body>

<div align="center">
	<form name="regFrm" method="post">
		<table>
			<tr>
				<td>국가</td>
				<td width="300" height="40">
					<input type="text" size="50" name="strCountry" id="strCountry" />
				</td>
			</tr> 
			<tr>
				<td>도시</td>
				<td width="300" height="40">
					<input type="text" size="50" name="strCity" id="strCity" />
				</td>
			</tr>
			<tr>
				<td>테마 및 일정</td>
				<td width="300" height="40">
					<input type="text" size="50" name="strSubjectSchedule" id="strSubjectSchedule" />
				</td>
			</tr>
			<tr>
				<td>예상비용</td>
				<td width="300" height="40">
					<input type="text" size="50" name="strProbableCost" id="strProbableCost" />
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td width="300" height="40">
					<input type="text" size="50" name="strTitle" id="strTitle" />
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td width="300" height="40">
					<textarea id="strContent" name="strContent" cols="100" rows="10"></textarea>
				</td>
			</tr>
		</table>
		<p>
			<input type="button" value="전송" onclick="insertBbs()"/>
		</p>
	</form>
</div>
</body>
</html>





