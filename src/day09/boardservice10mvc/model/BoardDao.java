package day09.boardservice10mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/*
    boardservice8mvc 패키지를 복사하여 boardservice10mvc으로 이름 변경해서 진행
    1. JAVA 와 DB를 연동하는 JDBC 라이브러리
        1. JDBC 라이브러리 설치
        2. Select Operating System:
            1.Platform Independent (Architecture Independent), ZIP Archive 9.1.0 [5.1M] 설치
            2.No Thanks, just start my download
            3.다운로드 후 압축 해제
            4. 폴더 내 mysql-connector-j-9.1.0.jar 파일 확인

    2. 현재 프로젝트 내 JDBC 라이브러리 등록/추가
        1. 준비된 mysql.connector-j-9.1.0.jar 파일을 현재 프로젝트 내 폴더로 이동/복사
        2. 이동/복사된 mysql-connector-j-9.1.0.jar 파일을 오른쪽 클릭 -> 가장 하단 [라이브러리 추가] 클릭
        3. [OK]

    3. 현재 프로젝트 내 외부 라이브러리 목록 확인
        1. [file] -> [project structure] -> 왼쪽 탭 [library] 클릭
        - 주의 : pc가 변경될때 경로 유의
    ----------------------------------
    [1] JDBC 라이브러리를 이용한 D[Data]A[Access]0[Object]에 DB 연동 객체 만들기
        1. dao 생성자에서 연동 코드 작성


 */

public class BoardDao {

    private Connection connection; // DB 연동 인터페이스 // DB 연동 결과를 가지고 있어서 DB조작이 가능한 인터페이스

    // 싱글톤 패턴
    private static BoardDao boardDao = new BoardDao();
    private BoardDao(){

        // DB 연동 시 필요한 코드 2줄

        try {
            // [1] 외부 라이브러리(JDBC)폴더 내 com->mysql->cj->jdbc->Driver 클래스 호출, * 일반 예외
            Class.forName("com.mysql.cj.jdbc.Driver");
            // forName() 특정한 클래스를 호출하는데 사용되는 함수, 만일 클래스가 존재하지 않으면 어떻게 해야하는지 일반예외에서 처리

            // [2] DB 연동 인터페이스 만들기 DriverManager.getConnection("MYSQLSERVER_URL/DB명","계정명","비밀번호");
            // DriverManager.getConnection(): DB SERVER 와 연동을 성공했을때 연동된 결과의 객체를 반환 * 일반 예외
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1122","root","1234");
            // [3] 확인
            System.out.println("DB 연동 성공");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        } // try catch ed
    }
    public static BoardDao getInstance() {
        return boardDao;
    }
    // 싱글톤 패턴

    ArrayList<BoardDto> boardDB = new ArrayList<>();


    // 1. 게시물 등록 접근 함수
    public boolean boardWrite(BoardDto boardDto) {
            boardDB.add(boardDto);
            return true;
        }

        // 2. 게시물 출력 접근 함수
        public ArrayList<BoardDto> boardPrint () {
            return boardDB;
        }
    } // BoardDto ed