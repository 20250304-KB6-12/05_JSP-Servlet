package org.scoula.ex06;
import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

import javax.servlet.annotation.WebServlet;
import java.util.Map;


@WebServlet(name = "frontControllerServlet", value = "/")
public class HomeControllerServlet extends DispatcherServlet {

  /* 컨트롤러 객체 생성 */
  HomeController homeController = new HomeController();

  /* DispatcherServlet 상속 받은 메서드 구현 */
  @Override
  protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap){

    // GET 매핑
    getMap.put("/", homeController::getIndex);
  }

}