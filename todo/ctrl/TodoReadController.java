package todo.ctrl;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoReadController {
    
    private TodoService service;

    public TodoReadController(){
        service = new TodoService();
    }

    public TodoResponseDTO selectTodo(int seq){
        
        System.out.println(">>> debug selectTodo");
        // TodoResponseDTO resService = service.selectService(seq);
        return service.selectService(seq);
    }
}
