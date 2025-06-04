<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 전달받은 파라미터 수신
    String userid = request.getParameter("userid");
    String password = request.getParameter("password");

    // 세션에 저장
    session.setAttribute("userid", userid);
    session.setAttribute("password", password);

    // loginInfo.jsp로 이동
    response.sendRedirect("loginInfo.jsp");
%>
