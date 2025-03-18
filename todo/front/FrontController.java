package todo.front;

import todo.ctrl.TodoSelectController;

public class FrontController {
    
    // 1: 전체보기, 2: 입력, 3: 수정, 4: 삭제
    public void list(){
        System.out.println(">>>> FrontController list");
        TodoSelectController selectCtrl = new TodoSelectController();
    }

    public void register(){
        System.out.println(">>>> FrontController register");
    }

    public void update(){
        System.out.println(">>>> FrontController update");
    }

    public void delete(){
        System.out.println(">>>> FrontController delete");
    }
}
