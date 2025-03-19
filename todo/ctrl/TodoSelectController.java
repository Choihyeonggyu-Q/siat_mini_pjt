package todo.ctrl;
import java.util.List;
import java.util.Optional;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoSelectController {
    private TodoService service;

    public TodoSelectController(TodoService service){
        this.service = service;
    }

    public TodoSelectController(){
        // service = new TodoService();
    }

    public List<TodoResponseDTO> selectTodo(){
        
        System.out.println(">>> debug selectTodo_all");
        
        Optional<List<TodoResponseDTO>> response = service.selectService();
        if(response.isPresent()){
            return response.get();
        }else{
            return null;
        }
        // return service.selectService();
    }
}
