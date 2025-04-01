package todo.ctrl;

import java.util.Collections;
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

    // public List<TodoResponseDTO> uncheckTodo(){
        
    //     System.out.println(">>> debug uncheckTodo");

    //     Optional<List<TodoResponseDTO>> response = service.selectService();
    //     List<TodoResponseDTO> responseCheck = null;
    //     if(response.isPresent()){
    //         responseCheck = response.get();
    //         responseCheck = responseCheck.stream().filter(s -> s.getStatus() == "N").toList();
    //         return responseCheck;

    //     }else{
    //         return null;
    //     }
    // }
    public List<TodoResponseDTO> uncheckTodo() {
        System.out.println(">>> debug uncheckTodo");

        return service.selectService()
                .map(list -> list.stream()
                        .filter(s -> "N".equals(s.getStatus()))  // 안전한 문자열 비교
                        .toList()
                )
                .orElse(Collections.emptyList());  // 비어 있는 경우 빈 리스트 반환
        }
}
