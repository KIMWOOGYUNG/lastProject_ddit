/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-17 07:59:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.approval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lineSetting_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<style>\r\n");
      out.write("\t#content {padding: 30px;}\r\n");
      out.write("\t#nav{float:right;width:140px;margin-top:10px;display:inline}\r\n");
      out.write("\th3{margin:10px 0 30px 0;}\r\n");
      out.write("\t#searchBtn{width:40px; heigth:40px;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("          <div class=\"col-12\">\r\n");
      out.write("            <div class=\"card\">\r\n");
      out.write("              <div class=\"card-header\">\r\n");
      out.write("                <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h3>\r\n");
      out.write("\t\t\t\t\t<select name=\"searchType\" class=\"form-control select2 select2-hidden-accessible\" style=\"width: 10%; float: left\">\r\n");
      out.write("\t      \t\t\t\t <option value=\"name\">그룹명</option>\r\n");
      out.write("\t       \t\t\t\t <option value=\"emp\">그룹원</option>\r\n");
      out.write("\t                  </select>\r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("                  <div class=\"input-group input-group-sm\" style=\"width: 40%; float: left\" id=\"searchUI\">\r\n");
      out.write("                    <input type=\"text\" name=\"searchWord\" class=\"form-control float-right\" placeholder=\"Search\" style=\"height: 38px;\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                    <div class=\"input-group-append\">\r\n");
      out.write("                      <button type=\"submit\" id=\"searchBtn\" class=\"btn btn-default\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  \r\n");
      out.write("                  <div id=\"nav\">\r\n");
      out.write("\t                    <a class=\"btn btn-primary btn-sm p-10\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/setting/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${state}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/add\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fas fa-folder\"></i>추가\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<button id=\"lineDeleteBtn\" class=\"btn btn-danger btn-sm\" >\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fas fa-trash\"></i>삭제\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t \t  </div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- /.card-header -->\r\n");
      out.write("              <div class=\"card-body table-responsive p-0\">\r\n");
      out.write("                <table class=\"table table-hover text-nowrap\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th><input type=\"checkbox\" id=\"allCheck\"></th>\r\n");
      out.write("                      <th>그룹명</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody id=\"listBody\">\r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("              <div style=\"margin:20px 20px 20px 20px;\">\r\n");
      out.write("\t\t\t\t<div id=\"pagingArea\" class=\"d-flex ml-md-auto d-print-none\">\r\n");
      out.write("\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.pagingHTML }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("             </div>\r\n");
      out.write("             <!-- /.card-body -->\r\n");
      out.write("           </div>\r\n");
      out.write("           <!-- /.card -->\r\n");
      out.write("         </div>\r\n");
      out.write("       </div>\r\n");
      out.write("</div>\r\n");
      out.write("        <form id=\"searchForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/setting/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${state}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"searchType\" value=\"\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"searchWord\" value=\"\"/>\r\n");
      out.write("\t\t</form>   \r\n");
      out.write("\t\t\r\n");
      out.write("        <div class=\"modal fade\" id=\"modal-danger\" style=\"display: none;\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\">\r\n");
      out.write("          <div class=\"modal-content bg-danger\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("              <h4 class=\"modal-title\">삭제</h4>\r\n");
      out.write("              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                <span aria-hidden=\"true\">×</span>\r\n");
      out.write("              </button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("           \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer justify-content-between\">\r\n");
      out.write("              <button type=\"button\" class=\"btn btn-outline-light\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("              <button type=\"button\" class=\"btn btn-outline-light\" id=\"modalConfirm\">확인</button>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.modal-content -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.modal-dialog -->\r\n");
      out.write("      </div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(\"#allCheck\").on(\"change\",function(){\r\n");
      out.write("\t var chk = $(this).is(\":checked\");//.attr('checked');\r\n");
      out.write("   \r\n");
      out.write("\t if(chk) $(\"#listBody input[type=checkbox]\").prop('checked', true);\r\n");
      out.write("    else  $(\"#listBody input[type=checkbox]\").prop('checked', false);\r\n");
      out.write("\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("$(\"#lineDeleteBtn\").on(\"click\",function(){\r\n");
      out.write("\tlet modal = $(\"#modal-danger\");\r\n");
      out.write("\tlet itemList = $(\"#listBody\").find(\"input:checked\")\r\n");
      out.write("\tif(itemList.length <= 0){\r\n");
      out.write("\t\talert(\"삭제하실 그룹을 선택해주세요.\")\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tlet modalBody= modal.find(\".modal-body\");\r\n");
      out.write("\tmodalBody.html($(\"<p>\").text(itemList.length+\"개의 그룹을 삭제하시겠습니까?\"));\r\n");
      out.write("\tmodal.modal();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#modalConfirm\").on(\"click\",function(){\r\n");
      out.write("\t\r\n");
      out.write("\tlet itemList = $(\"#listBody\").find(\"input:checked\");\r\n");
      out.write("\tlet dataList = [];\r\n");
      out.write("\t$.each(itemList,function(idx,item){\r\n");
      out.write("\t\tlet code = $(item).attr(\"data-code\");\r\n");
      out.write("\t\tdataList[dataList.length] = code;\r\n");
      out.write("\t});\r\n");
      out.write("\tvar data= {'dataList' :dataList};\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/setting/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${state}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/delete\"\r\n");
      out.write("\t\t,data :JSON.stringify(dataList)\r\n");
      out.write("\t\t,dataType:'text'\r\n");
      out.write("\t\t,contentType:'application/json'\r\n");
      out.write("\t\t,traditional : true\r\n");
      out.write("\t\t,method : 'delete'\r\n");
      out.write("\t\t,success : function(resp){\r\n");
      out.write("\t\t\tlocation.reload();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t,error : function(error){\r\n");
      out.write("\t\t\talert(error.responseText)\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\tvar listBody = $(\"#listBody\");\r\n");
      out.write("\tvar searchForm = $(\"#searchForm\").paging({\r\n");
      out.write("\t\tsearchUI:\"#searchUI\",\r\n");
      out.write("\t\tsearchBtn:\"#searchBtn\",\r\n");
      out.write("\t\tpagination:\"#pagingArea\",\r\n");
      out.write("\t\tpageParam:\"page\",\r\n");
      out.write("\t\tbyAjax:true,\r\n");
      out.write("\t\tsuccess:function(resp){\r\n");
      out.write("\t\t\tconsole.log(resp);\r\n");
      out.write("\t\t\tlet lineList = resp.dataList;\r\n");
      out.write("\t\t\tlet pagingHTML = resp.pagingHTML;\r\n");
      out.write("\t\t\tlet trTags = [];\r\n");
      out.write("\t\t\tif(lineList.length>0){\r\n");
      out.write("\t\t\t\t$.each(lineList, function(idx, line){\r\n");
      out.write("\t\t\t\t\tlet trTag = $(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  $(\"<td>\").html($(\"<input>\").attr({\"type\":\"checkbox\",\"data-code\":line.line_code}))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").html($(\"<a>\").attr(\"href\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/setting/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${state }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/modify/\"+line.line_code).text(line.line_name).addClass(\"url-link\"))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"#pagingArea\").html(pagingHTML);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\ttrTags.push($(\"<tr>\").html($(\"<td colspan='8'>\").text(\"해당 그룹이 없습니다.\")));\r\n");
      out.write("\t\t\t\t$(\"#pagingArea\").empty();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tconsole.log(trTags);\r\n");
      out.write("\t\t\tlistBody.html(trTags);\r\n");
      out.write("\t\t\tlistBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\t\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}).submit();\r\n");
      out.write("\r\n");
      out.write("</script>");
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
