/*
    BoardService1
        - 내용과 작성자로 구성된 게시물 3개까지 저장하는 서비스 구축
        - 조건 : main 함수 1개와 변수 6개와 반복문 사용 , 입출력 함수 사용 가능
        - 구축 : 게시물 쓰기와 게시물 출력 기능 구현
 */

package day01;

import java.util.Scanner;

public class BoardService1 {
    public static void main(String[] args) { // 번역된 코드들을 실행하는
        Scanner scan = new Scanner(System.in); // 입력 객체

        // (메인 쓰레드) 기능 포함
        // - 저장소 설계 , 게시물 1개당 내용과 작성자(내용 2개), 게시물이 3개면 내용 6개
        // 변수란? 하나의 데이터/주소값을 저장하는 공간/메모리
        // 타입이란? 변수의 저장된 데이터/주소의 타입,데이터 분류
        // 기본 타입 (int~double) , 참조 타입(클래스,인터페이스,배열)

        // 첫번째 게시물 내용
        String content1 = null; String writer1 = null;
        // 두번째 게시물 내용
        String content2 = null; String writer2 = null;
        // 세번째 게시물 내용
        String content3 = null; String writer3 = null;

        // if : 다중 if는 다중 조건의 다중 결과를 충족 가능
        // if~else if : if~else if는 다중 조건의 1개 결과만을 충족 가능

        while (true) { // 무한 루프
            System.out.println("1.게시물 쓰기 2.게시물 출력"); // 출력
            int choose = scan.nextInt(); // 입력
            if (choose == 1) { // 입력한 값이 1일때 게시물 쓰기 구현

               // 게시물을 저장할 내용 입력 받기
                System.out.println("새로운 게시물 내용: "); String content = scan.next();
                System.out.println("새로운 게시물 작성자: "); String writer = scan.next();

                // 게시물이 작성할 공간이 있는지 체크 , 임의로 게시물이 존재하지 않는 뜻 , null(선호) 또는 ""
                if (content1 == null) { // 만약 첫번째 게시물의 정보가 비어있으면 정보를 저장
                    // 입력받은 값들을 첫번째 게시물 변수에 저장
                    content1 = content; writer1 = writer;
                } else if (content2 == null) {
                    content2 = content; writer2 = writer;
                } else if (content3 == null) {
                    content3 = content; writer3 = writer;
                } else {
                    System.out.println("게시물 등록 실패 : 빈 공간 부족");
                } // if-else-if ed
            } // if ed
            if (choose == 2) { // 입력한 값이 2일때 게시물 출력 구현
               if (content1 != null) { // 만약 첫번째 게시물이 존재하면
                   System.out.printf("작성자:%s 내용:%s\n",writer1,content1);
               }
               if (content2 != null) { // 만약 두번째 게시물이 존재하면
                    System.out.printf("작성자:%s 내용:%s\n",writer2,content2);
               }
               if (content3 != null) { // 만약 세번째 게시물이 존재하면
                    System.out.printf("작성자:%s 내용:%s\n",writer3,content3);
               }
            } // if ed
        } // while ed
    } // main ed
} // class ed
