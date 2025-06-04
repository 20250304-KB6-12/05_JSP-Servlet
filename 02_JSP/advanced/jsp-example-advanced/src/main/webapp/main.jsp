<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>메인 화면 페이지</title>
</head>
<body>

<h1>include 지시어 태그 실습</h1>
내용 수정중입니다. 다음 줄에 삽입이 됩니다. <br>

<%--
    정적 Include
    - JSP 번역 시, 지정된 파일의 내용을 현재 위치에 그대로 삽입함
    - 공통 코드(헤더, 푸터 등) 재사용에 유용함
    - 포함된 파일이 변경되면 원본 JSP도 다시 컴파일 필요
    - 실행 시가 아닌 컴파일 시 포함됨 (정적 include)
--%>
<%@ include file="copyright.jsp" %>

</body>
</html>
