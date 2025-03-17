import java.util.List;

public class TodoAppMain {
    public static void main(String[] args) {
        
        TodoRequestDTO request = TodoRequestDTO.builder()
                                            .title("씨앗 키우기")
                                            .content("잘")
                                            .startDate("2025-03-17")
                                            .endDate("2025-03-21")
                                            .priority(3)    
                                            .build();
        // Quiz
        // 사용자로 부터 입력받은 데이터를 TodoInsertController(insertTodo)에 전달하여
        // TodoService(insertService) -> TodoDao(insertDao) 작업을 수행하고 실행 결과를 반환받는다.
        
        // controller
        TodoInsertController ctrl = new TodoInsertController();
        int controlResult = ctrl.insertTodo(request);
        
        if(controlResult == 1){
            System.out.println("제대로된 값 생성 완료");
        }
        else{
            System.out.println("실패");
        }

        // Quiz (상세보기)
        // 사용자로부터 입력받은 키를 TodoReadController(selectTodo메서드로) 전달하여
        // TodoService(selectService) -> TodoDao(selectDao) 작업을 수행하고
        // 실행 결과(TodoResponseDTO)를 반환받는다.
        TodoReadController readCtrl = new TodoReadController();
        TodoResponseDTO response = readCtrl.selectTodo(1);
        System.out.println(response);


        // 삭제
        TodoDeleteController deleteCtrl = new TodoDeleteController();
        int delResponse = deleteCtrl.deleteTodo(1);
        System.out.println(delResponse);

        // 수정
        TodoUpdateController updateCtrl = new TodoUpdateController();
        int upResponse = updateCtrl.updateTodo(request);
        System.out.println(upResponse);

        //전체 보기
        TodoSelectController selectCtrl = new TodoSelectController();
        List<TodoResponseDTO> selectLst = selectCtrl.selectTodo();
        for(TodoResponseDTO dto : selectLst){
            System.out.println(dto);
        }
    }
}
