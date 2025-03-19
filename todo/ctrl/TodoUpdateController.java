package todo.ctrl;

import java.util.Map;

import todo.model.domain.TodoRequestDTO;
import todo.service.TodoService;

public class TodoUpdateController {
    private TodoService service;

    public TodoUpdateController(TodoService service){
        this.service = service;
    }

    public TodoUpdateController(){
        // service = new TodoService();
    }

    // public int updateTodo(int seq, TodoRequestDTO request){
    public int updateTodo(Map<String, Object> map){
        System.out.println(">>> debug updateTodo");
        // TodoResponseDTO resService = service.selectService(seq);
        return service.updateService(map);
    }
}
