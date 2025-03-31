import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class JdbcDao {
    // try {
    //      1. Driver loading  - 1번만 실행
    //      2. Connection
    //      3. Statement, PreparedStatement(SQL)
    //      4. ResultSet excuteQuery()  - Select, 
    //         int excuteUpdate() - Insert, Update, Delete
    //      5. ResultSet Handling
    //      6. Connection close
    // } catch(){
          
    // }
    
    public static final String DRIVER   = "oracle.jdbc.driver.OracleDriver";
    public static final String URL      = "jdbc:oracle:thin:@localhost:1521/xe";
    public static final String USER     = "hr";
    public static final String PASSWORD = "hr";
    public JdbcDao(){
        try{
            Class.forName(DRIVER);
            System.out.println("1. Driver loading OK");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public int insertRow(TodoRequestDTO request){
        System.out.println(">>>> debug dao insertRow");
        int flag = 0;
        Connection          conn = null;
        PreparedStatement   pstmt = null;
        String insertSQL = "INSERT INTO JDBC_TODO_TBL(SEQ, TITLE, CONTENT, PRIORITY) VALUES(JDBC_SEQ.NEXTVAL,?,?,?)";
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, request.getTitle());
            pstmt.setString(2, request.getContent());
            pstmt.setInt(3, request.getPriority());
            flag = pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return flag;
    }
    public int deleteRow(int seq){
        System.out.println(" >>> dao deleteRow");
        int flag = 0;
        Connection          conn = null;
        PreparedStatement   pstmt = null;
        String deleteSQL = "DELETE FROM JDBC_TODO_TBL WHERE SEQ = ?";
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, seq);
            flag = pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return flag;
    }
    public int updateRow(Map<String, Object> map){
        System.out.println(">>> dao updateRow");
        int flag = 0;
        Connection          conn = null;
        PreparedStatement   pstmt = null;
        String updateSQL = "UPDATE JDBC_TODO_TBL SET CONTENT = ?, STATUS = ? WHERE SEQ = ?";
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, (String)(map.get("content")));
            pstmt.setString(2, (String)(map.get("status")));
            pstmt.setInt(3, (Integer)(map.get("seq")));
            flag = pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return flag;
    }
    public List<TodoResponseDTO> selectRow(){ // Optional 리턴 메서드
        System.out.println(">>> debug selectDao");
        List<TodoResponseDTO> list = new ArrayList<>();
        Connection          conn  = null;
        PreparedStatement   pstmt = null;
        ResultSet           rset  = null;
        String selectSQL = "SELECT SEQ, TITLE, CONTENT, TO_CHAR(STARTDATE, 'YY/MM/DD') AS SD, STATUS, ENDDATE, PRIORITY FROM JDBC_TODO_TBL";
        try{
            conn  = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectSQL);
            rset  = pstmt.executeQuery();
            while (rset.next()) {
                TodoResponseDTO response = TodoResponseDTO.builder()
                                                            .seq(rset.getInt(1))
                                                            .title(rset.getString(2))
                                                            .content(rset.getString(3))
                                                            .startDate(rset.getString("SD"))
                                                            .status(rset.getString(5))
                                                            .endDate(rset.getString(6))
                                                            .priority(rset.getInt(7))
                                                            .build();
                list.add(response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
    public Optional<TodoResponseDTO> selectRow(int seq){ // Optional 리턴 메서드
        System.out.println(">>> debug selectDao");
        Optional<TodoResponseDTO> response = Optional.empty(); // Optional 객체 생성
        Connection          conn  = null;
        PreparedStatement   pstmt = null;
        ResultSet           rset  = null;
        String selectSQL = "SELECT * FROM JDBC_TODO_TBL WHERE SEQ = ?";
        try{
            conn  = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setInt(1, seq);
            rset  = pstmt.executeQuery();
            while (rset.next()) {
                response = Optional.of(TodoResponseDTO.builder()
                                                .seq(rset.getInt(1))
                                                .title(rset.getString(2))
                                                .content(rset.getString(3))
                                                .startDate(rset.getString(4))
                                                .status(rset.getString(5))
                                                .endDate(rset.getString(6))
                                                .priority(rset.getInt(7))
                                                .build());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return response;
    }
}
