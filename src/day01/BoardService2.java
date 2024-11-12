/*
    BoardService1
        - 내용과 작성자로 구성된 게시물을 최대 100개까지 저장하는 서비스 구축
        - 조건 : main 함수 1개와 배열은 최대 2까지 사용 가능
        - 구축 : 게시물 쓰기와 게시물 출력 기능 구현
 */

package day01;

import java.util.Scanner;

public class BoardService2 {
    public static void main(String[] args) { // 번역된 코드들을 실행하는
        Scanner scan = new Scanner(System.in); // 입력 객체

        // (메인 쓰레드) 기능 포함
        // - 저장소 설계 , 게시물 1개당 내용과 작성자(내용 2개), 게시물이 3개면 내용 6개
        // 변수란? 하나의 데이터/주소값을 저장하는 공간/메모리
        // 타입이란? 변수의 저장된 데이터/주소의 타입,데이터 분류
        // 기본 타입 (int~double) , 참조 타입(클래스,인터페이스,배열)

        // 첫번째 게시물 내용
        // BoardService1 에서 변수를 사용했는데 배열 변수를 사용하는 이유
        // - 여러개의 변수에 있는 데이터를 배열로 사용하면 관리가 편하다
        // 배열이란 여러개의 동일한 타입의 데이터들을 하나의 변수에 저장할 수 있는 문법
        String[] content1 = new String[100];
        String[] writer1 = new String[100];


        // if : 다중 if는 다중 조건의 다중 결과를 충족 가능
        // if~else if : if~else if는 다중 조건의 1개 결과만을 충족 가능

        while (true) { // 무한 루프
            System.out.println("1.게시물 쓰기 2.게시물 출력"); // 출력
            int choose = scan.nextInt(); // 입력
            if (choose == 1) { // 입력한 값이 1일때 게시물 쓰기 구현

                // 게시물을 저장할 내용 입력 받기
                System.out.println("새로운 게시물 내용: ");
                String content = scan.next();
                System.out.println("새로운 게시물 작성자: ");
                String writer = scan.next();

                // 게시물이 작성할 공간이 있는지 체크 , 임의로 게시물이 존재하지 않는 뜻 , null(선호) 또는 ""
                // switch 변수 = 상태를 저장하는 변수
                boolean save = false; // 처음엔 false로 저장 실패했다는 뜻
                for (int i = 0; i < content1.length; i++) {
                    if (content1[i] == null) { // 만약 i번째 게시물이 비어있으면 입력받은 내용을 저장
                        content1[i] = content;
                        writer1[i] = writer;
                        save = true; // 저장에 성공했으면 변수값을 true로 변경
                        break; // 1개를 저장했으면 변수값을 true로 변경
                    } // if ed
                } // for ed
                if (!save) {
                    System.out.println("작성에 실패했습니다.");
                } else {
                    System.out.println("작성에 성공했습니다.");
                } // if~else ed
            } // if ed
                if (choose == 2) { // 입력한 값이 2일때 게시물 출력 구현
                    for (int i = 0; i < content1.length; i++) {
                        if (content1[i] != null) {
                            System.out.printf("내용:%s 작성자:%s\n",content1[i],writer1[i]);
                        } // if ed
                    } // for ed
                } // if ed
            } // while ed
        } // main ed
    } // class ed