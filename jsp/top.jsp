<%@page import="java.util.ArrayList"%>
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
		String sName = (String)session.getAttribute("name");

%>

<link rel="stylesheet" type="text/css" href="<%= strPath %>/css/top.css" media="all" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js">
</script>

<script src="<%= strPath %>/js/tr_background_color.js"></script>

<script type="text/javascript">
	function open1() {
	    window.open("<%= strPath %>/jsp/emp_attend.jsp", "hoge", 'width=500, height=400');
	}


</script>

</head>


<body>
	<h1><a href="<%= strPath %>/jsp/top.jsp">社員検索</a>　　　ログインユーザー：<%= sName %></h1>


		<form class="formSearch" action="<%= strPath %>/servlet/sk31.EmpSearch">

			<a class="firstId">ID</a><input type="text" name="txtId" />



			<input type="submit" class="square_btn" name="subSend" value="検索">	<a href="<%= strPath %>/jsp/emp_insert.jsp" class="square_btn">登録画面へ</a>


			<a href="<%= strPath %>/jsp/emp_log.jsp" class="square_btn">出退勤ログ一覧画面へ</a>


			<a href="<%= strPath %>/jsp/empEntExit_log.jsp" class="square_btn">入退室ログ一覧画面へ</a>

		</form>


		<form method="post" class="square_btn" action="<%= strPath %>/jsp/emp_attend.jsp" onsubmit="return false;">

  			<input type="submit" class="square_btn" name="id" value="入力画面へ" onclick="open1()"/>

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
				<td>社員ID</td>
				<td>社員PW</td>
				<td>社員名</td>
				<td>社員郵便番号</td>
				<td>社員住所1</td>
				<td>社員住所2</td>
				<td>社員電話番号</td>
				<td>社員年齢</td>
				<td>社員変更・削除</td>
    </tr>
  </thead>
  <tbody id="tbl1">
			<%
			try{
				for(int i = 0;i<list.size();i++){
					row=(ArrayList)list.get(i);

					%><tr><%

					for(int j = 0; j<row.size() - 2;j++){

							%><td><%= (String)row.get(j) %></td><%

					}
					%>
						<td>
							<a href="<%= strPath %>/servlet/k03pack.K03_select?strNo=<%= (String)row.get(0) %>">[編集]</a>
							<a href="<%= strPath %>/servlet/k03pack.K03_select2?strNo=<%= (String)row.get(0) %>">[削除]</a>
						</td>
					</tr>
					<%
				}
			}catch(Exception e){e.printStackTrace();}
			%>
  </tbody>
</table>



	</body>

</html>