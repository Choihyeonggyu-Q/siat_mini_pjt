import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class JdbcAppMain {
    public static void main(String[] args) {
        JdbcDao dao = new JdbcDao();
        // System.out.println(">>> 입력");
        // TodoRequestDTO request = TodoRequestDTO.builder()
        //                                         .title("JDBC")
        //                                         .content("fd")
        //                                         .priority(7)
        //                                         .build();
        // int insertFlag = dao.insertRow(request);
        // if (insertFlag != 0) {
        //     System.out.println("1 row insert complete");

        // }else{
        //     System.out.println("1 row insert fail");
        // }


        // System.out.println(">>> 삭제");
        // int deleteFlag = dao.deleteRow(1);
        // if (deleteFlag != 0) {
        //     System.out.println("1 row delete complete");

        // }else{
        //     System.out.println("1 row delete fail");
        // }

        // System.out.println(">>> 수정");
        // Map<String, Object> map = new HashMap<>();
        // map.put("content", "df");
        // map.put("status", "Y");
        // map.put("seq", 2);
        // int updateFlag = dao.updateRow(map);
        // if (updateFlag != 0) {
        //     System.out.println("1 row update complete");

        // }else{
        //     System.out.println("1 row update fail");
        // }

        System.out.println(">>> 출력");
        // List<TodoResponseDTO> list = dao.selectRow();
        // for(TodoResponseDTO response : list){
        //     System.out.println(response);
        // }

        Optional<TodoResponseDTO> res = dao.selectRow(2) ;
        if (res.isPresent()) {
            System.out.println(res.get());
        }
        
    }
}

