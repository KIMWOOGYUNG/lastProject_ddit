/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-19 04:19:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.approval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class daftList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t#content {padding: 30px;}\r\n");
      out.write("\t#nav{float:right;width:200px;margin-top:10px;display:inline}\r\n");
      out.write("\th2{margin:10px 0 30px 0;}\r\n");
      out.write("\t#searchBtn{width:40px; heigth:40px;}\r\n");
      out.write("</style>\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("          <div class=\"col-12\">\r\n");
      out.write("            <div class=\"card\">\r\n");
      out.write("              <div class=\"card-header\">\r\n");
      out.write("                <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                  <select name=\"searchType\" class=\"form-control select2 select2-hidden-accessible\" style=\"width: 10%; float: left\">\r\n");
      out.write("      \t\t\t\t <option value=\"no\">문서번호</option>\r\n");
      out.write("      \t\t\t\t <option value=\"emp\">기안자</option>\r\n");
      out.write("       \t\t\t\t <option value=\"title\">제목</option>\r\n");
      out.write("       \t\t\t\t <option value=\"state\">진행상태</option>\r\n");
      out.write("                  </select>\r\n");
      out.write("                  \r\n");
      out.write("                  <div class=\"input-group input-group-sm\" style=\"width: 40%; float: left\">\r\n");
      out.write("\t                  <input type=\"text\" name=\"searchWord\" class=\"form-control float-right\" placeholder=\"Search\" style=\"height: 38px;\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t                  <div class=\"input-group-append\">\r\n");
      out.write("\t                      <button type=\"submit\" id=\"searchBtn\" class=\"btn btn-default\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("\t                  </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"nav\">\r\n");
      out.write("\t\t\t\t\t<a class=\"btn btn-primary btn-sm p-10\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/approvalwrite\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fas fa-folder\"></i>등록\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<button id=\"apprDeleteBtn\"class=\"btn btn-danger btn-sm\" >\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fas fa-trash\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${btn }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- /.card-header -->\r\n");
      out.write("              <div class=\"card-body table-responsive p-0\">\r\n");
      out.write("                <table class=\"table table-hover text-nowrap\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                   \r\n");
      out.write("                      <th><input type=\"checkbox\" id=\"allCheck\" ></th>\r\n");
      out.write("                    \r\n");
      out.write("                      <th>문서번호</th>\r\n");
      out.write("                      <th>기안서명</th>\r\n");
      out.write("                      <th>기안서 상태</th>\r\n");
      out.write("                      <th>작성날짜</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody id=\"listBody\">\r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("                <div style=\"margin:20px 20px 20px 20px;\">\r\n");
      out.write("\t\t\t\t\t<div id=\"pagingArea\" class=\"d-flex ml-md-auto d-print-none\">\r\n");
      out.write("\t\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.pagingHTML }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t</div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- /.card-body -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.card -->\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\t<form id=\"searchForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/myapproval/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft_pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"searchType\" value=\"\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"searchWord\" value=\"\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"draft_pos\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft_pos }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t</form>   \r\n");
      out.write("\t<div class=\"modal fade\" id=\"modal\" style=\"display: none;\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\">\r\n");
      out.write("          <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("              <h4 class=\"modal-title\"></h4>\r\n");
      out.write("              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                <span aria-hidden=\"true\">×</span>\r\n");
      out.write("              </button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("           \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer justify-content-between\">\r\n");
      out.write("              <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("              <button type=\"button\" class=\"btn btn-primary\" id=\"modalConfirm\">확인</button>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.modal-content -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.modal-dialog -->\r\n");
      out.write("      </div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var activeCatag = \"\";\r\n");
      out.write("$(\"#allCheck\").on(\"change\",function(){\r\n");
      out.write("\t var chk = $(this).is(\":checked\");//.attr('checked');\r\n");
      out.write("    \r\n");
      out.write("\t if(chk) $(\"#listBody input[type=checkbox]\").prop('checked', true);\r\n");
      out.write("     else  $(\"#listBody input[type=checkbox]\").prop('checked', false);\r\n");
      out.write("\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("$(\"#apprDeleteBtn\").on(\"click\",function(){\r\n");
      out.write("\tlet modal = $(\"#modal\");\r\n");
      out.write("\t$(\".modal-title\").text(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${btn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\");\r\n");
      out.write("\tlet itemList = $(\"#listBody\").find(\"input:checked\")\r\n");
      out.write("\tif(itemList.length <= 0){\r\n");
      out.write("\t\talert(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${btn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("하실 기안서를 선택해주세요.\")\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar check = true;\r\n");
      out.write("\t$.each(itemList,function(idx,item){\r\n");
      out.write("\t\t let state = $(item).attr(\"data-stat\");\r\n");
      out.write("\t\tif(state != null && state != '기안중'){\r\n");
      out.write("\t\t\talert(\"결재상태가 기안중이거나 없는 경우만 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${btn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("가 가능합니다.\")\r\n");
      out.write("\t\t\tcheck = false;\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("\tif(!check) return;\r\n");
      out.write("\t\r\n");
      out.write("\tlet modalBody= modal.find(\".modal-body\");\r\n");
      out.write("\tmodalBody.html($(\"<p>\").text(itemList.length+\"개의 기안서를 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${btn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("하시겠습니까?\"));\r\n");
      out.write("\tmodal.modal();\r\n");
      out.write("\tactiveCatag = 'delete';\r\n");
      out.write("});\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("$(\"#modalConfirm\").on(\"click\",function(){\r\n");
      out.write("\tlet itemList = $(\"#listBody\").find(\"input:checked\");\r\n");
      out.write("\tlet dataList = [];\r\n");
      out.write("\tlet methodeType = \"\";\r\n");
      out.write("\tif('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft_pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("' == 'delete'){\r\n");
      out.write("\t\tmethodeType = 'delete';\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tmethodeType = 'post';\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$.each(itemList,function(idx,item){\r\n");
      out.write("\t\tlet code = $(item).attr(\"data-code\");\r\n");
      out.write("\t\tdataList[dataList.length] = code;\r\n");
      out.write("\t});\r\n");
      out.write("\tvar data= {'dataList' :dataList};\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/\"+activeCatag+\"/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft_pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t,data :JSON.stringify(dataList)\r\n");
      out.write("\t\t,contentType:'application/json'\r\n");
      out.write("\t\t,traditional : true\r\n");
      out.write("\t\t,datetype : \"text\"\r\n");
      out.write("\t\t,method : methodeType\r\n");
      out.write("\t\t,success : function(resp){\r\n");
      out.write("\t\t\tlocation.reload();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t,error : function(error){\r\n");
      out.write("\t\t\tconsole.log(error.responseText);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("})\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#apprMoveBtn\").on(\"click\",function(){\r\n");
      out.write("\t\tlet modal = $(\"#modal\");\r\n");
      out.write("\t\t$(\".modal-title\").text(\"이동\");\r\n");
      out.write("\t\tlet itemList = $(\"#listBody\").find(\"input:checked\")\r\n");
      out.write("\t\tif(itemList.length <= 0){\r\n");
      out.write("\t\t\talert(\"이동하실 그룹을 선택해주세요.\")\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlet modalBody= modal.find(\".modal-body\");\r\n");
      out.write("\t\tmodalBody.html($(\"<p>\").text(itemList.length+\"개의 그룹을 이동하시겠습니까?\"));\r\n");
      out.write("\t\tmodal.modal();\r\n");
      out.write("\t\tactiveCatag = 'move';\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tvar listBody = $(\"#listBody\");\r\n");
      out.write("\tvar searchForm = $(\"#searchForm\").paging({\r\n");
      out.write("\t\tsearchUI:\"#searchUI\",\r\n");
      out.write("\t\tsearchBtn:\"#searchBtn\",\r\n");
      out.write("\t\tpagination:\"#pagingArea\",\r\n");
      out.write("\t\tpageParam:\"page\",\r\n");
      out.write("\t\tbyAjax:true,\r\n");
      out.write("\t\tsuccess:function(resp){\r\n");
      out.write("\t\t\tlet draftList = resp.dataList;\r\n");
      out.write("\t\t\tlet pagingHTML = resp.pagingHTML;\r\n");
      out.write("\t\t\tlet trTags = [];\r\n");
      out.write("\t\t\tif(draftList.length>0){\r\n");
      out.write("\t\t\t\t$.each(draftList, function(idx, draft){\r\n");
      out.write("\t\t\t\t\tlet trTag = $(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t $(\"<td>\").append($(\"<input>\").attr(\"type\",\"checkbox\").attr(\"data-code\",draft.draft_code).attr(\"data-stat\",draft.draft_stat)),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t $(\"<td>\").text(draft.draft_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").html($(\"<a>\").attr(\"href\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/detail/\"+draft.draft_code).html(draft.draft_title).addClass(\"url-link\"))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(draft.draft_stat)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(draft.draft_date.split(\" \")[0]));\r\n");
      out.write("\t\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"#pagingArea\").html(pagingHTML);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\ttrTags.push($(\"<tr>\").html($(\"<td colspan='8'>\").text(\"기안서가 존재하지 않습니다.\")));\r\n");
      out.write("\t\t\t\t$(\"#pagingArea\").empty();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tconsole.log(trTags);\r\n");
      out.write("\t\t\tlistBody.html(trTags);\r\n");
      out.write("\t\t\tlistBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\t\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}).submit();\r\n");
      out.write("\t\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/approval/daftList.jsp(12,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("btn");
      // /WEB-INF/views/approval/daftList.jsp(12,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/approval/daftList.jsp(12,0) '${draft_pos eq 'all' ? '회수' : '삭제' }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${draft_pos eq 'all' ? '회수' : '삭제' }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/approval/daftList.jsp(44,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft_pos eq'delete'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<button id=\"apprMoveBtn\" class=\"btn btn-info btn-sm\" >\r\n");
          out.write("\t\t\t\t\t\t\t<i class=\"fas fa-pencil-alt\"></i>이동\r\n");
          out.write("\t\t\t\t\t\t</button>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
