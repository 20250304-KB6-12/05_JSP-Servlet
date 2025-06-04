<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 세션 무효화
    session.invalidate();

    // 로그인 폼으로 리다이렉트
    response.sendRedirect("loginForm.html");
%>