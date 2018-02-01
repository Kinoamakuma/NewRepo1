package sk31;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AttendSearch_Bean;
import bean.EmpAttend_Bean;
import bean.EmpInsert_Bean;
import bean.EmpSearch_Bean;
import bean.UserEELogInsert_Bean;
import bean.UserLogInsert_Bean;

public class EmpAttend extends HttpServlet{

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
		Integer int_flg = null;

		//System.out.println(str_id);

		//
		AttendSearch_Bean Search = new AttendSearch_Bean();
		Search.setstrfields("f_emp_flg");
		Search.setstrtablename("t_employee");
		Search.setstrjyouken("f_emp_id like '" + str_id + "'");
		Search.EmpSearch();
		int_flg = Search.getflg();
		//System.out.println(Search.EmpSearch());
		//System.out.println(int_flg);


		// ③Insert用のBeanで処理を行う
		EmpAttend_Bean EmpAttend = new EmpAttend_Bean();
		EmpAttend.set_Flg(int_flg);
		EmpAttend.set_Id(str_id);
		strmsg = EmpAttend.EmpAttend();



		// ④入退室ログ用のBeanで処理
		UserEELogInsert_Bean Insert = new UserEELogInsert_Bean();
		Insert.setEmp_id(str_id);

		Insert.LogInsert();





		// outputへ送る
		req.setAttribute("result", strmsg);

		// サーブレットからjsp に転送
		// オブジェクトscを作り、そこに値を代入する

		ServletContext sc = null;
		sc = getServletContext();
		// 値を転送する
		sc.getRequestDispatcher("/jsp/emp_attend.jsp").forward(req, res);



	}








}
