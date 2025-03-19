package todo.ctrl;

import java.util.List;
import java.util.Optional;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoUncheckController {
    private TodoService service;

    public TodoUncheckController(TodoService service){
        this.service = service;
    }

    public TodoUncheckController(){
        // service = new TodoService();
    }

    public List<TodoResponseDTO> uncheckTodo(){
        
        System.out.println(">>> debug uncheckTodo");

        Optional<List<TodoResponseDTO>> response = service.selectService();
        List<TodoResponseDTO> responseCheck = null;
        if(response.isPresent()){
            responseCheck = response.get();
            responseCheck = responseCheck.stream().filter(s -> s.getCheck() == 0).toList();
            return responseCheck;

        }else{
            return null;
        }
    }
}
