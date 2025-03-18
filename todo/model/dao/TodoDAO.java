package todo.model.dao;

import java.util.ArrayList;
import java.util.List;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoDAO {
    private List<TodoResponseDTO> list;
    private int i;

    public TodoDAO(){
        list = new ArrayList<TodoResponseDTO>();
    }

    public int insertRow(TodoRequestDTO request){
        System.out.println(">>>> debug dao insertRow");

        TodoResponseDTO response = TodoResponseDTO.builder()
                                                .seq(i++)
                                                .title(request.getTitle())
                                                .content(request.getContent())
                                                .startDate(request.getStartDate())                                                
                                                .endDate(request.getEndDate())
                                                .priority(request.getPriority())
                                                .check(0)
                                                .build();
        list.add(response);

        if (response != null) {
            return 1;

        }
        return 0;
    }

    // 상세조회
    public TodoResponseDTO selectRow(int num){
        System.out.println(">>> debug selectDao");
        // if(response.getSeq() == num){
        //     return response;
        // }
        return null;
    }

    // 삭제
    public int deleteRow(int seq){
        System.out.println(" >>> dao deleteRow");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSeq() == seq){
                list.remove(i);
                return 1;
            }
        }
        return 0;
    }

    //수정
    public int updateRow(int seq, TodoRequestDTO request){
        System.out.println(" >>> dao updateRow");

        for(int i = 0; i< list.size(); i++){
            if(list.get(i).getSeq() == seq){
                TodoResponseDTO exist = list.get(i);

                list.set(i, TodoResponseDTO.builder()
                                        .seq(seq)
                                        .title(request.getTitle() != null ? request.getTitle() : exist.getTitle())
                                        .content(request.getContent()  != null ? request.getContent() : exist.getContent())    
                                        .startDate(request.getStartDate()  != null ? request.getStartDate() : exist.getStartDate())                                                
                                        .endDate(request.getEndDate() != null ? request.getEndDate() : exist.getEndDate())
                                        .priority(request.getPriority() != 0 ? request.getPriority() : exist.getPriority())
                                        .check(0)
                                        .build());
                
                return 1;
            }
        }
        return 0;
    }

    //전체 조회
    public List<TodoResponseDTO> selectRow(){
        System.out.println(">>> dao selectRow");
        return list;
    }
}
