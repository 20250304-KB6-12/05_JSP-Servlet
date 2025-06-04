<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 정보 확인</title>
</head>
<body>
<h2>세션에 저장된 로그인 정보</h2>
<%
    String userid = (String)session.getAttribute("userid");
    String password = (String)session.getAttribute("password");

    // 다끝내고 세션확인하기
//    String sesssion = String.valueOf(request.getSession());
//    String sesssionId = String.valueOf(request.getSession().getId());
//    System.out.println("세션 : " + sesssionId);
%>

<p>아이디: <%= userid %></p>
<p>비밀번호: <%= password %></p>

<p><a href="logout.jsp">로그아웃</a></p>
</body>
</html>
