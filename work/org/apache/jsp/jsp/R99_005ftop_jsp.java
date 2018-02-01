package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.util.ArrayList;
import dao.db_connect;

public final class R99_005ftop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;\r\n  charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("\t\t<title>DAOサンプル</title>\r\n");
      out.write("\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t\t");

			   String strPath
			    = request.getContextPath();
			   //↑Context内のパスを返す

			   /* oracleのdaoを実装 */
			   db_connect dao = new db_connect("oracle","local");

			   if(!dao.Connect()){
				   out.println("接続に失敗した");
			   }else{
				   String strSQL = "select * from T_EMPLOYEE order by f_emp_id ASC";
				   if(!dao.Execute("select", strSQL)){
					   out.println("データ抽出に失敗した");
				   }else{
					   /* 抽出成功時 */
					   ArrayList<HashMap<String,String>>
					     all_data = new ArrayList<HashMap<String,String>>() ;

					   HashMap<Integer,String>
					     col_data = new HashMap<Integer,String>();

					   all_data = dao.get_db();
					   col_data = dao.get_db_col();

					   out.println("<table>");
					   out.println("<tr>");
					   for(int j=0;j<col_data.size();j++){
						   out.println("<td>");
						   out.println(col_data.get(j));
						   out.println("</td>");
					   }
					   out.println("<tr>");
					   for(int i=0;i<all_data.size();i++){
						   out.println("<tr>");
						   for(int j=0;j<all_data.get(i).size();j++){
							   out.println("<td>");
							   out.println(all_data.get(i).get(col_data.get(j)));
							   out.println("</td>");
						   }
						   out.println("</tr>");
					   }
					   out.println("</table>");
				   }
			   }
			   dao.Close();
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
