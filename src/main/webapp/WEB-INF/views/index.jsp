<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<nav class="navbar navbar-dark " style=height:80px;background-color:#000e18;>
  		<span class="navbar-brand mb-0 h1" style=font-size:30px;>CODE insight</span>
  	</nav>
  	<div style=height:20%;>
  	</div>

	<div class="container">
	<div class="row">
	<div class="col">
	<h1 class="font-weight-bold">시작하기</h1>		
	    <form action="/signin" method="post">
	        email<input type="email" class="form-control"name="email" required="required"/><br>
	        password<input type="password" class="form-control"name="password" required="required"/><br>
	        <input class="btn btn-primary" type="submit" value="login"/>
	    </form>
	    </div>
	    <br>
	    <div class="col">
	    <h1 class="font-weight-bold">새로운 시작 </h1>
	    <form action="/signup" method="post">
	        email  <input type="email" class="form-control" name="email" required="required"/><br>
	        password  <input type="password" class="form-control" name="password" required="required"/><br>
	        student no  <input type="text" class="form-control" name="studentNo"/><br>
	        name :<input type="text" class="form-control" name="name"/><br>
	        <input class="btn btn-primary" type="submit" value="signup"/>
	    </form>
	    </div>
	    </div>
    </div>
</body>
</html>