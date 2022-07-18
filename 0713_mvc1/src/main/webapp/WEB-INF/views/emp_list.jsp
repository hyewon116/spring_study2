<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>emp_list.jsp</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>사번</th> <th>이름</th> <th>직업</th> <th>팀장사번</th>
					<th>입사일</th> <th>급여</th> <th>보너스</th> <th>팀번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${emp_dto_list}" varStatus="">
					<tr> 
						<td>${dto.empno}</td> 
						<td>
							<a href="${pageContext.request.contextPath}/emp/detail?eno=${dto.empno}">
								${dto.ename}
							</a>
						</td> 
						<td>${dto.job}</td> <td>${dto.mgr}</td>
						<td>${dto.hiredate}</td> <td>${dto.sal}</td> 
						<td>${dto.comm}</td> <td>${dto.deptno}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>