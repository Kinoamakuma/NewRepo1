package sk31;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmpSearch_Bean;

public class EmpSearch extends HttpServlet {

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
		String id = req.getParameter("txtId");

		String Msg;
		// 受け取った値を、Beanにてデータベースに接続、データ取得を行う
		EmpSearch_Bean Search = new EmpSearch_Bean();
		Search.setstrfields("*");
		Search.setstrtablename("t_employee");
		Search.setstrjyouken("f_emp_id like '%" + id + "%' and f_emp_flg = 0");

		Search.EmpSearch();
		list = Search.getTbl();

		//(listを)outputへ送る
		req.setAttribute("list",list);

		// サーブレットからjspに転送（オブジェクトscを作り、そこに値を代入する）
		ServletContext sc = null;
		sc = getServletContext();
		//
		sc.getRequestDispatcher("/jsp/top.jsp").forward(req, res);

	}

}
