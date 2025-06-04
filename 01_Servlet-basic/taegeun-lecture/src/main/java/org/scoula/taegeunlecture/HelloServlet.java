package org.scoula.taegeunlecture;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/*
서블릿(Servlet)이란?
자바로 작성된 웹 프로그램에서, 클라이언트(브라우저)의 요청을 처리하고,
그에 대한 응답을 보내주는 자바 클래스.

✅ 흐름을 간단히 예를 들어 볼게요:
사용자(여러분)가 컴퓨터에서 웹 브라우저를 켜고 주소를 입력합니다.
예: http://localhost:8080/myapp/hello
이 주소에서:
localhost:8080은 여러분 컴퓨터에서 실행 중인 웹 서버(톰캣)의 주소와 포트를 나타냅니다.
/myapp/hello는 이 서버 안에 있는 특정 서블릿에 요청을 보내는 경로(URL)입니다.
그런데 아직 우리는 이 요청 경로(/myapp/hello)를 어떤 서블릿과 연결할지 설정한 적이 없죠.
그래서 이 경로를 서블릿과 연결해 주는 작업을 해야 합니다.
✅ 서블릿 연결 방법은 두 가지가 있습니다:
예전 방식: web.xml 파일에 <servlet> 태그와 <url-pattern>을 사용하여 경로 설정
요즘 방식: 서블릿 클래스에 @WebServlet("/hello") 어노테이션을 사용
이제 우리는 이 중에서 web.xml을 이용한 방식으로 경로 설정을 연습해 볼 거예요.
*/
//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name = "helloServlet", urlPatterns = {"/hello-servlet", "/bye-servlet"})
public class HelloServlet extends HttpServlet {
    private String message;

    // 필기. 최초 서블릿 요청 시에 동작하는 메소드
    public void init() {
        message = "Hello World!";
    }

    /*
     * 필기.
     *   서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init() 이후에 동작하고,
     *   두 번째 요청부터는 init() 호출 없이 바로 service()를 호출한다.
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        // MIME 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    // 필기. 서블릿 컨테이너가 종료될 때 호출되는 메소드이며 주로 자원을 반납하는 용도로 사용한다.
    public void destroy() {
    }
}