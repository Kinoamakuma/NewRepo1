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
</head>
	<body>
		<h1>ユーザログイン画面</h1>


		<form class="formSearch" action="<%= strPath %>/servlet/sk31.UserICLogin">


			<dl class="abc">
				<dt>IC情報</dt>

					<dd><input type="text" class="base" name="txtIC" required="required" autofocus="autofocus"/></dd>

				<dt><input type="reset" value="リセット" ></dt>

					<dd><input type="submit" value="ログイン"></dd>
			</dl>




			<!-- float left 解除 -->
			<div class="clear"></div>
		</form>















	</body>
</html>