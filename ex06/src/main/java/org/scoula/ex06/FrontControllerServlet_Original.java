package org.scoula.ex06;
import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//  value = "/"  : 모든 요청을 해당 서블릿에 매핑
// - /test, /board 등의 요청이 왔을 때
//   이를 처리하는 서블릿이 없다면
//   "/"를 처리하는 서블릿으로 fallback(대체)된다!!
@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet_Original extends HttpServlet {

  // URL과 Command 매핑을 저장하는 Map
  Map<String, Command> getMap;
  Map<String, Command> postMap;

  // View Resolver 설정
  // - forward 요청 시 JSP 경로를 나타낼 접두사/접미사
  // req.getRequestDispatch(경로).forward(req,res);
  // 경로 == (webapp 폴더 기준)  /WEB-INF/views/index.jsp
  // /WEB-INF/views/todo/list.jsp
  // /WEB-INF/views/todo/create.jsp
  String prefix = "/WEB-INF/views/";
  String suffix = ".jsp";


  /* 컨트롤러 객체 생성 */
  HomeController homeController = new HomeController();
  TodoController todoController = new TodoController();


  // 서블릿 객체 생성 시 실행되는 init() 메서드
  @Override
  public void init() {
    getMap = new HashMap<>();
    postMap = new HashMap<>();

    // 🏠 메인 페이지 요청
    //getMap.put("/", homeController::getIndex);
    getMap.put("/", (req, res) -> "index");

    // GET 매핑
//    getMap.put("/todo/list", todoController::getList);

//    getMap.put("/todo/list", (req, res) -> "todo/list");

    getMap.put("/todo/list", new Command() {
      @Override
      public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return "todo/list";
      }
    });


    getMap.put("/todo/view", todoController::getView);
    getMap.put("/todo/create", todoController::getCreate);
    getMap.put("/todo/update", todoController::getUpdate);

    // POST 매핑
    postMap.put("/todo/create", todoController::postCreate);
    postMap.put("/todo/update", todoController::postUpdate);
    postMap.put("/todo/delete", todoController::postDelete);

  }

  /* URL 식별 값 추출 메서드 */
  private String getCommandName(HttpServletRequest req) {
    String requestURI = req.getRequestURI(); // 전체 URI 반환
    String contextPath = req.getContextPath(); // context 경로 반환
    return requestURI.substring(contextPath.length());

    // ex) http://localhost:8080/todo/update
    //    -> /todo/update 반환
  }

  /* 커맨드 가져오기 */
  // URL과 Command가 저장된 Map(getMap, postMap)에서
  //요청 URL에 맞는 Command 객체 조회
  private Command getCommand(HttpServletRequest req) {

    String commandName = getCommandName(req); // /todo/update
    Command command;

    if(req.getMethod().equalsIgnoreCase("GET")) {
      command = getMap.get(commandName);
    } else {
      command = postMap.get(commandName);
    }
    return command;
  }

  /* 커맨드 실행 및 뷰 연결 처리 */
  public void execute(Command command, HttpServletRequest req, HttpServletResponse resp)
          throws IOException, ServletException {

    // Command를 실행하여 View 이름 얻어오기
    String viewName = command.execute(req, resp); // "redirect:/todo/list"

    // 얻어온 View 이름이 "redirect:"로 시작하는 경우 Redirect
    if(viewName.startsWith("redirect:")) { // redirect 처리

      // redirect 요청은 무조건 "GET"
      resp.sendRedirect(viewName.substring("redirect:".length()));
    }

    // 나머지 경우는 접두사/접미사를 붙여 JSP로 Forward
    else { // forward 처리
//      String prefix = "/WEB-INF/views/";
//      String suffix = ".jsp";

      // /WEB-INF/views/index.jsp
      String view = prefix + viewName + suffix;
      RequestDispatcher dis = req.getRequestDispatcher(view);
      dis.forward(req, resp);
    }
  }


  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

    Command command = getCommand(req);

    if(command != null) { // url이 일치하는 커맨드가 있으면 실행
      execute(command, req, resp);

    } else { // url이 일치하는 커맨드가 없다 -> 404 에러 처리
      String view = prefix + "404" + suffix;
      RequestDispatcher dis = req.getRequestDispatcher(view);
      dis.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    doGet(req, resp);  // GET과 동일한 처리 로직 사용
  }

}