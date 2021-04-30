<!--210426 9:54 김예원 (최종수정자) -->
<!-- 프론트 & 백 통합 -->
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
   height: 600px; /*높이는 각 세부페이지 컨텐츠 보고 알아서 적~당히 설정하기*/
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
	div#NoticeWriteContainer
	{
		width:600px;
		margin:0 auto;
		text-align:center;
    	padding: 30px 30px 50px 30px;
	}
	
/*공지사항 작성 타이틀 스타일*/
	div#NoticeWriteContainer span
	{
		font-size:25pt;
		display:block;
		margin:10px 0;
		padding-bottom: 20px;
	}
	
/*영역 지정 */
	table#tbl-noticeWrite
	{
		width:600px;
		border:1px solid white;
		border-collapse:collapse;
	}
/*테이블 th (제목) 스타일*/
	table#tbl-noticeWrite th
	{
		width:125px;
		padding:5px 0;
		text-align:center;
		border:1px solid white;
	}
	
	
	/*내용 작성 박스 스타일 지정*/
	.notice-content {
		width:500px;
		resize : none;
		outline-style : none;
	}
	
	/*텍스트 박스 '제목' 스타일 지정*/
	.notice-title {
		width: 500px; height: 30px;
		border: 1px solid lightgrey;
		outline-style : none;
	}
	
	/*텍스트 박스 '작성자' 크기 조정*/
	.notice-writer {
		width: 500px; 	height:30px;
		border: 1px solid lightgrey;
		outline-style : none;
	}
	
	/* 첨부파일 등록 버튼*/
	#tbl-noticeWrite input[type=file] {
		width:400px;
		height:20px;
		margin-left:5px;
		float:left;
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
	
</style>

<div id="box">
<section id="content">
	<div id="conbox">
	<div id='NoticeWriteContainer'>
		<span>공지사항 등록</span>
		<form action="<%= request.getContextPath() %>/Intro/NoticeWrite" method="POST" enctype="multipart/form-data">
			<table id='tbl-noticeWrite'>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" class="notice-title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" class="notice-writer" value="admin" readonly/></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="upfile"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" class="notice-content" cols="50" rows="15" ></textarea></td>
				</tr>
				
				<tr>
					<th colspan="2">
						<input type="button"  class="btn-cancell" onclick="location.href='<%= request.getContextPath() %>/Intro/NoticeBoard'"  value="작성취소">
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
