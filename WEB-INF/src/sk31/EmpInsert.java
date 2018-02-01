package sk31;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmpInsert_Bean;

public class EmpInsert extends HttpServlet{

	//POSTによる受信(doPost)
	protected void doPost
	   (HttpServletRequest req,
		HttpServletResponse res)
	    throws IOException,ServletException{

		//関数の呼び出し
		func(req,res);
	}
	//GETによる受信(doGet)
	protected void doGet
	   (HttpServletRequest req,
		HttpServletResponse res)
	    throws IOException,ServletException{

		//関数の呼び出し
		func(req,res);
	}
	//呼び出し関数の定義
	protected void func
	   (HttpServletRequest req,
		HttpServletResponse res)
	    throws IOException,ServletException{

		//文字コードの設定（文字化け対応）
		req.setCharacterEncoding("UTF-8");

		String strmsg = "";


		//(txtName,txtpassを）input から受け取る
		String str_id = req.getParameter("txtID");
		String str_name = req.getParameter("txtName");
		String str_postcode = req.getParameter("txtPostcode");
		String str_address1 = req.getParameter("txtAddress1");
		String str_address2 = req.getParameter("txtAddress2");
		String str_phone = req.getParameter("txtPhone");
		String str_age = req.getParameter("txtAge");

		// ②Insert用のBeanで処理を行う
		EmpInsert_Bean Empinsert = new EmpInsert_Bean();
		Empinsert.setEmp_id(str_id);
		Empinsert.setEmp_name(str_name);
		Empinsert.setEmp_postcode(str_postcode);
		Empinsert.setEmp_address1(str_address1);
		Empinsert.setEmp_address2(str_address2);
		Empinsert.setEmp_phone(str_phone);
		Empinsert.setEmp_age(str_age);
		strmsg = Empinsert.EmpInsert();

		// outputへ送る
		req.setAttribute("result", strmsg);

		// サーブレットからjsp に転送
		// オブジェクトscを作り、そこに値を代入する

		ServletContext sc = null;
		sc = getServletContext();
		// 値を転送する
		sc.getRequestDispatcher("/jsp/emp_insert.jsp").forward(req, res);



	}








}
