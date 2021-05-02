<!--210430 19:40 이재용 -->

<%@page import="mvc.adminCulture.model.vo.Culture"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mvc.common.util.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/views/common/headerDetail.jsp"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%
List<Culture> list = (ArrayList) request.getAttribute("list");

%>
<style>
/*하이퍼링크 스타일*/
a { text-decoration:none }
td>a:link { color:white; } /*방문안한 페이지 글자색*/
td>a:visited { color:wheat; } /*방문한 페이지 글자색*/
@font-face {
    font-family: 'GmarketSansLight';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansLight.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
#box{ 
   background-color:#2a1b0a;
   width:100%;
   height: 100%; /*높이는 각 세부페이지 컨텐츠 보고 알아서 적~당히 설정하기*/
   margin-top:330px;
   margin-bottom:100px;
   margin-left:-10px;
   padding:10px;
   color:white;
}
/*컨텐츠 영역*/
   #conbox{
       width:100%; /* 넓이도 각 세부 페이지 컨텐츠에 맞춰서 설정*/
       height: 100%;
       position:relative; 
       top:20px;
       margin:0 auto;
      font-family: 'GmarketSansLight';
   }
 
/* 게시판 영역 크기 지정*/
div#culList-con {
	width: 1400px ; height: 100%; 	margin: auto; 
}
/*공지사항 글자 스타일*/
div#culList-con h1 {
	font-size:25pt;
	margin-bottom:  50px;
}
/*테이블 크기 지정*/
table#tbl-board {
	width: 1400px;
	margin: auto;
	border-collapse: collapse; /* 테두리 셀 사이 간격*/
	clear: both;
	background:#2a1b0a;
	
}
/*th, td 테두리 및 텍스트 위치 설정*/
table#tbl-board th, table#tbl-board td {
	border-bottom: 1px solid wheat;
	padding: 13px 0;
	text-align: center;
}

/*"분류" 컬럼 너비 조정*/
#td2 {
	width: 80px;
}

/* "시대", "지정일" 컬럼 너비 조정*/
#td3, #td4 {
	width: 120px;
}

/*테이블 제목 스타일 지정*/
#tbl-board th{
	background:wheat;
	color: #2a1b0a;
	font-size:13.5pt;
}
/*등록 버튼*/
#btn-add {
	float:right; 
	text-align: center;
	width: 65px;	height: 35px;
	padding: 5px 5px;
	background: wheat;
	border:none;
	font-family: 'GmarketSansMedium';
}
/*버튼 영역*/
#culAdd-btn {width: 1400px;height: 50px;text-align: right;}
</style>

<script>
	$(".tbl-board").attr("style","word-break:break-all");
</script>

<div id="box">
<section>
	<div id="conbox">
	<div id="culList-con">
		<h1 align="center">문화재 목록</h1>
		<div id="culAdd-btn">
					<button type="button"  id="btn-add"
					onclick="location.href='<%=request.getContextPath() %>/culture/add'">등록</button>
			</div>

			<table id="tbl-board">
				<tr class="fix-head">
					<th width="10%">문화재번호</th>
					<th id="td2">분류</th>
					<th width="40%">이름</th>
					<th id="td3">시대</th>
					<th id="td4">지정일</th>
					<th>위치</th>
				</tr>
			<% if(list.isEmpty()){ %>
				 <tr>
					<td colspan="6">조회된 게시글이 없습니다.</td>
				</tr> 
			<% } else {
				for(Culture culture : list){ %>
				<tr>
					<td><%=culture.getCul_no() %></td>
					<td id="td2"><%=culture.getCul_category() %></td>
					<td>
					<a href="<%=request.getContextPath() %>/culture/modify?cul_no=<%=culture.getCul_no()%>">
					<%=culture.getCul_name() %>
					</a></td>
					<td id="td3"><%=culture.getCul_era() %></td>
					<td id="td4"><%=culture.getDeg_date() %></td>
					<td><%=culture.getCul_location() %></td>
				</tr>
				<% 
				}
			} 
			%>

		</table>
			</div>
		</div>
</section>
</div>

<%@ include file="/views/common/footer.jsp" %>