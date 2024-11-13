package day02;

import java.util.ArrayList;
import java.util.Scanner;

/* Board5 수정하기
    기존코드 : 가변길이 배열 구현
    수정조건 : 가변길이 배열 대신 ArrayList 컬렉션 프레임워크로 수정하기

    - 컬렉션(수집) 프레임워크(만들어진 구조) : (데이터)수집 관련 클래스들
        - 여러개의 데이터들을 하나의 객체에서 관리하기 위해서
            -> 배열은 고정길이라서 가변길이로 구현하는 방법은 복잡하다.
            -> 자바회사에서 배열을 이용한 가변길이의 배열클래스를 만들었다.
            - 대표 인터페이스 : ArrayList , Set , Map 컬렉션
                ArrayList 클래스
                    대표함수
                        .add(새로운 객체) : 리스트에 지정한 객체 저장
                        .get(인덱스) : 리스트 내 지정한 인덱스에 객체 반환 함수
                        .size() : 리스트에 저장한 총 객체 수 반환 함수
                        .remove(인덱스) : 리스트 내 지정한 인덱스의 객체를 삭제하는 함수
 */
public class BoardService5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // 입력 객체
        // 컬렉션 프레임워크 중 ArrayList 클래스를 이용한 배열 대체
        // 배열(고정길이) 컬렉션프레임워크(가변길이)
        ArrayList<Board> boardList = new ArrayList<>();
        // ArrayList<> 제네릭타입 : 리스트 객체에 저장할 여러개 데이터들의 타입

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

                // [3] 컬렉션프레임워크인 리스트객체에 게시물을 저장
                boardList.add(board);

            } else if (choose == 2) {
                // 배열 내 존재하는 게시물을 모두 출력하기
                for (int i = 0; 0 < boardList.size(); i++) {
                        System.out.printf("내용:%s 작성자:%s 비밀번호:%d\n",
                                boardList.get(i).content,boardList.get(i).writer,boardList.get(i).pwd);
                } // for ed
            } // if ed
        } // while ed
    }
}
