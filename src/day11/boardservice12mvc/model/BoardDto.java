package day11.boardservice12mvc.model;

public class BoardDto {
    // 필드
    private String content; // 내용
    private String writer; // 작성자
    private int pwd; // 비밀번호
    private int num; // 게시물 번호

    // 생성자 [객체 생성시 초기화를 담당하는 메서드]
    // DTO 주로 생성 시 개발자가 초기화할 필드로 생성자를 구성
    // 자동 완성 생성자 사용
    public BoardDto(String content, String writer, int pwd, int num) {
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
        this.num = num;
    }



    public BoardDto(String content, String writer, int num) {
        this.content = content;
        this.writer = writer;
        this.num = num;
    }

    public BoardDto(String content, int num) {
        this.content = content;
        this.num = num;
    }

    // 메서드 [DTO:실질적인 기능 역할 X , 단순 이동 객체]
    // DTO 는 주로 ,getter,setter,toString 역할 큼
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd=" + pwd +
                ", num=" + num +
                '}';
    }
}