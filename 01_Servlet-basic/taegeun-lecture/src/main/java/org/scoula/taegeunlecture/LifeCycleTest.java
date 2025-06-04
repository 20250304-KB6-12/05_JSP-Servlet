package org.scoula.taegeunlecture;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet(name = "lifeCycle", value = "/life-cycle")
// 이미지랑 같이 설명
public class LifeCycleTest extends HttpServlet {
    /* 필기. 각 메소드의 호출 횟수를 카운트 할 목적의 필드 */
    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    // 필기. 최초 서블릿 요청 시에 동작하는 메소드
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init() 메소드 호출 " + initCount++);
    }

    // 필기. 서블릿 컨테이너가 종료될 때 호출되는 메소드이며 주로 자원을 반납하는 용도로 사용한다.
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destory() 메소드 호출 " + destroyCount++);
    }


    /*
        get방식으로 보내게 될때, 같이 딸려가는 글자수가 255자 이상이면 잘리게되는데, 255자 넘는것들도 우린 처리해야 할 수 있잖아요?
        그래서 개를 받아 줄 수 있는 영역을 만들어서 긴문장을 담아 줄 수 있는 통신방법이 POST 방식입니다.
        이때, 이 영역을 RequestBody라고 합니다.
        그래서 이 두가지를 계속해서 보게 될겁니다.
        그러면 이제 이요청이 오는데, get 방식으로 오는지 post방식으로 오는지 서버가 알아야겠죠
        이걸 알게 해주는것을 이제 서블릿 서비스라는 곳에서 분기 처리를 해줄 겁니다.
    * */
    // service는 요청이 들어왔을 때, 해당 요청이 httpMethod중 get인지 Post인지 구분해서 처리해준다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 필기.
         *   서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init() 이후에 동작하고,
         *   두 번째 요청부터는 init() 호출 없이 바로 service()를 호출한다.
         * */
        System.out.println("xml 매핑 service() 메소드 호출 " + serviceCount++);
    }
}