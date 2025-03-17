public class TodoUpdateController {
    private TodoService service;

    public TodoUpdateController(){
        service = new TodoService();
    }

    public int updateTodo(TodoRequestDTO request){
        
        System.out.println(">>> debug updateTodo");
        // TodoResponseDTO resService = service.selectService(seq);
        return service.updateService(request);
    }
}
