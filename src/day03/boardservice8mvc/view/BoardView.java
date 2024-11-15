package day03.boardservice8mvc.view;

import day02.Board;
import day03.NewBoard;
import day03.boardservice8mvc.controller.BoardController;
import day03.boardservice8mvc.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    Scanner scan = new Scanner(System.in);

    public void mainPage(){ // View 시작 함수
        while(true) {
            System.out.print("1.게시물 등록 2.게시물 출력");
            int choose = scan.nextInt();
            if (choose == 1 ) {
                boardWrite();
            } else if (choose == 2) {
                boardPrint();
            } // if-else if ed
        } // while ed
    } // mainPage ed

    // view 가 해야하는 역할 : 입력과 출력만 해야 한다. (관례적인 약속)

    // 1. 게시물 등록 함수
    void boardWrite() {
        // 1. 입력
        scan.nextLine();
        System.out.print("내용 : ");
        String content = scan.nextLine();
        System.out.print("작성자 : ");
        String writer = scan.next();
        System.out.print("비밀번호 : ");
        int pwd = scan.nextInt();
        // 2. 입력받은 값을 컨트롤러에게 전달
        BoardController boardController = new BoardController();
        boolean result = boardController.boardWrite(content,writer,pwd);
        // 3. 컨트롤러에게 전달 후 결과를 받아 출력하기
        if(result) {
            System.out.println("게시물 등록 성공");
        } else {
            System.out.println("게시물 등록 실패");
        }
    }
    // 2. 게시물 출력 함수
    void boardPrint() {
        // 1. 컨트롤러에게 모든 게시물 정보를 요청한다.
        BoardController boardController = new BoardController(); // 객체가 필요한 이유
        // 다른 클래스의 정보를 가져오기 위해
        ArrayList<BoardDto> result = boardController.boardPrint(); // 게시물출력 함수 호출
        for(int i = 0; i < result.size(); i++) {
            System.out.print("게시물 내용 : "+result.get(i).getContent());
            System.out.println("작성자 : "+result.get(i).getWriter());
        } // for ed
        /*
        게시물 1개 = Board 객체 1개
        게시물 여러개 = Board[] 배열 또는 컬렉션프레임워크 ArrayList<Board>
         */

    } // boardPrint ed
} // class ed
