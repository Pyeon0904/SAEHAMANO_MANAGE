<!--210426 16:38 편준장-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>새하마노</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<style>
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {
    font-family: 'GmarketSansLight';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansLight.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

#bg{
	padding:0px;
	background-image:url(<%=request.getContextPath()%>/resources/images/mainbg.png);
	overflow-x:hidden;
	z-index:0;	
}


	.logo {
		margin: 0px;
		position: absolute;
		top: 30px;
		left:42%;
		width: 300px;
		display: inline-block;
		z-index:1;
	}
</style>
</head>

<body id="bg">
	<header>
		<!-- 로고 -->
		<img class="logo" src="<%=request.getContextPath() %>/resources/images/logocircle.png" />
	</header>
