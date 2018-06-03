<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
<script src="http://malsup.github.com/jquery.form.js"></script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="container" style="max-width: 80%;">
<div style=height:80px></div>
<h1 class="font-weight-bold">시험응시</h1>
<div style=height:30px></div>
<form action="takeTest" id="testSetting" method="post">
	시험코드<input type="text" class="form-control" style=width:30%; name="testCode"/>${data }<br>
	언어선택<input type="radio" name="language" value="phython" checked/>파이썬<br>
	<input type="submit" class="btn btn-primary" value="시험시작하기"/>
</form>
</div>
</body>
</html>