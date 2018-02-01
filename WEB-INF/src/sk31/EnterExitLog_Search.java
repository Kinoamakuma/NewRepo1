package sk31;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.runtime.Log;

import bean.EmpSearch_Bean;
import bean.Log_Search_Bean;

public class EnterExitLog_Search extends HttpServlet {

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

		ArrayList list = new ArrayList();


		//文字コードの設定（文字化け対応）
		req.setCharacterEncoding("UTF-8");


		//(txtName,txtpassを）input から受け取る
		String name = req.getParameter("txtName");

		String Msg;
		// 受け取った値を、Beanにてデータベースに接続、データ取得を行う
		Log_Search_Bean LogSearch = new Log_Search_Bean();
		LogSearch.setstrfields("log.f_log_id,log.f_emp_id, emp.f_emp_name, TO_CHAR(f_log_date, 'YYYY-MM-DD HH24:MI:SS')");
		LogSearch.setstrtablename("T_ENTEXITLOG log, T_employee emp");
		LogSearch.setstrjyouken("emp.f_emp_name like '%" + name + "%' and log.f_emp_id = emp.f_emp_id(+)");

		LogSearch.EmpSearch();
		list = LogSearch.getTbl();



		//(listを)outputへ送る
		req.setAttribute("list",list);

		// サーブレットからjspに転送（オブジェクトscを作り、そこに値を代入する）
		ServletContext sc = null;
		sc = getServletContext();
		//
		sc.getRequestDispatcher("/jsp/empEntExit_log.jsp").forward(req, res);

	}

}
