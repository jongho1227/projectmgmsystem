<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label{
		width:120px;
		float: left;
	}
</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<script src="js/jquery-ui.js"></script>
<script type="text/javascript">
	$(function(){
		$(".datepicker").datepicker();
		if("${project.currentState}"=="준비"){
			$("#prepare").attr("selected","selected");
		}else if("${project.currentState}"=="진행중"){
			$("#being").attr("selected","selected");
		}
		else if("${project.currentState}"=="종료"){
			$("#end").attr("selected","selected");
		}
		else if("${project.currentState}"=="보류"){
			$("#defer").attr("selected","selected");
		}
		
		$("form").submit(function(){
			var start = $("input[name='start']").val();
			var end = $("input[name='end']").val();
			
			var startDate = new Date(start);
			var endDate = new Date(end);
			
			if(startDate.getTime()>endDate.getTime()){
				alert("마감날짜는 시작날짜이후로 선택하세요.");
				return false;
			}
		})
		
	})
</script>
<body>
	<form action="update.do" method="post">
		<label>프로젝트 이름</label>
		<input type="text" name="name" value=${project.projectName }><br><br>
		<input type="hidden" name="no" value=${project.serialNumber }>
		<label>프로젝트 내용</label>
		<textarea rows="20" cols="50" name="content">${project.content }</textarea><br><br>
		<label>시작날짜</label>
		<input type="text" name="start" value=${project.startDate } class="datepicker" autocomplete="off"><br><br>
		<label>마감날짜</label>
		<input type="text" name="end" value=${project.endDate }  class="datepicker" autocomplete="off"><br><br>
		<label>상태 :</label>
		<select name="kind">
			<option id="prepare">준비</option>
			<option id="being">진행중</option>
			<option id="end">종료</option>
			<option id="defer">보류</option>
		</select><br><br>
		<input type="submit" value="수정"> <input type="reset" value="취소">
	</form>
</body>
</html>