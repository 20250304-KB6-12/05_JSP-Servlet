<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 필기.
지시자 태그 (Directive Tag)
- JSP 페이지에 대한 설정 정보를 지정할 때 사용하는 태그이다.
- 형식: "<%@ 지시자이름 속성="값" %>"
- 대표적인 지시자: page, include, taglib

page 지시자
- JSP 페이지의 속성(예: 인코딩, import, 오류 처리 등)을 설정할 때 사용
- 자바 클래스 import도 이 지시자를 통해 설정한다.

-->
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<!-- 순서 2. jsp 주석 태그 -->
<%-- jsp 주석 --%>
<%-- html 주석 --%>
<%-- 필기. html 주석은 클라이언트에 노출되지만, jsp 주석은 클라이언트에게 노출되지 않는다. --%>
<%-- 실행시킨후, 페이지 소스보기를 이용해 확인시켜주기 --%>

<!-- 순서 3. 선언 태그
-->
<!-- 필기. 서블릿으로 변환 시 선언 태그 내에 작성한 내용을 필드로 선언한다. -->
<%!
    private String name;
    private int age;
%>

<!-- 순서 4. scriptlet 태그 -->
<%
    // 필기. 간단한 자바 코드를 작성할 수 있는 부분이다.
    /* 설명. 스크립틀릿 태그 내애서의 주석은 자바 주석과 동일하다. */
    /* 설명. 선언 태그에서 작성한 내용을 초기화 하고 출력할 수 있으며, 간단한 로직 처리도 가능하다. */
    /* 설명. 여기서 작성하는 코드는 자바 코드이기 때문에 ;(세미콜론)을 작성하지 않으면 compile 과정에서 에러가 발생한다. */
    name = "홍길동";
    age = 20;

    System.out.println("name : " + name);
    System.out.println("age : " + age);

    /* 필기. 간단한 로직도 작성 가능하다. */
    for(int i = 0; i < name.length(); i++) {
        System.out.println(name.charAt(i));
    }
    // 설명. 실행해보면 콘솔에 결과가 잘 출력된다.

%>
<!-- 순서 5. expression 태그 -->
<!-- 필기. PrintWriter 를 이용하여 브라우저에 값을 내보내 브라우저에서 보여지게 한다. -->
<!-- 설명.
        자바 코드로 변환 시 out.print(); 괄호 안에 expression 태그 내애 작성한 내용이 들어간다.
        정상적으로 출력한 값을 작성하는 경우 out.print(name); 이런 식으로 표현되는데
        expression 태그 내에 세미콜론을 작성하면 out.print(name;); 형태가 되므로 compile 에러가 발생한다.
-->
name : <%= name %>
age : <%= age %>

</body>
</html>