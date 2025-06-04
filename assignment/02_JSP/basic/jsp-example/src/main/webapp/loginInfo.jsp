<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 정보 확인</title>
</head>
<body>
<h2>입력한 로그인 정보</h2>
    <%--
    getParameter -> 요청
    내장객체(request)에 .getParameter() key를 사용하여 request(요청)에 담긴 값을 가져옴.
    --%>
    <p>아이디: <%= request.getParameter("userid") %></p>
    <p>비밀번호: <%= request.getParameter("password") %></p>
<%--
    request 객체란?
    - JSP에서 기본 제공되는 내장 객체 (Implicit Object)
    - 클라이언트가 보낸 요청 정보(폼 데이터, URL 파라미터 등)를 담고 있음
    - 별도 선언 없이 <%= request.getParameter("key") %>로 바로 사용 가능
    - 클래스: javax.servlet.http.HttpServletRequest
--%>
</body>
</html>
