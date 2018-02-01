<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<h1>File list</h1>
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
		<td><a href="R00_file_list.jsp?path=<%= strUpPath %>">↑</a></td>
		<td></td>
	</tr>
	<%
		for(i = 0; i < aryFls.length; i++) {
			if(aryFls[i].isFile()) {
	%>
	<tr>
		<td>ファイル</td>
		<td><a href="<%= aryFls[i].getName() %>" target="_blank"><%= aryFls[i].getName() %></a></td>
		<td><%= (new Date(aryFls[i].lastModified()).toString()) %></td>
	</tr>
	<%
		} else if(aryFls[i].isDirectory()) {
	%>
	<tr>
		<td>ディレクトリ</td>
		<td><a href="R00_file_list.jsp?path=<%= strPath + "/" + aryFls[i].getName() %>"><%= aryFls[i].getName() %></a></td>
		<td><%= (new Date(aryFls[i].lastModified()).toString()) %></td>
	</tr>
	<%
			}
		}
	%>
	</table>
</div>
</body>
</html>