<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<style>
	.text, .form-control{display: inline;}
	.check{width: 20px; height: 20px}
	
	#content {
		padding: 50px;
	}
	
	.date {
		margin-right: 400px;
	}
	
	.list-inline-item {
		display: inline;
		float: left;
	}
	
	.inline-chart {
		width: 100px;
	}
	
	.btnAction {
		float: right;
		width: 65px;
		margin-left: 5px;
	}
	
	h3 {
		width: 700px;
		display: inline
	}
	
 	.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;} 
 	.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;} 
 	.map_wrap {position:relative;width:100%;height:500px;} 
 	#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;} 
 	.bg_white {background:#fff;} 
 	#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;} 
 	#menu_wrap .option{text-align: center;} 
 	#menu_wrap .option p {margin:10px 0;}   
 	#menu_wrap .option button {margin-left:5px;} 
 	#placesList li {list-style: none;} 
 	#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;} 
 	#placesList .item span {display: block;margin-top:4px;} 
 	#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;} 
 	#placesList .item .info{padding:10px 0 10px 55px;} 
 	#placesList .info .gray {color:#8a8a8a;} 
 	#placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;} 
 	#placesList .info .tel {color:#009900;} 
 	#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;} 
 	#placesList .item .marker_1 {background-position: 0 -10px;} 
 	#placesList .item .marker_2 {background-position: 0 -56px;} 
 	#placesList .item .marker_3 {background-position: 0 -102px} 
 	#placesList .item .marker_4 {background-position: 0 -148px;} 
 	#placesList .item .marker_5 {background-position: 0 -194px;} 
 	#placesList .item .marker_6 {background-position: 0 -240px;} 
 	#placesList .item .marker_7 {background-position: 0 -286px;} 
 	#placesList .item .marker_8 {background-position: 0 -332px;} 
 	#placesList .item .marker_9 {background-position: 0 -378px;} 
 	#placesList .item .marker_10 {background-position: 0 -423px;} 
 	#placesList .item .marker_11 {background-position: 0 -470px;}
 	#placesList .item .marker_12 {background-position: 0 -516px;} 
 	#placesList .item .marker_13 {background-position: 0 -562px;} 
 	#placesList .item .marker_14 {background-position: 0 -608px;} 
 	#placesList .item .marker_15 {background-position: 0 -654px;} 
 	#pagination {margin:10px auto;text-align: center;} 
 	#pagination a {display:inline-block;margin-right:10px;} 
 	#pagination .on {font-weight: bold; cursor: default;color:#777;} 
</style>

<div id="content">
	<div class="card card-info">
		<div class="card-header">
			<h3>${board.board_title}</h3>
			<button class="btn btn-block bg-gradient-secondary btn-sm btnAction"
				id="btnUpdate" style="margin-top: 0px;"
				onclick="location.href='${cPath }/board/boardList/${pos}'">
				<i class="fas fa-pencil-alt"> </i> 목록
			</button>
			<c:url
				value="/board/boardList/insertForm/${board.board_code }/${pos }"
				var="childBoardURL">
				<c:param name="parent_board" value="${board.board_code }" />
			</c:url>
<!-- 			<button class="btn btn-block bg-gradient-secondary btn-sm btnAction" -->
<!-- 				id="btnUpdate" style="margin-top: 0px;" -->
<%-- 				onclick="location.href='${childBoardURL}';"> --%>
<!-- 				<i class="fas fa-pencil-alt"> </i> 답글 -->
<!-- 			</button> -->
			<button class="btn btn-block bg-gradient-secondary btn-sm btnAction"
				id="btnUpdate" style="margin-top: 0px;"
				onclick="location.href='${cPath }/board/boardList/updateBoard/${board_code}/${pos}'">
				<i class="fas fa-pencil-alt"> </i> 수정
			</button>
			<button class="btn btn-block bg-gradient-danger btn-sm btnAction" id="deleteBtn" style="margin-top: 0px;">
				<i class="fas fa-trash"> </i> 삭제
			</button>
		</div>

		<!-- form start -->
		<form class="form-horizontal">
			<div class="card-body">
				<input type="hidden" name="board_code" value="${board.board_code }" />
				<div class="form-group row">
					<label for="board_title" class="col-sm-1 col-form-label" style="margin-right: 64px;">제목</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="board_title"
							placeholder="제목" value="${board.board_title }" readonly
							style="background: white;">
					</div>
				</div>
				<div class="form-group row">
					<label for="board_title" class="col-sm-1 col-form-label" style="margin-right: 64px;">작성자</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emp_code"
							placeholder="작성자" value="${board.emp_code }" readonly
							style="background: none;">
					</div>
				</div>
				<div class="form-group row">
					<label for="board_title" class="col-sm-1 col-form-label" style="margin-right: 64px;">작성날짜</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="board_date"
							placeholder="작성날짜" value="${board.board_date }" readonly
							style="background: none;">
					</div>
				</div>
				<div class="form-group row">
					<label for="board_title" class="col-sm-1 col-form-label" style="margin-right: 64px;">조회수</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="board_hit"
							placeholder="조회수" value="${board.board_hit }" readonly
							style="background: none;">
					</div>
				</div>
				<div class="form-group row">
					<label for="board_title" class="col-sm-1 col-form-label" style="margin-right: 64px;">첨부파일</label>
					<div class="col-sm-10">
						<c:forEach items="${board.attatchList }" var="attatch"
							varStatus="vs">
							<a href="<c:url value='/board/file/${attatch.board_attcode}' />">${attatch.org_name }</a> ${not vs.last?"&nbsp;":"" }
								</c:forEach>
					</div>
				</div>
				<div class="form-group row">
					<label for="form-group row" class="col-sm-1 col-form-label" style="margin-right: 64px;">주소</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="board_address"
							placeholder="주소" value="${board.board_address }" readonly
							style="background: white;">
					</div>
				</div>
				<div class="form-group row">
					<label for="board_title" class="col-sm-1 col-form-label" style="margin-right: 64px;">내용</label>
					<div class="col-sm-10">${board.board_content }</div>
				</div>
				<c:if test="${not empty board.board_catag}">
					<div class="form-group row">
						<div class="col-sm-10">
							<label for="board_title" class="col-sm-1 col-form-label" style="margin-right: 64px;">답글</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="emp_code"
								placeholder="작성자" value="${board.emp_code}" readonly
								style="background: none; margin-right: 64px;">
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="reply"
								placeholder="답글" value="${reply}" readonly
								style="background: none;">
<!-- 						<button type="submit" class="btn btn-primary" id="save" style="margin-left: 50%"><i class="fas fa-pencil-alt"> </i>등록</button> -->
						</div>
					</div>
				</c:if>
			</div>
		</form>
	</div>
</div>

<div id="content">
	<div class="card card-info">
		<div class="card-header">
			${board.board_address }
		</div>
		<div class = "card-body">
			<div class="map_wrap">
				<div id="map"
					style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
			
				<div id="menu_wrap" class="bg_white">
					<div class="option">
						<div>
							<form onsubmit="searchPlaces(); return false;">
								키워드 : <input type="text" value="${board.board_address} "
									id="keyword" size="15">
								<button type="submit">검색하기</button>
							</form>
						</div>
					</div>
					<hr>
					<ul id="placesList"></ul>
					<div id="pagination"></div>
				</div>
			</div>
		</div>
	</div>
</div>
	
<!--///////////////////////////////////////지도API//////////////////////////////////////////////////////////-->
<!-- <div id="map" style="width:100%; height:800px;"></div> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fa8be80617da9d878a9c56e308d0051c&libraries=services,clusterer,drawing"></script>

<script type="text/javascript">

 
//마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다
searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    var listEl = document.getElementById('placesList'), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new kakao.maps.LatLngBounds(), 
    listStr = '';
    
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i), 
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, title) {
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });

            itemEl.onmouseover =  function () {
                displayInfowindow(marker, title);
            };

            itemEl.onmouseout =  function () {
                infowindow.close();
            };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}

 
/* 
 $(function(){
	   $.ajax({
	      url:"Map.jsp",
	      datatype:"json",
	      type:"get"
	   }).done(function(data){
	      data =  JSON.parse(data.trim());

	      var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	      mapOption = { //지도를 생성할 때 필요한 기본 옵션
	         center : new kakao.maps.LatLng(36.340453, 127.399441), // 지도의 중심좌표
	         level : 10// 지도의 확대 레벨 (확대, 축소 정도)
	      };

	      // 지도를 생성합니다    
	      var map = new kakao.maps.Map(mapContainer, mapOption);
	      
	      // 주소-좌표 변환 객체를 생성합니다
	      var geocoder = new kakao.maps.services.Geocoder();
	      
	      for (var i = 0; i < data.length; i++) {
	         
	         (function(i){
	            geocoder.addressSearch(data[i].addr, function(result, status) {
	               // 정상적으로 검색이 완료됐으면 
	                if (status === kakao.maps.services.Status.OK) {
	                   var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	                    
	                  // 마커를 생성합니다
	                  var marker = new kakao.maps.Marker({
	                     map:map, // 마커를 표시할 지도
	                     position : coords, // 마커를 표시할 위치
	                     title : data[i].title // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	                  });
	         
	                  // 인포윈도우를 생성합니다
	                  var infowindow = new kakao.maps.InfoWindow({
	                     content : data[i].title
	                  });
	         
	                  kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
	                  
	                  kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	               }
	            });
	         })(i);
	      } 
	   });
	});
	   
	   // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	   function makeOverListener(map, marker, infowindow) {
	      return function() {
	         infowindow.open(map, marker);
	      };
	   }

	   // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	   function makeOutListener(infowindow) {
	      return function() {
	         infowindow.close();
	      };
	   }

 */


/////////////////////////////////////////////////////////////////////////////////////////

	$("#deleteBtn").on("click", function(){
		let board_code = "${board.board_code}";
		
		if(confirm("삭제하시겠습니까 ? ")){
			$.ajax({
				url : '${cPath }/board/boardList/deleteBoard/${board.board_code}/${board.board_catag}',
				type : 'POST',
	            datatype : 'json',
				data : {
					board_code : board_code
				},
				success : function(data){
					alert("삭제가 완료 되었습니다.");
					location.href="${pageContext.request.contextPath }/board/boardList/${board.board_catag}"
				},
				error : function(error){
// 					alert(error);
					alert("삭제를 실패했습니다.");
				}
			})
		}
		
	})

</script>








