package day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileExample2 {
    public static void main(String[] args) {
        // 1, 파일 읽기
        try {
            FileInputStream fileInput = new FileInputStream("./src/day05/test1.txt");

        } catch (FileNotFoundException e) {
            // 만약 파일 경로가 존재하지 않으면 예외 발생 후 실행되는 코드
            e.printStackTrace();
        } // try catch ed
    } // main ed
} // class ed
