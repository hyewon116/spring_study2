<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>emp_detail.jsp</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<table class ="table table-hover">
			<tr>
				<th>사번</th> <td>${detail_dto.empno}</td>
				<th>이름</th> <td>${detail_dto.ename}</td>
			</tr>
			<tr>
				<th>직업</th> <td>${detail_dto.job}</td>
				<th>팀장</th> <td>${detail_dto.mgr}</td>
			</tr>
			<tr>
				<th>입사일</th> <td>${detail_dto.hiredate}</td>
				<th>부서번호</th> <td>${detail_dto.deptno}</td>
			</tr>
			<tr>
				<th>급여</th> <td>${detail_dto.sal}</td>
				<th>성과급</th> <td><i class="fa fa-won"></i>${detail_dto.comm}</td>
			</tr>
		</table>
	</body>
</html>