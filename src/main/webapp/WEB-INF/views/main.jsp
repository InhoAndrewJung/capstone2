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
	<nav class="navbar navbar-light bg-light" style=height:80px;>
  		<span class="navbar-brand mb-0 h1" style=font-size:30px;>CODE insight</span>
  	</nav>
  	<div style=height:100%;background:#000e18;>
  	<div class="container" style="max-width: 80%;">
  		<div class="row">
  		<p class="text-center" style="font-size:100px;color:white">The most advanced Universal Test Platform</p>
  		
  		</div>
  		<div class="row, d-flex justify-content-center">
			<form action="/makeTestStarter" method="post">
				<input type="submit" value="Create Test" style="height:300px;width:300px;color:white;font-size:50px;background: #678e30;border: 0px;"/>
			</form>  
			<span>&nbsp&nbsp</span>
			<form action="/takeTestStarter" method="post">
				<input type="submit" value="Take Exam" style="height:300px;width:300px;color:white;font-size:50px;background: #678e30;border: 0px;"/>
			</form>
			<span>&nbsp&nbsp</span>
			<form action="/myPage" method="post">
	  			<input type="submit" value="Control" style="height:300px;width:300px;color:white;font-size:50px;background: #678e30;border: 0px;"/>
	 		 </form>
	 		 <span>&nbsp&nbsp</span>
	 		 <form action="/signout" method="post">
	  			<input type="submit" value="Logout" style="height:300px;width:300px;color:white;font-size:50px;background: #678e30;border: 0px;"/>
	    	</form>
	    	</div>	
    	</div>
  	</div>

  
   <!--  <form action="/makeProblem" method="post">
  	<input type="submit" value="문제출제"/>
  </form>
    <form action="/takeProblem" method="post">
  	<input type="submit" value="문제풀기"/>
  </form>
  
    <form action="/checkGrade" method="post">
  	<input type="submit" value="성적확인"/>
  </form> -->
    
  <br>
    
    
</body>
</html>

