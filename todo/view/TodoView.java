package todo.view;

import java.util.List;
import java.util.Scanner;

import todo.front.FrontController;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoView {
    
    private FrontController front;
    public TodoView(){
        front = new FrontController();
    }

    public void menu(){
        while (true) {
            
            System.out.println(">>> Todo service menu");
            System.out.println("1.목록보기 | 2.작성 | 3.수정 | 4.삭제 | 99. 종료");
            System.out.print("원하시는 번호를 선택하세요 : ");
            Scanner scan = new Scanner(System.in); // in: System 클래스가 갖고 있는 static 메서드
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    list(); break;
                case 2:
                    register(); break;
                case 3:
                    update(); break;

                case 4:
                    delete(); break;
                case 99:
                    System.out.println("프로그램을 종료할까요? (y/n)");
                    System.exit(0);
            }
        }
    }

    // method 정의
    public void list(){
       List<TodoResponseDTO> lst = front.list();
       System.out.println();
       System.out.println(">>> Todo List <<<");
       
       for(TodoResponseDTO value : lst){
        System.out.println(value);
       }
    }

    public void register(){
        System.out.println(">>> Todo Register");
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("제목 : ");
        String title = scan.nextLine();
        System.out.print("내용 : ");
        String content = scan.nextLine();
        System.out.print("시작일 : ");
        String startDate = scan.nextLine();
        System.out.print("종료일 : ");
        String endDate = scan.nextLine();
        System.out.print("우선순위 : ");
        int priority = scan.nextInt();

        int insertFlag = front.register(title, content, startDate, endDate, priority);
        System.out.println(insertFlag);
    }

    public void update(){
        System.out.println(">>> Todo Update");

        Scanner scan = new Scanner(System.in);

        System.out.print("변경할 seq 값을 입력하시오 : ");
        int seq = scan.nextInt();
        
        scan.nextLine(); // 버퍼 비우기

        System.out.print("변경할 내용을 입력하시오 : ");
        String content = scan.nextLine();

        int updateFlag = front.update(seq, content);
        System.out.println(updateFlag);
    }

    public void delete(){
        System.out.println(">>> TodoDelete");

        Scanner scan = new Scanner(System.in);

        System.out.print("삭제할 목록의 seq를 입력해주세요 : ");
        int seq = scan.nextInt();

        int deleteFlag = front.delete(seq);
        System.out.println(deleteFlag);

    }
}
