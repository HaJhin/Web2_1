package day05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileExample {
    public static void main(String[] args) {
        // 1.파일 출력(쓰기)
        // - 자바에서 사용되는 데이터를 자바 외부(C:/java) 메모장(.txt)으로 저장
        try { // 예외가 발생할 것 같은 코드를 try{}안에서 작성

            // - c드라이브에 'java' 폴더를 생성한다.
            // FileOutputStream fileOutput = new FileOutputStream("c:/java/test1.txt")

            // 현재 프로젝트 내 'src -> day05 -> test1.txt' 파일을 생성한다.
            FileOutputStream fileOutput = new FileOutputStream("./src/day05/test1.txt");
            fileOutput.write("Hello Java".getBytes());
            // fileOutput(객체).write(메서드)(매개 변수/인자값1);
        } catch (FileNotFoundException e) { // [특정] 예외가 발생했을때 실행되는 코드를 작성한다.
            e.printStackTrace();
        } catch (Exception e) {
            // [모든] 예외가 발생했을 때 실행되는 코드를 작성한다.
            // (Exception:예외 클래스의 최상위 클래스)
            e.printStackTrace();
        } finally {
            // 예외가 있던 없던 작성되는 코드 작성한다.
        }
    } // main ed
} // class ed
