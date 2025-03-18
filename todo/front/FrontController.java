package todo.front;

import java.util.List;

import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoSelectController;
import todo.ctrl.TodoUpdateController;
import todo.factory.BeanFactory;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class FrontController {
    
    private BeanFactory factory;
    public FrontController(){
        factory = BeanFactory.getInstance();
    }

    // 1: 전체보기, 2: 입력, 3: 수정, 4: 삭제
    public List<TodoResponseDTO> list(){
        System.out.println(">>>> FrontController list");
        // TodoSelectController selectCtrl = new TodoSelectController(); 
        //   factory로 부터 instance를 반환받는 형식으로 바뀌어야한다.
        TodoSelectController selectCtrl = (TodoSelectController)factory.getCtrl("list");
        List<TodoResponseDTO> list = selectCtrl.selectTodo();
        return list;
    }

    public int register(String title, String content, String startDate, String endDate, int priorty){
        System.out.println(">>>> FrontController register");
        // TodoInsertController insertCtrl = new TodoInsertController();
        TodoInsertController insertCtrl = (TodoInsertController)factory.getCtrl("register");
        TodoRequestDTO request = TodoRequestDTO.builder()
                                            .title(title)
                                            .content(content)
                                            .startDate(startDate)
                                            .endDate(endDate)
                                            .priority(priorty)
                                            .build();
        return insertCtrl.insertTodo(request);
    }

    public int update(int seq, String content){
        System.out.println(">>>> FrontController update");
        // TodoUpdateController updateCtrl = new TodoUpdateController();
        TodoUpdateController updateCtrl = (TodoUpdateController)factory.getCtrl("update");
        TodoRequestDTO request = TodoRequestDTO.builder()
                                            .content(content)
                                            .build();
        return updateCtrl.updateTodo(seq, request);
    }

    public int delete(int seq){
        System.out.println(">>>> FrontController delete");
        TodoDeleteController deleteCtrl = (TodoDeleteController)factory.getCtrl("delete");
        // int seq = 1;
        return deleteCtrl.deleteTodo(seq);
    }
}
