/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-14 02:35:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.approval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class totalList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1593409600303L));
    _jspx_dependants.put("/WEB-INF/lib/tiles-jsp-3.0.8.jar", Long.valueOf(1593409599707L));
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/GroupwarePJ/WEB-INF/lib/tiles-jsp-3.0.8.jar!/META-INF/tld/tiles-jsp.tld", Long.valueOf(1506773284000L));
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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t.chkBox {width: 15px;height: 15px;}\r\n");
      out.write("\t.icon {margin: 0px 5px 10px 0px;}\r\n");
      out.write("\t.button {background: none;border: 0;float:left;}\r\n");
      out.write("\t#nav{float:right;width:70px;margin-top:10px;}\r\n");
      out.write("\th2{margin:10px 0 30px 0;}\r\n");
      out.write("\t#searchBtn{width:40px; heigth:40px;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<div class=\"col-12\" style=\"padding:0px\">\r\n");
      out.write("            <div class=\"card card-secondary card-outline card-tabs\">\r\n");
      out.write("              <div class=\"card-header p-0 pt-1 border-bottom-0\">\r\n");
      out.write("                <ul class=\"nav nav-tabs\" id=\"custom-tabs-three-tab\" role=\"tablist\">\r\n");
      out.write("                  <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link active\" id=\"custom-tabs-three-all-tab\" data-toggle=\"pill\" href=\"#custom-tabs-three-all\" role=\"tab\" aria-controls=\"custom-tabs-three-all\" aria-selected=\"true\" data-state=\"all\">전체</a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" id=\"custom-tabs-three-draft-tab\" data-toggle=\"pill\" href=\"#custom-tabs-three-draft\" role=\"tab\" aria-controls=\"custom-tabs-three-draft\" aria-selected=\"false\"data-state=\"draft\">기안중</a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" id=\"custom-tabs-three-prog-tab\" data-toggle=\"pill\" href=\"#custom-tabs-three-prog\" role=\"tab\" aria-controls=\"custom-tabs-three-prog\" aria-selected=\"false\" data-state=\"prog\">진행중</a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" id=\"custom-tabs-three-attr-tab\" data-toggle=\"pill\" href=\"#custom-tabs-three-attr\" role=\"tab\" aria-controls=\"custom-tabs-three-attr\" aria-selected=\"false\" data-state=\"attr\">반려</a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" id=\"custom-tabs-three-comp-tab\" data-toggle=\"pill\" href=\"#custom-tabs-three-comp\" role=\"tab\" aria-controls=\"custom-tabs-three-comp\" aria-selected=\"false\" data-state=\"comp\">승인</a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"card-body\">\r\n");
      out.write("                <div class=\"tab-content\" id=\"custom-tabs-three-tabContent\">\r\n");
      out.write("                  <div class=\"tab-pane fade active show\" id=\"custom-tabs-three-content\" role=\"tabpanel\" aria-labelledby=\"custom-tabs-three-all-tab\">\r\n");
      out.write("\t                \t\r\n");
      out.write("\t                \t<div class=\"row\">\r\n");
      out.write("\t\t\t\t          <div class=\"col-12\">\r\n");
      out.write("\t\t\t\t            <div class=\"card\">\r\n");
      out.write("\t\t\t\t              <div class=\"card-header\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t                    <select name=\"searchType\" class=\"form-control select2 select2-hidden-accessible\" style=\"width: 10%; float: left\">\r\n");
      out.write("\t\t\t\t                         \t\t\t\t <option value=\"no\">문서번호</option>\r\n");
      out.write("\t\t\t\t                          \t\t\t\t <option value=\"title\">제목</option>\r\n");
      out.write("\t\t\t\t                          \t\t\t\t <option value=\"state\">진행상태</option>\r\n");
      out.write("\t\t\t\t                    </select>\r\n");
      out.write("\t\t\t\t                  <div class=\"input-group input-group-sm\" style=\"width: 40%; float: left\" id=\"searchUI\">\r\n");
      out.write("\t\t\t\t                      <input type=\"text\" name=\"searchWord\" class=\"form-control float-right\" placeholder=\"Search\" style=\"height: 38px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t                      <div class=\"input-group-append\">\r\n");
      out.write("\t\t\t\t                      \t<button type=\"submit\" id=\"searchBtn\" class=\"btn btn-default\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("\t\t\t\t                      </div>\r\n");
      out.write("\t\t\t\t                  </div>\r\n");
      out.write("\t\t\t\t               <div id=\"nav\">\r\n");
      out.write("\t\t\t\t                  <a class=\"btn btn-primary btn-sm p-10\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/approvalwrite\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fas fa-folder\"></i>추가\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t              <!-- /.card-header -->\r\n");
      out.write("\t\t\t\t              <div class=\"card-body table-responsive p-0\">\r\n");
      out.write("\t\t\t\t                <table class=\"table table-hover text-nowrap\">\r\n");
      out.write("\t\t\t\t                  <thead>\r\n");
      out.write("\t\t\t\t                    <tr>\r\n");
      out.write("\t\t\t\t                      <th>문서코드</th>\r\n");
      out.write("\t\t\t\t                      <th>기안서명</th>\r\n");
      out.write("\t\t\t\t                      <th>작성자</th>\r\n");
      out.write("\t\t\t\t                      <th>기안서 상태</th>\r\n");
      out.write("\t\t\t\t                      <th>작성날짜</th>\r\n");
      out.write("\t\t\t\t                    </tr>\r\n");
      out.write("\t\t\t\t                  </thead>\r\n");
      out.write("\t\t\t\t                  <tbody id=\"listBody\">\r\n");
      out.write("\t\t\t\t                  </tbody>\r\n");
      out.write("\t\t\t\t                </table>\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t              <!-- /.card-body -->\r\n");
      out.write("\t\t\t\t            </div>\r\n");
      out.write("\t\t\t\t            <!-- /.card -->\r\n");
      out.write("\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t\t\t \r\n");
      out.write("                \t\t<div class=\"card-footer\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-sm-12 col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-sm-12 col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"dataTables_paginate paging_simple_numbers\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tid=\"example2_paginate\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<nav id=\"pagingArea\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.pagingHTML }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<form id=\"searchForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/entiremanage/all\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"searchType\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"searchWord\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"draft_pos\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft_pos }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t</form>   \r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- /.card -->\r\n");
      out.write("             \r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("      </div>\r\n");
      out.write("          <div class=\"modal fade\" id=\"modal-danger\" style=\"display: none;\" aria-hidden=\"true\">\r\n");
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
      out.write("$(\"#apprDeleteBtn\").on(\"click\",function(){\r\n");
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
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("$(\"#modalConfirm\").on(\"click\",function(){\r\n");
      out.write("\tlet itemList = $(\"#listBody\").find(\"input:checked\");\r\n");
      out.write("\tlet dataList = [];\r\n");
      out.write("\tlet methodeType = \"\";\r\n");
      out.write("\tif('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
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
      out.write("/approval/delete\"\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("var listBody = $(\"#listBody\");\r\n");
      out.write("var searchForm = $(\"#searchForm\").paging({\r\n");
      out.write("\tsearchUI:\"#searchUI\",\r\n");
      out.write("\tsearchBtn:\"#searchBtn\",\r\n");
      out.write("\tpagination:\"#pagingArea\",\r\n");
      out.write("\tpageParam:\"page\",\r\n");
      out.write("\tbyAjax:true,\r\n");
      out.write("\tsuccess:function(resp){\r\n");
      out.write("\t\tlet draftList = resp.dataList;\r\n");
      out.write("\t\tconsole.log(draftList);\r\n");
      out.write("\t\tlet pagingHTML = resp.pagingHTML;\r\n");
      out.write("\t\tlet trTags = [];\r\n");
      out.write("\t\tif(draftList.length>0){\r\n");
      out.write("\t\t\t$.each(draftList, function(idx, draft){\r\n");
      out.write("\t\t\t\tlet trTag = $(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t  $(\"<td>\").text(draft.draft_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").html($(\"<a>\").attr(\"href\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/detail/\"+draft.draft_code).html(draft.draft_title).addClass(\"url-link\"))\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").text(draft.emp_kor)\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").text(draft.draft_stat)\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").text(draft.draft_date.split(\" \")[0]));\r\n");
      out.write("\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"nav#pagingArea\").html(pagingHTML);\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\ttrTags.push($(\"<tr>\").html($(\"<td colspan='8'>\").text(\"기안서가 존재하지 않습니다.\")));\r\n");
      out.write("\t\t\t$(\"nav#pagingArea\").empty();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tlistBody.html(trTags);\r\n");
      out.write("\t\tlistBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("}).submit();\r\n");
      out.write("\n");
      out.write("$(\"#custom-tabs-three-tab\").on(\"click\",\"a\",function(){\r\n");
      out.write("\tlet state = $(this).data(\"state\");\r\n");
      out.write("\t$(\"#searchForm\").attr(\"action\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/approval/entiremanage/\"+state);\r\n");
      out.write("\tsearchForm.submit();\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      // /WEB-INF/views/approval/totalList.jsp(62,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${state eq 'draft' }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<button id=\"apprDeleteBtn\"class=\"btn btn-danger btn-sm\" >\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fas fa-trash\"></i>삭제\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</button>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
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