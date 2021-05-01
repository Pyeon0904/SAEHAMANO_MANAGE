<!--210430 19:29 이재용-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerDetail.jsp" %>

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
	div#con-enrollevent
	{
		width:600px;
		margin:0 auto;
		text-align:center;
    	padding: 30px 30px 50px 30px;
	}
	
/*공지사항 작성 타이틀 스타일*/
	div#con-enrollevent span
	{
	    font-family: 'GmarketSansMedium';
		font-size:25pt;
		display:block;
		margin:0px;
		padding-bottom: 20px;
	}
	
/*영역 지정 */
	table#enrollevent
	{
		width:600px;
		border:1px solid white;
		border-collapse:collapse;
	}
/*테이블 th (제목) 스타일*/
	table#enrollevent th
	{
		width:125px;
		padding:5px 0;
		text-align:center;
		border:1px solid white;
	}
	
	
	/*내용 작성 박스 스타일 지정*/
	.enroll-content {
		width:500px;
		resize : none;
		outline-style : none;
	}
	
	/*텍스트 박스 '제목' 스타일 지정*/
	.enroll-title {
		width: 500px; height: 30px;
		border: 1px solid lightgrey;
		outline-style : none;
	}
	
	/*텍스트 박스 '작성자' 크기 조정*/
	.enroll-writer {
		width: 500px; 	height:30px;
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
   	#enrollevent input[type=file] {
      width:400px;
      height:20px;
      margin-left:5px;
      float:left;
   }
	
</style>
<div id="box">
<section id="content">
	<div id="conbox">
	<div id='con-enrollevent'>
		<span>행사 등록</span>
		<form action="<%=request.getContextPath() %>/event/enroll" method="POST" enctype="multipart/form-data">
			<table id="enrollevent">
				<tr>
					<th>제목</th>
					<td><input type="text" name="event_name" class="enroll-title"></td>
				</tr>
				<!--  <tr>
					<th>작성자</th>
					<td><input type="text" name="writer" class="enroll-writer" value="admin"  readonly></td>
				</tr> -->
				<tr>
					<th>시작</th>
					<td><input type="type" id="startdate" name="event_start_date" class="enroll-writer">
		            </td>
				</tr>
				<tr>
					<th>종료</th>
					<td>
					<input type="type" id="finaldate" name="event_last_date" class="enroll-writer">
		            </td>
				</tr>
				<tr>
					<th>인스타</th>
					<td><input type="text" name="event_insta" class="enroll-writer" /></td>
				</tr>
				<tr>
					<th>홈페이지</th>
					<td><input type="text" name="event_home" class="enroll-writer" /></td>
				</tr>
				<tr>
					<th>장소</th>
					<td><input type="text" name="event_place" class="enroll-writer" /></td>
				</tr>
				<tr>
					<th>주최</th>
					<td><input type="text" name="event_hosting" class="enroll-writer" /></td>
				</tr>
				<tr>
					<th>이미지링크</th>
					<td><input type="text" name="event_img" class="enroll-writer" value="https://drive.google.com/uc?id=" /></td>
				</tr>
				<!--  <tr>
					<th>첨부파일</th>
					<td><input type="file" name="upfile"></td>
				</tr>
				-->
				<tr>
					<th>내용</th>
					<td><textarea name="event_content" class="enroll-content" cols="50" rows="15" ></textarea></td>
				</tr>
				
				<tr>
					<th colspan="2">
						<input type = "reset"value="취소">
						<input type="submit" class="btn-submit" value="등록">
					</th>
				</tr>
			</table>
		</form>
		
	</div>
</div>
</section>
</div>

<%@ include file="/views/common/footer.jsp" %>