<!-- 210427(수) 01:07 편준장(최종수정자) -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerLogin.jsp"%>
<title> 관리자 로그인 페이지 </title>
	<style>
			/*제일 바탕 영역 설정*/
			#box{ 
			   background-color:#2a1b0a;
			   width:100%;
			   height:700px; /*높이는 각 세부페이지 컨텐츠 보고 알아서 적~당히 설정하기*/
			   margin-top:330px;
			   margin-bottom:100px;
			   margin-left:-10px;
			   padding:10px;
			}
		
			/*컨텐츠 영역*/
		   	#conbox{
		       width:500px; /* 넓이도 각 세부 페이지 컨텐츠에 맞춰서 설정*/
		       position:relative; 
		       top:20px;
		       margin:auto;
		  	}
			
		/* ---------------(페이지제목)----------------- */
			#pageName{
				color : white;
				font-family:GmarketSansMedium;
				text-align:center;
				font-size: 25pt;
				
			}
			
			#pageExplain {
				color: white;
				font-family:GmarketSansLight;
				text-align:center;
				font-size: 15pt;
			}
		/* ---------------------------------------- */
		
		/* ------중앙 컨테이너 영역 배치-------- */
			.login-container {
				width: 350px; 
				height: 250px;
				margin-left: 75px;
				margin-top: 40px;
    			position:absolute; 
    			background-color : #948c84;
			}
		
		/* -------테이블 내 글씨--------- */	
			#tableExplain {
				color: #2a1b0a;
				font-family:GmarketSansLight;
				text-align:center;
				font-size: 13pt;
				font-weight: bold;
			}
			
		/* -------Id, Pwd textbox 크기 -------*/
			#adminId, #adminPwd {
				width: 300px;
				height: 30px;
			}
			
		/* ------로그인 버튼------- */
			.adminLogin{
				width: 150px;
				height: 35px;
				margin-top: 20px;
				margin-left: 100px;
				font-family:GmarketSansLight;
				font-weight: bold;
			}
			
		/* -------회원가입 버튼--------*/
			.adminEnroll {
				width: 80px;
				height: 30px;
				margin-left: 245px;
				font-family:GmarketSansLight;
				font-weight: bold;
				background-color: #948c84;
			}	
			
		/*-------버튼에 마우스 올렸을 때 동작------------*/
			input:hover {
				background-color: wheat;
				border: 3px solid white;
			}
	</style>

<div id="box">
	<section id="section">
    	<div id="conbox">
      	<!------------ 상단 text ------------>
			<h2 id="pageName">대한민국 새하마노 관리자 페이지</h2>
		    <p id="pageExplain">로그인 후 이용하시길 바랍니다.</p>	
		<!----------------------------------->
		      	
      			<div class="login-container">
      				<form id="loginFrm" action="<%= request.getContextPath() %>/login" method="POST">
						<table class="tableManage">
							<tr>
								<td id="tableExplain">
									관리자 아이디를 적어주세요.
									<input type="text" name="adminId" id="adminId" value="" placeholder="아이디" required />
								</td>
								<td></td>
							</tr>
							<tr>
								<td id="tableExplain">
									관리자 비밀번호를 적어주세요.
									<input type="password" name="password" id="adminPwd" placeholder="비밀번호" required />										
								</td>
								<td></td>					
							</tr>
							<tr>
								<td>
									<input type="button" name="adminEnroll" class="adminEnroll" value="회원가입" onclick="location.href='<%= request.getContextPath()%>/adminEnroll.jsp'" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<!-- 아이디 저장은 보안상 제거함 -->
									<!-- 회원가입 버튼은 불필요하다 결론 -->
									<input type="submit" class="adminLogin" value="로그인" onclick="<%= request.getContextPath()%>/main.jsp"/>
								</td>
							</tr>
						</table>
					</form>
				</div>
				
				
				
				
				
		</div> 
	</section>
</div>


<%@ include file="/views/common/footer.jsp"%>