<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>include 액션 실습</title>
</head>
<body>

<h1>include 액션 태그 실습</h1>
현재 시간을 구하는 예제입니다. 다음 줄에 삽입이 됩니다. <br>

<%--
    동적 include 태그 설명
    - 실행 시점에 header.jsp 파일을 현재 위치에 포함함
    - 요청(request), 응답(response) 객체를 공유함
    - flush="true": 포함 전 출력 버퍼를 비움 (거의 필수처럼 사용됨)
    - 포함된 파일이 수정되면 바로 반영됨 (재컴파일 필요 없음)
    - 자주 변경되는 콘텐츠(예: 로그인 상태, 공지사항 등)에 적합
--%>
<jsp:include page="header.jsp" flush="true" />

</body>
</html>
