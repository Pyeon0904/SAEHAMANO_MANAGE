<!-- 210430  19:27  -->
<%@page import="java.util.ArrayList"%>
<%@page import="mvc.adminEvent.model.vo.Event"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "/views/common/headerDetail.jsp"%>

<%
	List<Event> list = (ArrayList) request.getAttribute("list");
%>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
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
   height: 1010px; /*높이는 각 세부페이지 컨텐츠 보고 알아서 적~당히 설정하기*/
   margin-top:330px;
   margin-bottom:100px;
   margin-left:-10px;
   padding:10px;
   color:white;
}
/*컨텐츠 영역*/
   #conbox{
       width:100%; /* 넓이도 각 세부 페이지 컨텐츠에 맞춰서 설정*/
       position:relative; 
       top:20px;
       margin:0 auto;
      font-family: 'GmarketSansLight';
   }
   
  
/* 전체 세션 영역 크기&스타일 지정*/
#content {
	width: 0 auto ; height: 0 auto; 	margin:0 auto;
}
/* 게시판 영역 크기 지정*/
#board-containers {
   background: #2a1b0a;
   width: 1400px;
   height: 1000px;
   overflow:auto;
   overflow-x:hidden;
   margin:auto;
   }
#title {  margin-top:50px; margin-bottom:20px; font-family: 'GmarketSansMedium'; font-size:25pt; text-align:center; color:white;}
#enroll{ margin:0px 0px 20px 0px; font-family: 'GmarketLight'; font-size:13.5pt; text-align:right;}
/*테이블 크기 지정*/
table#feslist {
	width: 1200px;
	margin: 0 auto;
	border-collapse: collapse; /* 테두리 셀 사이 간격*/
	clear: both;
}
/*th, td 테두리 및 텍스트 위치 설정*/
table#feslist th, table#feslist td {
	border-bottom: 1px solid wheat;
	padding: 15px 0;
	text-align: center;
}
/*테이블 제목 스타일 지정*/
#feslist th{
	background:wheat;
	color: #2a1b0a;
	font-size:13.5pt;
}
#feslist td a { color:white; text-decoration:none;}
#img{ width:100px; overflow-y:hidden;}
/*제목 부분 크기*/
#t1 {width:200px;}
#ex { width:400px; }
</style>

<script>
	$(".tbl-board").attr("style","word-break:break-all");
</script>

<div id="box">
<section id="content">
	<div id="conbox">
	<div id="board-containers">
		<div id="title">
			<span>축제 관리</span>
		</div>
		<div id="enroll">
			<input type="button" value="등록"
			onclick="location.href='<%= request.getContextPath() %>/event/enroll'"><!-- enrollevent.jsp로 이동 -->
		</div>	
			<table id="feslist">			
				<tr>
					<th>글번호</th>
					<th id="t1" >제목</th>
					<th>이미지</th>
					<th id="ex">설명</th>
					<th>기간</th>
					<th>상세조회</th>
				</tr>
					<% if(list.isEmpty()){ %>
			<tr>
				<td colspan="6">
					조회된 게시글이 없습니다.
				</td>
			</tr>	
			<% } else{ 
				for(Event event : list){
	
			%>
				
				<tr>
					<td><%=event.getEvent_no() %></td>
					<td>
					<%= event.getEvent_name() %>
					</td><% if(event.getEvent_img() != null){ %>
					<td><img id="img" src="<%=event.getEvent_img() %>"/>
					<% }else{ %><td><img id="img" src="/resources/upload/event/<%=event.getRenamed_FileName() %>"/>
					<% } %>
					</td>
					<td><%= event.getEvent_content() %></td>
					<td><%=event.getEvent_start_date() %> ~ <%= event.getEvent_last_date() %></td>
					<td><input type="button" value="상세조회"
					onclick="location.href='<%= request.getContextPath() %>/event/modify?eventNo=<%=event.getEvent_no()%>'"></td><!-- modifyEvent.jsp로 이동 -->
				</tr>
		<%}
				}%>
			</table>
	
		</div>
	</div>
</section>
</div>

<%@ include file="/views/common/footer.jsp" %>
