/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-18 01:12:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myreportForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/GroupwarePJ/WEB-INF/lib/spring-webmvc-4.3.27.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1588032890000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005fid_005fenctype_005fclass_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005fid_005fenctype_005fclass_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005fid_005fenctype_005fclass_005faction.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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

      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/ckeditor/ckeditor.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t.text, .form-control{display: inline;}\r\n");
      out.write("\t.check{width: 20px; height: 20px}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      if (_jspx_meth_form_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("  <div class=\"modal-dialog modal-dialog-scrollable modal-xl\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">팀 일지 목록</h5>\r\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("        </button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("      \t<table class=\"table\">\r\n");
      out.write("      \t\t<thead>\r\n");
      out.write("      \t\t\t<tr>\r\n");
      out.write("      \t\t\t\t<th>#</th>\r\n");
      out.write("      \t\t\t\t<th>작성일</th>\r\n");
      out.write("      \t\t\t\t<th>일지제목</th>\r\n");
      out.write("      \t\t\t</tr>\r\n");
      out.write("      \t\t</thead>\r\n");
      out.write("      \t\t<tbody id=\"listBody\">\r\n");
      out.write("      \t\t\r\n");
      out.write("      \t\t</tbody>\r\n");
      out.write("      \t</table>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form id=\"searchForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/work/workreport/insertreport\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/dynamicSelect.js?time=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${System.currentTimeMillis()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction fileAttatch(){\r\n");
      out.write("\t    $(\"#attatchDiv\").append(\"<input type='file' name='re_files' style='margin:10px'/>\");\r\n");
      out.write("\t }\r\n");
      out.write("\r\n");
      out.write("\t$()\r\n");
      out.write("\tCKEDITOR.replace('report_content',{\r\n");
      out.write("\t\t // Adding drag and drop image upload.\r\n");
      out.write("\t      uploadUrl: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/image?command=QuickUpload&type=Files&responseType=json',\r\n");
      out.write("\t\r\n");
      out.write("\t     // Configure your file manager integration. This example uses CKFinder 3 for PHP.\r\n");
      out.write("\t      filebrowserImageUploadUrl: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/image?command=QuickUpload&type=Images',\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tvar reportForm = $(\"#reportForm\");\r\n");
      out.write("\t$(\".delBtn\").on(\"click\", function(){\r\n");
      out.write("\t\tlet report_attcode = $(this).data(\"report_attcode\");\r\n");
      out.write("\t\treportForm.append(\r\n");
      out.write("\t\t\t$(\"<input>\").attr({\r\n");
      out.write("\t\t\t\ttype : \"text\"\r\n");
      out.write("\t\t\t\t, name : \"deleteAttatches\"\r\n");
      out.write("\t\t\t\t, value : report_attcode\r\n");
      out.write("\t\t\t})\t\t\r\n");
      out.write("\t\t);\r\n");
      out.write("\t\t$(this).parent(\"span:first\").remove();\r\n");
      out.write("\t}); \r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t$(\"#exampleCheck1\").on(\"click\", function(){\r\n");
      out.write("\t\tif($(this).attr(\"checked\", true)){\r\n");
      out.write("\t\t\t$(this).val(\"Y\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\toptionPtrn = \"<option value='%V' %S>%T</option>\";\r\n");
      out.write("\tvar deptTag = $(\"select[name='dept']\").data(\"success\", function(resp){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar html = \"\";\r\n");
      out.write("\t\t$.each(resp, function(i, dept){\r\n");
      out.write("\t\t\thtml += optionPtrn.replace(\"%V\", dept.dept_code)\r\n");
      out.write("\t\t\t\t\t\t\t  .replace(\"%T\", dept.dept_name)\r\n");
      out.write("\t\t\t\t\t\t\t  .replace(\"%S\", dept.dept_code == \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptlist.dept_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"?\"selected\":\"\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tdeptTag.append(html);\r\n");
      out.write("\t}).on(\"change\", function(){\r\n");
      out.write("\t\tlet dept_code = $(this).val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tteam_codeTag.trigger(\"renew\", {\r\n");
      out.write("\t\t\tdept_code : dept_code\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\temp_targetTag.trigger(\"renew\", {\r\n");
      out.write("\t\t\tdept_code : dept_code\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tvar team_codeTag = $(\"select[name='team_code']\").data(\"success\", function(resp){\r\n");
      out.write("\t\tvar html = \"<option value=''>팀</option>\";\r\n");
      out.write("\t\t$.each(resp, function(i, team){\r\n");
      out.write("\t\t\thtml += optionPtrn.replace(\"%V\", team.team_code)\r\n");
      out.write("\t\t\t\t\t\t\t  .replace(\"%T\", team.team_name)\r\n");
      out.write("\t\t\t\t\t\t\t  .replace(\"%S\", team.team_code == \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${report.team_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" ? \"selected\": \"\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tteam_codeTag.html(html);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tvar emp_targetTag = $(\"select[name='emp_target']\").data(\"success\", function(resp){\r\n");
      out.write("\t\tvar html = \"<option value>보고대상</option>\";\r\n");
      out.write("\t\t$.each(resp, function(i, target){\r\n");
      out.write("\t\t\thtml += optionPtrn.replace(\"%V\", target.emp_code)\r\n");
      out.write("\t\t\t\t\t\t\t  .replace(\"%T\", target.emp_kor)\r\n");
      out.write("\t\t\t\t\t\t\t  .replace(\"%S\", target.emp_code == \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${report.emp_target}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"?\"selected\":\"\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\temp_targetTag.html(html);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$(\".dynamicElement\").dynamicSelect();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t// 모달\r\n");
      out.write("\tvar listBody = $(\"#listBody\");\r\n");
      out.write("\tvar searchForm = $(\"#searchForm\").paging({\r\n");
      out.write("\t\tsearchUI:\"#searchUI\",\r\n");
      out.write("\t\tsearchBtn:\"#searchBtn\",\r\n");
      out.write("\t\tpagination:\"#pagingArea\",\r\n");
      out.write("\t\tpageParam:\"page\",\r\n");
      out.write("\t\tbyAjax:true,\r\n");
      out.write("\t\tsuccess:function(resp){\r\n");
      out.write("\t\t\tlet worklogList = resp.dataList;\r\n");
      out.write("\t\t\tlet pagingHTML = resp.pagingHTML;\r\n");
      out.write("\t\t\tlet trTags = [];\r\n");
      out.write("\t\t\tif(worklogList.length>0){\r\n");
      out.write("\t\t\t\t$.each(worklogList, function(idx, worklog){\r\n");
      out.write("\t\t\t\t\tlet trTag = $(\"<tr>\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"<td>\").text(worklog.rnum)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(worklog.wl_date)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<td>\").text(worklog.wl_title)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t, $(\"<p>\").html('<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" id=\"addWl\" data-code='+worklog.wl_code+' style=\"margin-left:10px;\">추가</button>')\r\n");
      out.write("\t\t\t\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\ttrTags.push(trTag);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tlistBody.html(trTags);\r\n");
      out.write("\t\t\tlistBody.data(\"currentPage\", resp.currentPage);\r\n");
      out.write("\t\t\t$(\"#pagingArea\").html(pagingHTML);\r\n");
      out.write("\t\t\tsearchForm.find(\"[name='page']\").val(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\".modal-body\").on(\"click\",\"button\",function(){\r\n");
      out.write("\t\tlet code = $(this).attr(\"data-code\");\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/work/workreport\"\r\n");
      out.write("\t\t\t,method : \"post\"\r\n");
      out.write("\t\t\t,dataType : \"json\"\r\n");
      out.write("\t\t\t,data : {\r\n");
      out.write("\t\t\t\twl_code : code\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t,success: function(resp){\r\n");
      out.write("\t\t\t\t$(\"input[name=report_title]\").val(resp.wl_title);\r\n");
      out.write("\t\t\t\t$(\"select[name=team_code]\").find(\"option[value=\"+resp.team_code+\" ]\").attr(\"selected\",true);\r\n");
      out.write("\t\t\t\t$(\"select[name=dept]\").find(\"option[value=\"+resp.dept_code+\" ]\").attr(\"selected\",true);\r\n");
      out.write("\t\t\t\t$(\"input[name=report_date]\").val(resp.wl_date);\r\n");
      out.write("\t\t\t\tCKEDITOR.instances.report_content.setData(resp.wl_content);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tlet tags = [];\r\n");
      out.write("\t\t\t\tvar attList = resp.attatchList;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(attList != null){\r\n");
      out.write("\t\t\t\t\t$(\"#orgatt\").css(\"display\", \"inline\");\r\n");
      out.write("\t\t\t\t\tlet spanTag3 = $(\"<span>\").addClass(\"text\").css(\"margin-right\", \"45px\").text(\"기존파일\");\r\n");
      out.write("\t\t\t\t\t$.each(attList, function(idx, attatch){\r\n");
      out.write("\t\t\t\t\t\tconsole.log(attatch);\r\n");
      out.write("\t\t\t\t\t\tlet spanTag1 = $(\"<span>\").addClass(\"eachAttatch\").text(attatch.org_name);\r\n");
      out.write("\t\t\t\t\t\tlet hidden = $(\"<input type='hidden' name='wl_attcode'>\").val(attatch.wl_attcode);\r\n");
      out.write("\t\t\t\t\t\tlet spanTag2 = $(\"<span data-attno='\"+ attatch.wl_attcode +\"'>\").addClass(\"delBtn\").text(\"[DEL] \");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\ttags.push(spanTag3, spanTag1, spanTag2, hidden);\r\n");
      out.write("\t\t\t\t\t\tconsole.log(hidden);\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t$(\"#orgatt\").append(tags);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\".delBtn\").on(\"click\", function(){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("// \t\t\t\t\tlet wl_attcode = $(this).data(\"wl_attcode\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(this).parent().children().eq(1).remove();\r\n");
      out.write("\t\t\t\t\t$(this).parent().children().eq(2).remove();\r\n");
      out.write("\t\t\t\t\t$(this).remove();\r\n");
      out.write("\t\t\t\t}); \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tsearchForm.submit();\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_form_005fform_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005fid_005fenctype_005fclass_005faction.get(org.springframework.web.servlet.tags.form.FormTag.class);
    boolean _jspx_th_form_005fform_005f0_reused = false;
    try {
      _jspx_th_form_005fform_005f0.setPageContext(_jspx_page_context);
      _jspx_th_form_005fform_005f0.setParent(null);
      // /WEB-INF/views/work/myreportForm.jsp(14,0) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_form_005fform_005f0.setId("reportForm");
      // /WEB-INF/views/work/myreportForm.jsp(14,0) name = modelAttribute type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_form_005fform_005f0.setModelAttribute("report");
      // /WEB-INF/views/work/myreportForm.jsp(14,0) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_form_005fform_005f0.setMethod("post");
      // /WEB-INF/views/work/myreportForm.jsp(14,0) name = enctype type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_form_005fform_005f0.setEnctype("multipart/form-data");
      // /WEB-INF/views/work/myreportForm.jsp(14,0) null
      _jspx_th_form_005fform_005f0.setDynamicAttribute(null, "class", "w-100");
      // /WEB-INF/views/work/myreportForm.jsp(14,0) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_form_005fform_005f0.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }/work/workreport/insertreport", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_form_005fform_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_form_005fform_005f0 = _jspx_th_form_005fform_005f0.doStartTag();
        if (_jspx_eval_form_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t<div class = \"content\" style=\"margin: 40px 60px 0 60px\">\r\n");
            out.write("\t\t<div class=\"card card-primary\" style=\"width: 100%;\">\r\n");
            out.write("\t\t\t<div class=\"card-header\" >\r\n");
            out.write("\t\t\t\t<h3 class=\"card-title\">업무보고 작성</h3>\r\n");
            out.write("\t\t\t</div>\r\n");
            out.write("\t\t\t<form role=\"form\">\r\n");
            out.write("\t\t\t\t<div class=\"card-body\" style=\"width: 100%; padding: 20px 40px 20px 40px\">\r\n");
            out.write("\t\t\t\t\t<input type=\"hidden\" name=\"report_code\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${report.report_code }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("\t\t\t\t\r\n");
            out.write("\t\t\t\t\t<span class=\"text\" style=\"margin-right: 30px\">일지첨부</span> \r\n");
            out.write("\t\t\t\t\t<button  id=\"att\" type=\"button\" class=\"btn btn-primary btn-sm\" data-toggle=\"modal\" data-target=\"#exampleModal\"> 첨부 </button><br><br>\r\n");
            out.write("<!-- \t\t\t\t\t<input type=\"button \" id=\"att\" class=\"btn btn-primary btn-sm\" data-toggle=\"modal\" data-target=\"#exampleModal\"><br><br> -->\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t<span class=\"text\" style=\"margin-right: 60px\">제목</span> \r\n");
            out.write("\t\t\t\t\t\t<input class=\"form-control\" type=\"text\" style=\"width: 80%\" name=\"report_title\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${report.report_title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"><br><br>\r\n");
            out.write("\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t<span class=\"text\" style=\"margin-right: 60px\">부서</span> \r\n");
            out.write("\t\t\t\t\t<select class=\"dynamicElement form-control select2bs4 select2-hidden-accessible\" style=\"width: 30%; margin-right: 40px;\" data-select2-id=\"17\" tabindex=\"-1\" aria-hidden=\"true\" \r\n");
            out.write("\t\t\t\t\t\t\tname=\"dept\" data-url=\"");
            if (_jspx_meth_c_005furl_005f0(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
              return true;
            out.write("\">\r\n");
            out.write("\t\t\t\t\t\t<option selected disabled>부서</option>\r\n");
            out.write("\t\t\t\t\t</select> \r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t<span class=\"text\" style=\"margin-right: 60px\">팀</span> \r\n");
            out.write("\t\t\t\t\t<select class=\"dynamicElement form-control select2bs4 select2-hidden-accessible\" style=\"width: 30%; margin-right: 40px;\" data-select2-id=\"17\" tabindex=\"-1\" aria-hidden=\"true\" \r\n");
            out.write("\t\t\t\t\t\t\tname=\"team_code\" data-url=\"");
            if (_jspx_meth_c_005furl_005f1(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
              return true;
            out.write("\">\r\n");
            out.write("\t\t\t\t\t\t<option selected disabled>팀</option>\r\n");
            out.write("\t\t\t\t\t</select><br><br>\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t<span class=\"text\" style=\"margin-right: 45px\">보고일</span> \r\n");
            out.write("\t\t\t\t\t<input class=\"form-control\" type=\"date\" style=\"width: 80%\" name=\"report_date\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${report.report_date }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"><br><br>\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t<span class=\"text\" style=\"margin-right: 30px\">보고대상</span> \r\n");
            out.write("\t\t\t\t\t<select class=\"dynamicElement form-control select2bs4 select2-hidden-accessible\" style=\"width: 30%; margin-right: 40px;\" data-select2-id=\"17\" tabindex=\"-1\" aria-hidden=\"true\" \r\n");
            out.write("\t\t\t\t\t\t\tname=\"emp_target\" data-url=\"");
            if (_jspx_meth_c_005furl_005f2(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
              return true;
            out.write("\">\r\n");
            out.write("\t\t\t\t\t\t<option selected disabled>보고대상</option>\r\n");
            out.write("\t\t\t\t\t</select><br><br>\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("<!-- \t\t\t\t\t<span class=\"text\" style=\"margin-right: 23px\">도장/사인</span>  -->\r\n");
            out.write("<!-- \t\t\t\t\t<input type=\"file\" name=\"report_stamp\"><br><br> -->\r\n");
            out.write("\r\n");
            out.write('\r');
            out.write('\n');
            out.write('\r');
            out.write('\n');
            out.write('\r');
            out.write('\n');
            out.write('\r');
            out.write('\n');
            out.write("\r\n");
            out.write("<!-- \t\t\t\t\t\t\t</span> -->\r\n");
            out.write('\r');
            out.write('\n');
            out.write("\r\n");
            out.write("\r\n");
            out.write("\t\t\t\t\t<div style=\"display: none\" id=\"orgatt\">\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t</div><br>\r\n");
            out.write("\t\t\t\t\t<span class=\"text\" style=\"margin-right: 60px\">첨부</span> \r\n");
            out.write("\t\t\t\t\t<!-- 첨부파일 -->\r\n");
            out.write("\t\t\t        <input type=\"button\" id=\"btnAttatch\" class=\"btn btn-default\" value=\"파일첨부\" onclick=\"fileAttatch()\">\r\n");
            out.write("\t\t\t        <div id=\"attatchDiv\"  style=\"display: inline-block;\"></div><br><br>\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t<span class=\"text\" style=\"margin-right: 60px\">내용</span><br><br>\r\n");
            out.write("\t\t\t\t\t<textarea class=\"form-control\" id=\"report_content\" name=\"report_content\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${report.report_content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"> </textarea> \r\n");
            out.write("\t\t\t\t\t\r\n");
            out.write("\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t<div class=\"card-footer\">\r\n");
            out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary float-right\" id=\"save\">등록</button>\r\n");
            out.write("\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t</form>\r\n");
            out.write("\t\t</div>\r\n");
            out.write("\t</div>\r\n");
            int evalDoAfterBody = _jspx_th_form_005fform_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_form_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_form_005fform_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_form_005fform_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_form_005fform_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005fid_005fenctype_005fclass_005faction.reuse(_jspx_th_form_005fform_005f0);
      _jspx_th_form_005fform_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_form_005fform_005f0, _jsp_getInstanceManager(), _jspx_th_form_005fform_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
      // /WEB-INF/views/work/myreportForm.jsp(35,29) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/work/getDeptList");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
      // /WEB-INF/views/work/myreportForm.jsp(41,34) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/work/getTeamList");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f2_reused = false;
    try {
      _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
      // /WEB-INF/views/work/myreportForm.jsp(50,35) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f2.setValue("/work/getEmpList");
      int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
      if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      _jspx_th_c_005furl_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f2, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f2_reused);
    }
    return false;
  }
}