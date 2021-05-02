<!-- 210430(금) 15:36 김예원 (최종수정자) -->
<!-- 최종 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mvc.community.qna.model.vo.Qna"%>	
<%@ include file="/views/common/headerDetail.jsp"%>
<!-- 구글 Noto 바탕체 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serif:wght@400;700&display=swap"
	rel="stylesheet">
<!-- 구글 Noto 굴림체 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&family=Noto+Serif:wght@400;700&display=swap"
	rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>


<%
	/* by.예원 중요 session을 request로 꼭 바꿔주기 */
	Qna qna = (Qna)request.getAttribute("qna");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/css/select2.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/js/select2.min.js"></script>

<title>Q&A 글쓰기 페이지</title>
<style>
		/* 전체 영역--------------------------------------------------------------------------*/
				
			/*---------------제일 바깥 영역 설정-----------------*/
			#box{ 
			   background-color:#948c84;
			   width:100%;
			   height:1000px; /*높이는 각 세부페이지 컨텐츠 보고 알아서 적~당히 설정하기*/
			   margin-top:330px;
			   margin-bottom:100px;
			   margin-left:-10px;
			   padding:10px;
			}
			/*-------------------컨텐츠 영역---------------------*/
			#conbox{
				width:1600px; /* 넓이도 각 세부 페이지 컨텐츠에 맞춰서 설정*/
				position:relative; 
				top:20px;
				margin:auto;
			}
			    
		/*-----------------------------------------------------------------------------------*/
			
		/* 페이지 상단 TEXT -----------------------------------------------------------------*/
			
			/* ----- 페이지 이름(후기작성 게시판) ----- */
			.pageName { 
				text-align: center;
				font-family: GmarketSansLight;
				color: white;
			}
			/* ----- 페이지 설명(국보문화재 관람 후기를 남겨~~~)*/
			.pageExplain {
				color: wheat;
			}
			
		/*-----------------------------------------------------------------------------------*/
		
			/* 질문 작성 네모 칸에 대한 스타일 */
			#title { 
				width: 500px;
				height: 20px;
				align: center;
				outline-style: solid; 
				outline-color: wheat;
				position: relative; /*z-index 사용해서 배치 앞으로 하기 위해 작성*/
				z-index: 8;
			}
	
		/* 작성 TABLE -------------------------------------------------*/	
			/* 테이블 상단 영역 */
			.Qnatitle_area {
		   		margin-top : 80px;
				margin-left: 420px;
				height: 10px;
			}

			div#board-write-container {
				width:0px;
				margin:0 auto;
				text-align:center;
			}
			
			div#board-write-container h2 {
				margin:10px;
			}
			
			/* 테이블 틀에 대한 스타일 */
			table#tbl-board {
				width:800px;
				margin:10 auto;
				border:1px solid black;
				border-collapse:collapse; /* 단선으로 바꿈! */
				background-color: wheat;
				position: relative; /*z-index 사용해서 배치 앞으로 하기 위해 작성*/
				z-index: 6;
				font-family: GmarketSansLight;
			}
			
			/* 테이블 th에 대한 스타일 지정 */
			#tbl-board th {
				width:125px;
				border:1px solid;
				padding:5px 0;
				text-align:center;
				font-family: GmarketSansLight;
			}
			
			/* 테이블 td에 대한 스타일 지정 */
			#tbl-board td {
				border:1px solid;
				padding:5px 0 5px 10px;
				text-align:left;
				font-family: GmarketSansLight;
			}		
		/*------------------------------------------------------------*/
			
			/*마우스올렸을 때 강조 (제목/작성자/버튼)*/
			input:hover {
				background-color:honeydew;
			}	
		</style>


</head>

<body>
	<div id="box">
		<section id="section">
			<div id="conbox">

				<!-- 상단의 TEXT 구현 ---------------------------------------------------------- -->
				<div class="pageName">
					<h1>Q & A (질문과 답변)</h1>
					<hr>
					<h3 class="pageExplain">국보 문화재 관람시 궁금하신 내용을 작성해 전문가의 답변을
						받아보세요.</h3>
				</div>
				<!------------------------------------------------------------------------------- -->

				

			
					<!-- by.예원 form태그 추가/ 제목 input name 속성 추가 -->
					<form action="<%= request.getContextPath()%>/community/qna/update" method="POST">
						<input type="hidden" name="qna_no" value="<%=qna.getQna_no()%>" />
							<input type="hidden" name="rowNum" value="<%=qna.getRowNum()%>" />
							<div class="Qnatitle_area">
							<h2>
								<label style="color: wheat" >&nbsp;&nbsp;&emsp;제목&nbsp;&emsp; <input type="text" id="title" name ="title" maxlength="80" value="<%=qna.getQna_name()%>"></label>
							</h2>
								<!-- 게시글 작성 table 구현 -->
								<table id='tbl-board'>
									<tr>
										<th>작성자</th>
										<td>
											<!-- &nbsp; : 스페이스 / &ensp; : 스페이스 / &emsp; : 큰스페이스 --> 
											사용할 닉네임 &emsp;: <%= qna.getQna_nickname() %>
											<br>
											<!-- 04.22 18:00 [type="password"로 변경] by.예원  --> 
										</td>
									</tr>
									<tr>
										<th>내용</th>
										<td><textarea name="content" style="width: 650px" cols="60" rows="20" style="resize: none"><%= qna.getQna_content() %></textarea></td>
									</tr>
									<tr>
									<!-- 210429(목) by준장 - (등록버튼을 '수정'으로, 취소버튼을 '삭제'로 바꾸고 이에 맞게 구현필요!)  -->
										<th colspan="2"><input type="submit" style="font-family: GmarketSansLight; value="수정">
											<input type="reset" value="삭제" style="font-family: GmarketSansLight;"onclick="location.href='<%=request.getContextPath()%>/community/qna/delete?qnaNo=<%=qna.getQna_no()%>'"></th>
									</tr>
								</table>
								<!---------------------------------------------------------------------------------->

								<h5 style="color: #696666; font-family: GmarketSansLight;">저작권 등 다른 사람의 권리를 침해하거나 명예를 훼손하는
									게시물은 관련법률에 의해 제재를 받으실 수 있습니다.</h5>
							</div>
					</form>
				</div>
		</section>
	</div>
</body>
</html>

<%@ include file="/views/common/footer.jsp"%>