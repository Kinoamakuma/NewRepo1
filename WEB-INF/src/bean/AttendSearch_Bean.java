package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AttendSearch_Bean implements Serializable {
	private String strfields;
	private String strtablename;
	private String strjyouken;
	private Integer flg = null;


	public AttendSearch_Bean(){
		strfields = "f_emp_flg";
		strtablename = "t_employee";
		strjyouken = "f_emp_id like '%'";
	}


	// アクセサメソッド
	public void setstrfields(String strfields){
		this.strfields = strfields;
	}

	public void setstrtablename(String strtablename){
		this.strtablename = strtablename;
	}

	public void setstrjyouken(String strjyouken){
		this.strjyouken = strjyouken;
	}


	public String getstrfields(){
		return this.strfields;
	}

	public String getstrtablename(){
		return this.strtablename;
	}

	public String getstrjyouken(){
		return this.strjyouken;
	}

	public Integer getflg() {
		return this.flg;
	}


	public String EmpSearch(){
		// 接続先の設定
		// ユーザ、パスワード、URL、ドライバ、SID（Oracleのみ）、接続するDB名、ホスト
		final String strUser = "sk31";
		final String strPass = "sk31";
		final String strSID = "XE";
		final String strHost = "localhost";
		final String strDriver = "oracle.jdbc.driver.OracleDriver";
		final String strURL = "jdbc:oracle:thin:@" + strHost + ":1521:" + strSID;



		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String strResuSlt = "";



		try{
			// 1ドライバの読み込み

				Class.forName(strDriver);

			// 2 DBに接続

				con = DriverManager.getConnection(strURL, strUser, strPass);


			// 3 SQLの作成
				stmt = con.createStatement();

				StringBuffer query = new StringBuffer();
				query.append("select ");
				query.append(strfields);
				query.append(" From ");
				query.append(strtablename);
				query.append(" Where ");
				query.append(strjyouken);
				//System.out.println(query.toString());


			// 4 SQLの実行
				rs = stmt.executeQuery(query.toString());


			// 5 実行結果

				while(rs.next()){
					flg = rs.getInt("f_emp_flg");
				}







		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			// try - catch で最後にかならず処理させる部分
			try{
				// rs を閉じる
				if(rs != null){
					rs.close();
				}
				// stmt を閉じる
				if(stmt != null){
					stmt.close();
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
		return strResuSlt;
	}
}