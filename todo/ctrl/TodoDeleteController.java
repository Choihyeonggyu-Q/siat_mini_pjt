public class TodoDeleteController {
    private TodoService service;

    public TodoDeleteController(){
        service = new TodoService();
    }

    public int deleteTodo(int seq){
        
        System.out.println(">>> debug deleteTodo");
        // TodoResponseDTO resService = service.selectService(seq);
        return service.deleteService(seq);
    }
}
