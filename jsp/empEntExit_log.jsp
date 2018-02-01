<%@page import="java.util.ArrayList"%>
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

<link rel="stylesheet" type="text/css" href="<%= strPath %>/css/top.css" media="all" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js">
</script>

<script src="<%= strPath %>/js/tr_background_color.js"></script>


</head>


<body>
	<h1><a href="<%= strPath %>/jsp/empEntExit_log.jsp">入退室ログ一覧画面</a>　　　ログインユーザー：<%= sName %></h1>


		<form class="formSearch" action="<%= strPath %>/servlet/sk31.EnterExitLog_Search">

			<a class="firstId">社員名</a><input type="text" name="txtName" />



			<input type="submit" class="square_btn" name="subSend" value="検索">


			<a href="<%= strPath %>/jsp/empEntExit_log.jsp" class="square_btn">ログ一覧画面へ</a>

			<a href="<%= strPath %>/jsp/top.jsp" class="square_btn">トップ画面へ</a>


		</form>







		<%
			ArrayList list = (ArrayList) request.getAttribute("list");
			ArrayList row = new ArrayList();
		%>


		<%
		    String strDisp =
		      (String)request.getAttribute("result");

			if(!(strDisp == null)){
			%>
			<%= strDisp %><br />


			<%} %>

<table class="table-design-set-1">
  <thead>
    <tr>
				<td>ログID</td>
				<td>社員ID</td>
				<td>社員名</td>
				<td>日時</td>

    </tr>
  </thead>
  <tbody id="tbl1">
			<%
			try{
				for(int i = 0;i<list.size();i++){
					row=(ArrayList)list.get(i);

					%><tr><%

					for(int j = 0; j<row.size();j++){

							%><td><%= (String)row.get(j) %></td><%


					}
					%>

					<%
				}
			}catch(Exception e){e.printStackTrace();}
			%>
  </tbody>
</table>



	</body>

</html>