/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-19 04:56:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.note;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class entirenote_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t#searchBtn{width:40px; heigth:40px;}\r\n");
      out.write("\t#content {padding: 30px;}\r\n");
      out.write("\t#nav{float:right;}\r\n");
      out.write("\t.table-hover > tbody:hover  {\r\n");
      out.write("\t\tcursor:Pointer\r\n");
      out.write("\t\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<div class=\"col-12\">\r\n");
      out.write("\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t<h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("\t\t\t<div class=\"form-group\" id=\"searchUI\">\r\n");
      out.write("\t\t  <select name=\"searchType\" class=\"form-control select2 select2-hidden-accessible\" style=\"width: 10%;float:left\" data-select2-id=\"1\" tabindex=\"-1\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t<option value=\"emp_sender\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchType eq 'emp_sender' ?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" data-select-id=\"35\">보낸이</option>\r\n");
      out.write("\t\t\t<option value=\"emp_receiver\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchType eq 'emp_receiver' ?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" data-select-id=\"35\">받는이</option>\r\n");
      out.write("\t\t\t<option value=\"msg_content\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchType eq '\"msg_content\"'?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" data-select2-id=\"36\">내용</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"input-group input-group-sm\" style=\"width: 40%; float:left\">\r\n");
      out.write("\t\t              <input type=\"text\" class=\"form-control float-right\" name=\"searchWord\" placeholder=\"Search\" style=\"height:38px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.searchVO.searchWord }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t              <div class=\"input-group-append\">\r\n");
      out.write("\t\t                <button id=\"searchBtn\"  type=\"submit\" id=\"searchBtn\" class=\"btn btn-default\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("\t\t              </div>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t<div class=\"float-right\">\r\n");
      out.write("\t<a class=\"btn btn-primary btn-sm mx-2\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/note/writenote\" style=\"float: right;\">\r\n");
      out.write("        <i class=\"fas fa-folder\">\r\n");
      out.write("        </i>\r\n");
      out.write("       \t 쪽지쓰기\r\n");
      out.write("    </a>\r\n");
      out.write("      <a class=\"btn btn-danger btn-sm\" id=\"delBtn\" href=\"#\" onclick=\"deleteAction()\" style=\"float: right;\">\r\n");
      out.write("        <i class=\"fas fa-trash\">\r\n");
      out.write("        </i>\r\n");
      out.write("       \t 삭제\r\n");
      out.write("    </a>\r\n");
      out.write("   \r\n");
      out.write("    <a class=\"btn btn-primary btn-sm mx-2\" id=\"moveBtn\" href=\"#\"  onclick=\"moveAction()\" style=\"float: right;\">\r\n");
      out.write("        <i class=\"fas fa-plus\">\r\n");
      out.write("        </i>\r\n");
      out.write("    \t 이동\r\n");
      out.write("    </a>\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("<table class=\"table table-hover projects\" style=\"table-layout: fixed;\">\r\n");
      out.write("  \t<thead>\r\n");
      out.write("  \t\t<tr > \r\n");
      out.write("  \t\t<th rowspan=\"1\" colspan=\"1\" id = \"choice\"><input type=\"checkbox\" name=\"checkAll\" id=\"th_checkAll\" onclick=\"checkAll();\"/></th>\r\n");
      out.write("  \t\t<th rowspan=\"1\" colspan=\"1\">내용</th>\r\n");
      out.write("  \t\t<th rowspan=\"1\" colspan=\"1\">날짜</th>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t</thead>\r\n");
      out.write("  \t<tbody id=\"listBody\">\r\n");
      out.write("  \t</tbody>\r\n");
      out.write("  </table>\r\n");
      out.write(" <div id=\"footer\">\r\n");
      out.write("  <nav id=\"pagingArea\" class=\"d-flex ml-md-auto d-print-none\">\r\n");
      out.write("   ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.pagingHTML}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("  </nav>\r\n");
      out.write("  </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--   <form method=\"post\" > -->\r\n");
      out.write("\r\n");
      out.write("<!--   </form> -->\r\n");
      out.write("  <form id=\"searchForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/note/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" >\r\n");
      out.write("  \t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("  \t<input type=\"hidden\" name=\"searchType\" value=\"\"/>\r\n");
      out.write("  \t<input type=\"hidden\" name=\"searchWord\" value=\"\"/>\r\n");
      out.write("  </form>\r\n");
      out.write("    \r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("   $(function(){\r\n");
      out.write("   var pos = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("   if(pos == 'entirenote')\r\n");
      out.write("\t   $(\"#choice\").after(\"<th rowspan='1' colspan='1'>보낸사람</th>\",\"<th rowspan='1' colspan='1'>받는사람</th>\")\r\n");
      out.write("   else  if(pos == 'receivenote')\r\n");
      out.write("\t\t   $(\"#choice\").after(\"<th rowspan='1' colspan='1'>보낸사람</th>\")\r\n");
      out.write("   else if(pos == 'sendnote')\r\n");
      out.write("\t   $(\"#choice\").after(\"<th rowspan='1' colspan='1'>받는사람</th>\")\r\n");
      out.write("   });\r\n");
      out.write("   \r\n");
      out.write("  \tvar listBody = $(\"#listBody\");\r\n");
      out.write("  \tvar searchForm = $(\"#searchForm\").paging({\r\n");
      out.write("  \t\tsearchUI:\"#searchUI\",\r\n");
      out.write("  \t\tsearchBtn:\"#searchBtn\",\r\n");
      out.write("  \t\tpagination:\"#pagingArea\",\r\n");
      out.write("  \t\tpageParam:\"page\",\r\n");
      out.write("  \t\tbyAjax:true,\r\n");
      out.write("  \t\tsuccess:function(resp){\r\n");
      out.write("  \t\t\tlet msgList = resp.dataList;\r\n");
      out.write("  \t\t\tlet pagingHTML=resp.pagingHTML;\r\n");
      out.write("  \t\t\tlet trTags=[];\r\n");
      out.write("  \t\t\tconsole.log(resp.dataList);\r\n");
      out.write("  \t\t\tif(msgList.length>0){\r\n");
      out.write("  \t\t\t\t$.each(msgList,function(idx,msg){\r\n");
      out.write("  \t\t\t\t\tlet trTag=$(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t $(\"<td>\").html('<input type=\"checkbox\" name=\"checkRow\" value=\"'+msg.msg_code+'\"/> ')\r\n");
      out.write("  \t\t\t\t\t .attr(\"data-url\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/note/detailnote\")).attr(\"data-code\",msg.msg_code);\r\n");
      out.write("  \t\t\t\t\t if(\"entirenote\"== '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("') {\r\n");
      out.write("  \t\t\t\t\t\t\ttrTag.append($(\"<td>\").text(msg.emp_sender));\r\n");
      out.write("  \t  \t\t  \t\t\t\ttrTag.append($(\"<td>\").text(msg.emp_receiver));\r\n");
      out.write("  \t\t\t\t\t\t}else if('receivenote'== '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("') {\r\n");
      out.write("\t\t\t\t\t\t  trTag.append($(\"<td>\").text(msg.emp_receiver));\r\n");
      out.write("  \t\t\t\t\t\t}else if('sendnote'=='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("') {\r\n");
      out.write("\t\t\t\t\t\t\ttrTag.append($(\"<td>\").text(msg.emp_sender));\r\n");
      out.write("  \t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("  \t\t\t\t\ttrTag.append(\r\n");
      out.write("  \t\t\t\t\t\t\t$(\"<td>\").text(msg.msg_content)\r\n");
      out.write("  \t\t\t\t\t);\r\n");
      out.write("  \t\t\t\t\ttrTag.append(\r\n");
      out.write("  \t\t\t\t\t$(\"<td>\").text(msg.msg_date)\r\n");
      out.write("  \t\t\t\t\t); \r\n");
      out.write("  \t\t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("  \t\t\t\t});\r\n");
      out.write("  \t\t\t\t$(\"#pagingArea\").html(pagingHTML);\r\n");
      out.write("  \t\t\t  \r\n");
      out.write("  \t\t\t   $(\".table-hover\").on(\"click\",\"tbody td\",function(event){\r\n");
      out.write("  \t\t\t\t   event.stopPropagation()    \r\n");
      out.write("  \t\t\t\t \r\n");
      out.write("  \t\t\t\t  if($(this).children().length > 0){\r\n");
      out.write("  \t\t\t\t\t  return;\r\n");
      out.write("  \t\t\t\t  }\r\n");
      out.write("  \t\t\t\t   let code = $(this).parent().attr(\"data-code\");\r\n");
      out.write("  \t\t\t\t   location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/note/detailnote/\"+code;\r\n");
      out.write("  \t\t\t  \t });\r\n");
      out.write("  \t\t\t\t\r\n");
      out.write("  \t\t\t}else{\r\n");
      out.write("  \t\t\t    $(\".table-hover\").off();\r\n");
      out.write("  \t\t\t\ttrTags.push($(\"<tr>\").append($(\"<td colspan='8'>\").text(\"조건에 맞는 쪽지가 없습니다.\")));\r\n");
      out.write("  \t\t\t\t$(\"#pagingArea\").empty();\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("  \t\t\tlistBody.html(trTags);\r\n");
      out.write("  \t\t\tlistBody.data(\"currentpage\",resp.currentPage);\r\n");
      out.write("  \t\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t}).submit();\r\n");
      out.write("   \r\n");
      out.write("   //삭제버튼전체선택\r\n");
      out.write("   function checkAll(){\r\n");
      out.write("\t   if( $(\"#th_checkAll\").is(':checked') ){\r\n");
      out.write("\t\t   $(\"input[name=checkRow]\").prop(\"checked\",true);\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t\t   $(\"input[name=checkRow]\").prop(\"checked\", false);\r\n");
      out.write("\t   }\r\n");
      out.write("   }\r\n");
      out.write("\t   \r\n");
      out.write("   //체크된것 삭제 (체크박스 된거 전부)\r\n");
      out.write("   \tfunction deleteAction(){\r\n");
      out.write("\t   var checkRow=\"\";\r\n");
      out.write("\t   $(\"input[name='checkRow']:checked\").each(function(){\r\n");
      out.write("\t\t  checkRow=checkRow+$(this).val()+\",\"; \r\n");
      out.write("\t   });\r\n");
      out.write("\t   checkRow=checkRow.substring(0,checkRow.lastIndexOf(\",\")); //맨끝 콤마지우기\r\n");
      out.write("\t   if(checkRow==''){\r\n");
      out.write("\t\t   alert(\"삭제 쪽지 선택하세요\");\r\n");
      out.write("\t\t   return false;\r\n");
      out.write("\t   }\r\n");
      out.write("\t   if(confirm(\"쪽지를 삭제하시겠습니까?\")){\r\n");
      out.write("\t\t   $.ajax({\r\n");
      out.write("\t            url : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/note/deletenote',\r\n");
      out.write("\t            type : \"POST\",\r\n");
      out.write("\t            datatype : 'json',\r\n");
      out.write("\t            contentType: \"application/x-www-form-urlencoded; charset=UTF-8\", \r\n");
      out.write("\t            data:{\r\n");
      out.write("\t                msg_code : checkRow\r\n");
      out.write("\t            },\r\n");
      out.write("\t            success : function(data) {\r\n");
      out.write("\t\t\t\t    alert(\"삭제가 완료되었습니다.\");\r\n");
      out.write("\t\t\t\t    location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/note/entirenote/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t                \r\n");
      out.write("\t            },\r\n");
      out.write("\t            error:function(request, status, error) {\r\n");
      out.write("\t            \talert(\"삭제를 실패하였습니다.\");\r\n");
      out.write("\t \r\n");
      out.write("\t            }\r\n");
      out.write("\t   })\r\n");
      out.write("   }\r\n");
      out.write("}\r\n");
      out.write("\t//이동 전체선택\r\n");
      out.write("   function checkAll2(){\r\n");
      out.write("\t   if( $(\"#th_checkAll\").is(':checked') ){\r\n");
      out.write("\t\t   $(\"input[name=checkRow]\").prop(\"checked\",true);\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t\t   $(\"input[name=checkRow]\").prop(\"checked\", false);\r\n");
      out.write("\t   }\r\n");
      out.write("   }\r\n");
      out.write("   $(\"#moveBtn\").on(\"click\",function(){\r\n");
      out.write("\t   \r\n");
      out.write("   })\r\n");
      out.write("   ///이동버튼\r\n");
      out.write("  \tfunction moveAction(){\r\n");
      out.write("\t   var checkRow=[];\r\n");
      out.write("\t   $(\"input[name='checkRow']:checked\").each(function(){\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  checkRow.push($(this).val());\r\n");
      out.write("\t   });\r\n");
      out.write("\t  \r\n");
      out.write("\t   if(checkRow.length <= 0){\r\n");
      out.write("\t\t   alert(\"이동할 쪽지 선택하세요\");\r\n");
      out.write("\t\t   return false;\r\n");
      out.write("\t   }\r\n");
      out.write("\t   if(confirm(\"쪽지를 보관함으로 이동하시겠습니까?\")){\r\n");
      out.write("\t\t   $.ajax({\r\n");
      out.write("\t\t\t   url : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/note/importantnote',\r\n");
      out.write("\t\t\t   type:\"POST\",\r\n");
      out.write("\t\t\t   contentType:\"application/json\",\r\n");
      out.write("\t\t\t   data:JSON.stringify({ \r\n");
      out.write("\t\t\t\t   msg_code : checkRow\r\n");
      out.write("\t\t\t   }),\r\n");
      out.write("\t\t\t   success :function(data){\r\n");
      out.write("\t\t \t\t  alert(\"쪽지가 이동되었습니다.\");\r\n");
      out.write("\t\t \t\t  location.reload();\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t\t   ,error :function(error){\r\n");
      out.write("\t\t\t\t alert(\"이동을 실패하였습니다.\");\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t   })\r\n");
      out.write("\t   }\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("   </script>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    ");
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
