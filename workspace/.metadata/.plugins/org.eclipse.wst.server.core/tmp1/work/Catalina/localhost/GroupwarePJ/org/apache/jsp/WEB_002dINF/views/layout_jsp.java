/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-08-24 02:27:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.commons.lang3.StringUtils;

public final class layout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/tiles-jsp-3.0.8.jar", Long.valueOf(1593409599707L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1593409600303L));
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/GroupwarePJ/WEB-INF/lib/tiles-jsp-3.0.8.jar!/META-INF/tld/tiles-jsp.tld", Long.valueOf(1506773284000L));
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/GroupwarePJ/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.apache.commons.lang3.StringUtils");
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
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("  <title>GroupWare!</title>\r\n");
      out.write("  \r\n");
      out.write("  <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <!-- Font Awesome -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/fontawesome-free/css/all.min.css\">\r\n");
      out.write("  <!-- Ionicons -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css\">\r\n");
      out.write("   <!-- Theme style -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/dist/css/adminlte.min.css\">\r\n");
      out.write("   <!-- Google Font: Source Sans Pro -->\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700\" rel=\"stylesheet\">\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("  <!-- Tempusdominus Bbootstrap 4 -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css\">\r\n");
      out.write("  <!-- iCheck -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/open-iconic-master/font/css/open-iconic-bootstrap.css\">\r\n");
      out.write("  <!-- JQVMap -->\r\n");
      out.write("  <!--link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/jqvmap/jqvmap.min.css\"--!>\r\n");
      out.write("  <!-- overlayScrollbars -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css\">\r\n");
      out.write("  <!-- Daterange picker -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/daterangepicker/daterangepicker.css\">\r\n");
      out.write("  <!-- summernote -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/summernote/summernote-bs4.css\">\r\n");
      out.write(" \r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/left.css\">\r\n");
      out.write(" <!-- jQuery -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/jquery/jquery.min.js\"></script>\r\n");
      out.write("<!-- jQuery UI 1.11.4 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/jquery-ui/jquery-ui.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap 4 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<!-- overlayScrollbars -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/dist/js/adminlte.js\"></script>\r\n");
      out.write("<!-- AdminLTE for demo purposes -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/dist/js/demo.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 아이콘 사용 -->\r\n");
      out.write("<script src=\"https://unpkg.com/ionicons@5.1.2/dist/ionicons.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/paging.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body class=\"hold-transition sidebar-mini layout-fixed\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\t<nav class=\"main-header navbar navbar-expand navbar-white navbar-light\">\r\n");
      out.write("\t \t");
      if (_jspx_meth_tiles_005finsertAttribute_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t<aside class=\"main-sidebar sidebar-dark-primary elevation-4\">\r\n");
      out.write("\t \t");
      if (_jspx_meth_tiles_005finsertAttribute_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</aside>\r\n");
      out.write(" <div class=\"content-wrapper\"> \r\n");
      out.write(" \t");
      if (_jspx_meth_tiles_005finsertAttribute_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write(" </div>\r\n");
      out.write(" \r\n");
      out.write("  <!-- Control Sidebar -->\r\n");
      out.write(" <aside class=\"control-sidebar control-sidebar-dark\">\r\n");
      out.write("    <!-- Control sidebar content goes here -->\r\n");
      out.write(" </aside>\r\n");
      out.write(" \r\n");
      out.write("  <!-- /.control-sidebar -->\r\n");
      out.write("  <div id=\"sidebar-overlay\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- ./wrapper -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->\r\n");
      out.write("<script>\r\n");
      out.write("  $.widget.bridge('uibutton', $.ui.button)\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar ws;\r\n");
      out.write("\tfunction connect(){\t\r\n");
      out.write("\t \tconst protocol = location.protocol == \"http:\"?\"ws:\":\"wss:\";\r\n");
      out.write("\t\tconst domain = location.hostname;\r\n");
      out.write("\t\tconst port = location.port!=\"\"?\":\"+location.port:\"\";\r\n");
      out.write("\t\tconst address = protocol+\"//\"+domain+port+\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pushMessage\";\r\n");
      out.write("\t\t$(\"#url\").val(address);\r\n");
      out.write("\t\t\tws = new WebSocket(address);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tws.onmessage = function(e){\r\n");
      out.write("\t\t\t\tlet data = JSON.parse(e.data);\r\n");
      out.write("\t\t\t\tlet title = data.title;\r\n");
      out.write("\t\t\t\tlet content = data.content;\r\n");
      out.write("\t\t\t\tlet date = data.data;\r\n");
      out.write("\t\t\t\tlet type = data.type == 'draft'?'far fa-copy':'fas fa-envelope fa-lg';\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t $(document).Toasts('create', {\r\n");
      out.write("\t\t\t\t        body: content,\r\n");
      out.write("\t\t\t\t        title: title,\r\n");
      out.write("\t\t\t\t        subtitle: date,\r\n");
      out.write("\t\t\t\t        autohide: true,\r\n");
      out.write("\t\t\t\t        delay: 5000,\r\n");
      out.write("\t\t\t\t        icon: type,\r\n");
      out.write("\t\t\t\t        position:\"topRight\"\r\n");
      out.write("\t\t\t\t      });\r\n");
      out.write("\t\t\t\t      \r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t\tlet node = $(\"#topsideMenu\").find(\".\"+data.type);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tlet parentNode = node.find(\"span\");\r\n");
      out.write("\t\t\tlet childrenNode = node.find(\".dropdown-menu\");\r\n");
      out.write("\t\t\t\t console.log(parentNode);\r\n");
      out.write("\t\t\t\t console.log(childrenNode);\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t   \t $.ajax({\r\n");
      out.write("\t\t\t\t\t  url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pushmesage/\"+data.type\r\n");
      out.write("\t\t\t\t\t , method : \"get\"\r\n");
      out.write("\t\t\t\t\t , dataType : \"json\"\r\n");
      out.write("\t\t\t\t\t , success : function(desp){\r\n");
      out.write("\t\t\t\t\t\t console.log(desp);\r\n");
      out.write("\t\t\t\t\t\tlet tags = []\r\n");
      out.write("\t\t\t\t\t\t$(parentNode).text(desp.length);\r\n");
      out.write("\t\t\t\t\t\tif(desp != null && desp.length > 0){\r\n");
      out.write("\t\t\t\t\t\t\t$.each(desp,function(idx,push){\r\n");
      out.write("\t\t\t\t\t\t\t\t  let tag = $(\"<a>\").addClass(\"dropdown-item\").attr({\"href\":\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pushmesage/\"+push.push_code}).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t   $(\"<div>\").addClass(\"media\").append($(\"<div>\").addClass(\"media-body\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t   \t$(\"<h3>\").addClass(\"dropdown-item-title\").text(push.title)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t,$(\"<p>\").addClass(\"text-sm\").text(push.content)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t,$(\"<p>\").addClass(\"text-sm text-muted\").text(push.push_date).prepend($(\"<i>\").addClass(\"far fa-clock mr-1\")))))\r\n");
      out.write("\t\t\t\t\t\t\t\t tags.push(tag);\r\n");
      out.write("\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\tlet tag = $(\"<a>\").addClass(\"dropdown-item\").attr({\"href\":\"#\"}).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t   $(\"<div>\").addClass(\"media\").append($(\"<div>\").addClass(\"media-body\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t   \t$(\"<h3>\").addClass(\"dropdown-item-title\").text()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t,$(\"<p>\").addClass(\"text-sm\").text(\"알람이 없습니다.\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t)));\r\n");
      out.write("\t\t\t\t\t\t tags.push(tag);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t$(childrenNode).html(tags);\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t   });\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tconnect();\r\n");
      out.write("\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("  \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_tiles_005finsertAttribute_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f0 = new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jsp_getInstanceManager().newInstance(_jspx_th_tiles_005finsertAttribute_005f0);
    try {
      _jspx_th_tiles_005finsertAttribute_005f0.setJspContext(_jspx_page_context);
      // /WEB-INF/views/layout.jsp(74,3) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005finsertAttribute_005f0.setName("topMenu");
      _jspx_th_tiles_005finsertAttribute_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_tiles_005finsertAttribute_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f1 = new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jsp_getInstanceManager().newInstance(_jspx_th_tiles_005finsertAttribute_005f1);
    try {
      _jspx_th_tiles_005finsertAttribute_005f1.setJspContext(_jspx_page_context);
      // /WEB-INF/views/layout.jsp(78,3) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005finsertAttribute_005f1.setName("leftMenu");
      _jspx_th_tiles_005finsertAttribute_005f1.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_tiles_005finsertAttribute_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f2 = new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jsp_getInstanceManager().newInstance(_jspx_th_tiles_005finsertAttribute_005f2);
    try {
      _jspx_th_tiles_005finsertAttribute_005f2.setJspContext(_jspx_page_context);
      // /WEB-INF/views/layout.jsp(81,2) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005finsertAttribute_005f2.setName("content");
      _jspx_th_tiles_005finsertAttribute_005f2.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_tiles_005finsertAttribute_005f2);
    }
    return false;
  }
}