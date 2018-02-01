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


	<script type="text/javascript">
		function close1() {
			window.open('about:blank','_self').close();
		}
	</script>




</head>


<body >

	<h1>勤怠管理</h1>

		<form action="<%= strPath %>/servlet/sk31.EmpAttend">

			<table>
				<tbody>
					<tr>
						<td colspan="2">ID</td>
						<td colspan="3"><input type="text" name="txtID" required/></td>
					</tr>
				</tbody>
</table>








			<input type="submit" name="subSend" value="入力する">

		</form>

			<a href="#" onclick="close1()">戻る</a>

			<br />

			<%
				String strDisp = (String)request.getAttribute("result");

			if(!(strDisp == null)){


			%>

			<%= strDisp %> <br />



			<%} %>



	</body>

</html>