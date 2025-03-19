package todo.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<TodoResponseDTO> selectRow(int seq){ // Optional 리턴 메서드
        System.out.println(">>> debug selectDao");
        Optional<TodoResponseDTO> response = Optional.empty(); // Optional 객체 생성
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).getSeq() == seq){
                response = Optional.of(list.get(i)) ; // Optional로 감싼것
            } 
        }
        return response;
    }

    // 삭제
    public int deleteRow(int seq){
        System.out.println(" >>> dao deleteRow");
        int flag = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSeq() == seq){
                // list 의 index와 동일하게 삭제
                list.remove(i);
                flag = 1;
            }
        }
        
        return flag;
    }

    //수정
    // public int updateRow(int seq, TodoRequestDTO request){
    //     System.out.println(" >>> dao updateRow");

    //     for(int i = 0; i< list.size(); i++){
    //         if(list.get(i).getSeq() == seq){
    //             TodoResponseDTO exist = list.get(i);

    //             list.set(i, TodoResponseDTO.builder()
    //                                     .seq(seq)
    //                                     .title(request.getTitle() != null ? request.getTitle() : exist.getTitle())
    //                                     .content(request.getContent()  != null ? request.getContent() : exist.getContent())    
    //                                     .startDate(request.getStartDate()  != null ? request.getStartDate() : exist.getStartDate())                                                
    //                                     .endDate(request.getEndDate() != null ? request.getEndDate() : exist.getEndDate())
    //                                     .priority(request.getPriority() != 0 ? request.getPriority() : exist.getPriority())
    //                                     .check(0)
    //                                     .build());
                
    //             return 1;
    //         }
    //     }
    //     return 0;
    // }
    public int updateRow(Map<String, Object> map){
        System.out.println(">>> dao updateRow");
        int flag = 0;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getSeq() == (Integer)(map.get("seq"))) {
                list.get(i).setContent((String)(map.get("content")));
                list.get(i).setCheck((Integer)(map.get("check")));
                flag = 1;
            }
        }
        return flag;
    }

    //전체 조회
    public Optional<List<TodoResponseDTO>> selectRow(){
        System.out.println(">>> dao selectRow");
        if(list == null || list.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(list);
        // return list;
    }
}
