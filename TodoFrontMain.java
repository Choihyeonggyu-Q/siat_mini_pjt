import todo.front.FrontController;
import todo.view.TodoView;

public class TodoFrontMain {
    public static void main(String[] args) {
        FrontController front = new FrontController();
        // TodoSelectController listCtrl = front.requestProcess(1);
        // TodoInsertController insertCtrl = front.requestProcess(2);
        // TodoDeleteController deleteCtrl = front.requestProcess(3);
        // TodoUpdateController updateCtrl = front.requestProcess(4);

        TodoView view = new TodoView();
        view.menu();
    }
}
