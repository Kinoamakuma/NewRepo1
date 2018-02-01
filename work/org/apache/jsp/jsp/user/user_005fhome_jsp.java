package org.apache.jsp.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");

		//パスの取得
		String strPath = request.getContextPath();



      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( strPath );
      out.write("/css/home.css\" media=\"all\" />\r\n");
      out.write("<script src=\"http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.4.min.js\">\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<h1>ユーザログイン画面</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<form class=\"formSearch\" action=\"");
      out.print( strPath );
      out.write("/servlet/sk31.UserLogin\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<dl class=\"abc\">\r\n");
      out.write("\t\t\t\t<dt>ID</dt>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<dd><input type=\"text\" class=\"base\" name=\"txtId\"  required=\"required\" pattern=\"\\d{1,4}\"/></dd>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<dt>PW</dt>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<dd><input type=\"password\" class=\"base\" name=\"txtPass\" required=\"required\" pattern=\"\\d{1,4}\"/></dd>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<dt>IC情報</dt>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<dd><input type=\"text\" class=\"base\" name=\"txtIC\" required=\"required\" /></dd>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<dt><input type=\"reset\" value=\"リセット\" ></dt>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<dd><input type=\"submit\" value=\"ログイン\"></dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- float left 解除 -->\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
