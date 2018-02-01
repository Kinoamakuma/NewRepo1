package sk31;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminLogin_Bean;
import bean.EmpSearch_Bean;
import bean.UserLogInsert_Bean;
import bean.UserLogin_Bean;

public class UserLogin extends HttpServlet {

	//POSTによる受信(doPost)
	@Override
	protected void doPost
	   (HttpServletRequest req,
		HttpServletResponse res)
	    throws IOException,ServletException{

		//関数の呼び出し
		func(req,res);
	}
	//GETによる受信(doGet)
	@Override
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


		//(txtName,txtpassを）input から受け取る
		String id = req.getParameter("txtId");
		String pw = req.getParameter("txtPass");
		String card = req.getParameter("txtIC");

		String Msg;

			// 受け取った値を、Beanにてデータベースに接続、データ取得を行う
			UserLogin_Bean Search = new UserLogin_Bean();
			Search.setstrfields("*");
			Search.setstrtablename("t_employee");
			Search.setstrjyouken("f_emp_id = " + id + " and f_emp_pass = " + pw + " and f_emp_card = " + card);

			Search.EmpSearch();

			//System.out.println(Search.EmpSearch());

			// 受け取った値を、Beanにてデータベースに接続、ログ挿入を行う
			UserLogInsert_Bean Insert = new UserLogInsert_Bean();
			Insert.setEmp_id(id);

			Insert.LogInsert();



			// セッションに値を設定
			HttpSession hs = req.getSession();

			// 値の設定
			hs.setAttribute("Username", Search.EmpSearch());



			// outputへ送る
			req.setAttribute("UserName", Search.EmpSearch());

		// サーブレットからjspに転送（オブジェクトscを作り、そこに値を代入する）
		ServletContext sc = null;
		sc = getServletContext();
		//
		sc.getRequestDispatcher("/jsp/user/user_index.jsp").forward(req, res);

	}

}
