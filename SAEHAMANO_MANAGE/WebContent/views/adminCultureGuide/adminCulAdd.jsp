<!-- 최종! -->
<!--210430 19:40 이재용 -->
<!-- 등록 취소 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/headerDetail.jsp" %>
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
#box{background-color:#2a1b0a; width:100%; height: 1200px; margin-top:330px; margin-bottom:100px;
	margin-left:-10px; padding:10px;
 	overflow:auto;}
 	
 #conbox{
      width:600px; /* 넓이도 각 세부 페이지 컨텐츠에 맞춰서 설정*/
       position:relative; 
       top:20px;
       margin:0 auto;
       color:white;
      font-family: 'GmarketSansLight';
   }
/*수정 타이틀 스타일&영역 지정*/
div#cul-detail-con .cul-title{
	display:inline-block;
	font-size: 25pt;
	font-family: 'GmarketSansMedium';
	margin: 50px 0px;
	width:600px;
	height:auto;
	text-align:center;
}
/*레이아웃 영역 지정*/
table#cul-modify {width:600px; margin:0 auto; border:1px solid white; border-collapse: collapse; color:white;}
table#cul-modify td{text-align: left;  border:1px solid white; }
/*테이블에 제목 영역*/
table#cul-modify th{
text-align:center;
border:1px solid white;
margin-right:10px;
width: 120px;
height:30px;
}
/*글 쓰는 부분 영역&스타일 지정*/
table#cul-modify input[type=text] {width:464px; height:30px; background:#2a1b0a; border:none; color:white;}
table#cul-modify input[type=file] {width:464px;height:30px;background:#2a1b0a;border:none;color:white;}
table#cul-modify textarea {width: 464px;height:242px;background:#2a1b0a;border:none;color:white; resize : none; outline-style : none; overflow:auto;}
table#cul-modify .cul-btn{width:50px; height: 30px; background:white; cololr:#2a1b0a; border:none;}
table#cul-modify .cul-btn:hover{background:wheat;}
table#cul-modify input[type=text]:hover{background: #453625;}
table#cul-modify input[type=file]:hover{background: #453625;}
table#cul-modify textarea:hover{background: #453625;}
</style>

<div id="box">
<section id="culturalDetails">
<div id="conbox">
		<div id="cul-detail-con">
			<span class="cul-title"> 문화재 등록</span>
			
		<form action="<%= request.getContextPath() %>/culture/add" method="POST" 
				enctype="multipart/form-data">
	<table id="cul-modify">
				<tr>
					<th>문화재 번호</th>
					<td><input type="text" name="cul_no" ></td>
				</tr>
				<tr>
					<th>문화재 이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>지역</th>
					<td><input type="text"  name="region" />
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text"  name="location" /></td>
				</tr>
				<tr>
					<th>크기</th>
					<td><input type="text" name="invalid"/></td>
				</tr>
				<tr>
					<th>지정일</th>
					<td><input type="text" name="deg_date" /></td>
				</tr>
				<tr>
					<th>시대</th>
					<td><input type="text"  name="era" /></td>
				</tr>
				<tr>
					<th>분류</th>
					<td><input type="text" name="category"/></td>
				</tr>
				<tr>
					<th>정의</th>
					<td><input type="text"  name="field" /></td>
				</tr>
				<tr>
					<th>설명</th>
					<td><textarea name="description" class="cul-content" cols="50" rows="15" /></textarea></td>
				</tr>
				
				<tr>
					<th> 첨부파일 </th>
					<td><input type="file" name = "upfile"></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" class="cul-btn" value="등록">
						<input type="button"  class="cul-btn" onclick="" value="취소">
					</th>
				</tr>
			</table>
			</form>
		</div>
</div>
</section>
</div>
<%@ include file="/views/common/footer.jsp" %>
