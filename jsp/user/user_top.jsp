<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
		//パスの取得
		String strPath1 = request.getContextPath();


		// セッションが存在している
		String sName = (String)session.getAttribute("Username");

%>

<link rel="stylesheet" type="text/css" href="<%= strPath1 %>/css/top.css" media="all" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js">
</script>

<script src="<%= strPath1 %>/js/tr_background_color.js"></script>


</head>


<body>
	<h1><a href="<%= strPath1 %>/jsp/user/user_top.jsp"></a>　　　ログインユーザー：<%= sName %></h1>


	<table border="1">
	<tr>
		<th>種類</th><th>名称</th><th>最終更新日</th>
	</tr>
	<%
		String strPath = request.getParameter("path");
		if(strPath == null) {
			strPath = "/jsp";
		}

		File objFld = new File(application.getRealPath("." + strPath));
		File[] aryFls = objFld.listFiles();

		String[] strSplitPath = strPath.split("/", 0);
		String strUpPath = "";
		int i;

		for(i = 0; strSplitPath.length > i + 1; i++) {
			strUpPath += strSplitPath[i] + "/";
		}
	%>
	<tr>
		<td></td>

		<%
					if(sName.equals("片岡利幸")){
						%><td><a href="user_top.jsp?path=<%= strUpPath %>">↑</a></td><%
					}else{
						%><td><a>↑</a></td><%
					}





		%>
		<td></td>
	</tr>
	<%
		for(i = 0; i < aryFls.length; i++) {
			if(aryFls[i].isFile()) {

				%>
				<tr>
					<td>ファイル</td>
					<td><a href="<%= strPath1 %><%= strPath %>/<%= aryFls[i].getName() %>" target="_blank"><%= aryFls[i].getName() %></a></td>
					<td><%= (new Date(aryFls[i].lastModified()).toString()) %></td>
				</tr>
				<%


			} else if(aryFls[i].isDirectory()) {

	%>

				<tr>
					<td>ディレクトリ</td>
					<td><a href="user_top.jsp?path=<%= strPath + "/" + aryFls[i].getName() %>"><%= aryFls[i].getName() %></a></td>
					<td><%= (new Date(aryFls[i].lastModified()).toString()) %></td>
				</tr>
				<%

			}
		}
	%>
	</table>







</body>

</html>