<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>방문자 수 보기</title>
</head>
<body>
<h2>현재 방문자 수</h2>
<%
    Integer count = (Integer)application.getAttribute("count");

    if (count == null) {
        count = 0; // count.jsp가 실행되지 않았다면 0으로 표시
    }
%>

<p>총 방문자 수: <%= count %></p>
</body>
</html>
