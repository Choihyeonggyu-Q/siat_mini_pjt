import java.util.List;

public class TodoService {

    private TodoDAO dao;
    
    public TodoService(){
        dao = new TodoDAO();
    }

    public int insertService(TodoRequestDTO reqeust){
        System.out.println(">>> debug service insertService");

        // TodoDAO dao = new TodoDAO();
        // int daoReuslt = dao.insertRow(reqeust);
        return dao.insertRow(reqeust);
    }

    public TodoResponseDTO selectService(int seq){
        System.out.println(">>>> debug selectService");
        // TodoResponseDTO resDao = dao.selectDao(num);
        return dao.selectRow(seq);
    }

    public int deleteService(int seq){
        System.out.println(">>> debug deleteService");
        return dao.deleteRow(seq);
    }

    public int updateService(TodoRequestDTO requset){
        System.out.println(">>> debug updateService");
        return dao.updateRow(requset);
    }

    public List<TodoResponseDTO> selectService(){
        System.out.println(">>> debug selectService_all");
        return dao.selectRow();
    }
}
