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
	h3{
		text-align: right !important;
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

</script>
</head>
<body>
	<div id="container">
		<h3><a href="add.do">[새 프로젝트 등록]</a></h3>
		<table>
			<tr>
				<th>프로젝트 이름</th>
				<th>시작날짜</th>
				<th>종료날짜</th>
				<th>상태</th>
			</tr>
			<c:forEach var="list" items="${list }">
				<tr>
					<td><a href="view.do?no=${list.serialNumber }">${list.projectName }</a></td>
					<td>${list.startDate }</td>
					<td>${list.endDate }</td>
					<td>${list.currentState }</td>
				</tr>
			</c:forEach>
		
		</table>
	</div>
</body>
</html>