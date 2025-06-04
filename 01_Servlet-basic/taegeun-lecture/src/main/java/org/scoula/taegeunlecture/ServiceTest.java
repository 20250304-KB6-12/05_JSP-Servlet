package org.scoula.taegeunlecture;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "serviceTest", value = "/service-test")
public class ServiceTest extends HttpServlet {

    // service는 요청이 들어왔을 때, 해당 요청이 httpMethod중 get인지 Post인지 구분해서 처리해준다.
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        /*
         * 설명
         * 아래 있는 doGet과 doPost를 보면 request와 response 앞에 HTTP라고 쓰여 있다.
         * 이친구들을 들어가보자 그럼 얘네는 ServletRequest와 ServletResponse를 상속받고 있다.
         * 우리가 지금은 HTTP 프로토콜을 사용하지만 나중에 HTTPS를 쓴다던지 WebSocket을 쓴다던지 등
         * 프로토콜이 바뀔 수 있다. 이렇듯 바뀌기 위해 ServletRequest와 ServeletResponse를 추상화를 해놓고,
         * 이를 상속받은 HttpServletRequest, Response로 다운캐스팅 해 사용한다.
         * */
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        /*
         * 설명. 하위 타입으로 다운캐스팅 한 후 요청받은 http 메소드가 어떤 메소드인지 판단한다.
         * */
        // 필기. httpRequest의 getMehtod() : 어떠한 http method 요청이 들어온 건지 문자열 형태로 반환한다.
        String httpMethod = httpRequest.getMethod();

        /*
         * 설명 요청 내용을 한번 출력해보자
         * */
        // 필기. a태그의 href 속성은 화면의 url 내용을 변경하는 방식으로 GET 요청에 해당한다.
        System.out.println("http method : "+ httpMethod);

        // service는 get과 post를 구분해준다 했죠?
        // 내부적으로 이렇게 분리를 해줍니다. 우리는 이걸 해보는거에요
        if(("GET").equals(httpMethod)) {
            /* 필기. GET 요청을 처리할 메소드로 요청과 응답 정보를 전달한다. */
            doGet(httpRequest, httpResponse);

        } else if(("POST").equals(httpMethod)) {
            /* 필기. POST 요청을 처리할 메소드로 요청과 응답 정보를 전송한다. */
            doPost(httpRequest, httpResponse);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }
}