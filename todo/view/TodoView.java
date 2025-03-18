package todo.view;

import java.util.Scanner;

import todo.front.FrontController;

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

    }

    public void register(){

    }

    public void update(){

    }

    public void delete(){

    }
}
