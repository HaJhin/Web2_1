package day09.boardservice10mvc;

import day09.boardservice10mvc.view.BoardView;

public class AppStart {
    public static void main(String[] args) {
        // 메인 뷰를 요청
        // - 다른 클래스에 존재하는 함수를 호출하는 방법
            // - 객체를 생성한 후 객체명.메서드명()
            // - 단, 패키지가 다르면 public 함수로 선언한다.
        /// 싱글톤을 사용하기 전 ///
        // BoardView view = new BoardView();
        // view.mainPage();

        /// 싱글톤을 사용한 후 ///
        BoardView.getInstance().mainPage();
            // BoardView.getInstance() -> boardView
            // boardView.page();
    } // main ed
} // class ed
