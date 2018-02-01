<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
		//パスの取得
		String strPath = request.getContextPath();



	   // セッションが存在している
	   String sName = (String)session.getAttribute("name");






%>

<link rel="stylesheet" type="text/css" href="<%= strPath %>/css/home.css" media="all" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js">
</script>
</head>
	<body>
		<h1>インデックス</h1>


		<h2>ようこそ<%= sName %>さん</h2>

		<a href="<%= strPath %>/jsp/top.jsp">社員検索画面へ</a>

	</body>
</html>