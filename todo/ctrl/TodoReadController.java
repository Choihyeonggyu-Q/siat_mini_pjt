package todo.ctrl;

import java.lang.StackWalker.Option;
import java.util.Optional;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoReadController {
    
    private TodoService service;

    public TodoReadController(TodoService service){
        this.service = service;
    }
    public TodoReadController(){
        // service = new TodoService();
    }

    public TodoResponseDTO readTodo(int seq){
        
        System.out.println(">>> debug selectTodo");
        // TodoResponseDTO resService = service.selectService(seq);
        // return service.selectService(seq);
        Optional<TodoResponseDTO> response = service.selectService(seq);
        if(response.isPresent()){
            return response.get();
        }else{
            return null;
        }
    }
}
