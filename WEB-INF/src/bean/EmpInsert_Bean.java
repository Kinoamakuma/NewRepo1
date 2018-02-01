package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpInsert_Bean implements Serializable{
	private String Emp_id;
	private String Emp_name;
	private String Emp_postcode;
	private String Emp_address1;
	private String Emp_address2;
	private String Emp_phone;
	private String Emp_age;



	public EmpInsert_Bean(){
		Emp_id = "";
	    Emp_name = "";
		Emp_postcode = "";
		Emp_address1 = "";
		Emp_address2 = "";
		Emp_phone = "";
		Emp_age = "";

	}


	// アクセサメソッド
	public void setEmp_id(String Emp_id){
		this.Emp_id = Emp_id;
	}


	public void setEmp_name(String Emp_name){
		this.Emp_name = Emp_name;
	}

	public void setEmp_postcode(String Emp_postcode){
		this.Emp_postcode = Emp_postcode;
	}

	public void setEmp_address1(String Emp_address1){
		this.Emp_address1 = Emp_address1;
	}

	public void setEmp_address2(String Emp_address2){
		this.Emp_address2 = Emp_address2;
	}


	public void setEmp_phone(String Emp_phone){
		this.Emp_phone = Emp_phone;
	}


	public void setEmp_age(String Emp_age){
		this.Emp_age = Emp_age;
	}


	// getter
	public String getEmp_id(){
		return this.Emp_id;
	}


	public String getEmp_name(){
		return this.Emp_name;
	}

	public String getEmp_postcode(){
		return this.Emp_postcode;
	}

	public String getEmp_address1(){
		return this.Emp_address1;
	}

	public String getEmp_address2(){
		return this.Emp_address2;
	}

	public String getEmp_phone(){
		return this.Emp_phone;
	}

	public String getEmp_age(){
		return this.Emp_age;
	}



	public String EmpInsert(){
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
				strSQL += "insert into t_employee(f_emp_id,f_emp_name,f_emp_postcode,f_emp_address1,f_emp_address2,f_emp_tel,f_emp_age)";
				strSQL += " values ";
				strSQL += "(?,?,?,?,?,?,?)";


			// 4 SQLの実行
				pstmt = con.prepareStatement(strSQL);
				pstmt.setString(1, Emp_id);
				pstmt.setString(2, Emp_name);
				pstmt.setString(3, Emp_postcode);
				pstmt.setString(4, Emp_address1);
				pstmt.setString(5, Emp_address2);
				pstmt.setString(6, Emp_phone);
				pstmt.setString(7, Emp_age);



			// 5 実行結果
				pstmt.executeUpdate();

				strMsg += "データ登録が完了しました。<br />";



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
