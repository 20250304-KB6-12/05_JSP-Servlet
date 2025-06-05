package org.scoula.ex06;
import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

import javax.servlet.annotation.WebServlet;
import java.util.Map;


@WebServlet(name = "frontControllerServlet", value = "/todo/*")
public class TodoControllerServlet extends DispatcherServlet {

  /* 컨트롤러 객체 생성 */
  TodoController todoController = new TodoController();

  /* DispatcherServlet 상속 받은 메서드 구현 */
  @Override
  protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap){

    // GET 매핑
    getMap.put("/todo/list", todoController::getList);
    getMap.put("/todo/view", todoController::getView);
    getMap.put("/todo/create", todoController::getCreate);
    getMap.put("/todo/update", todoController::getUpdate);

    // POST 매핑
    postMap.put("/todo/create", todoController::postCreate);
    postMap.put("/todo/update", todoController::postUpdate);
    postMap.put("/todo/delete", todoController::postDelete);
  }

}