<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type = "text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script type = "text/javascript" src = "https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>

<style type="text/css">
      html { font-family:Calibri, Arial, Helvetica, sans-serif; font-size:11pt; background-color:white }
      a.comment-indicator:hover + div.comment { background:#ffd; position:absolute; display:block; border:1px solid black; padding:0.5em }
      a.comment-indicator { background:red; display:inline-block; border:1px solid black; width:0.5em; height:0.5em }
      div.comment { display:none }
      table { border-collapse:collapse; page-break-after:always }
      .gridlines td { border:1px dotted black }
      .gridlines th { border:1px dotted black }
      .b { text-align:center }
      .e { text-align:center }
      .f { text-align:right }
      .inlineStr { text-align:left }
      .n { text-align:right }
      .s { text-align:left }
      td.style0 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'굴림체'; font-size:11pt; background-color:white }
      th.style0 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'굴림체'; font-size:11pt; background-color:white }
      td.style1 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style1 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style2 { vertical-align:middle; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style2 { vertical-align:middle; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style3 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style3 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style4 { vertical-align:middle; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style4 { vertical-align:middle; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style5 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:11pt; background-color:white }
      th.style5 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:11pt; background-color:white }
      td.style6 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style6 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style7 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style7 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style8 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style8 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style9 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style9 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style10 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style10 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style11 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style11 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style12 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style12 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style13 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style13 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style14 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style14 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style15 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style15 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style16 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style16 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style17 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style17 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style18 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style18 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style19 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style19 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style20 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style20 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style21 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style21 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style22 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:2px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style22 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:2px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style23 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style23 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style24 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style24 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style25 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style25 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style26 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style26 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style27 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style27 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style28 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style28 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style29 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style29 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style30 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style30 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style31 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style31 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style32 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:2px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style32 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:2px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style33 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style33 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style34 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style34 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style35 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style35 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style36 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style36 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style37 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style37 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style38 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style38 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style39 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style39 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style40 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style40 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style41 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style41 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style42 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style42 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style43 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style43 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style44 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style44 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style45 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style45 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style46 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style46 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style47 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style47 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style48 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style48 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style49 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style49 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style50 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style50 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style51 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style51 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style52 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style52 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style53 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style53 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style54 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style54 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style55 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style55 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style56 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style56 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style57 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style57 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style58 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style58 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style59 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:2px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style59 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:2px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style60 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style60 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style61 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style61 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style62 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:2px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      th.style62 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:2px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:#FFFFFF }
      td.style63 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style63 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style64 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style64 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:2px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style65 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style65 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style66 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style66 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style67 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style67 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:2px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style68 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style68 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style69 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      th.style69 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'맑은 고딕'; font-size:18pt; background-color:white }
      td.style70 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style70 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style71 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style71 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      td.style72 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      th.style72 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'맑은 고딕'; font-size:10pt; background-color:white }
      table.sheet0 col.col0 { width:16.94444425pt }
      table.sheet0 col.col1 { width:16.94444425pt }
      table.sheet0 col.col2 { width:16.94444425pt }
      table.sheet0 col.col3 { width:16.94444425pt }
      table.sheet0 col.col4 { width:16.94444425pt }
      table.sheet0 col.col5 { width:16.94444425pt }
      table.sheet0 col.col6 { width:16.94444425pt }
      table.sheet0 col.col7 { width:16.94444425pt }
      table.sheet0 col.col8 { width:16.94444425pt }
      table.sheet0 col.col9 { width:16.94444425pt }
      table.sheet0 col.col10 { width:16.94444425pt }
      table.sheet0 col.col11 { width:16.94444425pt }
      table.sheet0 col.col12 { width:72.52222139pt }
      table.sheet0 col.col13 { width:42pt }
      table.sheet0 col.col14 { width:42pt }
      table.sheet0 col.col15 { width:42pt }
      table.sheet0 col.col16 { width:42pt }
      table.sheet0 col.col17 { width:42pt }
      table.sheet0 col.col18 { width:42pt }
      table.sheet0 col.col19 { width:42pt }
      table.sheet0 col.col20 { width:42pt }
      table.sheet0 col.col21 { width:42pt }
      table.sheet0 col.col22 { width:42pt }
      table.sheet0 col.col23 { width:42pt }
      table.sheet0 col.col24 { width:42pt }
      table.sheet0 tr { height:18pt }
      table.sheet0 tr.row0 { height:18pt }
      table.sheet0 tr.row1 { height:18pt }
      table.sheet0 tr.row2 { height:18pt }
      table.sheet0 tr.row3 { height:18pt }
      table.sheet0 tr.row4 { height:18pt }
      table.sheet0 tr.row5 { height:18pt }
      table.sheet0 tr.row6 { height:18pt }
      table.sheet0 tr.row7 { height:18pt }
      table.sheet0 tr.row8 { height:18pt }
      table.sheet0 tr.row9 { height:9.95pt }
      table.sheet0 tr.row10 { height:30pt }
      table.sheet0 tr.row11 { height:21.95pt }
      table.sheet0 tr.row12 { height:21.95pt }
      table.sheet0 tr.row13 { height:21.95pt }
      table.sheet0 tr.row14 { height:21.95pt }
      table.sheet0 tr.row15 { height:21.95pt }
      table.sheet0 tr.row16 { height:21.95pt }
      table.sheet0 tr.row17 { height:21.95pt }
      table.sheet0 tr.row18 { height:21.95pt }
      table.sheet0 tr.row19 { height:21.95pt }
      table.sheet0 tr.row20 { height:21.95pt }
      table.sheet0 tr.row21 { height:21.95pt }
      table.sheet0 tr.row22 { height:21.95pt }
      table.sheet0 tr.row23 { height:21.95pt }
      table.sheet0 tr.row24 { height:21.95pt }
      table.sheet0 tr.row25 { height:21.95pt }
      table.sheet0 tr.row26 { height:21.95pt }
      table.sheet0 tr.row27 { height:21.95pt }
      table.sheet0 tr.row28 { height:21.95pt }
      table.sheet0 tr.row29 { height:21.95pt }
      table.sheet0 tr.row30 { height:21.95pt }
      table.sheet0 tr.row31 { height:21.95pt }
      table.sheet0 tr.row32 { height:21.95pt }
      table.sheet0 tr.row33 { height:21.95pt }
      table.sheet0 tr.row34 { height:21.95pt }
      table.sheet0 tr.row35 { height:21.95pt }
      table.sheet0 tr.row36 { height:21.95pt }
      table.sheet0 tr.row37 { height:21.95pt }
    </style>
<div class = "content row" style="padding:30px 50px;">
	<div class="card card-primary col-sm-12" >
		
		<br>
		<div id = "top" style="width:80%;margin:0 auto; padding:0 10px;">
			<button class="btn btn-primary btn-sm float-sm-right" id="saveBtn"  style="margin : 5px;">
			        <i class="fas fa-download">
			    </i>
			         다운로드
			</button>
		</div><br><br>
		
		<div class="card card-primary" style="width: 77%; margin:0 auto;">
			<div class="card-header">
				<h3 class="card-title">첨부파일</h3>
				<div class="card-tools">
					<button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i></button>
				</div>
			<!-- /.card-tools -->
			</div>
			<!-- /.card-header -->
			<div class="card-body" style="display: block;">
				<c:forEach items="${report.report_attList }" var="attatch" varStatus="vs">
					<a href="<c:url value='/report/file/${attatch.report_attcode }'/>">${attatch.org_name } </a>${not vs.last?"&nbsp;":"" }
				</c:forEach>
			</div>
			<!-- /.card-body -->
		</div>
	
   <div id="pdfchange" style="width:100%;padding-bottom:100px;">
	    <table id="pdftable" border="0" cellpadding="0" cellspacing="0" id="sheet0" class="sheet0" style="width:80%;margin:0 auto;">
	        <col class="col0">
	        <col class="col1">
	        <col class="col2">
	        <col class="col3">
	        <col class="col4">
	        <col class="col5">
	        <col class="col6">
	        <col class="col7">
	        <col class="col8">
	        <col class="col9">
	        <col class="col10">
	        <col class="col11">
	        <col class="col12">
	        <col class="col13">
	        <col class="col14">
	        <col class="col15">
	        <col class="col16">
	        <col class="col17">
	        <col class="col18">
	        <col class="col19">
	        <col class="col20">
	        <col class="col21">
	        <col class="col22">
	        <col class="col23">
	        <col class="col24">
	        <tbody>
	          <tr class="row0">
	            <td class="column0">&nbsp;</td>
	            <td class="column1">&nbsp;</td>
	            <td class="column2">&nbsp;</td>
	            <td class="column3">&nbsp;</td>
	            <td class="column4">&nbsp;</td>
	            <td class="column5">&nbsp;</td>
	            <td class="column6">&nbsp;</td>
	            <td class="column7">&nbsp;</td>
	            <td class="column8">&nbsp;</td>
	            <td class="column9">&nbsp;</td>
	            <td class="column10">&nbsp;</td>
	            <td class="column11">&nbsp;</td>
	            <td class="column12">&nbsp;</td>
	            <td class="column13">&nbsp;</td>
	            <td class="column14">&nbsp;</td>
	            <td class="column15">&nbsp;</td>
	            <td class="column16">&nbsp;</td>
	            <td class="column17">&nbsp;</td>
	            <td class="column18">&nbsp;</td>
	            <td class="column19">&nbsp;</td>
	            <td class="column20">&nbsp;</td>
	            <td class="column21">&nbsp;</td>
	            <td class="column22">&nbsp;</td>
	            <td class="column23">&nbsp;</td>
	            <td class="column24">&nbsp;</td>
	          </tr>
	          <tr class="row1">
	            <td class="column0">&nbsp;</td>
	            <td class="column1 style24 s style69" colspan="18" rowspan="5">&nbsp;주간 업무 보고</td>
	            <td class="column19 style7 s style7" colspan="3">담 당</td>
	            <td class="column22 style7 s style8" colspan="3">승 인</td>
	          </tr>
	          <tr class="row2">
	            <td class="column0">&nbsp;</td>
	            <td class="column19 style10 null style18" colspan="3" rowspan="3"><c:if test="${report.report_sign ne null }"><img src="${cPath }/emp/file/${report.report_sign }" style="height: 100px; width: 100px;"></c:if></td>
	            <td class="column22 style10 null style21" colspan="3" rowspan="3"><c:if test="${report.target_sign ne null and 'REP100' ne report.report_stat}"><img src="${cPath }/emp/file/${report.target_sign }" style="height: 100px; width: 100px;"></c:if></td>
	          </tr>
	          <tr class="row3">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row4">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row5">
	            <td class="column0">&nbsp;</td>
	            <td class="column19 style9 s style9" colspan="2">작성자</td>
	            <td class="column21 style9 null style31" colspan="4">${report.emp_reporter}</td>
	          </tr>
	          <tr class="row6">
	            <td class="column0">&nbsp;</td>
	            <td class="column1 style5 null"></td>
	            <td class="column2 style5 null"></td>
	            <td class="column3 style5 null"></td>
	            <td class="column4 style5 null"></td>
	            <td class="column5 style5 null"></td>
	            <td class="column6 style5 null"></td>
	            <td class="column7 style5 null"></td>
	            <td class="column8 style5 null"></td>
	            <td class="column9 style5 null"></td>
	            <td class="column10 style5 null"></td>
	            <td class="column11 style5 null"></td>
	            <td class="column12 style5 null"></td>
	            <td class="column13 style5 null"></td>
	            <td class="column14 style5 null"></td>
	            <td class="column15 style5 null"></td>
	            <td class="column16 style5 null"></td>
	            <td class="column17 style5 null"></td>
	            <td class="column18 style5 null"></td>
	            <td class="column19 style5 null"></td>
	            <td class="column20 style5 null"></td>
	            <td class="column21 style5 null"></td>
	            <td class="column22 style5 null"></td>
	            <td class="column23 style5 null"></td>
	            <td class="column24 style5 null"></td>
	          </tr>
	          <tr class="row7">
	            <td class="column0">&nbsp;</td>
	            <td class="column1 style32 s style23" colspan="3" rowspan="2">부 서 / 팀</td>
	            <td class="column4 style34 null style36" colspan="11" rowspan="2">${report.team_code }</td>
	            <td class="column15 style37 s style23" colspan="2" rowspan="2">작성일자</td>
	            <td class="column17 style34 null style39" colspan="8" rowspan="2">${report.report_date }</td>
	          </tr>
	          <tr class="row8">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row9">
	            <td class="column0">&nbsp;</td>
	            <td class="column1 style6 null"></td>
	            <td class="column2 style6 null"></td>
	            <td class="column3 style6 null"></td>
	            <td class="column4 style6 null"></td>
	            <td class="column5 style6 null"></td>
	            <td class="column6 style6 null"></td>
	            <td class="column7 style6 null"></td>
	            <td class="column8 style6 null"></td>
	            <td class="column9 style6 null"></td>
	            <td class="column10 style6 null"></td>
	            <td class="column11 style6 null"></td>
	            <td class="column12 style6 null"></td>
	            <td class="column13 style6 null"></td>
	            <td class="column14 style6 null"></td>
	            <td class="column15 style6 null"></td>
	            <td class="column16 style6 null"></td>
	            <td class="column17 style6 null"></td>
	            <td class="column18 style6 null"></td>
	            <td class="column19 style6 null"></td>
	            <td class="column20 style6 null"></td>
	            <td class="column21 style6 null"></td>
	            <td class="column22 style6 null"></td>
	            <td class="column23 style6 null"></td>
	            <td class="column24 style6 null"></td>
	          </tr>
	          <tr class="row10">
	            <td class="column0">&nbsp;</td>
	            <td class="column1 style46 s style48" colspan="3">제    목</td>
	            <td class="column4 style49 null style50" colspan="21">${report.report_title }</td>
	          </tr>
	          <tr class="row11">
	            <td class="column0">&nbsp;</td>
	            <td class="column1 style40 s style53" colspan="3" rowspan="27">진행 업무    내용</td>
	            <td class="column4 style54 null style62" colspan="21" rowspan="27">${report.report_content }</td>
	          </tr>
	          <tr class="row12">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row13">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row14">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row15">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row16">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row17">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row18">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row19">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row20">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row21">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row22">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row23">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row24">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row25">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row26">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row27">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row28">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row29">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row30">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row31">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row32">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row33">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row34">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row35">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row36">
	            <td class="column0">&nbsp;</td>
	          </tr>
	          <tr class="row37">
	            <td class="column0">&nbsp;</td>
	          </tr>
	        </tbody>
	    </table>
	</div>
</div>
<script>
	$('#saveBtn').click(function() { // pdf저장 button id
		
		let pdf = new jsPDF();
		let canvas = pdf.canvas;
		const pageWidth = 210;
		const pageHeight = 295;
		canvas.width = pageWidth;
		
		let ele = document.querySelector('#pdfchange');
		
		let width = ele.offsetWidth; // 요소 px 너비
		let height = ele.offsetHeight; // 요소 px 높이
		let imgHeight = pageWidth*height/width;  // 이미지 높이값 px to mm 변환
		
		if(!ele){
			console.warn('not exist');
			return false;
		}
	
		 html2canvas(ele).then(function(canvas){
			 let position = 0;
			 const imgData = canvas.toDataURL('image/jpg');
						 
			 pdf.addImage(imgData,'jpg',0,position,pageWidth,imgHeight);
			 //Paging처리
			 let heightLeft = imgHeight; 
			 heightLeft -= pageHeight;
			 while(heightLeft>=0){
				 position = heightLeft - imgHeight;
				 pdf.addPage();
				 pdf.addImage(imgData,'jpg',0,position,pageWidth,imgHeight);
				 heightLeft-=pageHeight;
			 }
			 
			 pdf.save('report.pdf');
		 
		 
		 });


	
	});
	
	
	
	        
</script>


