import java.util.List;

public class TodoDAO {
    private TodoResponseDTO response;

    public TodoDAO(){}

    public int insertRow(TodoRequestDTO request){
        System.out.println(">>>> debug dao insertRow");

        TodoResponseDTO response = TodoResponseDTO.builder()
                                                .title(request.getTitle())
                                                .content(request.getContent())
                                                .startDate(request.getStartDate())
                                                .check(1)
                                                .priority(request.getPriority())
                                                .seq(1)
                                                .endDate(request.getEndDate())
                                                .build();
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
        return response;
    }

    // 삭제
    public int deleteRow(int seq){
        System.out.println(" >>> dao deleteRow");
        return 0;
    }

    //수정
    public int updateRow(TodoRequestDTO requeset){
        System.out.println(" >>> dao updateRow");
        return 0;
    }

    //전체 조회
    public List<TodoResponseDTO> selectRow(){
        System.out.println(">>> dao selectRow");
        return null;
    }
}
