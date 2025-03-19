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
            try{
                System.out.println(">>> Todo service menu");
                System.out.println("1.목록보기 | 2.작성 | 3.수정 | 4.삭제 | 5.상세보기 | 99. 종료");
                System.out.print("원하시는 번호를 선택하세요 : ");
                Scanner scan = new Scanner(System.in); // in: System 클래스가 갖고 있는 static 메서드
                int num = scan.nextInt();
                switch (num) {
                    case 1:
                        subMenu(); break;
                    case 2:
                        register(); break;
                    case 3:
                        update(); break;

                    case 4:
                        delete(); break;

                    case 5:
                        read(); break;
                    case 99:
                        System.out.println("프로그램을 종료할까요? (y/n)");
                        // String check = scan.nextLine();
                        // if(check.equals("y")){
                        System.exit(0);    
                        // }else if(check.equals("n")){
                        //     break;
                        // }
                        
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("정확한 값을 입력해주세요 ");
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

        // scan.nextLine();

        System.out.print("완료 현황 체크 완료 됐을 시에 1, 아닐 시에 0 입력");
        int check = scan.nextInt();
        
        int updateFlag = front.update(seq, content, check);
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

    public void read(){
        System.out.println(">>> TodoRead");

        Scanner scan = new Scanner(System.in);

        System.out.print("상세보기 : ");
        int seq = scan.nextInt();

        TodoResponseDTO response = front.read(seq);
        System.out.println(response);
    }

    public void subMenu(){
            while (true) {
            try{
                System.out.println(">>> Todo service menu");
                System.out.println("1.전체보기 | 2.완료 일정 | 3.미완료 일정 | 4.상위메뉴 이동 | 5.우선순위 정렬");
                System.out.print("원하시는 번호를 선택하세요 : ");
                Scanner scan = new Scanner(System.in); // in: System 클래스가 갖고 있는 static 메서드
                int num = scan.nextInt();

                switch (num) {
                    case 1:
                        list();                        
                        break;
                    case 2:
                        checkList(); // 해당하는 controller
                        break;
                    case 3:
                        uncheckList(); // 해당하는 controller
                        break;
                    case 4:
                        return;
                    case 5:
                        sort();
                        break;
                    default:
                        break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void checkList(){
        List<TodoResponseDTO> lst = front.checkList();
        System.out.println();
        System.out.println(">>> Todo Check <<<");
        
        for(TodoResponseDTO value : lst){
            System.out.println(value);
        }
     }
     public void uncheckList(){
        List<TodoResponseDTO> lst = front.uncheckList();
        System.out.println();
        System.out.println(">>> Todo Uncheck <<<");
        
        for(TodoResponseDTO value : lst){
            System.out.println(value);
        }
     }
     public void sort(){
        List<TodoResponseDTO> lst = front.sortList();
        System.out.println();
        System.out.println(">>> Todo sort <<<");
        
        for(TodoResponseDTO value : lst){
            System.out.println(value);
        }
     }
}
