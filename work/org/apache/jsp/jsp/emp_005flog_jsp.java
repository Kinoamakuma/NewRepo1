package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class emp_005flog_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");

		//パスの取得
		String strPath = request.getContextPath();


		// セッションが存在している
		String sName = (String)session.getAttribute("name");


      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( strPath );
      out.write("/css/top.css\" media=\"all\" />\r\n");
      out.write("<script src=\"http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js\">\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print( strPath );
      out.write("/js/tr_background_color.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1><a href=\"");
      out.print( strPath );
      out.write("/jsp/emp_log.jsp\">出退勤ログ一覧画面</a>　　　ログインユーザー：");
      out.print( sName );
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<form class=\"formSearch\" action=\"");
      out.print( strPath );
      out.write("/servlet/sk31.Log_Search\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<a class=\"firstId\">社員名</a><input type=\"text\" name=\"txtName\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<input type=\"submit\" class=\"square_btn\" name=\"subSend\" value=\"検索\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<a href=\"");
      out.print( strPath );
      out.write("/jsp/emp_log.jsp\" class=\"square_btn\">ログ一覧画面へ</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<a href=\"");
      out.print( strPath );
      out.write("/jsp/top.jsp\" class=\"square_btn\">トップ画面へ</a>\r\n");
      out.write("\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t");

			ArrayList list = (ArrayList) request.getAttribute("list");
			ArrayList row = new ArrayList();
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t");

		    String strDisp =
		      (String)request.getAttribute("result");

			if(!(strDisp == null)){
			
      out.write("\r\n");
      out.write("\t\t\t");
      out.print( strDisp );
      out.write("<br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class=\"table-design-set-1\">\r\n");
      out.write("  <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("\t\t\t\t<td>ログID</td>\r\n");
      out.write("\t\t\t\t<td>社員ID</td>\r\n");
      out.write("\t\t\t\t<td>社員名</td>\r\n");
      out.write("\t\t\t\t<td>日時</td>\r\n");
      out.write("\r\n");
      out.write("    </tr>\r\n");
      out.write("  </thead>\r\n");
      out.write("  <tbody id=\"tbl1\">\r\n");
      out.write("\t\t\t");

			try{
				for(int i = 0;i<list.size();i++){
					row=(ArrayList)list.get(i);

					
      out.write("<tr>");


					for(int j = 0; j<row.size();j++){

							
      out.write("<td>");
      out.print( (String)row.get(j) );
      out.write("</td>");



					}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t");

				}
			}catch(Exception e){e.printStackTrace();}
			
      out.write("\r\n");
      out.write("  </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
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
