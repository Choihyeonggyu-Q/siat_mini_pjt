package todo.ctrl;
import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoSelectController {
    private TodoService service;

    public TodoSelectController(){
        service = new TodoService();
    }

    public List<TodoResponseDTO> selectTodo(){
        
        System.out.println(">>> debug selectTodo_all");
        // TodoResponseDTO resService = service.selectService(seq);
        return service.selectService();
    }
}
