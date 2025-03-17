public class TodoInsertController {

    private TodoService service;

    public TodoInsertController(){
        service = new TodoService();
    }

    public int insertTodo(TodoRequestDTO request){
        System.out.println(">>>> debug ctrl insertCtrl");

        // TodoService service = new TodoService();
        // int serviceResult = service.insertService(request);
        return service.insertService(request);
    }   
}
