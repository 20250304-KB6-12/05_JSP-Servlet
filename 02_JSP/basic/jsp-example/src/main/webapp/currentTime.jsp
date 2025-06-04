<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>현재 시간</title>
</head>
<body>
<h2>현재 시간</h2>
<p>
    <%-- 현재 시간 객체 생성 --%>
    <%
        Date now = new Date();
        out.println(now.toString());
    %>
</p>
</body>
</html>
