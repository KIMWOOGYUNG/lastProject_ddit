/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-07-23 06:56:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.address;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teamList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t#content{padding:50px;}\r\n");
      out.write("\t.chkBox{width:15px; height:15px;}\r\n");
      out.write(" \t.icon{margin:0px 5px 10px 0px;} \r\n");
      out.write("\t.button{background:none; border:0;}\r\n");
      out.write("</style>\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("<h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h1>\r\n");
      out.write("<div id=\"top\">\r\n");
      out.write("\t\t<div class=\"input-group input-group-sm\" id=\"searchUI\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 300px; float: left;\">\r\n");
      out.write("\t\t\t\t<select name=\"searchType\" class=\"custom-select\">\r\n");
      out.write("\t\t\t\t\t<option value=\"name\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchType eq 'name'?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">이름</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"dept\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${paginVO.searchVO.searchType eq 'department'?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">부서</option>\r\n");
      out.write("\t\t\t\t</select> \r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"searchWord\"\r\n");
      out.write("\t\t\t\t\tclass=\"form-control float-right\" placeholder=\"Search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchWord }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t\t<div class=\"input-group-append\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fas fa-search\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary btn-sm\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t<i class=\" fas fa-plus\"> </i> 이동\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t<!-- 아이콘 -->\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<button class=\"button showBtn\" id=\"blockBtn\" data-target=\"#blockBody\">\r\n");
      out.write("\t\t\t<span class=\"oi oi-grid-three-up icon\"></span>\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t<button class=\"button showBtn\" id=\"tableBtn\"  data-target=\"#addressTable\">\r\n");
      out.write("\t\t\t<span class=\"oi oi-list icon\"></span>\r\n");
      out.write("\t\t</button>\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<table class=\"table table-striped address toggleShow\" id=\"addressTable\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>\r\n");
      out.write("                <input type=\"checkbox\" name=\"checkAll\" id=\"th_checkAll\" onclick=\"checkAll();\"/>\r\n");
      out.write("            </th>\r\n");
      out.write("            <th>이름</th>\r\n");
      out.write("            <th>부서명</th>\r\n");
      out.write("            <th>팀명</th>\r\n");
      out.write("            <th>H.P</th>\r\n");
      out.write("            <th>이메일</th>\r\n");
      out.write("            <th>내선번호</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("\t<tbody id=\"listBody\">\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\t\r\n");
      out.write("\r\n");
      out.write("<div id=\"blockBody\" class=\"toggleShow\" style=\"height: 850px;\">\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("\t<nav id=\"pagingArea\" class=\"d-flex ml-md-auto d-print-none\">\r\n");
      out.write("\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.pagingHTML }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t</nav>\t\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<form id=\"searchForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/address/teamList?team_code=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.detailSearch.team_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"searchType\" value=\"\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"searchWord\" value=\"\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"viewType\" value=\"\"/>\t<!-- 페이지를 클릭할때 블럭인지 리스트인지 정보를 받아옴 -->\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar blockBody = $(\"#blockBody\");\r\n");
      out.write("\t\tvar listBody = $(\"#listBody\");\r\n");
      out.write("\t\tvar addressTable =$(\"#addressTable\");\r\n");
      out.write("\t\tvar searchForm =$(\"#searchForm\").paging({\r\n");
      out.write("\t\t\tsearchUI:\"#searchUI\",\r\n");
      out.write("\t\t\tsearchBtn:\"#searchBtn\",\r\n");
      out.write("\t\t\tpagination:\"#pagingArea\",\r\n");
      out.write("\t\t\tpageParam:\"page\",\r\n");
      out.write("\t\t\tbyAjax:true,\r\n");
      out.write("\t\t\tsuccess:function(resp){\r\n");
      out.write("\t\t\tlet addrList = resp.dataList;\r\n");
      out.write("\t\t\tlet pagingHTML = resp.pagingHTML;\r\n");
      out.write("\t\t\tlet divTags = [];\r\n");
      out.write("\t\t\tlet trTags = [];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tconsole.log(addrList.length);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(addrList.length>0){\r\n");
      out.write("\t\t\t\t$.each(addrList, function(idx, address){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t//블럭형태\r\n");
      out.write("\t\t\t\t\tlet divTag = $(\"<div>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"<div>\").css(\"display\",\"inline\").css(\"width\",\"30%\").css(\"float\",\"left\").addClass(\"col-12 col-sm-6 col-md-4 align-items-stretch\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"<div>\").addClass(\"card bg-light\").css(\"margin\",\"10px\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t$(\"<div>\").addClass(\"card-header text-muted border-bottom-0\").html($(\"<p>\").text(address.emp_kor))\r\n");
      out.write(" \t\t\t\t\t\t\t\t\t\t).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"<div>\").addClass(\"card-body pt-0\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t$(\"<div>\").addClass(\"row\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<div>\").addClass(\"col-15\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<h4>\").addClass(\"lead\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<b>\").text(address.emp_kor)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<p>\").addClass(\"text-muted text-sm\").html($(\"<p>\").text(address.dept_name))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<p>\").addClass(\"text-muted text-sm\").html($(\"<p>\").text(address.team_name))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<p>\").addClass(\"text-muted text-sm\").html($(\"<p>\").text(address.emp_hp))\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<p>\").addClass(\"text-muted text-sm\").html($(\"<p>\").text(address.emp_mail))\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<p>\").addClass(\"text-muted text-sm\").html($(\"<p>\").text(address.co_phone))\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t )\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t )\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"<div>\").addClass(\"card-footer\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t$(\"<div>\").addClass(\"text-right\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"<a>\").html($(\"<span>\").addClass(\"oi oi-zoom-in\")).attr(\"href\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/address/detailAddress/\"+address.emp_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t)\r\n");
      out.write("\t\t\t\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\t\tdivTags.push(divTag);\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t//리스트형태\r\n");
      out.write("\t\t\t\t\t\tlet trTag = $(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"<td>\").html('<input type=\"checkbox\" class=\"chkBox\" name=\"checkRow\" value=\"'+address.emp_code+'\" />'), \r\n");
      out.write("\r\n");
      out.write(" \t\t\t\t\t\t\t\t$(\"<td>\").html(\r\n");
      out.write(" \t\t\t\t\t\t\t\t\t$(\"<a>\").attr(\"href\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/address/detailAddress/\"+address.emp_code)\r\n");
      out.write(" \t\t\t\t\t\t\t\t\t.text(address.emp_kor)//이름\r\n");
      out.write(" \t\t\t\t\t\t\t\t)\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").text(address.dept_name)//부서명\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").text(address.team_name)//팀명\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").text(address.emp_hp)//핸드폰번호\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").text(address.emp_mail)//이메일\r\n");
      out.write("\t\t\t\t\t\t\t\t, $(\"<td>\").text(address.co_phone)//내선번호\r\n");
      out.write("\t\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"#pagingArea\").html(pagingHTML);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tdivTags.push($(\"<span>\").text(\"검색된 주소록이 없습니다.\"));\r\n");
      out.write("\t\t\t\t$(\"#pagingArea\").empty();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tblockBody.html(divTags);\r\n");
      out.write("\t\t\tblockBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\t\t\tlistBody.html(trTags);\r\n");
      out.write("\t\t\tlistBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("\t\t\tlet viewType = searchForm.find(\"[name='viewType']\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//paging시 viewType 유지\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(viewType){\t//viewType이 있다면\r\n");
      out.write("\t\t\t\t$(\".toggleShow\").hide();\t\r\n");
      out.write("\t\t\t\t$(viewType).show();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}else{\t\t\t//viewType이 없다면 (default)\r\n");
      out.write("\t\t\t\taddressTable.hide();\r\n");
      out.write("\t\t\t\tblockBody.show();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}).submit();\r\n");
      out.write("\t\r\n");
      out.write("//viewType 이벤트\r\n");
      out.write("\t$(\".showBtn\").on(\"click\", function(){\r\n");
      out.write("\t\tvar target = $(this).data(\"target\");\r\n");
      out.write("\t\t$(\".toggleShow\").hide();\r\n");
      out.write("\t\t$(target).show();\r\n");
      out.write("//\t\t\t$(\".toggleShow\").toggle();\r\n");
      out.write("\t\tsearchForm.find(\"[name='viewType']\").val(target);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("//프로젝트 추가\r\n");
      out.write("// function insertAction(){\r\n");
      out.write("// \tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/newProject\";\r\n");
      out.write("// }\r\n");
      out.write("\r\n");
      out.write("//전체 선택\r\n");
      out.write("function checkAll(){\r\n");
      out.write("      if( $(\"#th_checkAll\").is(':checked') ){\r\n");
      out.write("        $(\"input[name=checkRow]\").prop(\"checked\", true);\r\n");
      out.write("      }else{\r\n");
      out.write("        $(\"input[name=checkRow]\").prop(\"checked\", false);\r\n");
      out.write("      }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//체크된것 수정\r\n");
      out.write("// \tfunction updateAction(){\r\n");
      out.write("// \tvar project_code = $(\"input[name='checkRow']:checked\").val();\r\n");
      out.write("// \tif(project_code == null){\r\n");
      out.write("// \t\talert(\"리스트에서 수정할 프로젝트를 선택하세요.\");\r\n");
      out.write("// \t}else{\r\n");
      out.write("// \t\tif($(\"input[name='checkRow']:checked\").length == 1){\r\n");
      out.write("// \t\t\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/editProject/?project_code=\"+project_code;\r\n");
      out.write("// \t\t}else{\r\n");
      out.write("// \t\t\talert(\"프로젝트를 한개만 선택하세요.\");\r\n");
      out.write("// \t\t}\r\n");
      out.write("// \t}\r\n");
      out.write("// }\r\n");
      out.write("\r\n");
      out.write("//체크된것 삭제(체크박스된 것 전부)\r\n");
      out.write("// function deleteAction(){\r\n");
      out.write("//   var checkRow = \"\";\r\n");
      out.write("//   $( \"input[name='checkRow']:checked\" ).each (function (){\r\n");
      out.write("//     checkRow = checkRow + $(this).val()+\",\" ;\r\n");
      out.write("//   });\r\n");
      out.write("//   checkRow = checkRow.substring(0,checkRow.lastIndexOf( \",\")); //맨끝 콤마 지우기\r\n");
      out.write(" \r\n");
      out.write("//   if(checkRow == ''){\r\n");
      out.write("//     alert(\"삭제할 프로젝트를 선택하세요.\");\r\n");
      out.write("//     return false;\r\n");
      out.write("//   }\r\n");
      out.write("//   console.log(\"### checkRow => {}\"+checkRow);\r\n");
      out.write(" \r\n");
      out.write("//   if(confirm(\"프로젝트를 삭제 하시겠습니까?\")){\r\n");
      out.write("// \t  $.ajax({\r\n");
      out.write("//             url : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/delProject',\r\n");
      out.write("//             type : \"POST\",\r\n");
      out.write("//             datatype : 'json',\r\n");
      out.write("//             contentType: \"application/x-www-form-urlencoded; charset=UTF-8\", \r\n");
      out.write("//             data:{\r\n");
      out.write("//                 project_code : checkRow\r\n");
      out.write("//             },\r\n");
      out.write("//             success : function(data) {\r\n");
      out.write("// \t\t\t    alert(\"삭제가 완료되었습니다.\");\r\n");
      out.write("// \t\t\t    location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/project/projectlist/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("                \r\n");
      out.write("//             },\r\n");
      out.write("//             error:function(request, status, error) {\r\n");
      out.write("//             \talert(\"삭제를 실패하였습니다.\");\r\n");
      out.write(" \r\n");
      out.write("//             }\r\n");
      out.write("// \t })\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("//   }\r\n");
      out.write(" \r\n");
      out.write("// }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("<!-- \t\t\t<div class=\"card-body p-0\"> -->\r\n");
      out.write("<!-- \t\t\t\t<ul class=\"users-list clearfix\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t<li><img src=\"dist/img/user1-128x128.jpg\" alt=\"User Image\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t<input type=\"checkbox\" name=\"ceo\"> <a -->\r\n");
      out.write("<!-- \t\t\t\t\t\tclass=\"users-list-name\" href=\"#\"> 김우빈 대표이사</a> <span -->\r\n");
      out.write("<!-- \t\t\t\t\t\tclass=\"users-list-date\">CEO</span> <span class=\"users-list-date\">IT회사/CEO</span> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t<span class=\"users-list-date\">sss@naver.com</span> <span -->\r\n");
      out.write("<!-- \t\t\t\t\t\tclass=\"users-list-date\">010-1111-1111</span> <span -->\r\n");
      out.write("<!-- \t\t\t\t\t\tclass=\"users-list-date\">042-222-2222</span></li> -->\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t<li><img src=\"dist/img/user8-128x128.jpg\" alt=\"User Image\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t<a class=\"users-list-name\" href=\"#\">강현철 부장</a> <span -->\r\n");
      out.write("<!-- \t\t\t\t\t\tclass=\"users-list-date\">부장</span> <span class=\"users-list-date\">개발팀</span> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t<span class=\"users-list-date\">aaa@naver.com</span> <span -->\r\n");
      out.write("<!-- \t\t\t\t\t\tclass=\"users-list-date\">010-2222-2222</span> <span -->\r\n");
      out.write("<!-- \t\t\t\t\t\tclass=\"users-list-date\">042-111-1111</span></li> -->\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t</ul> -->\r\n");
      out.write("<!-- \t\t\t</div> -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("<!-- \t\t\t/.card-body -->\r\n");
      out.write("<!-- \t\t\t<div id=\"footer\"> -->\r\n");
      out.write("<!-- \t\t\t\t<nav id=\"pagingArea\" class=\"d-flex ml-md-auto d-print-none\"> -->\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t</div> -->\r\n");
      out.write("<!-- \t\t\t<form id=\"searchForm\" -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\ttype=\"hidden\" name=\"searchType\" value=\"\" /> <input type=\"hidden\" -->\r\n");
      out.write("<!-- \t\t\t\t\tname=\"searchWord\" value=\"\" /> -->\r\n");
      out.write("<!-- \t\t\t</form> -->");
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
