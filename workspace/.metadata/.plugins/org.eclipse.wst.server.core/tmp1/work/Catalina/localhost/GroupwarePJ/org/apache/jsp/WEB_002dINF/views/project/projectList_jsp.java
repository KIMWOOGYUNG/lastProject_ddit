/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-18 05:55:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class projectList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style>\r\n");
      out.write("\t#content {padding: 30px;}\r\n");
      out.write("\t.chkBox {width: 15px;height: 15px;}\r\n");
      out.write("\t.icon {margin: 0px 5px 10px 0px;}\r\n");
      out.write("\t.button {background: none;border: 0;float:left;}\r\n");
      out.write("\t#nav{float:right;width:140px;margin-top:10px;}\r\n");
      out.write("\th2{margin:10px 0 30px 0;}\r\n");
      out.write("\t#searchBtn{width:40px; heigth:40px;}\r\n");
      out.write("\t.hide2{float:right;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"col-12\">\r\n");
      out.write("\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t\t<h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\" id=\"searchUI\">\r\n");
      out.write("\t\t\t\t\t<select name=\"searchType\" class=\"form-control select2 select2-hidden-accessible\" style=\"width: 10%; float: left\" data-select2-id=\"1\" tabindex=\"-1\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\" data-select2-id=\"3\" selected disabled>검색 방법</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"dept\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchType eq 'dept'?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tdata-select2-id=\"34\">부서</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"pjName\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchType eq 'pjName'?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tdata-select2-id=\"35\">프로젝트명</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"name\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchType eq '\"name\"'?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tdata-select2-id=\"36\">팀원</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<div class=\"input-group input-group-sm\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width: 40%; float: left\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control float-right\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"searchWord\" placeholder=\"Search\" style=\"height: 38px;\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchWord }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group-append\">\r\n");
      out.write("\t\t\t                <button type=\"submit\" id=\"searchBtn\" class=\"btn btn-default\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("\t\t\t            </div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"nav\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-primary btn-sm\" onclick=\"insertAction()\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fas fa-folder\"> </i> 등록\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 아이콘 -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"card-body table-responsive p-0\">\r\n");
      out.write("\t\t\t\t<div style=\"margin:20px 20px 0px 20px;\">\r\n");
      out.write("\t\t\t\t\t<button class=\"button showBtn\" id=\"blockBtn\" data-target=\"#blockBody\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"oi oi-grid-three-up icon\"></span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<button class=\"button showBtn\" id=\"tableBtn\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#projectTable\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"oi oi-list icon\"></span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<table class=\"table table-hover text-nowrap toggleShow\" id=\"projectTable\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<th>코드</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>부서</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>프로젝트명</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>팀 리더</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>진행률</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>중요도</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>상태</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"text-center\">공개</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody id=\"listBody\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t<div id=\"blockBody\" class=\"toggleShow\"></div>\r\n");
      out.write("\t\t\t\t<div style=\"margin:20px 20px 20px 20px; float:left;width:80%;\">\r\n");
      out.write("\t\t\t\t\t<div id=\"pagingArea\" class=\"d-flex ml-md-auto d-print-none\">\r\n");
      out.write("\t\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.pagingHTML }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<form id=\"searchForm\"\r\n");
      out.write("\taction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/projectlist/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /> \r\n");
      out.write("\t<input type=\"hidden\" name=\"searchType\" value=\"\" /> \r\n");
      out.write("\t<input type=\"hidden\" name=\"searchWord\" value=\"\" /> <input type=\"hidden\" name=\"viewType\" value=\"\" />\r\n");
      out.write("\t<!-- 페이지를 클릭할때 블럭인지 리스트인지 정보를 받아옴 -->\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar blockBody = $(\"#blockBody\");\r\n");
      out.write("\tvar listBody = $(\"#listBody\");\r\n");
      out.write("\tvar projectTable = $(\"#projectTable\");\r\n");
      out.write("\tvar searchForm = $(\"#searchForm\").paging({\r\n");
      out.write("\t\t\t\t\t\tsearchUI : \"#searchUI\",\r\n");
      out.write("\t\t\t\t\t\tsearchBtn : \"#searchBtn\",\r\n");
      out.write("\t\t\t\t\t\tpagination : \"#pagingArea\",\r\n");
      out.write("\t\t\t\t\t\tpageParam : \"page\",\r\n");
      out.write("\t\t\t\t\t\tbyAjax : true,\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(resp) {\r\n");
      out.write("\t\t\t\t\t\t\tlet projectList = resp.dataList;\r\n");
      out.write("\t\t\t\t\t\t\tlet pagingHTML = resp.pagingHTML;\r\n");
      out.write("\t\t\t\t\t\t\tlet divTags = [];\r\n");
      out.write("\t\t\t\t\t\t\tlet trTags = [];\r\n");
      out.write("\t\t\t\t\t\t\tif (projectList.length > 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\tlet idx = 1;\r\n");
      out.write("\t\t\t\t\t\t\t\t$.each(projectList,\tfunction(idx, project) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet firstCol = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif ((\"my\" == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("')) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfirstCol = $(\"<td>\").html('<input type=\"checkbox\" class=\"chkBox\" name=\"checkRow\" value=\"'+project.project_code+'\" />');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfirstCol = $(\"<td>\").text(\"\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//블럭형태\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet pj_rgroupList = project.pj_rgroupList;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet pjMemDiv = $(\"<div>\").css(\"height\",\"60px\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet plTd = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (pj_rgroupList != null && pj_rgroupList.length > 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$.each(pj_rgroupList,function(idx,pj_rgroup) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlet pj_memberList = pj_rgroup.pj_memberList;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tif (pj_memberList != null && pj_memberList.length > 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t$.each(pj_memberList,function(idx,pj_member) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tpjMemDiv.append($(\"<span>\").addClass(\"oi oi-person text-muted text-sm\").css(\"margin\",\"5px\").text(pj_member.emp_kor + pj_rgroup.pr_name));\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tif (pj_rgroup.pr_code == (\"PR001\")) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tplTd = pj_member.emp_kor;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet hide = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (project.project_hide == 'Y') {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thide = '<span class=\"oi oi-lock-locked hide\"></span>'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thide2 = '<span class=\"oi oi-lock-locked hide2\"></span>'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thide = '<span class=\"oi oi-lock-unlocked hide\" ></span>'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thide2 = '<span class=\"oi oi-lock-unlocked hide2\" ></span>'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet divTag = $(\"<div>\").append($(\"<div>\").css(\"display\",\"inline\").css(\"width\",\"33.3%\").css(\"float\",\"left\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.addClass(\"col-12 col-sm-6 col-md-4 align-items-stretch\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html($(\"<div>\").addClass(\"card bg-light\").css(\"margin\",\"10px\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html($(\"<div>\").addClass(\"card-header text-muted border-bottom-0\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.html($(\"<p>\").text(project.dept_name).append(hide2)))\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.append($(\"<div>\").addClass(\"card-body pt-0\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html($(\"<div>\").addClass(\"row\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html($(\"<div>\").addClass(\"col-15\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html($(\"<h2>\").addClass(\"lead\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html($(\"<b>\").text(project.project_name)))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.append($(\"<p>\").addClass(\"text-muted\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html($(\"<p>\").text(project.project_sum)))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.append(pjMemDiv)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.append($(\"<div>\").addClass(\"project_progress progress-sm\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.html('<div class=\"progress progress-sm\" style=\"width:100%;\"><div class=\"progress-bar bg-green\" role=\"progressbar\" aria-volumenow=\"'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ project.project_progress\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ '\" aria-volumemin=\"0\" aria-volumemax=\"100\" style=\"width: '\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ project.project_progress\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ '%\"></div></div>')))))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.append($(\"<div>\").addClass(\"card-footer\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.html($(\"<div>\").addClass(\"text-right\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.html($(\"<a>\").attr(\"data-code\",project.project_code).html($(\"<span>\").addClass(\"oi oi-zoom-in\"))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t.attr(\"onclick\",\"goDetail1(event)\"))))));\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdivTags.push(divTag);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//리스트형태\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet trTag = $(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tfirstCol,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<td>\").text(project.project_code).addClass(\"code\"),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<td>\").text(project.dept_name),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<td>\").text(project.project_name),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<td>\").text(plTd),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<td class='project_progress'>\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t.html('<div class=\"progress progress-sm\"><div class=\"progress-bar bg-green\" role=\"progressbar\" aria-volumenow=\"'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ project.project_progress+ '\" aria-volumemin=\"0\" aria-volumemax=\"100\" style=\"width: '\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ project.project_progress+ '%\"></div></div><small>'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ project.project_progress+ '% Complete</small>'),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<td>\").text(project.import_name),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<td>\").text(project.stat_name),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<td class='text-center'>>\").html(hide)).attr(\"onclick\",\"goDetail2(event)\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#pagingArea\").html(pagingHTML);\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\tdivTags.push($(\"<span>\").text(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"검색된 프로젝트가 없습니다.\"));\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#pagingArea\").empty();\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tblockBody.html(divTags);\r\n");
      out.write("\t\t\t\t\t\t\tblockBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\t\t\t\t\t\t\tlistBody.html(trTags);\r\n");
      out.write("\t\t\t\t\t\t\tlistBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t\tlet viewType = searchForm.find(\"[name='viewType']\").val();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t//paging시 viewType 유지\r\n");
      out.write("\t\t\t\t\t\t\tif (viewType) { //viewType이 있다면\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\".toggleShow\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t\t$(viewType).show();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t} else { //viewType이 없다면 (default)\r\n");
      out.write("\t\t\t\t\t\t\t\tprojectTable.hide();\r\n");
      out.write("\t\t\t\t\t\t\t\tblockBody.show();\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}).submit();\r\n");
      out.write("\t\r\n");
      out.write("//상세페이지 이동\r\n");
      out.write("\t//블럭\r\n");
      out.write("\tfunction goDetail1(event){\r\n");
      out.write("\t\tvar project_code = $(event.target).parent().data(\"code\");\r\n");
      out.write("\t\tvar hide = $(event.target).parent().parent().parent().parent().find(\".hide2\");\r\n");
      out.write("\t\tconsole.log(hide);\r\n");
      out.write("\t\tif(hide.hasClass(\"oi-lock-locked\")){\r\n");
      out.write("\t\t\tconsole.log(\"a\");\r\n");
      out.write("\t\t\tif(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${authUser.jobtitle_code eq 'JT001'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("){\r\n");
      out.write("\t\t\t\tconsole.log(\"b\");\r\n");
      out.write("\t\t\t\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/eachproject/\" + project_code;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tconsole.log(\"c\");\r\n");
      out.write("\t\t\t\talert(\"팀장 이상만 접근가능합니다.\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t\tconsole.log(\"d\");\r\n");
      out.write("\t\t\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/eachproject/\" + project_code;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//리스트\r\n");
      out.write("\tfunction goDetail2(event){\r\n");
      out.write("\t\tvar td = $(event.target).parent().find(\".code\");\r\n");
      out.write("\t\tvar hide = $(event.target).parent().find(\".hide\");\r\n");
      out.write("\t\tconsole.log(hide);\r\n");
      out.write("\t\tlet project_code = td.text();\r\n");
      out.write("\t\tif(hide.hasClass(\"oi-lock-locked\")){\r\n");
      out.write("\t\t\tif(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${authUser.jobtitle_code eq 'JT001'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("){\r\n");
      out.write("\t\t\t\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/eachproject/\" + project_code;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\talert(\"팀장 이상만 접근가능합니다.\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/eachproject/\" + project_code;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//viewType 이벤트\r\n");
      out.write("\t$(\".showBtn\").on(\"click\", function() {\r\n");
      out.write("\t\tvar target = $(this).data(\"target\");\r\n");
      out.write("\t\t$(\".toggleShow\").hide();\r\n");
      out.write("\t\t$(target).show();\r\n");
      out.write("\t\t// \t\t\t$(\".toggleShow\").toggle();\r\n");
      out.write("\t\tsearchForm.find(\"[name='viewType']\").val(target);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t//프로젝트 추가\r\n");
      out.write("\tfunction insertAction() {\r\n");
      out.write("\t\tlocation.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/newProject\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//전체 선택\r\n");
      out.write("\tfunction checkAll() {\r\n");
      out.write("\t\tif ($(\"#th_checkAll\").is(':checked')) {\r\n");
      out.write("\t\t\t$(\"input[name=checkRow]\").prop(\"checked\", true);\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"input[name=checkRow]\").prop(\"checked\", false);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//삭제\r\n");
      out.write("\tfunction deleteAction() {\r\n");
      out.write("\t\tvar checkRow = \"\";\r\n");
      out.write("\t\t$(\"input[name='checkRow']:checked\").each(function() {\r\n");
      out.write("\t\t\tcheckRow = checkRow + $(this).val() + \",\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tcheckRow = checkRow.substring(0, checkRow.lastIndexOf(\",\")); //맨끝 콤마 지우기\r\n");
      out.write("\r\n");
      out.write("\t\tif (checkRow == '') {\r\n");
      out.write("\t\t\talert(\"삭제할 프로젝트를 선택하세요.\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tconsole.log(\"### checkRow => {}\" + checkRow);\r\n");
      out.write("\r\n");
      out.write("\t\tif (confirm(\"프로젝트를 삭제 하시겠습니까?\")) {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/delProject',\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\tdatatype : 'json',\r\n");
      out.write("\t\t\t\tcontentType : \"application/x-www-form-urlencoded; charset=UTF-8\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\tproject_code : checkRow\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\talert(\"삭제가 완료되었습니다.\");\r\n");
      out.write("\t\t\t\t\tlocation.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/projectlist/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(request, status, error) {\r\n");
      out.write("\t\t\t\t\talert(\"삭제를 실패하였습니다.\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
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
      // /WEB-INF/views/project/projectList.jsp(48,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who eq 'my'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<button class=\"btn btn-danger btn-sm\" onclick=\"deleteAction()\">\r\n");
          out.write("\t\t\t\t\t\t\t<i class=\"fas fa-trash\"> </i> 삭제\r\n");
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

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/project/projectList.jsp(75,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who  eq 'my'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<th><input type=\"checkbox\" name=\"checkAll\" class=\"chkBox\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\tid=\"th_checkAll\" onclick=\"checkAll();\" /></th>\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /WEB-INF/views/project/projectList.jsp(79,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who  ne 'my'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<th></th>\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }
}
