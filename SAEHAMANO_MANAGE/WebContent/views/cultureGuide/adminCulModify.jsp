<!--210430 19:40 이재용 -->
<!-- 수정 삭제 페이지 -->

<%@page import="mvc.adminCulture.model.vo.Culture"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/headerDetail.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/css/select2.min.css" rel="stylesheet"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/js/select2.min.js"></script>

<%
	Culture culture = (Culture) request.getAttribute("culture");
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
			<span class="cul-title"> 문화재 수정</span>
		<form action="<%= request.getContextPath() %>/culture/modify" method="POST" 
				enctype="multipart/form-data">
	<table id="cul-modify">
				<tr>
					<th>문화재 번호</th>
					<td><input type="text" name="cul_no"  value="<%=culture.getCul_no() %>"></td>
				</tr>
				<tr>
					<th>문화재 이름</th>
					<td><input type="text" name="name" value="<%=culture.getCul_name() %>"></td>
				</tr>
				<tr>
					<th>지역</th>
					<td><select id="region" name="region" required>
                        <option value="<%=culture.getCul_region()%> "><%=culture.getCul_region()%></option>
                     </select>
   
                     
                          <script>
                             $(document).ready(function(){
                                 var region = ['서울특별시','경기도','강원도','충청북도','충청남도', '전라북도','전라남도',
                                    '경상북도','경상남도','제주도','부산광역시','대구광역시','인천광역시','광주광역시','대전광역시','울산광역시'];
                                 $("#region").select2({
                                      data:region
                                 });
                              });
                          
                          </script></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text"  name="location" value="<%=culture.getCul_location() %>"></td>
				</tr>
				<tr>
					<th>크기</th>
					<td><input type="text" name="invalid" value="<%=culture.getCul_invalid() %>"/></td>
				</tr>
				<tr>
					<th>지정일</th>
					<td><input type="text" name="deg_date" value="<%=culture.getDeg_date() %>"/></td>
				</tr>
				<tr>
					<th>시대</th>
					<td><input type="text"  name="era" value="<%=culture.getCul_era() %>"/></td>
				</tr>
				<tr>
					<th>분류</th>
					<td> <select id="category" name="category" required>
                         <option value="<%=culture.getCul_category() %>" selected><%=culture.getCul_category() %></option>
                     </select>
                     
                          <script>
                             $(document).ready(function(){
                                 var category = ['유적건조물','유물','기록유산','무형문화재','자연유산','등록문화재','무형유산'];
                                 $("#category").select2({
                                      data:category
                                 });
                              });
                             
                          </script></td>
				</tr>
				<tr>
					<th>정의</th>
					<td><input type="text"  name="field" value="<%=culture.getCul_field() %>"/></td>
				</tr>
				<tr>
				<% if(culture.getImg1() != null){ %>
					<th>이미지링크 1</th>
					<td><input type="text"  name="img1" value="<%=culture.getImg1() %>"/></td>
					<%} else{ %>
					<th>이미지링크 1 </th>
					<td><input type="text"  name="img1" value="https://drive.google.com/uc?id="  /></td>
					<% } %>
				</tr>
				<tr>
					<% if(culture.getImg2() != null){ %>
					<th>이미지링크 2</th>
					<td><input type="text"  name="img2" value="<%=culture.getImg2() %>"/></td>
					<%} else{ %>
					<th>이미지링크 2 </th>
					<td><input type="text"  name="img2" value="https://drive.google.com/uc?id="  /></td>
					<% } %>
				</tr>
				<tr>
					<% if(culture.getImg3() != null){ %>
					<th>이미지링크 3</th>
					<td><input type="text"  name="img3" value="<%=culture.getImg3() %>"/></td>
					<%} else{ %>
					<th>이미지링크 3 </th>
					<td><input type="text"  name="img3" value="https://drive.google.com/uc?id="  /></td>
					<% } %>
				</tr>
				<tr>
					<th>설명</th>
					<td>
					<textarea name="description" class="cul-content" cols="50" rows="15" ><%=culture.getCul_description() %></textarea></td>
				</tr>
				
				
				<!-- 
				<tr>
					<th> 첨부파일 </th>
					<td><input type="file" name="reloadFile">
					<%= culture.getOriginal_filename() %>
					</td>
				</tr>
				 -->
				<tr>
					<th colspan="2">
						<input type="submit" class="cul-mod" value="수정">
						<input type="button"  class="cul-btn"  value="삭제">
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
		$(".cul-btn").on("click",(e) =>{
			if(confirm("정말로 게시글을 삭제하시겠습니까 ?")){
				location.replace("<%=request.getContextPath()%>/culture/delete?cul_no=<%= culture.getCul_no() %>")	
			}
		});
		
		
		
	});
</script>
<%@ include file="/views/common/footer.jsp" %>