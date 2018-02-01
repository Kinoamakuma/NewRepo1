package dao;

/* データベースアクセス用の */
/* インタフェース */

/* インタフェースで記述出来るもの */
/* 定数と完全抽象化メソッドのみ */

public interface dataobjects {
	/* 定数 */
    String HOST_LOCAL  = "localhost";
    String HOST_SCHOOL = "192.168.121.16";

    String USER_LOCAL    = "sk31";
    String PASS_LOCAL    = "sk31";

    String USER_SCHOOL  = "";
    String PASS_SCHOOL  = "";

    String DB_LOCAL    = "jv34db";
    String DB_SCHOOL  = "";

    String DRIVER_MYSQL   = "org.gjt.mm.mysql.Driver";
    String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";

    String URL_MYSQL_TOP   = "jdbc:mysql://";
    String URL_MYSQL_LAST  = "?useUnicode=true&characterEncoding=UTF-8";
    String URL_ORACLE_TOP  = "jdbc:oracle:thin:@";
    String URL_ORACLE_LAST  = ":1521";

    String URL_ORALE_SID_SCHOOL = ":ORCL";
    String URL_ORALE_SID_LOCAL = ":XE";

    /* 処理の記述が無いメソッド */
    /* 引数と戻り値は書ける */
    boolean Connect();
    boolean Execute(String kbn,String sql);
    boolean Close();
}
