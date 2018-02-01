<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
		//パスの取得
		String strPath = request.getContextPath();



	   // セッションが存在している
	   String sName = (String)session.getAttribute("Username");






%>

<link rel="stylesheet" type="text/css" href="<%= strPath %>/css/home.css" media="all" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js">
</script>
</head>
	<body>
		<h1>インデックス</h1>


		<h2>ようこそ<%= sName %>さん</h2>

		<a href="<%= strPath %>/jsp/user/user_top.jsp">社員専用画面へ</a>

	</body>
</html>