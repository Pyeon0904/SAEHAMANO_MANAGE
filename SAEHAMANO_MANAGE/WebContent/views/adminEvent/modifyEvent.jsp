<!--210430 19:29 이재용-->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="mvc.adminEvent.model.vo.Event"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerDetail.jsp" %>
<%
	Event event = (Event) request.getAttribute("event");
%>

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
   height: 700px; /*높이는 각 세부페이지 컨텐츠 보고 알아서 적~당히 설정하기*/
   margin-top:330px;
   margin-bottom:100px;
   margin-left:-10px;
   padding:10px;
   color:white;
}
/*컨텐츠 영역*/
   #conbox{
      width:800px; /* 넓이도 각 세부 페이지 컨텐츠에 맞춰서 설정*/
       position:relative; 
       top:20px;
       margin:0 auto;
      font-family: 'GmarketSansLight';
   }
   
/* 게시글 작성 전체 영역*/	
	div#con-modifyevent
	{
		width:600px;
		margin:0 auto;
		text-align:center;
    	padding: 30px 30px 50px 30px;
	}
	
/*공지사항 작성 타이틀 스타일*/
	div#con-modifyevent span
	{
	    font-family: 'GmarketSansMedium';
		font-size:25pt;
		display:block;
		margin:0px;
		padding-bottom: 20px;
	}
	
/*영역 지정 */
	table#modifyevent
	{
		width:600px;
		border:1px solid white;
		border-collapse:collapse;
	}
/*테이블 th (제목) 스타일*/
	table#modifyevent th
	{
		width:125px;
		padding:5px 0;
		text-align:center;
		border:1px solid white;
	}
	
	
	/*내용 작성 박스 스타일 지정*/
	.modify-content {
		width:500px;
		resize : none;
		outline-style : none;
	}
	
	/*텍스트 박스 '제목' 스타일 지정*/
	.modify-title {
		width: 500px; height: 30px;
		border: 1px solid lightgrey;
		outline-style : none;
	}
	
	/*텍스트 박스 '작성자' 크기 조정*/
	.modify-writer {
		width: 500px; 	height:30px;
		border: 1px solid lightgrey;
		outline-style : none;
	}
	
	/*리셋버튼 스타일*/
	.btn-cancell {
		width:65px; height:30px;
		background-color : white;
		border: none;
	}
	/*등록버튼 스타일*/
	.btn-submit {
		width:65px; height:30px;
		background-color : white;
		border: none;
	}
	
	/*마우스올렸을 때 강조 (제목/작성자/버튼)*/
	input:hover { background-color:wheat;}
	
	/* 첨부파일 등록 버튼*/
	 .file-add {
      width:400px;
      height:20px;
      margin-left:5px;
      float:left;
   	}
   	/* 첨부파일 등록 버튼*/
   	#modifyevent input[type=file] {
      width:400px;
      height:20px;
      margin-left:5px;
      float:left;
      
   }
   
	div#file {
		display: block;
		font-size: 10pt;
		float:left;
		margin-left:5px;
	}
</style>
<div id="box">
<section id="content">
	<div id="conbox">
	<div id='con-modifyevent'>
		<span>행사 수정</span>
		<form action="<%=request.getContextPath() %>/event/modify" method="POST" enctype="multipart/form-data">
			<table id="modifyevent">
			<tr >
			<td><input type="hidden" name="eventNo" class="eventNo" value="<%=event.getEvent_no()%>"></td>
				<input type="hidden" name="original_Filename" value="<%= event.getOriginal_FileName()%>"/>
				<input type="hidden" name="renamed_Filename" value="<%= event.getRenamed_FileName()%>"/>
			</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="event_name" class="modify-title"value="<%=event.getEvent_name()%>"></td>
				</tr>
				<tr>
					<!-- <th>작성자</th>
					<td><input type="text" name="writer" class="modify-writer" value="admin"  readonly></td>
				 --></tr>
				<tr>
					<th>시작</th>
				<td><input type="type" id="startdate" name="event_start_date" 
		                   value="<%=event.getEvent_start_date()%>" class="modify-writer">
		            </td>
				</tr>
				<tr>
					<th>종료</th>
					
					<td>
					<input type="type" id="finaldate" name="event_last_date"
		                   value="<%=event.getEvent_last_date()%>" class="modify-writer">
		            </td>
				</tr>
				<tr>
					<th>인스타</th>
					<td><input type="text" name="event_insta" class="modify-writer" value="<%=event.getEvent_insta() %>"/></td>
				</tr>
				<tr>
					<th>홈페이지</th>
					<td><input type="text" name="event_home" class="modify-writer"value="<%=event.getEvent_home() %>"/></td>
				</tr>
				<tr>
					<th>장소</th>
					<td><input type="text" name="event_place" class="modify-writer"value="<%=event.getEvent_place() %>"/></td>
				</tr>
				<tr>
					<th>주최</th>
					<td><input type="text" name="event_hosting" class="modify-writer"value="<%=event.getEvent_hosting() %>"/></td>
				</tr>
				
				<tr>
				<% if(event.getEvent_img() == null){ %>
				<th>이미지링크</th>
					<td><input type="text" name="event_img" class="modify-writer" value="https://drive.google.com/uc?id=" /></td>
					<%}else{ %>
					<th>이미지링크</th>
					<td><input type="text" name="event_img" class="modify-writer" value="<%=event.getEvent_img() %>" /></td>
					<%} %>
				</tr>
				<!--  
				<tr>
					<th>첨부파일</th>
					<td>
					
					<input type="file" name="reloadfile" value="<%=event.getOriginal_FileName()%>"/>
					<input type="button" id="deletefile" name="deletefile" value="삭제">
									<script>
										$(document).ready(function(){
											$("#deletefile").on("click",(e) => {
												$("#upfile").val('');
											});
										});
									</script>
					
						
					<% if(event.getOriginal_FileName() != null) { %>
						<div id="file">
						<img src="<%= request.getContextPath() %>/resources/images/filedown.png" width="20" height="20"/>
						<%= event.getOriginal_FileName() %>
						</div>
					<% } %>
					</td>
				</tr>
				-->
				<tr>
					<th>내용</th>
					<td><textarea name="event_content" class="modify-content" cols="50" rows="15" >
					<%=event.getEvent_content()%></textarea></td>
				</tr>
				
				<tr>
					<th colspan="2">
						<input type="button"  class="btn-cancell"  value="삭제">
						<input type="submit" class="btn-submit" value="수정">
					</th>
				</tr>
			</table>
		</form>
		
	</div>
</div>
</section>
</div>
<script>
	$(document).ready(() => {
		$(".btn-cancell").on("click",(e) =>{
			if(confirm("정말로 삭제?")){
				location.replace("<%= request.getContextPath()%>/event/delete?eventNo=<%= event.getEvent_no() %>")
			}
		});
	});

</script>

<%@ include file="/views/common/footer.jsp" %>