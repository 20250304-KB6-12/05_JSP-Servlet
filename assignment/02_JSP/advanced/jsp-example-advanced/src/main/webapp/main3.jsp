<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>include 액션 실습</title>
</head>
<body>

<h1>include 태그 실습</h1>
현재 시간을 구하는 예제입니다. 다음 줄에 삽입이 됩니다. <br>


<%--
    <jsp:param> 태그]
    - <jsp:include>  내부에서 사용함
    - 포함되거나 전달될 JSP 파일에 값을 전달하는 용도
    - name: 전달할 파라미터 이름
    - value: 전달할 값
    - request.getParameter("nickName")로 포함된 JSP에서 받을 수 있음
--%>
<jsp:include page="header2.jsp" flush="true">
    <jsp:param name="nickName" value="홍" />
</jsp:include>

</body>
</html>
