<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
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
	width: 80px;
	margin-left: 10px;
}

.teamMember {
	display: inline-block;
	float: left;
}

h3 {
	width: 700px;
	display: inline
}

.recentTask {
	float: right;
	width: 23%;
	margin-right: 20px;
}

.imp {
	font-weight: bold;
}

.emp_img {
	width:40px; 
	height:45px; 
	border-radius:50%;
}

</style>

<div id="content">
	<h1>PROJECT</h1>
	<div class="card card-info">
		<div class="card-header">
			<h3>${project.project_name}</h3>
			<button class="btn btn-block bg-gradient-danger btn-sm btnAction"
				onclick="deleteAction()">
				<i class="fas fa-trash"> </i> 삭제
			</button>
			<button class="btn btn-block bg-gradient-secondary btn-sm btnAction"
				id="btnUpdate" style="margin-top: 0px;"
				onclick="location.href='${cPath }/project/updateProject/${project.project_code}'">
				<i class="fas fa-pencil-alt"> </i> 수정
			</button>
			<button class="btn btn-block bg-gradient-secondary btn-sm btnAction"
				id="btnMemManage" style="margin-top: 0px;"
				onclick="location.href='${cPath }/project/tmManage/${project.project_code}'">
				<i class="fas fa-pencil-alt"> </i> 팀 관리
			</button>
		</div>

		<!-- form start -->
		<form class="form-horizontal">
			<div class="card-body">

				<!-- 프로젝트 코드 -->
				<input type="hidden" name="project_code"
					value="${project.project_code }" />

				<!-- 부서 -->
				<div class="form-group row">
					<label for="project_dept" class="col-sm-1 col-form-label">부서</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="dept" placeholder="부서"
							value="${project.dept_name}" readonly style="background: white;">
					</div>
				</div>

				<!-- 내용 -->
				<div class="form-group row">
					<label for="project_content" class="col-sm-1 col-form-label">내용</label>
					<div class="col-sm-10">
						<%-- 						<textarea class="form-control" id="content" placeholder="프로젝트 내용" readonly style="background:white; padding:15px;">${project.project_content}</textarea> --%>
						<div class="form-control  h-auto overflow-auto">${project.project_content}</div>
					</div>
				</div>

				<!-- 시작일, 종료일 -->
				<div class="form-group row">
					<div class="input-group">
						<label for="project_content" class="col-sm-1 col-form-label">시작일</label>
						<div class="input-group-prepend" style="margin-left: 8px;">
							<span class="input-group-text"><i
								class="far fa-calendar-alt"></i></span>
						</div>
						<input type="text" class="form-control date"
							data-inputmask-alias="datetime"
							data-inputmask-inputformat="mm/dd/yyyy" data-mask=""
							im-insert="false" readonly style="background: white;"
							value="${project.project_start }"> <label
							for="project_content" class="col-sm-1 col-form-label"
							style="margin-left: -350px;">종료일</label>
						<div class="input-group-prepend">
							<span class="input-group-text"><i
								class="far fa-calendar-alt"></i></span>
						</div>
						<input type="text" class="form-control date"
							data-inputmask-alias="datetime"
							data-inputmask-inputformat="mm/dd/yyyy" data-mask=""
							im-insert="false" readonly style="background: white;"
							value="${project.project_end }">
					</div>
				</div>

				<div class="form-group row">
					<div class="offset-sm-2 col-sm-10">
						<div class="form-check"></div>
					</div>
				</div>

				<!-- 중요도 -->
				<div class="form-group row">
					<label for="project_important" class="col-sm-1 col-form-label">중요도</label>
					<div class="col-sm-1">
						<input type="text" class="form-control" id="dept"
							placeholder="중요도" value="${project.import_name}" readonly
							style="background: white;">
					</div>
				</div>

				<!-- 상태 -->
				<div class="form-group row">
					<label for="project_status" class="col-sm-1 col-form-label">상태</label>
					<div class="col-sm-1">
						<input type="text" class="form-control" id="dept" placeholder="상태"
							value="${project.stat_name}" readonly style="background: white;">
					</div>
				</div>
				<br>

				<!-- 팀원 -->
				<div class="teamMember">
					<div class="form-group">
						<c:if test="${not empty project.pj_rgroupList}">
							<label for="project_members" class="col-sm-2 col-form-label"
								>팀원</label>
							<div style="margin-left: 90px;">
								<!-- 팀장 -->
								<!-- 							<ul class="list-inline"> -->
								<c:forEach var="pj_rgroup" items="${project.pj_rgroupList}">
									<c:set var="prCode" value="${pj_rgroup.pr_code}" />
									<c:forEach items="${pj_rgroup.pj_memberList }" var="pj_member">
										<c:if test="${prCode eq 'PR001'}">
											<!-- 											<li> -->
											<div class="text-center inline-chart">
												<div style="display: inline; width: 50px; height: 90px;">
													<input type="text" class="knob"
														value="${pj_member.pjm_progress}" data-width="90"
														data-height="90" data-fgcolor="#00c0ef"
														style="width: 49px; height: 30px; position: absolute; vertical-align: middle; margin-top: 30px; margin-left: -69px; border: 0px; background: none; font: bold 18px Arial; text-align: center; color: rgb(0, 192, 239); padding: 0px; -webkit-appearance: none;">
												</div>
												<img alt="" class="emp_img"	src="${cPath }/approval/download/emp/${pj_member.emp_attcode}"> 
													<span class="memName">${pj_member.emp_kor}</span>
												<p>${pj_rgroup.pr_name}</p>
											</div>
										</c:if>
									</c:forEach>
								</c:forEach>
								<!-- 	 						</ul> -->
								<!-- 팀원들 -->
								<div style="width: 400px">
									<ul class="list-inline">
										<c:forEach var="pj_rgroup" items="${project.pj_rgroupList}">
											<c:set var="prCode" value="${pj_rgroup.pr_code}" />
											<c:forEach items="${pj_rgroup.pj_memberList }"
												var="pj_member">
												<c:if test="${prCode ne 'PR001' && not empty prCode}">
													<li class="list-inline-item"
														style="display: inline; margin-right: 30px;">
														<div class="text-center inline-chart">
															<div style="display: inline; width: 50px; height: 90px;">
																<input type="text" class="knob"
																	value="${pj_member.pjm_progress}" data-width="90" data-height="90" data-fgcolor="#39CCCC"
																	style="width: 49px; height: 30px; position: absolute; vertical-align: middle; margin-top: 30px; margin-left: -69px; 
																	border: 0px; background: none; font: bold 18px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;">
																<div>
																	<img alt="" class="emp_img"	src="${cPath }/approval/download/emp/${pj_member.emp_attcode}" >  
																		<c:if test="${pj_member.out_member eq 'Y'}">
																			<span class="memName" style="color:grey">${pj_member.emp_kor}(제외)</span>
																		</c:if>
																		<c:if test="${pj_member.out_member eq 'N'}">
																			<span class="memName">${pj_member.emp_kor}</span>
																		</c:if>
																	<p>${pj_rgroup.pr_name}</p>
																</div>
															</div>
														</div>
													</li>
												</c:if>
											</c:forEach>
										</c:forEach>
									</ul>
								</div>
							</div>
						</c:if>
					</div>
				</div>

				<!-- 차트 -->
				<div class="chart" >
					<div class="form-group row" style="margin-left: 100px; ">
						<label for="project_progress" class="col-sm-3 col-form-label"
							style="width: 200px; margin-right: 50px;">진척도</label>
						<div style="margin-left: 30px; margin-top: -40px;">
							<canvas id="canvas"
								style="display: block; width: 700px; height: 500px;"
								class="chartjs-render-monitor chart"></canvas>
						</div>
					</div>
				</div>

				<br><br><br>
				<p></p>

				<!-- 일감 -->
				<div class="card">
					<div class="card-header row">
						<label for="project_dept" class="col-sm-2 col-form-label">최근
							등록된 일감</label>
						<div class="container-fluid recentTask ">
							<!-- 							<p class="imp">진행률</p> -->
							<span class="oi oi-minus text-danger"></span>&nbsp;<span>0
								- 25%</span>&nbsp;&nbsp; <span class="oi oi-minus text-warning"></span>&nbsp;<span>26
								- 50%</span>&nbsp;&nbsp; <span class="oi oi-minus text-primary"></span>&nbsp;<span>51
								- 75%</span> <span class="oi oi-minus text-success"></span>&nbsp;<span>76
								- 100%</span>
						</div>
					</div>
					<!-- /.card-header -->

					<div class="card-body p-0">
						<table class="table">
							<thead>
								<tr>
									<th style="width: 10px">#</th>
									<th>일감명</th>
									<th>담당자</th>
									<th>진행률</th>
									<th style="width: 40px"></th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${not empty recentTaskList }">
									<c:forEach items="${recentTaskList }" var="task">
										<tr>
											<td>${task.rnum }</td>
											<td><a href="${cPath}/project/eachtask/${task.task_code}/${project_code}">${task.task_name }</a></td>
											<td>${task.emp_kor }</td>
											<c:choose>
												<c:when test="${task.task_progress <= 25}">
													<td>
														<div class="progress progress-xs">
															<div class="progress-bar bg-danger"
																style="width: ${task.task_progress}%"></div>
														</div>
													</td>
													<td><span class="badge bg-danger">${task.task_progress }</span></td>
												</c:when>
												<c:when
													test="${task.task_progress > 25 and task.task_progress <= 50}">
													<td>
														<div class="progress progress-xs">
															<div class="progress-bar bg-warning"
																style="width: ${task.task_progress}%"></div>
														</div>
													</td>
													<td><span class="badge bg-warning">${task.task_progress }</span></td>
												</c:when>
												<c:when
													test="${task.task_progress > 50 and task.task_progress <=75 }">
													<td>
														<div class="progress progress-xs">
															<div class="progress-bar bg-primary"
																style="width: ${task.task_progress}%"></div>
														</div>
													</td>
													<td><span class="badge bg-primary">${task.task_progress }</span></td>
												</c:when>
												<c:otherwise>
													<td>
														<div class="progress progress-xs">
															<div class="progress-bar bg-success"
																style="width: ${task.task_progress}%"></div>
														</div>
													</td>
													<td><span class="badge bg-success">${task.task_progress }</span></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
					<!-- /.card-body -->
				</div>

			</div>
		</form>
	</div>
</div>

<!-- jQuery Knob -->
<script
	src="${pageContext.request.contextPath }/resources/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- ChartJS -->
<script
	src="${pageContext.request.contextPath }/resources/plugins/chart.js/Chart.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/plugins/chart.js/Chartutil.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>


<!-- 프로젝트 삭제 -->
<script>
	function deleteAction(){
		  
		  if(confirm("프로젝트를 삭제 하시겠습니까?")){
			  $.ajax({
		            url : '${pageContext.request.contextPath }/project/delProject',
		            type : "POST",
		            datatype : 'json',
		            contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
		            data:{
		                project_code : $("[name='project_code']").val()
		            },
		            success : function(data) {
					    alert("삭제가 완료되었습니다.");
					    location.href="${pageContext.request.contextPath }/project/projectlist/${who}";
		                
		            },
		            error:function(request, status, error) {
		            	alert("삭제를 실패하였습니다.");
		 
		            }
			 })
	        
	 	 }
	}
</script>


<!-- 프로젝트 진척도 차트 -->
<script type="text/javascript">

		var monthData = ${month};
		var progressData = ${progress};
		console.log(progressData);
		
		var config = {
			type: 'line',
			data: {
				labels: monthData,
				datasets: [{
					label: 'Project Progress',
					fill: false,
					backgroundColor: window.chartColors.blue,
					borderColor: window.chartColors.blue,
					data: progressData,
				}]
			},
			options: {
				responsive: true,
				title: {
					display: true,
					text: ' '
				},
				tooltips: {
					mode: 'index',
					intersect: false,
				},
				hover: {
					mode: 'nearest',
					intersect: true
				},
				scales: {
					xAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Month'
						}
					}],
					yAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Value'
						}
					}]
				}
			}
		};

		window.onload = function() {
			var ctx = document.getElementById('canvas').getContext('2d');
			window.myLine = new Chart(ctx, config);
		};
	
</script>

<!-- 팀원 -->
<script>
  $(function () {
    /* jQueryKnob */

    $('.knob').knob({
      /*change : function (value) {
       //console.log("change : " + value);
       },
       release : function (value) {
       console.log("release : " + value);
       },
       cancel : function () {
       console.log("cancel : " + this.value);
       },*/
      draw: function () {

        // "tron" case
        if (this.$.data('skin') == 'tron') {

          var a   = this.angle(this.cv)  // Angle
            ,
              sa  = this.startAngle          // Previous start angle
            ,
              sat = this.startAngle         // Start angle
            ,
              ea                            // Previous end angle
            ,
              eat = sat + a                 // End angle
            ,
              r   = true

          this.g.lineWidth = this.lineWidth

          this.o.cursor
          && (sat = eat - 0.3)
          && (eat = eat + 0.3)

          if (this.o.displayPrevious) {
            ea = this.startAngle + this.angle(this.value)
            this.o.cursor
            && (sa = ea - 0.3)
            && (ea = ea + 0.3)
            this.g.beginPath()
            this.g.strokeStyle = this.previousColor
            this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, sa, ea, false)
            this.g.stroke()
          }

          this.g.beginPath()
          this.g.strokeStyle = r ? this.o.fgColor : this.fgColor
          this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, sat, eat, false)
          this.g.stroke()

          this.g.lineWidth = 2
          this.g.beginPath()
          this.g.strokeStyle = this.o.fgColor
          this.g.arc(this.xy, this.xy, this.radius - this.lineWidth + 1 + this.lineWidth * 2 / 3, 0, 2 * Math.PI, false)
          this.g.stroke()

          return false
        }
      }
    })
    /* END JQUERY KNOB */

    //INITIALIZE SPARKLINE CHARTS
    $('.sparkline').each(function () {
      var $this = $(this)
      $this.sparkline('html', $this.data())
    })

    /* SPARKLINE DOCUMENTATION EXAMPLES http://omnipotent.net/jquery.sparkline/#s-about */
    drawDocSparklines()
    drawMouseSpeedDemo()

  })

  function drawDocSparklines() {

    // Bar + line composite charts
    $('#compositebar').sparkline('html', {
      type    : 'bar',
      barColor: '#aaf'
    })
    $('#compositebar').sparkline([4, 1, 5, 7, 9, 9, 8, 7, 6, 6, 4, 7, 8, 4, 3, 2, 2, 5, 6, 7],
      {
        composite: true,
        fillColor: false,
        lineColor: 'red'
      })


    // Line charts taking their values from the tag
    $('.sparkline-1').sparkline()

    // Larger line charts for the docs
    $('.largeline').sparkline('html',
      {
        type  : 'line',
        height: '2.5em',
        width : '4em'
      })

    // Customized line chart
    $('#linecustom').sparkline('html',
      {
        height      : '1.5em',
        width       : '8em',
        lineColor   : '#f00',
        fillColor   : '#ffa',
        minSpotColor: false,
        maxSpotColor: false,
        spotColor   : '#77f',
        spotRadius  : 3
      })

    // Bar charts using inline values
    $('.sparkbar').sparkline('html', { type: 'bar' })

    $('.barformat').sparkline([1, 3, 5, 3, 8], {
      type               : 'bar',
      tooltipFormat      : '{{value:levels}} - {{value}}',
      tooltipValueLookups: {
        levels: $.range_map({
          ':2' : 'Low',
          '3:6': 'Medium',
          '7:' : 'High'
        })
      }
    })

    // Tri-state charts using inline values
    $('.sparktristate').sparkline('html', { type: 'tristate' })
    $('.sparktristatecols').sparkline('html',
      {
        type    : 'tristate',
        colorMap: {
          '-2': '#fa7',
          '2' : '#44f'
        }
      })

    // Composite line charts, the second using values supplied via javascript
    $('#compositeline').sparkline('html', {
      fillColor     : false,
      changeRangeMin: 0,
      chartRangeMax : 10
    })
    $('#compositeline').sparkline([4, 1, 5, 7, 9, 9, 8, 7, 6, 6, 4, 7, 8, 4, 3, 2, 2, 5, 6, 7],
      {
        composite     : true,
        fillColor     : false,
        lineColor     : 'red',
        changeRangeMin: 0,
        chartRangeMax : 10
      })

    // Line charts with normal range marker
    $('#normalline').sparkline('html',
      {
        fillColor     : false,
        normalRangeMin: -1,
        normalRangeMax: 8
      })
    $('#normalExample').sparkline('html',
      {
        fillColor       : false,
        normalRangeMin  : 80,
        normalRangeMax  : 95,
        normalRangeColor: '#4f4'
      })

    // Discrete charts
    $('.discrete1').sparkline('html',
      {
        type     : 'discrete',
        lineColor: 'blue',
        xwidth   : 18
      })
    $('#discrete2').sparkline('html',
      {
        type          : 'discrete',
        lineColor     : 'blue',
        thresholdColor: 'red',
        thresholdValue: 4
      })

    // Bullet charts
    $('.sparkbullet').sparkline('html', { type: 'bullet' })

    // Pie charts
    $('.sparkpie').sparkline('html', {
      type  : 'pie',
      height: '1.0em'
    })

    // Box plots
    $('.sparkboxplot').sparkline('html', { type: 'box' })
    $('.sparkboxplotraw').sparkline([1, 3, 5, 8, 10, 15, 18],
      {
        type        : 'box',
        raw         : true,
        showOutliers: true,
        target      : 6
      })

    // Box plot with specific field order
    $('.boxfieldorder').sparkline('html', {
      type                     : 'box',
      tooltipFormatFieldlist   : ['med', 'lq', 'uq'],
      tooltipFormatFieldlistKey: 'field'
    })

    // click event demo sparkline
    $('.clickdemo').sparkline()
    $('.clickdemo').bind('sparklineClick', function (ev) {
      var sparkline = ev.sparklines[0],
          region    = sparkline.getCurrentRegionFields()
      value         = region.y
      alert('Clicked on x=' + region.x + ' y=' + region.y)
    })

    // mouseover event demo sparkline
    $('.mouseoverdemo').sparkline()
    $('.mouseoverdemo').bind('sparklineRegionChange', function (ev) {
      var sparkline = ev.sparklines[0],
          region    = sparkline.getCurrentRegionFields()
      value         = region.y
      $('.mouseoverregion').text('x=' + region.x + ' y=' + region.y)
    }).bind('mouseleave', function () {
      $('.mouseoverregion').text('')
    })
  }

  /**
   ** Draw the little mouse speed animated graph
   ** This just attaches a handler to the mousemove event to see
   ** (roughly) how far the mouse has moved
   ** and then updates the display a couple of times a second via
   ** setTimeout()
   **/
  function drawMouseSpeedDemo() {
    var mrefreshinterval = 500 // update display every 500ms
    var lastmousex       = -1
    var lastmousey       = -1
    var lastmousetime
    var mousetravel      = 0
    var mpoints          = []
    var mpoints_max      = 30
    $('html').mousemove(function (e) {
      var mousex = e.pageX
      var mousey = e.pageY
      if (lastmousex > -1) {
        mousetravel += Math.max(Math.abs(mousex - lastmousex), Math.abs(mousey - lastmousey))
      }
      lastmousex = mousex
      lastmousey = mousey
    })
    var mdraw = function () {
      var md      = new Date()
      var timenow = md.getTime()
      if (lastmousetime && lastmousetime != timenow) {
        var pps = Math.round(mousetravel / (timenow - lastmousetime) * 1000)
        mpoints.push(pps)
        if (mpoints.length > mpoints_max) {
          mpoints.splice(0, 1)
        }
        mousetravel = 0
        $('#mousespeed').sparkline(mpoints, {
          width        : mpoints.length * 2,
          tooltipSuffix: ' pixels per second'
        })
      }
      lastmousetime = timenow
      setTimeout(mdraw, mrefreshinterval)
    }
    // We could use setInterval instead, but I prefer to do it this way
    setTimeout(mdraw, mrefreshinterval);
  }
  
</script>