package day04.bst.view;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    private static View view = new View();
    private View() {}
    public static View getInstance(){
        return view;
    } // 싱글톤 패턴

    // 기능 선택 메서드
    public void mainPage()  {
        System.out.print("1.게시물 출력 2.게시물 작성 : ");
        int choose = scanner.nextInt();

        if (choose == 1) {
            boardWrite();
        } else if (choose == 2) {
            boardPrint();
        } // if-else if ed
    } // 기능 선택 메서드 종료

    // 게시물 작성 메서드
    public void boardWrite() {

    }
} // View ed
