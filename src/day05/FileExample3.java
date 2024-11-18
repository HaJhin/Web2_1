package day05;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class FileExample3 {
    public static void main(String[] args) {
        // 생각해보기
        // 1.키보드로부터 입력받은 문자열을 'day25' 폴더 내 test2.txt에 저장하시오.
        // 2.'day25' 폴더 내 test2.txt에 저장된 (문자열)바이트를 읽어서 콘솔에 출력하시오.
        Scanner scan = new Scanner(System.in); // 입력 객체
        System.out.println("파일에 저장할 내용 : ");
        String str = scan.next();
        try {
            // 파일출력 객체 생성, 경로 지정
            FileOutputStream fileOutput = new FileOutputStream("./src/day05/test2.txt");
            // 파일출력 객체로 문자열 출력 , .write("문자열".getBytes());
            fileOutput.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 현재 읽어올 파일의 용량을 몰라서 1000으로 지정

        File file = new File("./src/day05/test2.txt");
        System.out.println(file.isFile());
        System.out.println(file.getName());
        System.out.println(file.length());
        byte[] bytes = new byte[(int)file.length()]; // 21억 바이트 허용
            // (캐스팅) : 강제 타입 변환 : long 타입을 int 타입으로 변환
            // 배열 내 [] 안에 들어가는 배열 크기는 타입이 정수 (int)만 가능하다.

        try {
            // 파일 입력 객체 생성, 경로 지정
            FileInputStream fileInput = new FileInputStream("./src/day05/test2.txt");
            fileInput.read(bytes);
            String inStr = new String(bytes);
            System.out.println(inStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // main ed
} // class ed
