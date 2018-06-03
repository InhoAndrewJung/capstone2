<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="container" style="max-width: 80%;">
<div style=height:80px></div>
<h1 class="font-weight-bold">출제 시작하기</h1>
<div style=height:30px></div>
<form action="makeTest" method="post">
	시험제목<input type="text" class="form-control" style=width:30%; name="title" placeholder="시험제목을 입력하세요" required/><br>
	<input type="hidden" id=testTime name="testTime" value="1">
	<!-- 시험시간
	<div class="form-group"style=width:30%;>
	<select id="testTime" class="custom-select" required name="testTime">
		<option value="1">1시간</option>
		<option value="2">2시간</option>
		<option value="3">3시간</option>
		<option value="4">4시간</option>
		<option value="5">5시간</option>
	</select>
	</div> -->
	
	문제 수
	<div class="form-group" style=width:30%;>
	<select id="count"  class="custom-select" name="count">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
	</select>
	</div>
	문제코드
	<input type="text" class="form-control" style=width:30%; name="testCode" value="${testCode}" readonly/><br>
	액세스코드
	<input type="text" class="form-control" style=width:30%; name="accessCode" value="${accessCode}" readonly/><br>
	<input type="hidden" name="email" value="${email}"/>
	<input type="submit" class="btn btn-primary" value="출제하기"/>
</form>
</div>
</body>
</html>