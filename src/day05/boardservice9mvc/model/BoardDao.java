package day05.boardservice9mvc.model;

import java.util.ArrayList;

public class BoardDao {

    // 싱글톤 패턴
    private static BoardDao boardDao = new BoardDao();
    private BoardDao(){}
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