<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>방문자 수 카운트</title>
</head>
<body>
<h2>방문자 수 카운트</h2>
<%
    // application.getAttribute()
    // 서버 내부에서 공유한 객체를 읽기
    Integer count = (Integer)application.getAttribute("count");

    if (count == null) {
        count = 1;  // 최초 방문자는 1로 초기화
    } else {
        count++;    // 이후 방문자는 +1 증가
    }

    // 최신 방문자 수 저장
    application.setAttribute("count", count);
%>

<p>현재까지 방문자 수: <%= count %></p>
</body>
</html>
