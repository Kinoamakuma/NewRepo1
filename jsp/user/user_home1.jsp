<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
		//パスの取得
		String strPath = request.getContextPath();


%>

<link rel="stylesheet" type="text/css" href="<%= strPath %>/css/home.css" media="all" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js">
</script>

<script src="<%= strPath %>/js/tr_background_color.js"></script>






</head>
	<body>
		<h1>ユーザログイン画面</h1>







<div class="flexbox">

	<div class="parent">
	  <img src="<%= strPath %>/img/pass.jpg" width="103px" height="102px" alt="画像">
	  <div class="inner">
	    <a href="<%= strPath %>/jsp/user/user_home.jsp" class="square_btn1">ID・PW・IC認証</a>
	  </div>
	</div>


	<div class="parent">
	  <img src="<%= strPath %>/img/ictag.png" width="128px" height="128px" alt="画像">
	  <div class="inner">
	    <a href="<%= strPath %>/jsp/user/user_IC.jsp" class="square_btn1">IC認証</a>
	  </div>
	</div>



</div>



	</body>
</html>