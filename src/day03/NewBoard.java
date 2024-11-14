package day03;

public class NewBoard {
    private String content; // 내용
    private String writer; // 작성자
    private int pwd; // 비밀번호

    public NewBoard(String content,String writer,int pwd) {
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;

    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "NewBoard{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}