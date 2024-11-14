package day03;
/*
    BoardService7, 기능별 각 함수로 구현
        - BoardService6 코드를 가지고 이어서 진행
        - 추가 조건 : 등록 기능과 출력 기능 코드를 main 함수 밖으로 빼내어
            각 함수로 구현
        - 분리하는 이유 : 메서드는 기능 단위로 분리해서 하나의 함수로 묶으면/관리/사용하면,
        추후에 복잡한 프로젝트에서 유지보수/식별/구분이 쉽다.
            * 본인이 작성한 코드도 이해하기 힘든 멍청한 샌드위치가 되기 때문...
                그러니 깝치지 말고 함수화해두도록 하자
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService7 {
    static Scanner scan = new Scanner(System.in);
    // ArrayList타입 board 객체
    static ArrayList<NewBoard> boardList = new ArrayList<>();

    public static void main(String[] args) { // main 함수
        // 기능 구현 함수
        while (true) {
            // 기능 선택 함수
            System.out.println("1.게시물 작성 2.게시물 출력");
            int fuc = scan.nextInt();
            if (fuc == 1) {
                writeBoard(); // 게시물 작성 메서드 호출
            } else if (fuc == 2) {
                printBoard(); // 게시물 출력 메서드 호출
            } // if-else if ed
        } // while ed
    } // main ed

    // 게시물 작성 메서드
    static void writeBoard () {
        scan.nextLine();
        System.out.print("내용 : ");
        String content = scan.nextLine();
        System.out.print("작성자 : ");
        String writer = scan.next();
        System.out.print("비밀번호 : ");
        int pwd = scan.nextInt();
        // [2] 입력받은 데이터로 게시물 객체 생성
        NewBoard board = new NewBoard(content,writer,pwd);
        // [3] 컬렉션프레임워크인 리스트객체에 게시물을 저장
        boardList.add(board);
    } // writeBoard ed

    // 게시물 출력 메서드
    static void printBoard() {
        for (int i = 0; i < boardList.size(); i++) {
            System.out.printf("내용:%s 작성자:%s 비밀번호:%d\n",
                    boardList.get(i).getContent(), boardList.get(i).getWriter(), boardList.get(i).getPwd());
        } // for ed
    } // printBoard ed
} // class ed

