package todo.ctrl;

import java.util.List;
import java.util.Optional;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoCheckController {
    private TodoService service;

    public TodoCheckController(TodoService service){
        this.service = service;
    }

    public TodoCheckController(){
    }

    public List<TodoResponseDTO> checkTodo(){
        
        System.out.println(">>> debug checkTodo");

        Optional<List<TodoResponseDTO>> response = service.selectService();
        List<TodoResponseDTO> responseCheck = null;
        if(response.isPresent()){
            responseCheck = response.get();
            responseCheck = responseCheck.stream().filter(s -> s.getCheck() == 1).toList();
            return responseCheck;

        }else{
            return null;
        }
    }
}
