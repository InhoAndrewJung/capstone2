<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="container" style="max-width: 80%;">
<div style=height:80px></div>
<h1 class="font-weight-bold">${title}</h1>
<div style=height:80px></div>
<c:forEach var="item" items="${testList}" begin="0" end="${questionCount}" step="1" varStatus="status">
<h1 class="font-weight-bold">문제${item.questionNo}</h1><br>
<h2 class="font-weight-bold">${item.title}</h2><br>
문제<pre class="form-control" style=font-family:맑은고딕;>${item.problem}</pre><br>
입력<pre class="form-control" style=font-family:맑은고딕;>${item.input}</pre><br>
출력<pre class="form-control" style=font-family:맑은고딕;>${item.output}</pre><br> 
예시 입력<pre class="form-control" style=font-family:맑은고딕;>${item.exInput}</pre><br>
예시 출력<pre class="form-control" style=font-family:맑은고딕;>${item.exOutput}</pre><br>
코드 입력
<button id="compile${item.questionNo}" class="btn btn-warning">컴파일</button>
<button id="submit${item.questionNo}" class="btn btn-success">제출</button>
<div style=height:1px></div>
<br>
<textarea id="userCode${item.questionNo}" class="form-control" style=font-family:맑은고딕;height:250px; name="userCode" ></textarea><br>
<textarea id="compileRlt${item.questionNo}" class="form-control" style=font-family:맑은고딕;height:150px; name="compileRlt" ></textarea>

<hr>

</c:forEach>
</div>
</body>
<script>

$(document).ready(function(){

	
	$("#compileRlt1").hide();$("#compileRlt2").hide();$("#compileRlt3").hide();$("#compileRlt4").hide();$("#compileRlt5").hide();
    $("#compile1").click(function(){
    	var sendData = {userCode : $("#userCode1").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/getCompileRlt",
        	contentType : "application/x-www-form-urlencoded; charset=utf-8",
        	success : function(data){
        		$("#compileRlt1").val(data);
        	}
        })
        $("#compileRlt1").show();
    });
    $("#compile2").click(function(){
    	var sendData = {userCode : $("#userCode2").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/getCompileRlt",
        	success : function(data){
        		$("#compileRlt2").val(data);
        	}
        })
        $("#compileRlt2").show();
    });
    $("#compile3").click(function(){
    	var sendData = {userCode : $("#userCode3").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/getCompileRlt",
        	success : function(data){
        		$("#compileRlt3").val(data);
        	}
        })
        $("#compileRlt3").show();
    });
    $("#compile4").click(function(){
    	var sendData = {userCode : $("#userCode4").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/getCompileRlt",
        	success : function(data){
        		$("#compileRlt4").val(data);
        	}
        })
        $("#compileRlt4").show();
    });
    $("#compile5").click(function(){
    	var sendData = {userCode : $("#userCode5").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/getCompileRlt",
        	success : function(data){
        		$("#compileRlt5").val(data);
        	}
        })
        $("#compileRlt5").show();
    });
    
    $("#submit1").click(function(){
    	var sendData = {testCode : ${testCode},questionNo : 1, title : "${title}", sourceCode : $("#userCode1").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/submitCode",
        	contentType : "application/x-www-form-urlencoded; charset=utf-8",
        	success : function(data){
        		alert(data);
        	}
        })
    });
    $("#submit2").click(function(){
    	var sendData = {testCode : ${testCode},questionNo : 2, title : "${title}", sourceCode : $("#userCode2").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/submitCode",
        	contentType : "application/x-www-form-urlencoded; charset=utf-8",
        	success : function(data){
        		alert(data);
        	}
        })
    });
    $("#submit3").click(function(){
    	var sendData = {testCode : ${testCode},questionNo : 3, title : "${title}", sourceCode : $("#userCode3").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/submitCode",
        	contentType : "application/x-www-form-urlencoded; charset=utf-8",
        	success : function(data){
        		alert(data);
        	}
        })
    });
    $("#submit4").click(function(){
    	var sendData = {testCode : ${testCode},questionNo : 4, title : "${title}", sourceCode : $("#userCode4").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/submitCode",
        	contentType : "application/x-www-form-urlencoded; charset=utf-8",
        	success : function(data){
        		alert(data);
        	}
        })
    });
    $("#submit5").click(function(){
    	var sendData = {testCode : ${testCode},questionNo : 5, title : "${title}", sourceCode : $("#userCode5").val()};
        $.ajax({
        	type : "POST",
        	dataType : "text",
        	data : sendData,
        	url : "/submitCode",
        	contentType : "application/x-www-form-urlencoded; charset=utf-8",
        	success : function(data){
        		alert(data);
        	}
        })
    });
});
</script>
</html>