<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery/jquery-1.7.1.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/common.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery/jfastmenu_v1.2.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$.jFastMenu("#menu");
	});
	
	function loginForm() {
		var frm = document.headerFrm;
		frm.action = "${pageContext.request.contextPath}/loginFrm.do";
		frm.submit();
	}
	function memInfo() {
		var frm = document.headerFrm;
		frm.action = "${pageContext.request.contextPath}/mem/memInfo.do";
		frm.submit();
	}
	function updateMemInfoForm() {
		var frm = document.headerFrm;
		frm.action = "${pageContext.request.contextPath}/mem/updateMemInfoFrm.do";
		frm.submit();
	}
	function memList() {
		var frm = document.headerFrm;
		frm.action = "${pageContext.request.contextPath}/mem/memInfoList.do";
		frm.submit();
	}
	function bbsList() {
		var frm = document.headerFrm;
		frm.action = "${pageContext.request.contextPath}/bbs/selectBbsList";
		frm.submit();
	}
	function regNoticeForm() {
		var frm = document.headerFrm;
		frm.action = "${pageContext.request.contextPath}/notice/regNoticeFrm.do";
		frm.submit();
	}
</script>
<form name="headerFrm" method="post">
</form>
<div id="menu" >
	<ul>
		<li><a href="javascript:loginForm();">Home</a></li>
		
		<c:if test="${MEM_ID != null}">
		<li><a href="javascript:memInfo();">회원정보</a>
			<ul>
				<li><a href="javascript:memInfo();">마이페이지</a>
					<ul>
						<li><a href="javascript:memInfo();">내정보</a></li>
						<li><a href="javascript:updateMemInfoForm();">정보수정</a></li>
					</ul>
				</li>
				<li><a href="javascript:memList();">회원리스트</a></li>
			</ul>
		</li>
		<li><a href="javascript:noticeList();">공지사항</a>
			<ul>
				<li><a href="javascript:bbsList();">게시판 리스트</a></li>
				<li><a href="javascript:regNoticeForm();">공지사항 등록</a></li>
			</ul>
		</li>
		<li><a href="javascript:loginForm();">로그아웃</a></li>
		</c:if>
		
	</ul>
</div>




