
/* - 클래스 : 타입 만들기 (멤버변수(필드),생성자,(멤버함수(메서드))로 구성된 새로운 타입을 제작
   - 객체 : 하나의 자료(여러개의 자료들의 주소값)를 저장하는 메모리 공간(JVM 힙영역)
   - 객체(Easy) : 참조(클래스 등등) 타입으로 생성된 메모리 공간. 여러개의 주소값을 가짐
   - 변수 : 하나의 자료(실제값,주소값)를 저장하는 메모리 공간 (JVM 스택영역)
   - 변수(Easy) : 기본/참조 타입으로 생성된 메모리 공간
   - 타입 : 데이터의 형태를 분류하는 기준
        대분류 : 기본타입(int~double), -> 기본값 : 정수 = 0 , 실수 - 0.0 , 논리 = false
        참조타입(String,[]배열,클래스,인터페이스,열거 등등) -> 기본값 : null
*/

/* Board4 수정하기 : 고정길이인 Board[] boardList = new Board[100];
   - 조건 : 고정길이가 아닌 가변길이 형식으로 100개를 넘어
   무한개 저장 가능한 가변길이 배열 만들기
   * 만드는 이유? : 가변길이의 여러개 데이터를 관리할때는
   - 컬렉션프레임워크(ArrayList) = 실무
   - 가변배열 = 시험/코딩테스트/c언어
 */
package day02;

import day02.Board;

import java.util.Scanner;

public class BoardService4 { // 실행 클래스
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // 입력 객체
        Board[] boardList = null;
        // 현재 게시물 수를 저장하는 변수
        int count = 0;
        // 배열-고정(불변) 길이. 컬렉션 프레임워크-가변 길이

        while (true) {
            System.out.println("1.글 쓰기 2.글 출력");
                int choose = scan.nextInt();
                if (choose == 1) {
                    scan.nextLine(); // 의미없는 nextLine() 코드를 작성한다
                    System.out.println("내용 :");
                    String content = scan.nextLine();
                    // .next() 문자열(공백x)입력 , .nextline() 문자열(공백/띄어쓰기 가능)입력
                    // .nextLine() 사용시 주의할 점 : .nextLine() 앞에 또다른 .nextXX가 존재하면
                    // 의미없는 .nextLine()을 하나 추가한다.
                    System.out.println("작성자 :");
                    String writer = scan.next();
                    System.out.println("비밀번호 : ");
                    int pwd = scan.nextInt();

                    // [2] 입력받은 데이터로 게시물 객체 생성
                    Board board = new Board();
                    board.content = content;
                    board.writer = writer;
                    board.pwd = pwd;

                    // [3]
                    count++; // 게시물 수 1 증가
                    Board[] newboardList = new Board[count]; // 새로운 배열 생성
                    // 기존 배열 내 게시물들을 새로운 배열에 이동하기 / 배열 복사
                    if (count != 1) { // 만약에 기존 배열 내 게시물이 존재하면
                        for(int i = 0; i < boardList.length; i++) {
                            newboardList[i] = boardList[i];
                            // 기존 배열 내 게시물들을 새로운 배열에 대입 / 카피(복사)
                        } // for ed
                    } // if ed.
                    // 새로운 배열 내 마지막 인덱스에 입력받은 게시물 객체 등록
                    newboardList[newboardList.length-1] = board;
                    // 새로운 배열을 기존 배열에 대입한다.
                    boardList = newboardList;
                } else if (choose == 2) {
                    // 배열 내 존재하는 게시물을 모두 출력하기
                    for (int i = 0; 0 < boardList.length; i++) {
                            System.out.printf("내용:%s 작성자:%s 비밀번호:%d\n",
                                    boardList[i].content,boardList[i].writer,boardList[i].pwd);
                    } // for ed
                } // if ed
        } // while ed
    } // main ed
} // class ed
