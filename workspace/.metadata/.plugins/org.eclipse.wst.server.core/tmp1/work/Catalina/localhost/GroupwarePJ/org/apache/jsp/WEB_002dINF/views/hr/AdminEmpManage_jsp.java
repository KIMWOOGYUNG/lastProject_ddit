/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-19 04:14:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.hr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminEmpManage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t#content {padding: 30px;}\r\n");
      out.write("\t.chkBox {width: 15px;height: 15px;}\r\n");
      out.write("\t#nav{float:right;width:140px;margin-top:10px;}\r\n");
      out.write("\th2{margin:10px 0 30px 0;}\r\n");
      out.write("\t#searchBtn{width:40px; heigth:40px;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<div class=\"col-12\">\r\n");
      out.write("\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t\t<h2>전 사원 관리</h2>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- 검색 -->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\" id=\"searchUI\">\r\n");
      out.write("\t\t\t\t\t<select name=\"searchType\" class=\"form-control select2 select2-hidden-accessible\" style=\"width: 10%; float: left\" data-select2-id=\"1\" tabindex=\"-1\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\" data-select2-id=\"3\" selected disabled>검색 방법</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"empnum\" \r\n");
      out.write("\t\t\t\t\t\t\tdata-select2-id=\"34\">사원번호</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"empnm\" \r\n");
      out.write("\t\t\t\t\t\t\tdata-select2-id=\"35\">사원명</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"deptnm\" \r\n");
      out.write("\t\t\t\t\t\t\tdata-select2-id=\"36\">부서명</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"teamnm\" \r\n");
      out.write("\t\t\t\t\t\t\tdata-select2-id=\"36\">팀명</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"position\" \r\n");
      out.write("\t\t\t\t\t\t\tdata-select2-id=\"36\">직급</option>\r\n");
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
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"nav\">\r\n");
      out.write("\t\t\t\t\t<a class=\"btn btn-primary btn-sm\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/hr/employer/empenroll\">\r\n");
      out.write("\t\t\t\t        <i class=\"fas fa-folder\">\r\n");
      out.write("\t\t\t\t        </i>\r\n");
      out.write("\t\t\t\t       \t 등록\r\n");
      out.write("\t\t\t\t    </a>\r\n");
      out.write("<!-- \t\t\t\t    <button class=\"btn btn-danger btn-sm\" onclick=\"deleteAction()\"> -->\r\n");
      out.write("<!-- \t\t\t\t        <i class=\"fas fa-trash\"> -->\r\n");
      out.write("<!-- \t\t\t\t        </i> -->\r\n");
      out.write("<!-- \t\t\t\t    \t 삭제 -->\r\n");
      out.write("<!-- \t\t\t\t    </button> -->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"card-body table-responsive p-0\">\r\n");
      out.write("\t\t\t\t <table class=\"table table-hover text-nowrap\">      \r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t   <tr>\r\n");
      out.write("\t\t\t\t\t\t   <th rowspan=\"1\" colspan=\"1\">선택</th>\r\n");
      out.write("\t\t\t\t\t\t   <th rowspan=\"1\" colspan=\"1\">사원번호</th>\r\n");
      out.write("\t\t\t\t\t\t   <th rowspan=\"1\" colspan=\"1\">사원명</th>\r\n");
      out.write("\t\t\t\t\t\t   <th rowspan=\"1\" colspan=\"1\">부서명</th>\r\n");
      out.write("\t\t\t\t\t\t   <th rowspan=\"1\" colspan=\"1\">팀명</th>\r\n");
      out.write("\t\t\t\t\t\t   <th rowspan=\"1\" colspan=\"1\">직급</th>\r\n");
      out.write("\t\t\t\t\t\t   <th rowspan=\"1\" colspan=\"1\">메일</th>\r\n");
      out.write("\t\t\t\t\t\t   <th rowspan=\"1\" colspan=\"1\">내선번호</th>\r\n");
      out.write("\t\t\t\t\t   </tr>\r\n");
      out.write("\t\t\t\t    </thead>\r\n");
      out.write("\t                <tbody id=\"listBody\">\r\n");
      out.write("\t               \r\n");
      out.write("\t                </tbody>\r\n");
      out.write("                 </table>\r\n");
      out.write("             </div>\r\n");
      out.write("             <div style=\"margin:20px 20px 20px 20px;\">\r\n");
      out.write("\t\t\t\t<nav id=\"pagingArea\" class=\"d-flex ml-md-auto d-print-none\">\r\n");
      out.write("\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagingVO.pagingHTML }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t</nav>\t\r\n");
      out.write("\t\t\t </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<form id=\"searchForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/hr/employer/entiremanage\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"searchType\" value=\"\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"searchWord\" value=\"\"/>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("//테이블 만들기\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar listBody = $(\"#listBody\");\r\n");
      out.write("\t\tvar searchForm = $(\"#searchForm\").paging({\r\n");
      out.write("\t\t\tsearchUI:\"#searchUI\",\r\n");
      out.write("\t\t\tsearchBtn:\"#searchBtn\",\r\n");
      out.write("\t\t\tpagination:\"#pagingArea\",\r\n");
      out.write("\t\t\tpageParam:\"page\",\r\n");
      out.write("\t\t\tbyAjax:true,\r\n");
      out.write("\t\t\tsuccess:function(resp){\r\n");
      out.write("\t\t\t\tlet empList = resp.dataList;\r\n");
      out.write("\t\t\t\tlet pagingHTML = resp.pagingHTML;\r\n");
      out.write("\t\t\t\tlet trTags = [];\r\n");
      out.write("\t\t\t\tif(empList.length>0){\r\n");
      out.write("\t\t\t\t\t$.each(empList, function(idx, empmanage){\r\n");
      out.write("\t\t\t\t\t\tif(empmanage.retire_date==null){\r\n");
      out.write("\t\t\t\t\t\tlet trTag = $(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"<td>\").html('<input type=\"checkbox\" name=\"checkRow\" value=\"'+empmanage.emp_code+'\" />')\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(empmanage.emp_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t, $(\"<td>\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"<a>\").attr(\"href\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/hr/employer/detailempinfo/\" + empmanage.emp_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t.text(empmanage.emp_kor)\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(empmanage.dept_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(empmanage.team_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(empmanage.position_code)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(empmanage.emp_mail)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(empmanage.co_phone)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t$(\"#pagingArea\").html(pagingHTML);\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\ttrTags.push($(\"<tr>\").html($(\"<td colspan='8'>\").text(\"조건에 맞는 사원이 없음.\")));\r\n");
      out.write("\t\t\t\t\t$(\"#pagingArea\").empty();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tlistBody.html(trTags);\r\n");
      out.write("\t\t\t\tlistBody.data(\"currentpage\", resp.currentPage);\r\n");
      out.write("\t\t\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}).submit();\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("//전체 선택\r\n");
      out.write("\tfunction checkAll(){\r\n");
      out.write("\t      if( $(\"#th_checkAll\").is(':checked') ){\r\n");
      out.write("\t        $(\"input[name=checkRow]\").prop(\"checked\", true);\r\n");
      out.write("\t      }else{\r\n");
      out.write("\t        $(\"input[name=checkRow]\").prop(\"checked\", false);\r\n");
      out.write("\t      }\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("//체크된것 삭제(체크박스된 것 전부)\r\n");
      out.write("\tfunction deleteAction(){\r\n");
      out.write("\t  var checkRow = \"\";\r\n");
      out.write("\t  $( \"input[name='checkRow']:checked\" ).each (function (){\r\n");
      out.write("\t    checkRow = checkRow + $(this).val()+\",\" ;\r\n");
      out.write("\t  });\r\n");
      out.write("\t  checkRow = checkRow.substring(0,checkRow.lastIndexOf( \",\")); //맨끝 콤마 지우기\r\n");
      out.write("\t \r\n");
      out.write("\t  if(checkRow == ''){\r\n");
      out.write("\t    alert(\"삭제할 사원을 선택하세요.\");\r\n");
      out.write("\t    return false;\r\n");
      out.write("\t  }\r\n");
      out.write("\t  console.log(\"### checkRow => {}\"+checkRow);\r\n");
      out.write("\t \r\n");
      out.write("\t  if(confirm(\"사원정보를 삭제 하시겠습니까?\")){\r\n");
      out.write("\t\t  $.ajax({\r\n");
      out.write("\t            url : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/hr/employer/deleteemp',\r\n");
      out.write("\t            type : \"POST\",\r\n");
      out.write("\t            datatype : 'json',\r\n");
      out.write("\t            contentType: \"application/x-www-form-urlencoded; charset=UTF-8\", \r\n");
      out.write("\t            data:{\r\n");
      out.write("\t                emp_code : checkRow\r\n");
      out.write("\t            },\r\n");
      out.write("\t            success : function(data) {\r\n");
      out.write("\t\t\t\t    alert(\"삭제가 완료되었습니다.\");\r\n");
      out.write("\t\t\t\t    location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/hr/employer/entiremanage/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${who}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t                \r\n");
      out.write("\t            },\r\n");
      out.write("\t            error:function(request, status, error) {\r\n");
      out.write("\t            \talert(\"삭제를 실패하였습니다.\");\r\n");
      out.write("\t \r\n");
      out.write("\t            }\r\n");
      out.write("\t\t })\r\n");
      out.write("\t        \r\n");
      out.write("\r\n");
      out.write("\t  }\r\n");
      out.write("\t \r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("               \r\n");
      out.write("                \r\n");
      out.write("                   \r\n");
      out.write("             ");
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
