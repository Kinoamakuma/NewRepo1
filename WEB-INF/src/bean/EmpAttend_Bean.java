package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class EmpAttend_Bean implements Serializable{
	private String str_Id;
	private Integer int_Flg;


	public EmpAttend_Bean(){
		str_Id = "";
		int_Flg = null;
	}


	// アクセサメソッド
	public void set_Id(String str_Id){
		this.str_Id = str_Id;
	}

	public void set_Flg(Integer int_Flg){
		this.int_Flg = int_Flg;
	}


	// getter
	public String getstr_Id(){
		return this.str_Id;
	}

	public Integer getint_Flg(){
		return this.int_Flg;
	}

	public String EmpAttend(){
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


		if(int_Flg == 1){
			int_Flg = 0;
		}else if(int_Flg == 0){
			int_Flg = 1;
		}


		try{
			// 1ドライバの読み込み

				Class.forName(strDriver);

			// 2 DBに接続

				con = DriverManager.getConnection(strURL, strUser, strPass);



			// 3 SQLの作成
				strSQL += "update t_employee";
				strSQL += " set ";
				strSQL += "F_EMP_FLG = ? ";
				strSQL += "where F_EMP_ID = ?";

			// 4 SQLの実行
				pstmt = con.prepareStatement(strSQL);
				pstmt.setInt(1, int_Flg);
				pstmt.setString(2, str_Id);



			// 5 実行結果
				pstmt.executeUpdate();

				strMsg += "データ更新が完了しました。<br />";



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
