package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* dataobjectインタフェースを継承した
     mysql_connectクラス */
/* インタフェースを継承する時は、
     implementsを使用する。 */

public class db_connect implements dataobjects {

	/* 継承したインタフェースを
	     使う時は必ずオーバーライドが
	     必要となる。  */

	private Connection con  = null;
	private Statement  stmt = null;
	private ResultSet   rs    = null;

	private String url = null;
	private String driver = null;

	private ArrayList<HashMap<String, String>> ary_data;
	private HashMap<Integer, String> col_name;
	private ResultSetMetaData rsmd = null;

	/* コンストラクタ */
	public db_connect(String kbn,String host) {
		// TODO 自動生成されたコンストラクター・スタブ
		if(kbn.equals("mysql")){
			this.url = URL_MYSQL_TOP;
			if(host.equals("local")){
				this.url = URL_MYSQL_TOP
			            +HOST_LOCAL+"/"
			            +DB_LOCAL
			            +URL_MYSQL_LAST;
			}else{
				this.url = URL_MYSQL_TOP
			            +HOST_SCHOOL+"/"
			            +DB_SCHOOL
			            +URL_MYSQL_LAST;
			}
			this.driver = DRIVER_MYSQL;
		}else{
			this.url = URL_ORACLE_TOP;
			if(host.equals("local")){
				this.url += HOST_LOCAL
			            +URL_ORACLE_LAST+URL_ORALE_SID_LOCAL;
			}else{
				this.url += HOST_SCHOOL
			            +URL_ORACLE_LAST+URL_ORALE_SID_SCHOOL;
			}
			this.driver = DRIVER_ORACLE;
		}
	}


	public boolean Connect() {
		try{
           Class.forName(this.driver);
           this.con = DriverManager.getConnection
        		    (this.url,
        		     USER_LOCAL,
        		     PASS_LOCAL);
           this.stmt = this.con.createStatement();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}


	public boolean Execute(String kbn,String sql) {
		try{
			if(kbn.equals("select")){
				this.rs = stmt.executeQuery(sql);
				this.rsmd = rs.getMetaData();

				col_name = new HashMap<Integer,String>();
				ary_data = new ArrayList<HashMap<String, String>>();

				for(int i=0;i<rsmd.getColumnCount();i++){
					col_name.put(Integer.valueOf(i), rsmd.getColumnName(i+1));
				}

				while(rs.next()){
					HashMap<String, String> rec
					 = new HashMap<String,String >();

					for(int j = 0;j<rsmd.getColumnCount();j++){
						rec.put(col_name.get(j), rs.getString(col_name.get(j)));
					}
					ary_data.add(rec);
				}

			}else{
				this.stmt.executeUpdate(sql);
			}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public ArrayList<HashMap<String, String>> get_db(){
		return ary_data;
	}
	public HashMap<Integer, String> get_db_col(){
		return col_name;
	}


	public boolean Close() {
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(con != null){
				con.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
}
