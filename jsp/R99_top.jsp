<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.db_connect"%>
<%@ page language="java"
  contentType="text/html;
  charset=UTF-8"
  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title>DAOサンプル</title>

	</head>


	<body>
			<%
			   String strPath	=	request.getContextPath();
			   //↑Context内のパスを返す

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

					   out.println("<table>");
					   out.println("<tr>");
					   for(int j=0;j<col_data.size();j++){
						   out.println("<td>");
						   out.println(col_data.get(j));
						   out.println("</td>");
					   }
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

	</body>
</html>