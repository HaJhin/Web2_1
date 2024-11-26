package day11.boardservice12mvc.controller;

import day02.Board;
import day11.boardservice12mvc.model.BoardDao;
import day11.boardservice12mvc.model.BoardDto;

import java.util.ArrayList;

public class BoardController {
    // 싱글톤 //
    private static BoardController boardController = new BoardController();
    private BoardController(){}
    public static BoardController getInstance() {
        return boardController;
    }
    // 싱글톤 //

    // 1. 게시물 등록 제어 함수
    public boolean boardWrite(String content,String writer,int pwd) {

        // 1. 다양한 데이터 검사=유효성 검사, 오늘은 생략
        // 2. 유효성검사 통과 했으면 서로다른 데이터를 하나(객체)로
        BoardDto boardDto = new BoardDto(content,writer,pwd);
        // 3. 입력받은 객체를 저장하기 위해 Dao 를전달하고 결과를 응답 받기

        return BoardDao.getInstance().boardWrite(boardDto);
    } // boardWrite ed

    // 2. 게시물 출력 제어 함수
    public ArrayList<BoardDto> boardPrint() {
        // void : 메서드 호출 시 반환되는 값이 없다는 뜻을 가진 키워드
        // void 대신 여러개 게시물 반환 받고 싶을 떄
        // 2. 메서드 호출
        ArrayList<BoardDto> result = BoardDao.getInstance().boardPrint();
        // 3. Dao 에게 응답받은 결과를 view 에게 반환
        return result; // - return 메서드가 종료되면서 반환되는 값
    } // boardPrint ed

    // 3. 게시물 삭제 제어 함수
    public boolean boardDelete(int D) {
        // 유효성 검사(지금은 생략)
        boolean result = BoardDao.getInstance().boardDelete(D);
        return result;
    }

    // 4. 게시물 수정 함수
    public boolean boardUpdate(BoardDto updateDto) {
        boolean result = BoardDao.getInstance().boardUpdate(updateDto);
        return result;
    }
} // class ed
