<%@page import="java.util.HashMap"%>
<%@page import="dao.db_connect"%>
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

		%>



	<link rel="stylesheet" type="text/css" href="<%= strPath %>/css/top.css" media="all" />

	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js"></script>

	<script src="<%= strPath %>/js/tr_background_color.js"></script>





<%

		/* oracleのdaoを実装 */
		db_connect dao = new db_connect("oracle","local");


		   if(!dao.Connect()){
			   out.println("接続に失敗した");
		   }else{
			   String strSQL = "select * from T_EMPLOYEE order by f_emp_id ASC";
			   if(!dao.Execute("select", strSQL)){
				   out.println("データ抽出に失敗した");
			   }else{
				   /* 抽出成功時 */
				   ArrayList<HashMap<String,String>>
				     all_data = new ArrayList<HashMap<String,String>>() ;

				   HashMap<Integer,String>
				     col_data = new HashMap<Integer,String>();

				   all_data = dao.get_db();
				   col_data = dao.get_db_col();


%>

</head>


<body>
	<h1>社員検索</h1>


		<form class="formSearch" action="<%= strPath %>/servlet/sk31.EmpSearch">

			<a class="firstId">ID</a><input type="text" name="txtId" />



			<input type="submit" class="square_btn" name="subSend" value="検索">	<a href="<%= strPath %>/jsp/emp_insert.jsp" class="square_btn">登録画面へ</a>

		</form>


					<table class="table-design-set-1">
					  <thead>
					    <tr>
									<td>社員ID</td>
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

				   out.println("<tr>");
				   for(int i=0;i<all_data.size();i++){
					   out.println("<tr>");
					   for(int j=0;j<all_data.get(i).size();j++){
						   out.println("<td>");
						   out.println(all_data.get(i).get(col_data.get(j)));
						   out.println("</td>");
					   }
					   out.println("</tr>");
				   }
				   out.println("</table>");
			   }
		   }
		   dao.Close();







%>

						</table>



	</body>

</html>