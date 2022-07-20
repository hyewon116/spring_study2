<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>day5_ajax1.jsp</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jquery 링크 달기 -->
	</head>
	<body>
		<h2>Ajax = Asynchronous Javascript and Xml </h2>
		<h3>Asynchronous = (사전적 의미)동시에 발생하지 않는다.</h3>
		<h3>Asynchronous = 화면 전환과 데이터 전송이 동시에 일어나지 않는다는 의미.</h3>
		<h3>Asynchronous = 화면은 그대로 있고, 서버와 보이지 않는 통신을 한다는 의미.</h3>
		<h3>javascript = 자바스크립트를 통해 동작한다는 의미.</h3>
		<h3>Xml = XmlHttpRequest, XmlHttpResponse 통신을 의미</h3>
		
		<hr>
		<h1 id="txtFromServer">여기가 서버로부터 오는 메시지가 들어오는 자리입니다.</h1>
		<button id="btn1"> jquery ajax 실행</button>
		<h1>RootPath = ${pageContext.request.contextPath}</h1>
		<script type="text/javascript">
		$(document).ready(function() { 	$("#btn1").click(function() {
				
				$.get(//get 방식의 통신을 의미 
						//get ()소괄호의 첫 번쨰 자리는 통신을 하는 서버의 주소.(@RequestMapping의 value)
						"${pageContext.request.contextPath}/ajax1_test" 
						//get ()소괄호의 두 번쨰 자리는 서버로 보내는 데이터
						//, 
						
						//get ()소괄호의 세 번쨰 자리는 서버에서 호출하는 함수(callback function)
						//data : 서버가 보내는 data
						//status : 서버와의 통신 상태, 에러가 나도 통신 연결만 됐다면 succeess
						, function(data, status) { 
							alert(data);
							alert(status);
							$("#txtFromServer").text( data );
						}//anonymous funtion 
 				);//get
				
			});//click
		});//ready
		</script>
	</body>
</html>