<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<h1>휴일정보등록-모달</h1>
<script>

  function onload () {
   var eventArr = []; //달력 그려줄 애 
   
   $.ajax({ //DB에서 정보 받아오는애 
      url : "<c:url value='/schedule/calendar/read'/>",
      dataType : "json", // Accept:application/json, Content-Type:application/json
      success : function(resp) { //정보받았음 
         $.each(resp,function(idx, taskList){ //받은 정보를 title, start, end 정해주는곳 
            let color = taskList.pri_no;
            let myEvent = new Object();
            
            myEvent.title = taskList.title;
            myEvent.start = new Date(taskList.start);
            myEvent.end = new Date(taskList.end);
            myEvent.backgroundColor = color;
            myEvent.borderColor = color;
            myEvent.allDay = true;
            
            eventArr.push(myEvent);
            
         });
         
          calendar = new Calendar(calendarEl, { //캘린더를 그려주는곳 
              plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid' ],
              header    : {
                left  : 'prev,next today',
                center: 'title',
                right : 'dayGridMonth,timeGridWeek,timeGridDay'
              },
              'themeSystem': 'bootstrap',
              //Random default events
              events    : eventArr, // 위에서 조작한 data를 넣어주는곳, 즉 실질적인 일정이 들어가는곳
              editable  : false
//               droppable : true, // this allows things to be dropped onto the calendar !!!
//               drop      : function(info) {
                // is the "remove after drop" checkbox checked?
//                 if (checkbox.checked) {
//                   // if so, remove the element from the "Draggable Events" list
//                   info.draggedEl.parentNode.removeChild(info.draggedEl);
//                 }
//               }    
            });
           
            calendar.render();
      },
      error : function(errorResp) {
         console.log(errorResp.status + ":" + errorResp.responseText);
      }
   });
   
   
    /* 모든 팀 일감, 내 일감 이벤트 처리 (쓸지안쓸지 몰라 일단 보류) 
     -----------------------------------------------------------------*/
//     function ini_events(ele) {
//       ele.each(function () {

//         // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
//         // it doesn't need to have a start or end
//         var eventObject = {
//           title: $.trim($(this).text()) // use the element's text as the event title
//         }

//         // store the Event Object in the DOM element so we can get to it later
//         $(this).data('eventObject', eventObject)

//         // make the event draggable using jQuery UI
//         $(this).draggable({
//           zIndex        : 1070,
//           revert        : true, // will cause the event to go back to its
//           revertDuration: 0  //  original position after the drag
//         })

//       })
//     }

//     ini_events($('#external-events div.external-event'))

    /* initialize the calendar (캘린더 초기화 건들면 안됨)
     -----------------------------------------------------------------*/
    //Date for the calendar events (dummy data)
    var date = new Date()
    var d    = date.getDate(),
        m    = date.getMonth(),
        y    = date.getFullYear()

    var Calendar = FullCalendar.Calendar;
//     var Draggable = FullCalendarInteraction.Draggable;

    var containerEl = document.getElementById('external-events');
    var checkbox = document.getElementById('drop-remove');
    var calendarEl = document.getElementById('calendar');

    // 일감 움직이기 쓸지안쓸지 몰라 일단 남겨둠
    // -----------------------------------------------------------------

//     new Draggable(containerEl, {
//       itemSelector: '.external-event',
//       eventData: function(eventEl) {
//         console.log(eventEl);
//         return {
//           title: eventEl.innerText,
//           backgroundColor: window.getComputedStyle( eventEl ,null).getPropertyValue('background-color'),
//           borderColor: window.getComputedStyle( eventEl ,null).getPropertyValue('background-color'),
//           textColor: window.getComputedStyle( eventEl ,null).getPropertyValue('color'),
//         };
//       }
//     });


//     $('#calendar').fullCalendar();


   // task들 추가하기 버튼 눌렀을때
//     var currColor = '#3c8dbc' //Red by default
   
    //Color chooser button
    var colorChooser = $('#color-chooser-btn')
    $('#color-chooser > li > a').click(function (e) {
      e.preventDefault()
      //Save color
      currColor = $(this).css('color')
      //Add color effect to button
      $('#add-new-event').css({
        'background-color': currColor,
        'border-color'    : currColor
      })
    })
    $('#add-new-event').click(function (e) {
      e.preventDefault()
      //Get value and make sure it is not null
      var val = $('#new-event').val()
      if (val.length == 0) {
        return
      }
      
      
      
      //Create events
      var event = $('<div />')
      event.css({
        'background-color': currColor,
        'border-color'    : currColor,
        'color'           : '#fff'
      }).addClass('external-event')
      event.html(val)
      $('#external-events').prepend(event)

      //Add draggable funtionality
//       ini_events(event)

      //Remove event from text input
//       $('#new-event').val('')
    })
  }
  
  onload();
  
  
 </script>