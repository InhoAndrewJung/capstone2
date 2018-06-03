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
	<div class="row">
		<div class="col">
<div style=height:80px></div>
<h1 class="font-weight-bold">제어센터</h1>
<div style=height:50px></div>
<h3>내가 응시한 시험</h3><br>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">테스트코드</th>
      <th scope="col">시험명</th>
      <th scope="col">문제번호</th>
      <th scope="col">소스코드</th>
      <th scope="col">채점결과</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${takeList}">
  <form action="/getSourceCode">
  		<input type="hidden" id = "email" name = "email" value="${email}"/>
		<input type="hidden" id = "testCode" name = "testCode" value="${item.testCode}"/>
		<input type="hidden" id = "questionNo" name = "questionNo" value="${item.questionNo}"/>
    <tr>
      <th scope="row">${item.testCode}</th>
      <td>${item.title }</td>
      <td>${item.questionNo}번</td>
      <td><input type ="submit"  class="btn btn-secondary" id="soureCode" value="소스코드"/></td>
      <td>${item.testResult}</td>
    </tr>
    </form>
   </c:forEach>
    
  </tbody>
  </table>
<!--<c:forEach var="item" items="${takeList}">
	<form action="/getSourceCode">
		${item.testCode} ${item.title } ${item.questionNo}번 문항
		<input type ="submit" id="soureCode" value="소스코드"/>
		<input type="hidden" id = "email" name = "email" value="${email}"/>
		<input type="hidden" id = "testCode" name = "testCode" value="${item.testCode}"/>
		<input type="hidden" id = "questionNo" name = "questionNo" value="${item.questionNo}"/>
		${item.testResult}
	</form>
</c:forEach> -->
</div> 

	<div class="col">
	<div style=height:185px></div>
<h3>내가 출제한 시험</h3><br>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">테스트코드</th>
      <th scope="col">액세스코드</th>
      <th scope="col">시험명</th>
      <th scope="col">채점하기</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${makeList}">
	<form action="/requestMark">
	<input type="hidden" name = "testCode" value="${item.testCode}"/>
	<input type="hidden" name = "accessCode" value="${item.accessCode}"/>
    <tr>
      <th scope="row">${item.testCode}</th>
      <td>${item.accessCode }</td>
      <td>${item.title }</td>
      <td><input type="submit" class="btn btn-info" value="채점"/></td>
    </tr>
    	</form>
</c:forEach>

<!--<c:forEach var="item" items="${makeList}">
	<form action="/requestMark">
		${item.testCode} ${item.accessCode } ${item.title }
		<input type="hidden" name = "testCode" value="${item.testCode}"/>
		<input type="hidden" name = "accessCode" value="${item.accessCode}"/>
		<input type="submit" value="채점"/> <br>
	</form>
</c:forEach>-->


</div>
</div>
</div>
</body>
<script>

/* 	$("#soureCode").click(function (){
		
		var sendData = {email : $("#email").val(), testCode : $("#testCode").val(), questionNo : $("#questionNo").val()}
		 $.ajax({
			type : "POST",
			dataType : "text",
			data : sendData,
			url : "/getSourceCode",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(data){
				alert(data);
			}
		}) 
	}) */
	
</script>
</html>