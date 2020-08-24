<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    

  <!-- fullCalendar -->
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-daygrid/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-timegrid/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-bootstrap/main.min.css">


<style>

  #calendar {
    max-width: auto;
    margin: 0 auto;
  } 

</style>




   <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>부서 휴가 현황</h1>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>



    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-3">
            <div class="sticky-top mb-3">
             
              <!-- /.card -->
              </div>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-md-7">
            <div class="card card-primary">
              <div class="card-body p-0">
                <!-- THE CALENDAR -->
                <div id="calendar"></div>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
    </section>









<section class="content">
      <div class="container-fluid">
  <div id='calendar'></div>
</div>
</section>





















	<!-- fullCalendar 2.2.5 -->
	<script src="${cPath }/resources/plugins/moment/moment.min.js"></script>
	<script src="${cPath }/resources/plugins/fullcalendar/main.min.js"></script>
	<script src="${cPath }/resources/plugins/fullcalendar-daygrid/main.min.js"></script>
	<script src="${cPath }/resources/plugins/fullcalendar-timegrid/main.min.js"></script>
	<script src="${cPath }/resources/plugins/fullcalendar-interaction/main.min.js"></script>
	<script src="${cPath }/resources/plugins/fullcalendar-bootstrap/main.min.js"></script>
	
	
	<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
      },
      navLinks: true, // can click day/week names to navigate views
      businessHours: true, // display business hours
      selectable: true,
      selectMirror: true,
      select: function(arg) {
        var title = prompt('Event Title:');
        if (title) {
            calendar.addEvent({
            title: title,
            start: arg.start,
            end: arg.end,
            allDay: arg.allDay
          })
        }
        calendar.unselect()
      },
      editable: true,
      eventLimit: true,
      navLinks: true,
      events: [
        {
          title: 'Business Lunch',
          start: '2020-07-03T13:00:00',
          constraint: 'businessHours'
        },
        {
          title: 'Meeting',
          start: '2020-07-13T11:00:00',
          constraint: 'availableForMeeting', // defined below
          color: '#257e4a'
        },
        {
          title: 'Conference',
          start: '2020-07-18',
          end: '2020-02-20'
        },
        {
          title: 'Party',
          start: '2020-07-29T20:00:00'
        },

        // areas where "Meeting" must be dropped
        {
          groupId: 'availableForMeeting',
          start: '2020-02-11T10:00:00',
          end: '2020-02-11T16:00:00',
          rendering: 'background'
        },
        {
          groupId: 'availableForMeeting',
          start: '2020-02-13T10:00:00',
          end: '2020-02-13T16:00:00',
          rendering: 'background'
        },

        // red areas where no events can be dropped
        {
          start: '2020-02-24',
          end: '2020-02-28',
          overlap: false,
          rendering: 'background',
          color: '#ff9f89'
        },
        {
          start: '2020-02-06',
          end: '2020-02-08',
          overlap: false,
          rendering: 'background',
          color: '#ff9f89'
        }
      ]
    });

    calendar.render();
  });

</script>