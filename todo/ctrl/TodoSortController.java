package todo.ctrl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoSortController {
    private TodoService service;

    public TodoSortController(TodoService service){
        this.service = service;
    }

    public TodoSortController(){
        // service = new TodoService();
    }

    public List<TodoResponseDTO> sortTodo(){
        
        System.out.println(">>> debug sort Todo");
        
        Optional<List<TodoResponseDTO>> response = service.selectService();
        List<TodoResponseDTO> responseCheck = null;
        if(response.isPresent()){
            responseCheck = response.get();
            responseCheck = responseCheck.stream()
                            .sorted(Comparator.comparing(TodoResponseDTO::getPriority))
                            .toList();
                            
            return responseCheck;
        }else{
            return null;
        }

    }
}
