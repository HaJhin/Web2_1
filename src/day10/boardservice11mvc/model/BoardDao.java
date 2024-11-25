package day10.boardservice11mvc.model;

import java.sql.*;
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
    // JDBC 인터페이스, import java.sql
    private Connection connection; // DB 연동 인터페이스 // DB 연동 결과를 가지고 있어서 DB조작이 가능한 인터페이스
    // 연동된 결과의 연동 객체를 조작할 인터페이스
    
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1125","root","1234");
            // [3] 확인
            System.out.println("DB 연동 성공");
            // 연동에 실패하는 이유 : 1. 프로젝트에 jdbc 라이브러리 등록 안했다. 2. DB 연동 url 경로 오류
        } catch (ClassNotFoundException e) {
            e.getMessage();
            System.out.println("BoardDB Connection fail");
            // 실패 이유 : 1. 프로젝트 내 JDBC 라이브러리 등록 2. 오타 3. DB 없음
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("BoardDB Connection fail");
        } // try catch ed
    }
    public static BoardDao getInstance() {
        return boardDao;
    }
    // 싱글톤 패턴

    // 1. 게시물 등록 접근 함수
    public boolean boardWrite(BoardDto boardDto) {
            // boardDB.add(boardDto);
        try {
            // 1. SQL 작성. SQL 그대로 작성하되 데이터가 들어가는 자리는 ? 로 작성
            String sql = "insert into board(content,writer,pwd)values(?,?,?)";
            // 2. 작성한 SQL 을 DB 연동객체에 기재한다.
                // - 연동된 객체로부터 SQL 기재해서 준비된 객체를 PreparedStatement 인터페이스에 대입한다.
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,boardDto.getContent()); // 1.SQL 내 첫 ?에 입력받은 게시물 내용을 대입한다.
            ps.setString(2,boardDto.getWriter()); // 2. SQL 내 두번째 ?에 대입
            ps.setInt(3,boardDto.getPwd()); // 3. SQL 내 세번째 ?에 대입
            // 4. 기재된 SQL을 실행한다.
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("오류 발생");
        }
            return false;
        }

        // 2. 전체 게시물 출력 접근 함수
        public ArrayList<BoardDto> boardPrint () {
            ArrayList<BoardDto> list = new ArrayList<>();
            try {
                // 1. SQL 작성
                String sql = "select * from board";
                // 2. SQL 기재
                PreparedStatement ps = connection.prepareStatement(sql); // 기재할 SQL 준비
                // 3. SQL 조작 , executeQuery() : sql 실행 결과 조회된 SQL 결과 조작하는

                // 4. SQL 실행
                ResultSet rs = ps.executeQuery();
                // 5. SQL 결과
                /*
                    예) 조회 결과가
                    num     content     writer      pwd     <- rs : 인터페이스가 조작할 수 있다. rs.next();
                    1       자바         유재석       1234    <- (rs.next())
                    2       안녕         강호동       5678    <- (rs.next())
                    3       하하         신동엽       9876    <- (rs.next())
                 */
                while(rs.next()) { // while(조건){} : 반복문, rs.next() : 조회 결과에서 다음 레코드 이동 (true/false)함수
                    // 만약에 레코드가 3개 존재하면 rs.next() 3번 실행된다.
                    // [해석] 조회 결과 마지막 레코드까지 하나씩 레코드 이동
                    // 6. 레코드를 읽어서 필드별 데이터 호출 , rs.getXXX("필드명") : 지정한 필드명의 값 타입에 맞춰 반환
                    int num = rs.getInt("num");   // 현재 조회중인 레코드의 게시물번호(num)값 호출
                    String content = rs.getString("content");    // 현재 조회중인 레코드의 게시물내용(content)값 호출
                    String writer = rs.getString("writer");     // 현재 조회중인 레코드의 게시물작성자(writer)값 호출
                    int pwd = rs.getInt("pwd");   // 현재 조회중인 레코드의 게시물비밀번호(pwd)값 호출
                    // 7. 각 레코드의 호출된 필드값들을 객체화 -> DTO 생성
                    BoardDto boardDto = new BoardDto(content,writer,pwd);
                    // 8. 1개 레코드를 DTO 객체로 변환, 변환된 DTO 를 리스트에 저장
                    list.add(boardDto);
                    // - 반복문 한번에 레코드 1개를 dto 로 반환
                } // w end
            } catch (SQLException e) {
                e.getMessage();
                System.out.println("오류 발생");
            } // 예외 처리
            // (9) 구성한 리스트의 객체 반환
            return list;
        }
    } // BoardDto ed