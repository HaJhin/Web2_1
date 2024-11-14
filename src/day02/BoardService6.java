package day02;
/*
    - BoardService5 모든 코드 복사
    - 추가조건 : Board 클래스 객체들을 캡슐화(접근제한자)하기
    - NewBoard의 모든 필드(멤버변수)는 private으로 선언
    - 외부에서 객체 생성 시 생성자를 사용
    - getter(필드값호출 함수), setter(필드값대입함수), toString(객체정보함수)들을 이용하여
    모든 필드의 데이터를 간접접근한다.

    public : 공개용 , 모든 클래스/패키지 내에서 접근 가능
    private : 비공개용 , 현재 클래스 내에서만 접근 가능
        - 이유 : 객체의 자료는 중요하기 때문에 쉽게 저장/변경하면 안됌!
        (유효성 검사 1.원하는 데이터인지 2.안전한 데이터인지)
        -객체를 통해 필드 직접 접근을 차단하고 간접접근을 이용한 유효성검사를 시행한다.
    protected : 동일한 패키지 내에서만 접근 가능. 상속관계이면 다른 패키지에서도 접근 가능.
    default : 기본적으로 적용되는 접근 제한자, 동일한 패키지 내에서만 접근가능.

 */
import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService6 {
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
        scan.nextLine(); // 의미없는 nextLine() 코드를 작성한다
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