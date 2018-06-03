<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
<script src="http://malsup.github.com/jquery.form.js"></script>
<script> 
        // wait for the DOM to be loaded 
        $(document).ready(function() { 
            // bind 'questionNo' and provide a simple callback function 
            $('#question1').ajaxForm(function() { 
                alert("저장되었습니다"); 
            }); 
            $('#question2').ajaxForm(function() { 
                alert("저장되었습니다"); 
            }); 
            $('#question3').ajaxForm(function() { 
                alert("저장되었습니다"); 
            }); 
            $('#question4').ajaxForm(function() { 
                alert("저장되었습니다"); 
            }); 
            $('#question5').ajaxForm(function() { 
                alert("저장되었습니다"); 
            }); 
        }); 
        
        function complete(){
        	alert("출제가 완료되었습니다");
        	
        }
     
</script> 
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="container" style="max-width: 80%;">
<div style=height:80px></div>
    <h1 class="font-weight-bold">${testTitle} 출제</h1>
    <div style=height:30px></div>
    <c:forEach var="i" begin="1" end="${count}" step="1">
    <form action="/registerTest" id="question${i}" method="post">
    
    	<h1>문제${i}</h1>
    	문제제목
    	<textarea class="form-control" name="title" rows="1" cols="200" ></textarea><br>
    	문제
    	<textarea class="form-control" name="problem" rows="10" cols="200" ></textarea><br>
    	입력
    	<textarea class="form-control" name="input" rows="5" cols="200" ></textarea><br>
    	출력
    	<textarea class="form-control" name="output" rows="5" cols="200" ></textarea><br>
    	예시입력
    	<textarea class="form-control" name="exInput" rows="5" cols="200" ></textarea><br>
    	예시출력
    	<textarea class="form-control" name="exOutput" rows="5" cols="200" ></textarea><br>
    	채점용데이터입력
    	<textarea class="form-control" name="gradeInput" rows="5" cols="200" ></textarea><br>
    	채점용데이터출력
    	<textarea class="form-control" name="gradeOutput" rows="5" cols="200" ></textarea><br>
    <input type="hidden" name = "testCode" value="${testCode}"/>
    <input type="hidden" name="accessCode" value="${accessCode}"/>
    <input type="hidden" name ="count" value="${count}"/>
    <input type="hidden" name = "testTime" value="${testTime}"/>
    <input type="hidden" name="email" value="${email}"/>
    <input type="hidden" name="name" value="${name}"/>
    <input type="hidden" name="questionNo" value="${i}"/>
    
    <input type="submit" class="btn btn-success" value="저장"/>
    </form>
    <div style=height:50px></div>
    </c:forEach>
    
    <form action="/main" method="post">
    	<input type="submit" class="btn btn-danger" value=" 출제완료" onclick="complete()"/>
    </form>
    </div>
</body>
</html>