/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-18 02:53:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DepScheduleCalendar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("  <!-- fullCalendar -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar/main.min.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar-daygrid/main.min.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar-timegrid/main.min.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar-bootstrap/main.min.css\">\r\n");
      out.write("<style>\r\n");
      out.write("   #calendar {\r\n");
      out.write("    max-width: auto;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("  } \r\n");
      out.write("  .content {\r\n");
      out.write("\tpadding: 50px;\r\n");
      out.write("  }\r\n");
      out.write("  .imp {\r\n");
      out.write("  \tfont-weight:bold;\r\n");
      out.write("  }\r\n");
      out.write("  .container-fluid{\r\n");
      out.write("  \tpadding:0;\r\n");
      out.write("  }\r\n");
      out.write("  #content {\r\n");
      out.write("\tpadding: 50px;\r\n");
      out.write("  }\r\n");
      out.write("  .imp {\r\n");
      out.write("  \tfont-weight:bold;\r\n");
      out.write("  }\r\n");
      out.write("  h2{\r\n");
      out.write("  \tdisplay:inline;\r\n");
      out.write("  \tmargin-left:5px;\r\n");
      out.write("  }\r\n");
      out.write("  #tableBtn{\r\n");
      out.write("  \tmargin-left:20px;\r\n");
      out.write("  }\r\n");
      out.write("  #addSchedule{\r\n");
      out.write("  \tfloat:right;\r\n");
      out.write("  \tmargin-right:8px;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("     <h2>부서 일정 캘린더</h2>\r\n");
      out.write("     <input type=\"button\" id=\"addSchedule\" value=\"일정 등록\" class=\"btn btn-info btn-sm\" onclick=\"window.open('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/plan/dsediter', '부서 일정 등록', 'width=#, height=#')\">\r\n");
      out.write("        \r\n");
      out.write("<!--         <button class=\"btn btn-info btn-sm\" href=\"#\" id=\"addBtn\"> -->\r\n");
      out.write("<!-- \t\t<i class=\"fas fa-pencil-alt\"></i>일정 등록</button> -->\r\n");
      out.write("        \r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t        <div class=\"col-md-3\">\r\n");
      out.write("\t          <div class=\"sticky-top mb-3\">\r\n");
      out.write("\t            <!-- /.card -->\r\n");
      out.write("\t          </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t     </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t    <div class=\"col-md-12\">\r\n");
      out.write("      \t<div class=\"card card-primary\">\r\n");
      out.write("           <div class=\"card-body p-0\">\r\n");
      out.write("          \t\t<section class=\"content-header\">\r\n");
      out.write("\t\t\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"imp\">중요도</span> &nbsp;\r\n");
      out.write("\t\t\t\t\t\t<span class=\"oi oi-minus text-danger\"></span>&nbsp;<span>높음</span>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<span class=\"oi oi-minus text-warning\"></span>&nbsp;<span>중간</span>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<span class=\"oi oi-minus text-info\"></span>&nbsp;<span>낮음</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<button class=\"button showBtn\" id=\"tableBtn\"  data-target=\"#addressTable\" onclick = \"location.href = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/plan/departmentplanbox/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type2}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("' \">\r\n");
      out.write("\t\t\t\t\t<span class=\"oi oi-list icon\"></span>\r\n");
      out.write("\t\t\t\t</button>\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("                <!-- THE CALENDAR -->\r\n");
      out.write("                <div id=\"calendar\"></div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- /.card-body -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.card -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.col -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- fullCalendar 2.2.5 -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/moment/moment.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar/main.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar-daygrid/main.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar-timegrid/main.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar-interaction/main.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fullcalendar-bootstrap/main.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<script> \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write(" \t//모달창 수정 가능/불가능\r\n");
      out.write("     var modalStartDate= $(\".modalStartDate\");\r\n");
      out.write("     var modalEndDate= $(\".modalEndDate\");\r\n");
      out.write("     var modalTitleName= $(\".modalTitleName\");\r\n");
      out.write("     var modalWriter=  $(\".modalWriter\");\r\n");
      out.write("     var modalManager=  $(\".modalManager\");\r\n");
      out.write("     var modalImport=  $(\".modalImport\");\r\n");
      out.write("  \r\n");
      out.write(" \tvar diseditable = function(){ //숨기고 수정못하게 \r\n");
      out.write(" \t\tmodalStartDate.attr('disabled',true);\r\n");
      out.write(" \t\tmodalEndDate.attr('disabled',true);\r\n");
      out.write(" \t\tmodalTitleName.attr('disabled',true);\r\n");
      out.write(" \t\tmodalWriter.attr('disabled',true);\r\n");
      out.write(" \t\tmodalManager.attr('disabled',true);\r\n");
      out.write(" \t\t$(\"#modalImport\").attr('hidden',true);\r\n");
      out.write(" \t}\r\n");
      out.write(" \tvar editable = function(){ //보여주고 수정하게\r\n");
      out.write(" \t\tmodalStartDate.attr('disabled',false);\r\n");
      out.write(" \t\tmodalEndDate.attr('disabled',false);\r\n");
      out.write(" \t\tmodalTitleName.attr('disabled',false);\r\n");
      out.write(" \t\tmodalWriter.attr('disabled',false);\r\n");
      out.write(" \t\tmodalManager.attr('disabled',false);\r\n");
      out.write(" \t\t$(\"#modalImport\").attr('hidden',false);\r\n");
      out.write(" \t}\r\n");
      out.write("\t\r\n");
      out.write(" \t$(\"#addBtn\").on(\"click\",function(){\r\n");
      out.write(" \t\tmodalStartDate.val('');\r\n");
      out.write(" \t\tmodalEndDate.val('');\r\n");
      out.write(" \t\tmodalTitleName.val('');\r\n");
      out.write(" \t\tmodalWriter.val('');\r\n");
      out.write(" \t\tmodalManager.val('');\r\n");
      out.write(" \t\tmodalImport.val('');\r\n");
      out.write(" \t\teditable();\r\n");
      out.write(" \t\t$(\"#modalTitle\").text('부서 일정 등록');\r\n");
      out.write(" \t\t$(\"#okBtn\").text('등록');\r\n");
      out.write(" \t\t$('#calendarModal').modal();\r\n");
      out.write(" \t});\r\n");
      out.write("\t\r\n");
      out.write(" \t//수정 또는 등록\r\n");
      out.write(" \t$(\"#okBtn\").on(\"click\",function(){\r\n");
      out.write(" \t\tvar del = '';\r\n");
      out.write(" \t\tvar ds_start =  modalStartDate.val();//(yyyy-mm-dd)\r\n");
      out.write(" \t\tvar ds_end =  modalEndDate.val();//(yyyy-mm-dd)\r\n");
      out.write(" \t\tvar ds_title = modalEndDate.val();\r\n");
      out.write(" \t\tvar standard_code = modalTitleName.val();\r\n");
      out.write(" \t\tvar emp_code = modalWriter.val();\r\n");
      out.write(" \t\tvar emp_code2 = modalManager.val();\r\n");
      out.write(" \t\tvar ds_important = $('input[name=\"modalImport\"]:checked').val();\r\n");
      out.write(" \t\tif($(\"#okBtn\").text()=='삭제'){\r\n");
      out.write(" \t\t\t$(\"#okBtn\").on(\"click\",function(){\r\n");
      out.write(" \t\t\tif(confirm(\"정말 삭제하시겠습니까?\")==true){\r\n");
      out.write(" \t\t\t\tvar del = 'y'; //controller에서 null return\r\n");
      out.write(" \t\t\t\t$.ajax({\r\n");
      out.write(" \t\t\t\t\ttype : \"POST\",\r\n");
      out.write(" \t\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/plan/depplancalendar\",  //삭제 url\r\n");
      out.write(" \t\t\t\t\tdata : {\r\n");
      out.write(" \t\t\t\t\t\tds_important: modalImport,\r\n");
      out.write(" \t\t\t\t\t\tdel : del\r\n");
      out.write(" \t\t\t\t\t},\r\n");
      out.write(" \t\t\t\t\tsuccess : function(resp) {\r\n");
      out.write(" \t\t\t\t\t\talert($(\"#okBtn\").text()+'되었습니다');\r\n");
      out.write(" \t\t\t\t\t\t$('#calendarModal').modal(\"hide\");\r\n");
      out.write(" \t\t\t\t\t}\r\n");
      out.write(" \t\t\t\t})//ajax\r\n");
      out.write(" \t\t\t}\t\t\t\t\r\n");
      out.write(" \t\t\t});\r\n");
      out.write(" \t\t}\r\n");
      out.write(" \t\tif($(\"#okBtn\").text()=='등록'){\r\n");
      out.write(" \t\t$.ajax({\r\n");
      out.write(" \t\t\ttype : \"POST\",\r\n");
      out.write(" \t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/plan/depplancalendar\", //업데이트 url\r\n");
      out.write(" \t\t\tdata : {\r\n");
      out.write(" \t\t\t\tds_important: modalImport,\r\n");
      out.write(" \t\t\t\tdel : del\r\n");
      out.write(" \t\t\t},\r\n");
      out.write(" \t\t\tsuccess : function(resp) {\r\n");
      out.write(" \t\t\t\talert($(\"#okBtn\").text()+'되었습니다');\r\n");
      out.write(" \t\t\t\t$('#calendarModal').modal(\"hide\");\r\n");
      out.write(" \t\t\t}\r\n");
      out.write(" \t\t})//ajax\r\n");
      out.write(" \t\t}\r\n");
      out.write(" \t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write(" \tvar eventArr = [];\r\n");
      out.write(" \tvar emp_kor = \"\";\r\n");
      out.write(" \tvar title = \"\";\r\n");
      out.write(" \tvar content = \"\";\r\n");
      out.write(" \tvar startdate = \"\";\r\n");
      out.write(" \tvar enddate = \"\"; \r\n");
      out.write(" \tvar important = \"\";\r\n");
      out.write(" \tvar manager = \"\";\r\n");
      out.write(" \tvar manager_name = \"\";\r\n");
      out.write(" \t\r\n");
      out.write(" \tvar getAttList = function(){\r\n");
      out.write(" \t\t$.ajax({\r\n");
      out.write(" \t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/plan/depplancalendar/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write(" \t\t   ,contentType: \"application/x-www-form-urlencoded; charset=UTF-8\"\r\n");
      out.write(" \t\t   ,type:\"post\"\r\n");
      out.write(" \t\t   ,success : function(mp){\r\n");
      out.write(" \t\t\t  console.log(mp);\r\n");
      out.write(" \t\t\t  \r\n");
      out.write(" \t\t\t   var calendarEl = document.getElementById('calendar');\r\n");
      out.write(" \t\t\t    var calendar = new FullCalendar.Calendar(calendarEl, {\r\n");
      out.write(" \t\t\t      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list','interactionPlugin' ],\r\n");
      out.write(" \t\t\t      header: {\r\n");
      out.write(" \t\t\t        left: 'prev,next today',\r\n");
      out.write(" \t\t\t        center: 'title',\r\n");
      out.write(" \t\t\t        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'\r\n");
      out.write(" \t\t\t      },\r\n");
      out.write(" \t\t\t      navLinks: true, // can click day/week names to navigate views\r\n");
      out.write(" \t\t\t      businessHours: true, // display business hours\r\n");
      out.write(" \t\t\t      selectable: true,\r\n");
      out.write(" \t\t\t      selectMirror: true,\r\n");
      out.write(" \t\t\t      eventLimit: true,\r\n");
      out.write(" \t\t\t      navLinks: true,\r\n");
      out.write(" \t\t\t      displayEventTime: false,\r\n");
      out.write(" \t\t\t      height: 750,\r\n");
      out.write(" \t\t\t      allDay : false,\r\n");
      out.write(" \t\t\t      events: mp,      //아무것도 없는 날짜 클릭 했을 때 ->등록모달\r\n");
      out.write(" \t\t\t      select:  function(selectionInfo) {\r\n");
      out.write(" \t\t\t    \t console.log(selectionInfo);\r\n");
      out.write("\t\t    \t       selectionInfo.end.setDate(selectionInfo.end.getDate()-1);\r\n");
      out.write("\t\t    \t       \r\n");
      out.write("\t\t    \t        console.log(selectionInfo.end.toLocaleDateString());\r\n");
      out.write("\t\t    \t        date = new Date(selectionInfo.end.toLocaleDateString()); \r\n");
      out.write("\t\t    \t       var year = date.getFullYear();              //yyyy\r\n");
      out.write("\t\t    \t      var month = (1 + date.getMonth());          //M\r\n");
      out.write("\t\t    \t      month = month >= 10 ? month : '0' + month;  //month 두자리로 저장\r\n");
      out.write("\t\t    \t      var day = date.getDate();                   //d\r\n");
      out.write("\t\t    \t      day = day >= 10 ? day : '0' + day;          //day 두자리로 저장\r\n");
      out.write("\t\t    \t       \r\n");
      out.write("\t\t    \t  startdate = selectionInfo.startStr;\r\n");
      out.write("\t\t    \t  enddate = year + '-' + month + '-' + day;\r\n");
      out.write("//  \t\t\t\t    \t editable();\r\n");
      out.write("//  \t\t\t\t    \tmodalTitleName.val('');\r\n");
      out.write("//  \t\t\t\t    \tmodalImport.val('');\r\n");
      out.write("//  \t\t\t\t\t\t $(\"#modalTitle\").text('부서 일정 등록');\r\n");
      out.write("//  \t\t\t\t\t\t $(\"#okBtn\").text('등록');\r\n");
      out.write("//  \t\t\t\t\t\tmodalStartDate.val(selectionInfo.startStr);\r\n");
      out.write("//  \t\t\t\t\t\tmodalEndDate.val(selectionInfo.startStr);\r\n");
      out.write("//  \t\t\t\t         $('#calendarModal').modal();\r\n");
      out.write(" \t\t\t    \t window.open(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/plan/dsediter\",\"\",'top=0, left=0, width=800, height=556, directories=no, location=no, menubar=no, resizable=no, status=yes, toolbar=no')  ;\r\n");
      out.write(" \t\t\t      },\r\n");
      out.write(" \t\t\t      //이미 있는 이벤트를 클릭했을 때 ->수정모달\r\n");
      out.write(" \t\t\t      eventClick: function(info) {\r\n");
      out.write(" \t\t\t    \t  console.log(info);\r\n");
      out.write("//  \t\t\t    \t  let startdate = info.event.start;\r\n");
      out.write("//  \t\t\t    \t  let enddate = info.event.end;\r\n");
      out.write("//  \t\t\t    \t  let emp_kor = info.event.id;\r\n");
      out.write("//  \t\t\t    \t  startdate = moment(startdate).format('YYYY-MM-DD');\r\n");
      out.write("//  \t\t\t    \t  enddate = moment(enddate).format('YYYY-MM-DD');\r\n");
      out.write("//  \t\t\t    \t  diseditable();\r\n");
      out.write("//  \t\t\t    \t  $(\"#modalTitle\").text('부서 일정 수정');\r\n");
      out.write("//  \t\t\t    \t  $(\"#okBtn\").text('삭제');\r\n");
      out.write("//  \t\t\t    \t $(\".modalWriter\").val(emp_kor);\r\n");
      out.write("//  \t\t\t    \t  $(\".modalStartDate\").val(startdate);\r\n");
      out.write("//  \t\t\t    \t  $(\".modalEndDate\").val(enddate);\r\n");
      out.write("//  \t\t\t    \t  $(\".modalTitleName\").val(info.event.title);\r\n");
      out.write("//  \t\t\t    \t  $(\".modalImport\").find(\"option\").each(function(index){\r\n");
      out.write("//  \t\t\t\t    \t\t if($(this).text()==emp_kor){\r\n");
      out.write("//  \t\t\t\t    \t\t\t $(\".modalImport\").val($(this).val());\r\n");
      out.write("//  \t\t\t\t    \t\t }\r\n");
      out.write("//  \t\t\t\t    \t  });\r\n");
      out.write("//  \t\t\t    \t  $('#calendarModal').modal();\r\n");
      out.write(" \t\t\t    \t\r\n");
      out.write("\t\t\t\t\t     content = info.event.extendedProps.content;\r\n");
      out.write("\t\t\t\t\t\t emp_kor = info.event.id;\r\n");
      out.write("\t\t    \t\t\t startdate = info.event.start;\r\n");
      out.write("\t\t    \t\t\t startdate = moment(startdate).format('YYYY-MM-DD');\r\n");
      out.write("\t\t    \t\t\t enddate = info.event.end;\r\n");
      out.write("\t\t    \t\t\t enddate = moment(enddate).format('YYYY-MM-DD');\r\n");
      out.write("\t\t\t\t\t     title = info.event.title;\r\n");
      out.write("\t\t\t\t\t     important = info.event.extendedProps.ds_important;\r\n");
      out.write("\t\t\t\t\t     manager = info.event.extendedProps.manager;\r\n");
      out.write("\t\t\t\t\t     manager_name = info.event.extendedProps.manager_name;\r\n");
      out.write("\t\t\t\t\t     \r\n");
      out.write("\t\t\t\t\t     \r\n");
      out.write(" \t\t\t      \r\n");
      out.write("\t\t\t\t\t     console.log(info.event.extendedProps)\r\n");
      out.write(" \t\t\t    \t window.open(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/plan/dsediter\",\"\",'top=0, left=0, width=800, height=556, directories=no, location=no, menubar=no, resizable=no, status=yes, toolbar=no')  ;\r\n");
      out.write(" \t\t\t      }\r\n");
      out.write(" \t\t\t    });\r\n");
      out.write(" \t\t\t    calendar.render();\r\n");
      out.write(" \t\t   }\r\n");
      out.write(" \t\t});\t\r\n");
      out.write(" \t}\r\n");
      out.write(" \tgetAttList();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write(" </script>\r\n");
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
}
