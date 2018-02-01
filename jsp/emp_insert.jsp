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

</head>


<body>

	<h1>社員登録</h1>

		<form action="<%= strPath %>/servlet/sk31.EmpInsert">

			<table>
				<tbody>
					<tr>
						<td colspan="2">ID</td>
						<td colspan="3"><input type="text" name="txtID" /></td>
					</tr>
					<tr>
						<td colspan="2">名前</td>
						<td colspan="3"><input type="text" name="txtName" /></td>
					</tr>
					<tr>
						<td colspan="2">郵便番号</td>
						<td colspan="3"><input type="text" name="txtPostcode" /></td>
					</tr>
					<tr>
						<td colspan="2">住所1</td>
						<td colspan="3"><input type="text" name="txtAddress1" /></td>
					</tr>
					<tr>
						<td colspan="2">住所2</td>
						<td colspan="3"><input type="text" name="txtAddress2"></td>
					</tr>
					<tr>
						<td colspan="2">電話番号</td>
						<td colspan="3"><input type="text" name="txtPhone"></td>
					</tr>
					<tr>
						<td colspan="2">年齢</td>
						<td colspan="3"><input type="text" name="txtAge"></td>
					</tr>
				</tbody>
</table>








			<input type="submit" name="subSend" value="登録する">

		</form>

			<a href="<%= strPath %>/jsp/top.jsp">戻る</a>

			<br />

			<%
				String strDisp = (String)request.getAttribute("result");

			if(!(strDisp == null)){

			%>

			<%= strDisp %> <br />

			<%} %>



	</body>

</html>