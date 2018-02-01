package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserLogInsert_Bean implements Serializable{
	private String Log_id;
	private String Emp_id;
	private String Log_date;




	public UserLogInsert_Bean(){
		Log_id = "";
	    Emp_id = "";
		Log_date = "sysdate";

	}


	// アクセサメソッド
	public void setLog_id(String Log_id){
		this.Log_id = Log_id;
	}


	public void setEmp_id(String Emp_id){
		this.Emp_id = Emp_id;
	}

	public void setEmp_postcode(String Log_date){
		this.Log_date = Log_date;
	}


	// getter
	public String getLog_id(){
		return this.Log_id;
	}


	public String getEmp_id(){
		return this.Emp_id;
	}

	public String getLog_date(){
		return this.Log_date;
	}




	public String LogInsert(){
		// 接続先の設定
		// ユーザ、パスワード、URL、ドライバ、SID（Oracleのみ）、接続するDB名、ホスト
		final String strUser = "sk31";
		final String strPass = "sk31";
		final String strSID = "XE";
		final String strHost = "localhost";
		final String strDriver = "oracle.jdbc.driver.OracleDriver";
		final String strURL = "jdbc:oracle:thin:@" + strHost + ":1521:" + strSID;



		Connection con = null;
		PreparedStatement pstmt = null;
		String strMsg = "";
		String strSQL = "";


		try{
			// 1ドライバの読み込み

				Class.forName(strDriver);

			// 2 DBに接続

				con = DriverManager.getConnection(strURL, strUser, strPass);




			// 3 SQLの作成
//insert into t_log　(f_log_id,f_emp_id,f_log_date) select max(f_log_id) + 1, 2 , sysdate from t_log;
				strSQL += "insert into t_log (f_log_id , f_emp_id , f_log_date )";
				strSQL += " select max(f_log_id) + 1, ? , sysdate from t_log";



			// 4 SQLの実行
				pstmt = con.prepareStatement(strSQL);
				pstmt.setString(1, Emp_id);


			// 5 実行結果
				pstmt.executeUpdate();

				System.out.println("ログ入力が完了しました。");
				//strMsg += "データ登録が完了しました。<br />";



		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			strMsg += "ドライバがセットされていません。";
		}catch (SQLException e) {
			// TODO: handle exception
			strMsg += "SQL文の異常："+e.getMessage()+":"+strSQL;
		}finally{
			// try - catch で最後にかならず処理させる部分
			try{
				// stmt を閉じる
				if(pstmt != null){
					pstmt.close();
				}
			// con を閉じる
				if(con != null){
					con.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return strMsg;
	}
}
