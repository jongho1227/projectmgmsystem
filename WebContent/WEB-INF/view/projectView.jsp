<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#container{
		width:900px;
		margin:0 auto;
		text-align: center;
	}
	
	table{
		border-collapse: collapse;
		width:800px;
		text-align: center;
	}
	th, td{
		border: 1px solid black;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#delete").click(function(){
			 var a = confirm("삭제하시겠습니까?");
			 if(a==true){
				 location.href="delete.do?no=${project.serialNumber }";
			 }
			 return false;
		})
	})
</script>
</head>
<body>
<div id="container">
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<td>${project.projectName}</td>
		</tr>
		<tr>
			<th>프로젝트 내용</th>
			<td>${project.content}</td>
		</tr>
		<tr>
			<th>시작날짜</th>
			<td>${project.startDate}</td>
		</tr>
		<tr>
			<th>종료날짜</th>
			<td>${project.endDate}</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>${project.currentState}</td>
		</tr>
	</table>
	<a href="update.do?no=${project.serialNumber }">[수정]</a><a href="#" id="delete">[삭제]</a><a href="list.do">[돌아가기]</a>
</div>
</body>
</html>