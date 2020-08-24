/**
 * 
 */

var loadingArea = $("#loadingArea").css({
	"position":"absolute",
	"width":"100%",
	"height":"100%",
	"z-index":9000
}).hide();

$( document ).ajaxStart(function() {
	loadingArea.show();
});

$( document ).ajaxStop(function() {
	loadingArea.hide();
	$(document).scrollTop(0);
	$(document).scrollLeft(0);
});

$(document).on("scroll", function(){
	loadingArea.css({
		top:document.scrollingElement.scrollTop,
		left:document.scrollingElement.scrollLeft
	});
});

var topHeader = $("#topHeader");
var bodyContent = $("#bodyContent").on("submit", "form", function(){
	let action = $(this).attr("action");
	let method = $(this).attr("method");
	let isMultipart = this.enctype.startsWith("multipart");
	let data = null;
	if(isMultipart){
		data = new FormData(this);
	}else{
		data = $(this).serialize();
	}
	let contentType = isMultipart?false:this.enctype;
	let processData = !isMultipart;
	$.ajax({
		url:action,
		method:method,
		data:data,
		processData:processData,
		contentType:contentType,
		dataType:"html",
		success:function(resp){
			bodyContent.html(resp);
			history.pushState({html:resp}, '', action);
		}		
	});
	return false;
});
$(document).ajaxError(function(resp){
	console.log(resp);
});

$("body, .unfold").on("click", "a.byAjax", function(){
	let url = $(this).attr("href");
	
	if(url=='#') return false;
	else if($(this).hasClass("noAjax")) return true;
	$.ajax({
		url:url,
		method:"get",
		dataType:"html",
		success:function(resp){
			bodyContent.html(resp);
			history.pushState({
				html:resp
				, url:url
			}, '', url);
			sameSideBarMenu(url);
			sameTopMenu(url);
		}
	});
	return false;
});
var sidebar = $("#sidebar").on("click", "li.side-nav-menu-item", function(){
	sidebar.find(".side-nav-menu-second-level>li.side-nav-menu-item").removeClass("side-nav-opened");
});

function sameSideBarMenu(url){
	sidebar.find("li").removeClass("active");
	if(sidebar.find("a[href='"+url+"']").length==0 || !sidebar.find("a[href='"+url+"']").parent("li:first").hasClass("side-nav-has-menu")){ 
		sidebar.find("li.side-nav-opened").find("a:first").click();
	}
	sidebar.find("a[href='"+url+"']").parent("li:first").addClass("active");
	if(!sidebar.find("a[href='"+url+"']").parents("li.side-nav-has-menu").hasClass("side-nav-opened")){
		sidebar.find("a[href='"+url+"']").parents("li.side-nav-has-menu").find("a:first").click();
	}
}
function sameTopMenu(url){
	topHeader.find(".header-content>div>a").removeClass("active");
	topHeader.find("a[href='"+url+"']").addClass("active");
}


$(window).on("popstate", function(event){
	
	if(event.originalEvent.state){
		let state = event.originalEvent.state;
		bodyContent.html(state.html);
		if(state.url){
			sidebar.find("li").removeClass("active");
			sidebar.find("a[href='"+state.url+"']").parent("li:first").addClass("active");
		}
	}
});
history.pushState({html:bodyContent.html()}, '', '');