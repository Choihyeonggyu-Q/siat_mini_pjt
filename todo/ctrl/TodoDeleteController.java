package todo.ctrl;

import todo.service.TodoService;

public class TodoDeleteController {
    private TodoService service;

    public TodoDeleteController(TodoService service){
        this.service = service;
    }

    public TodoDeleteController(){
        // service = new TodoService();
    }

    public int deleteTodo(int seq){
        
        System.out.println(">>> debug deleteTodo");
        // TodoResponseDTO resService = service.selectService(seq);
        return service.deleteService(seq);
    }
}
