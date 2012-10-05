<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>리스트</title>
<script type="text/javascript">
	function selectBbsDetail(bbsId) {
		$('#bbsId').attr("value", bbsId);
		$('#listFrm').attr("action", "${pageContext.request.contextPath}/bbs/selectBbsDetail");
		$('#listFrm').submit();
	}

	
</script>
</head>
<body>
<div align="center">

<table>
	<tr>
		<td height="25">
			<div>게시판 리스트</div>
			<form id="listFrm" name="listFrm" method="post"> 
			<table border="1" cellpadding="3" cellspacing="0">
				<tr style="background-color:gray;">
					<td>글일련번호</td>
					<td>제목</td>
					<td>글쓴날짜</td>
					<td>글쓴이</td>
					<td>내용</td>
					<td>사진</td>
					<td>추천</td>
					<td>조회수</td>
					<td>국가</td>
					<td>도시</td>
					<td>테마및일정</td>
					<td>예상비용</td>
				</tr>
				<c:if test="${not empty selectBbsList}"> 
				<c:forEach items="${selectBbsList}" var="bbs">
				<tr>
				<!-- 
					<td><c:out value="${bbs.bbsId}"/></td>
					<td>
						<a href="javascript:selectBbsDetail(${bbs.bbsId})"><c:out value="${bbs.title}"/></a></td>
					<td><c:out value="${bbs.insertDt}"/></td>
					<td><c:out value="${bbs.insertAdminId}"/></td>
					<td><c:out value="${bbs.content}"/></td>
					<td><c:out value="${bbs.picture}"/></td>
					<td><c:out value="${bbs.likeCnt}"/></td>
					<td><c:out value="${bbs.viewCnt}"/></td>
					<td><c:out value="${bbs.country}"/></td>
					<td><c:out value="${bbs.city}"/></td>
					<td><c:out value="${bbs.subjectSchedule}"/></td>
					<td><c:out value="${bbs.probableCost}"/></td>
				 -->	
					
					
					<td><c:out value="${bbs.bbs_id}"/></td>
					<td>
						<a href="javascript:selectBbsDetail(${bbs.bbs_id})"><c:out value="${bbs.title}"/></a></td>
					<td><c:out value="${bbs.insert_dt}"/></td>
					<td><c:out value="${bbs.insert_admin_id}"/></td>
					<td><c:out value="${bbs.content}"/></td>
					<td><c:out value="${bbs.picture}"/></td>
					<td><c:out value="${bbs.like_cnt}"/></td>
					<td><c:out value="${bbs.view_cnt}"/></td>
					<td><c:out value="${bbs.country}"/></td>
					<td><c:out value="${bbs.city}"/></td>
					<td><c:out value="${bbs.subject_schedule}"/></td>
					<td><c:out value="${bbs.probable_cost}"/></td>
					
					
					
					
				</tr>
				</c:forEach>
				</c:if>
			</table>
			</form>
		</td>
	</tr>
</table>

</div>

</body>
</html>

