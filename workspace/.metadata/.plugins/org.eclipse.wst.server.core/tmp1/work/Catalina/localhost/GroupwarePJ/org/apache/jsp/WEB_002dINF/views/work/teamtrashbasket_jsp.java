/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-18 05:28:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teamtrashbasket_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1593409600303L));
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/GroupwarePJ/WEB-INF/lib/spring-webmvc-4.3.27.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1588032890000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.3.27.RELEASE.jar", Long.valueOf(1593409602202L));
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/GroupwarePJ/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t#content{padding:30px;}\r\n");
      out.write("\th2{margin:10px 0 30px 0;}\r\n");
      out.write("\t#nav{float:right;width:140px;margin-top:10px;}\r\n");
      out.write("\t#searchBtn{width:40px; height:40px;}\r\n");
      out.write("\t#searchDate{height:40px;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"col-12\">\r\n");
      out.write("            <div class=\"card\">\r\n");
      out.write("              <div class=\"card-header\">\r\n");
      out.write("                <h2>팀 삭제함</h2>\r\n");
      out.write("                \r\n");
      out.write("                <div id=\"nav\">\r\n");
      out.write("\t\t\t   <button class=\"btn btn-primary btn-sm\" onclick=\"back()\">\r\n");
      out.write("\t\t\t       <i class=\" fas fa-save\"></i> 복구\r\n");
      out.write("\t\t\t    </button>\r\n");
      out.write("\t\t\t    <button class=\"btn btn-danger btn-sm\" onclick=\"realDel()\">\r\n");
      out.write("\t\t\t        <i class=\"fas fa-trash\"></i> 삭제\r\n");
      out.write("\t\t\t    </button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                <div>\r\n");
      out.write("                  <div class=\"input-group input-group-sm\" id=\"searchUI\" style=\"width: 200px;\">\r\n");
      out.write("                    \r\n");
      out.write("                    <input type=\"date\" id=\"searchDate\" name=\"searchWord\" class=\"form-control float-right\" placeholder=\"Search\"\r\n");
      out.write("                    \tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchWord }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tonkeyup=\"event.keyCode==13?$('#searchBtn').trigger('click'):'';\"\r\n");
      out.write("                    >\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                    <div class=\"input-group-append\">\r\n");
      out.write("                      <button class=\"btn btn-default\" id=\"searchBtn\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- /.card-header -->\r\n");
      out.write("              <div class=\"card-body table-responsive p-0\">\r\n");
      out.write("                <table class=\"table table-hover text-nowrap\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th><input type=\"checkbox\" name=\"checkAll\" id=\"th_checkAll\" onclick=\"checkAll();\"/></th>\r\n");
      out.write("                      <th>순번</th>\r\n");
      out.write("                      <th>작성자</th>\r\n");
      out.write("                      <th>작성일</th>\r\n");
      out.write("                      <th>제목</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody id=\"listBody\">\r\n");
      out.write(" \r\n");
      out.write("                  </tbody>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                </table>\r\n");
      out.write("                <div style=\"margin:20px 20px 20px 20px;\">\r\n");
      out.write("\t                <div id=\"pagingArea\" class=\"d-flex ml-md-auto d-print-none\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.pagingHTML }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("              </div>\t\r\n");
      out.write("              <!-- /.card-body -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.card -->\r\n");
      out.write("          </div>\r\n");
      out.write("</div>\r\n");
      out.write("<form id=\"searchForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/work/teamwork/teamtrashbasket\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"searchWord\" value=\"\"/>\r\n");
      out.write("</form>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar listBody = $(\"#listBody\");\r\n");
      out.write("\tvar searchForm = $(\"#searchForm\").paging({\r\n");
      out.write("\t\tsearchUI:\"#searchUI\",\r\n");
      out.write("\t\tsearchBtn:\"#searchBtn\",\r\n");
      out.write("\t\tpagination:\"#pagingArea\",\r\n");
      out.write("\t\tpageParam:\"page\",\r\n");
      out.write("\t\tbyAjax:true,\r\n");
      out.write("\t\tsuccess:function(resp){\r\n");
      out.write("\t\t\tlet worklogList = resp.dataList;\r\n");
      out.write("\t\t\tconsole.log(worklogList);\r\n");
      out.write("\t\t\tlet pagingHTML = resp.pagingHTML;\r\n");
      out.write("\t\t\tlet trTags = [];\r\n");
      out.write("\t\t\tif(worklogList.length > 0){\r\n");
      out.write("\t\t\t\t$.each(worklogList, function(idx, worklog){\r\n");
      out.write("\t\t\t\t\tconsole.log(worklog);\r\n");
      out.write("\t\t\t\t\tlet trTag = $(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t $(\"<td>\").html('<input type=\"checkbox\" name=\"checkRow\" value=\"' + worklog.wl_code + '\" />')\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(worklog.rnum)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(worklog.emp_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(worklog.wl_date)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(worklog.wl_title));\r\n");
      out.write("\t\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"#pagingArea\").html(pagingHTML);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\ttrTags.push($(\"<tr>\").html($(\"<td colspan='8'>\").text(\"일지가 없습니다.\")));\r\n");
      out.write("\t\t\t\t$(\"#pagingArea\").empty();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tlistBody.html(trTags);\r\n");
      out.write("\t\t\tlistBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\t\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}).submit();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkAll(){\r\n");
      out.write("        if( $(\"#th_checkAll\").is(':checked') ){\r\n");
      out.write("          $(\"input[name=checkRow]\").prop(\"checked\", true);\r\n");
      out.write("        }else{\r\n");
      out.write("          $(\"input[name=checkRow]\").prop(\"checked\", false);\r\n");
      out.write("        }\r\n");
      out.write("  \t}\r\n");
      out.write("\t\r\n");
      out.write("\t// 체크 된 것 복구\r\n");
      out.write("\tfunction back(){\r\n");
      out.write("\t\tvar checkRow = \"\";\r\n");
      out.write("\t\t$(\"input[name='checkRow']:checked\").each(function(){\r\n");
      out.write("\t\t\tcheckRow = checkRow + $(this).val() + \",\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tcheckRow = checkRow.substring(0, checkRow.lastIndexOf(\",\")); // 맨 끝 콤마 지우기\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(checkRow == ''){\r\n");
      out.write("\t\t\talert(\"복구할 일지를 선택하세요.\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(confirm(\"일지를 복구하시겠습니까 ?\")){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/work/mywork/delworklog/back/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wl_team}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("',\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\tdataType : 'html',\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\twl_code : checkRow\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\talert(\"복구가 완료 되었습니다.\");\r\n");
      out.write("\t\t\t\t\t$(\".wrapper\").children().remove();\r\n");
      out.write("\t\t\t\t\t$(\".wrapper\").html(data);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(request, status, error){\r\n");
      out.write("\t\t\t\t\talert(\"복구 실패\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t// 영구삭제\r\n");
      out.write("\tfunction realDel(){\r\n");
      out.write("\t\tvar checkRow = \"\";\r\n");
      out.write("\t\t$(\"input[name='checkRow']:checked\").each(function(){\r\n");
      out.write("\t\t\tcheckRow = checkRow + $(this).val() + \",\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tcheckRow = checkRow.substring(0, checkRow.lastIndexOf(\",\")); // 맨 끝 콤마 지우기\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(checkRow == ''){\r\n");
      out.write("\t\t\talert(\"삭제할 일지를 선택하세요.\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(confirm(\"일지를 영구 삭제하시겠습니까?\")){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/work/mywork/realDelete/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wl_team}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("',\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\tdataType : 'html',\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\twl_code : checkRow\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\talert(\"삭제가 완료 되었습니다.\");\r\n");
      out.write("\t\t\t\t\t$(\".wrapper\").children().remove();\r\n");
      out.write("\t\t\t\t\t$(\".wrapper\").html(data);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(request, status, error){\r\n");
      out.write("\t\t\t\t\talert(\"삭제 실패\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
